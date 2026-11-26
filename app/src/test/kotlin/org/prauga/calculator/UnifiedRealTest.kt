/*
 * SPDX-FileCopyrightText: Saalim Quadri <danascape@gmail.com>
 * SPDX-License-Identifier: Apache-2.0
 */

package org.prauga.calculator

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import org.junit.Test

class UnifiedRealTest {

    @Test
    fun `one third times three is exactly one`() {
        val testSubject = UnifiedReal(1).divide(UnifiedReal(3))

        val result = testSubject.multiply(UnifiedReal(3))

        assertThat(result.boundedRationalValue()).isEqualTo(BoundedRational.ONE)
    }

    @Test
    fun `square root of two squared is exactly two`() {
        val testSubject = UnifiedReal.TWO.sqrt()

        val result = testSubject.multiply(testSubject)

        assertThat(result.boundedRationalValue()).isEqualTo(BoundedRational.TWO)
    }

    @Test
    fun `sine of a sixth of pi is exactly one half`() {
        val testSubject = UnifiedReal.PI.divide(UnifiedReal(6))

        val result = testSubject.sin()

        assertThat(result.boundedRationalValue()).isEqualTo(BoundedRational.HALF)
    }

    @Test
    fun `two pi is displayed exactly`() {
        val testSubject = UnifiedReal.TWO.multiply(UnifiedReal.PI)

        assertThat(testSubject.exactlyDisplayable()).isTrue()
        assertThat(testSubject.toNiceString()).isEqualTo("2π")
    }

    @Test
    fun `square root of two times pi truncates to correct digits`() {
        val testSubject = UnifiedReal.TWO.sqrt().multiply(UnifiedReal.PI)

        assertThat(testSubject.toStringTruncated(15)).isEqualTo("4.442882938158366")
    }

    @Test
    fun `e to the power of pi truncates to correct digits`() {
        val testSubject = UnifiedReal.E.pow(UnifiedReal.PI)

        assertThat(testSubject.toStringTruncated(20)).isEqualTo("23.14069263277926900572")
    }
}
