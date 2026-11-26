/*
 * SPDX-FileCopyrightText: 2015 The Android Open Source Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.prauga.calculator;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;

public class Licenses extends AppCompatActivity {

    private static final String LICENSE_URL = "file:///android_asset/licenses.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);

        Toolbar toolbar = requireViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        WebView webView = requireViewById(R.id.webview);
        if (WebViewFeature.isFeatureSupported(WebViewFeature.ALGORITHMIC_DARKENING)) {
            WebSettingsCompat.setAlgorithmicDarkeningAllowed(webView.getSettings(), true);
        }
        webView.loadUrl(LICENSE_URL);
    }
}
