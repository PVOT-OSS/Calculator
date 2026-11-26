/*
 * SPDX-FileCopyrightText: 2015 The Android Open Source Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.prauga.calculator;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Extended {@link TextView} that supports ascent/baseline alignment.
 */
public class AlignedTextView extends AppCompatTextView {

    private static final String LATIN_CAPITAL_LETTER = "H";
    private static final float MAX_VERTICAL_PADDING_FRACTION = 0.4f;

    // temporary rect for use during layout
    private final Rect mTempRect = new Rect();

    private int mTopPaddingOffset;
    private int mBottomPaddingOffset;

    private final int mBasePaddingTop;
    private final int mBasePaddingBottom;

    public AlignedTextView(Context context) {
        this(context, null /* attrs */);
    }

    public AlignedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public AlignedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // Disable any included font padding by default.
        setIncludeFontPadding(false);

        mBasePaddingTop = getPaddingTop();
        mBasePaddingBottom = getPaddingBottom();
    }

    protected void fitVerticalPaddingToHeight(int height) {
        final int basePadding = mBasePaddingTop + mBasePaddingBottom;
        final float maxPadding = height * MAX_VERTICAL_PADDING_FRACTION;
        final float scale = basePadding > maxPadding ? maxPadding / basePadding : 1f;
        final int top = (int) (mBasePaddingTop * scale);
        final int bottom = (int) (mBasePaddingBottom * scale);
        if (top != getPaddingTop() || bottom != getPaddingBottom()) {
            setPadding(getPaddingLeft(), top, getPaddingRight(), bottom);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final Paint paint = getPaint();

        // Always align text to the default capital letter height.
        paint.getTextBounds(LATIN_CAPITAL_LETTER, 0, 1, mTempRect);

        mTopPaddingOffset = Math.min(getPaddingTop(),
                (int) Math.ceil(mTempRect.top - paint.ascent()));
        mBottomPaddingOffset = Math.min(getPaddingBottom(), (int) Math.ceil(paint.descent()));

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public int getCompoundPaddingTop() {
        return super.getCompoundPaddingTop() - mTopPaddingOffset;
    }

    @Override
    public int getCompoundPaddingBottom() {
        return super.getCompoundPaddingBottom() - mBottomPaddingOffset;
    }
}
