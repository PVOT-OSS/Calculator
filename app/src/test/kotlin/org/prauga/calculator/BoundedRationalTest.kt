/*
 * SPDX-FileCopyrightText: Saalim Quadri <danascape@gmail.com>
 * SPDX-License-Identifier: Apache-2.0
 */

package org.prauga.calculator

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class BoundedRationalTest {

    @Test
    fun `fraction is shown in lowest terms`() {
        val testSubject = BoundedRational(6, 8)

        assertThat(testSubject.toNiceString()).isEqualTo("3/4")
    }

    @Test
    fun `sum of a third and a sixth is one half`() {
        val testSubject = BoundedRational(1, 3)

        val result = BoundedRational.add(testSubject, BoundedRational(1, 6))

        assertThat(result).isEqualTo(BoundedRational.HALF)
    }

    @Test
    fun `one seventh truncates to its repeating digits`() {
        val testSubject = BoundedRational(1, 7)

        assertThat(testSubject.toStringTruncated(12)).isEqualTo("0.142857142857")
    }
}
