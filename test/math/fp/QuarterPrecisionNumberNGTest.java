/*
 * Copyright (C) 2024 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package math.fp;

import math.fractions.Fraction;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the QuarterPrecisionNumber class. Since there are only 256 possible 
 * values, it is possible for these tests to be much more exhaustive and 
 * complete than is possible for greater precision floating point numbers.
 * @author Alonso del Arte
 */
public class QuarterPrecisionNumberNGTest {
    
    private static final Fraction ONE = new Fraction(1, 1);
    
    private static final Fraction ONE_HALF = ONE.divides(2);
    
    private static final Fraction ONE_QUARTER = ONE_HALF.divides(2);
    
    private static final Fraction ONE_EIGHTH = ONE_QUARTER.divides(2);
    
    @Test
    public void testToStringNegativeInfinity() {
        byte b = -8;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String expected = "\u2212Infinity";
        String actual = number.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringPositiveInfinity() {
        byte b = 120;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String expected = "Infinity";
        String actual = number.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringNegativeNaN() {
        String expected = "NaN";
        for (byte b = -7; b < 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String actual = number.toString();
            assertEquals(actual, expected);
        }
    }

    @Test
    public void testToStringNegativeExponentSeven() {
        Fraction currFract = ONE.times(128).negate();
        Fraction subtrahend = ONE.times(16);
        for (byte b = -16; b < -8; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testToStringNegativeExponentSix() {
        Fraction currFract = ONE.times(64).negate();
        Fraction subtrahend = ONE.times(8);
        for (byte b = -24; b < -16; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testToStringNegativeExponentFive() {
        Fraction currFract = ONE.times(32).negate();
        Fraction subtrahend = ONE.times(4);
        for (byte b = -32; b < -24; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testToStringNegativeExponentFour() {
        Fraction currFract = ONE.times(16).negate();
        Fraction subtrahend = ONE.times(2);
        for (byte b = -40; b < -32; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testToStringNegativeExponentThree() {
        Fraction currFract = ONE.times(8).negate();
        for (byte b = -48; b < -40; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(ONE);
        }
    }
    
    @Test
    public void testToStringNegativeExponentTwo() {
        Fraction currFract = ONE.times(4).negate();
        for (byte b = -56; b < -48; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(ONE_HALF);
        }
    }
    
    @Test
    public void testToStringNegativeExponentOne() {
        Fraction currFract = ONE.times(2).negate();
        for (byte b = -64; b < -56; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(ONE_QUARTER);
        }
    }
    
    @Test
    public void testToStringNegativeExponentZero() {
        Fraction currFract = ONE.negate();
        for (byte b = -71; b < -64; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            currFract = currFract.minus(ONE_EIGHTH);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
        }
    }
    
    @Test
    public void testToStringNegativeOne() {
        QuarterPrecisionNumber number = new QuarterPrecisionNumber((byte) -72);
        String expected = "\u22121.0";
        String actual = number.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringNegativeWithExponentNegativeOne() {
        Fraction currFract = ONE_HALF.negate();
        Fraction subtrahend = ONE.divides(16);
        for (byte b = -80; b < -72; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testToStringNegativeWithExponentNegativeTwo() {
        Fraction currFract = ONE_QUARTER.negate();
        Fraction subtrahend = ONE.divides(32);
        for (byte b = -88; b < -80; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testToStringNegativeWithExponentNegativeThree() {
        Fraction currFract = ONE_EIGHTH.negate();
        Fraction subtrahend = ONE.divides(64);
        for (byte b = -96; b < -88; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testToStringNegativeWithExponentNegativeFour() {
        Fraction currFract = ONE.divides(16).negate();
        Fraction subtrahend = ONE.divides(128);
        for (byte b = -104; b < -96; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testToStringNegativeWithExponentNegativeFive() {
        Fraction currFract = ONE.divides(32).negate();
        Fraction subtrahend = ONE.divides(256);
        for (byte b = -112; b < -104; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testToStringNegativeWithExponentNegativeSix() {
        Fraction currFract = ONE.divides(64).negate();
        Fraction subtrahend = ONE.divides(512);
        for (byte b = -120; b < -112; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testToStringNegativeSubnormal() {
        Fraction subtrahend = ONE.divides(512);
        Fraction currFract = subtrahend.negate();
        for (byte b = -127; b < -120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = "\u2212" + Double.toString(-currFract
                    .numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testToStringNegativeZero() {
        QuarterPrecisionNumber number 
                = new QuarterPrecisionNumber(Byte.MIN_VALUE);
        String expected = "\u22120.0";
        String actual = number.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringPositiveZero() {
        QuarterPrecisionNumber number = new QuarterPrecisionNumber((byte) 0);
        String expected = "0.0";
        String actual = number.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringPositiveSubnormal() {
        Fraction addend = ONE.divides(512);
        Fraction currFract = addend;
        for (byte b = 1; b < 8; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testToStringPositiveWithExponentNegativeSix() {
        Fraction currFract = ONE.divides(64);
        Fraction addend = ONE.divides(512);
        for (byte b = 8; b < 16; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testToStringPositiveWithExponentNegativeFive() {
        Fraction currFract = ONE.divides(32);
        Fraction addend = ONE.divides(256);
        for (byte b = 16; b < 24; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testToStringPositiveWithExponentNegativeFour() {
        Fraction currFract = ONE.divides(16);
        Fraction addend = ONE.divides(128);
        for (byte b = 24; b < 32; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testToStringPositiveWithExponentNegativeThree() {
        Fraction currFract = ONE_EIGHTH;
        Fraction addend = ONE.divides(64);
        for (byte b = 32; b < 40; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testToStringPositiveWithExponentNegativeTwo() {
        Fraction currFract = ONE_QUARTER;
        Fraction addend = ONE.divides(32);
        for (byte b = 40; b < 48; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testToStringPositiveWithExponentNegativeOne() {
        Fraction currFract = ONE_HALF;
        Fraction addend = ONE.divides(16);
        for (byte b = 48; b < 56; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testToStringPositiveOne() {
        QuarterPrecisionNumber number = new QuarterPrecisionNumber((byte) 56);
        String expected = "1.0";
        String actual = number.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringPositiveExponentZero() {
        Fraction currFract = ONE;
        for (byte b = 57; b < 64; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            currFract = currFract.plus(ONE_EIGHTH);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
        }
    }
    
    @Test
    public void testToStringPositiveExponentOne() {
        Fraction currFract = ONE.times(2);
        for (byte b = 64; b < 72; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(ONE_QUARTER);
        }
    }
    
    @Test
    public void testToStringPositiveExponentTwo() {
        Fraction currFract = ONE.times(4);
        for (byte b = 72; b < 80; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(ONE_HALF);
        }
    }
    
    @Test
    public void testToStringPositiveExponentThree() {
        Fraction currFract = ONE.times(8);
        for (byte b = 80; b < 88; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(ONE);
        }
    }
    
    @Test
    public void testToStringPositiveExponentFour() {
        Fraction currFract = ONE.times(16);
        Fraction addend = ONE.times(2);
        for (byte b = 88; b < 96; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testToStringPositiveExponentFive() {
        Fraction currFract = ONE.times(32);
        Fraction addend = ONE.times(4);
        for (byte b = 96; b < 104; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testToStringPositiveExponentSix() {
        Fraction currFract = ONE.times(64);
        Fraction addend = ONE.times(8);
        for (byte b = 104; b < 112; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testToStringPositiveExponentSeven() {
        Fraction currFract = ONE.times(128);
        Fraction addend = ONE.times(16);
        for (byte b = 112; b < 120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String expected = Double.toString(currFract.numericApproximation());
            String actual = number.toString();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testToStringPositiveNaN() {
        String expected = "NaN";
        for (byte b = 121; b > 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String actual = number.toString();
            assertEquals(actual, expected);
        }
    }
    
    @Test
    public void testNegativeInfinityIsNotNormal() {
        byte b = -8;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should not be considered normal";
        assert !number.isNormal() : msg;
    }
    
    @Test
    public void testPositiveInfinityIsNotNormal() {
        byte b = 120;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should not be considered normal";
        assert !number.isNormal() : msg;
    }
    
    @Test
    public void testNegativeNaNIsNotNormal() {
        for (byte b = -7; b < 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should not be considered normal";
            assert !number.isNormal() : msg;
        }
    }
    
    @Test
    public void testPositiveNaNIsNotNormal() {
        for (byte b = 121; b > 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should not be considered normal";
            assert !number.isNormal() : msg;
        }
    }
    
    @Test
    public void testIsNormalNegative() {
        for (byte b = -120; b < -16; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should be considered normal";
            assert number.isNormal() : msg;
        }
    }
    
    @Test
    public void testIsNormalPositive() {
        for (byte b = 8; b < 120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should be considered normal";
            assert number.isNormal() : msg;
        }
    }
    
    @Test
    public void testNegativeSubnormalIsNotNormal() {
        for (byte b = Byte.MIN_VALUE; b < -120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should not be considered normal";
            assert !number.isNormal() : msg;
        }
    }
    
    @Test
    public void testPositiveSubnormalIsNotNormal() {
        for (byte b = 0; b < 8; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should not be considered normal";
            assert !number.isNormal() : msg;
        }
    }
    
    @Test
    public void testNegativeInfinityIsNotSubnormal() {
        byte b = -8;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should not be considered subnormal";
        assert !number.isSubnormal() : msg;
    }
    
    @Test
    public void testPositiveInfinityIsNotSubnormal() {
        byte b = 120;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should not be considered subnormal";
        assert !number.isSubnormal() : msg;
    }
    
    @Test
    public void testNegativeSubnormal() {
        for (byte b = Byte.MIN_VALUE; b < -120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should be considered subnormal";
            assert number.isSubnormal() : msg;
        }
    }
    
    @Test
    public void testPositiveSubnormal() {
        for (byte b = 0; b < 8; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should be considered subnormal";
            assert number.isSubnormal() : msg;
        }
    }
    
    @Test
    public void testNegativeNormalIsNotSubnormal() {
        for (byte b = -120; b < -16; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should not be considered subnormal";
            assert !number.isSubnormal() : msg;
        }
    }
    
    @Test
    public void testPositiveNormalIsNotSubnormal() {
        for (byte b = 8; b < 120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should not be considered subnormal";
            assert !number.isSubnormal() : msg;
        }
    }
    
    @Test
    public void testNegativeNaNIsNotSubnormal() {
        for (byte b = -7; b < 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() + " from byte " + b
                    + " should not be considered subnormal";
            assert !number.isSubnormal() : msg;
        }
    }
    
    @Test
    public void testPositiveNaNIsNotSubnormal() {
        for (byte b = 121; b > 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() + " from byte " + b
                    + " should not be considered subnormal";
            assert !number.isSubnormal() : msg;
        }
    }
    
    @Test
    public void testIsZero() {
        System.out.println("isZero");
        QuarterPrecisionNumber number = new QuarterPrecisionNumber((byte) 0);
        assert number.isZero() : "0.0 should be considered zero";
    }
    
    @Test
    public void testNegativeInfinityIsNotInteger() {
        byte b = -8;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should not be considered an integer";
        assert !number.isInteger() : msg;
    }
    
    @Test
    public void testNegativeNaNIsNotInteger() {
        for (byte b = -7; b < 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() + " from byte " + b 
                    + " should not be considered an integer";
            assert !number.isInteger() : msg;
        }
    }
    
    @Test
    public void testNegativeIsInteger() {
        byte b = -72;
        final byte interval = 8;
        byte increment = interval;
        while (b < -8) {
            byte outerThreshold = (byte) (b + interval);
            while (b < outerThreshold) {
                byte innerThreshold = (byte) (b + increment);
                QuarterPrecisionNumber integer = new QuarterPrecisionNumber(b);
                String msg = "Number " + integer.toString() 
                        + " should be considered an integer";
                assert integer.isInteger() : msg;
                b++;
                while (b < innerThreshold) {
                    QuarterPrecisionNumber number 
                            = new QuarterPrecisionNumber(b);
                    String msgNot = "Number " + number.toString() 
                            + " should not be considered an integer";
                    assert !number.isInteger() : msgNot;
                    b++;
                }
            }
            increment = (byte) (increment / 2 + (increment % 2));
        }
    }
    
    @Test
    public void testNumberBetweenNegativeOneAndZeroIsNotInteger() {
        for (byte b = -127; b < -72; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should not be considered an integer";
            assert !number.isInteger() : msg;
        }
    }
    
    @Test
    public void testNegativeZeroIsInteger() {
        byte b = Byte.MIN_VALUE;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should be considered an integer";
        assert number.isInteger() : msg;
    }
    
    @Test
    public void testPositiveZeroIsInteger() {
        byte b = 0;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should be considered an integer";
        assert number.isInteger() : msg;
    }
    
    @Test
    public void testNumberBetweenZeroAndOneIsNotInteger() {
        for (byte b = 1; b < 56; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should not be considered an integer";
            assert !number.isInteger() : msg;
        }
    }
    
    @Test
    public void testPositiveIsInteger() {
        byte b = 56;
        final byte interval = 8;
        byte increment = interval;
        while (b < 120) {
            byte outerThreshold = (byte) (b + interval);
            while (b < outerThreshold) {
                byte innerThreshold = (byte) (b + increment);
                QuarterPrecisionNumber integer = new QuarterPrecisionNumber(b);
                String msg = "Number " + integer.toString() 
                        + " should be considered an integer";
                assert integer.isInteger() : msg;
                b++;
                while (b < innerThreshold) {
                    QuarterPrecisionNumber number 
                            = new QuarterPrecisionNumber(b);
                    String msgNot = "Number " + number.toString() 
                            + " should not be considered an integer";
                    assert !number.isInteger() : msgNot;
                    b++;
                }
            }
            increment = (byte) (increment / 2 + (increment % 2));
        }
    }
    
    @Test
    public void testPositiveNaNIsNotInteger() {
        for (byte b = 121; b > 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() + " from byte " + b 
                    + " should not be considered an integer";
            assert !number.isInteger() : msg;
        }
    }
    
    @Test
    public void testPositiveInfinityIsNotInteger() {
        byte b = 120;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should not be considered an integer";
        assert !number.isInteger() : msg;
    }
    
    @Test
    public void testNegativeInfinityIsNotFinite() {
        byte b = -8;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should not be considered finite";
        assert !number.isFinite() : msg;
    }
    
    @Test
    public void testNegativeNaNIsNotFinite() {
        for (byte b = -7; b < 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() + " from byte " + b 
                    + " should not be considered finite";
            assert !number.isFinite() : msg;
        }
    }
    
    @Test
    public void testNegativeFiniteIsFinite() {
        for (byte b = Byte.MIN_VALUE; b < -8; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString()
                    + " should be considered finite";
            assert number.isFinite() : msg;
        }
    }
    
    @Test
    public void testPositiveFiniteIsFinite() {
        for (byte b = 0; b < 120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString()
                    + " should be considered finite";
            assert number.isFinite() : msg;
        }
    }
    
    @Test
    public void testPositiveNaNIsNotFinite() {
        for (byte b = 121; b > 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() + " from byte " + b 
                    + " should not be considered finite";
            assert !number.isFinite() : msg;
        }
    }
    
    @Test
    public void testPositiveInfinityIsNotFinite() {
        byte b = 120;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should not be considered finite";
        assert !number.isFinite() : msg;
    }
    
    @Test
    public void testNegativeInfinityIsInfinite() {
        byte b = -8;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should be considered infinite";
        assert number.isInfinite() : msg;
    }
    
    @Test
    public void testNegativeNaNsAreNotInfinite() {
        for (byte b = -7; b < 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() + " from byte " + b
                    + " should not be considered infinite";
            assert !number.isInfinite() : msg;
        }
    }
        
    @Test
    public void testNegativeFinitesAreNotInfinite() {
        for (byte b = Byte.MIN_VALUE; b < -8; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should not be considered infinite";
            assert !number.isInfinite() : msg;
        }
    }
    
    @Test
    public void testPositiveFinitesAreNotInfinite() {
        for (byte b = 0; b < 120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should not be considered infinite";
            assert !number.isInfinite() : msg;
        }
    }
    
    @Test
    public void testPositiveNaNsAreNotInfinite() {
        for (byte b = 121; b > 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() + " from byte " + b
                    + " should not be considered infinite";
            assert !number.isInfinite() : msg;
        }
    }
    
    @Test
    public void testPositiveInfinityIsInfinite() {
        byte b = 120;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should be considered infinite";
        assert number.isInfinite() : msg;
    }
    
    @Test
    public void testNegativeInfinityIsNotNaN() {
        byte b = -8;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should not be considered NaN";
        assert !number.isNaN() : msg;
    }
    
    @Test
    public void testNegativeNaNsAreNaN() {
        for (byte b = -7; b < 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() + " from byte " + b
                    + " should be considered NaN";
            assert number.isNaN() : msg;
        }
    }
        
    @Test
    public void testNegativeFinitesAreNotNaN() {
        for (byte b = Byte.MIN_VALUE; b < -8; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should not be considered NaN";
            assert !number.isNaN() : msg;
        }
    }
    
    @Test
    public void testPositiveFinitesAreNotNaN() {
        for (byte b = 0; b < 120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() 
                    + " should not be considered NaN";
            assert !number.isNaN() : msg;
        }
    }
    
    @Test
    public void testPositiveNaNsAreNaN() {
        for (byte b = 121; b > 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = "Number " + number.toString() + " from byte " + b
                + " should be considered NaN";
            assert number.isNaN() : msg;
        }
    }
    
    @Test
    public void testPositiveInfinityIsNotNaN() {
        byte b = 120;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String msg = "Number " + number.toString() 
                + " should not be considered NaN";
        assert !number.isNaN() : msg;
    }
    
    @Test
    public void testNotNaNAtAllIsCertainlyNotQuietNaNEither() {
        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
            byte b = (byte) i;
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            if (!number.isNaN()) {
                String msg = "Said to not be NaN, " + number.toString() 
                        + " should not be quiet NaN either";
                assert !number.isQuietNaN() : msg;
            }
        }
    }
    
    @Test
    public void testNegativeQuietNaNIsQuietNaN() {
        for (byte b = -7; b < -4; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = number.toString() + " from bit pattern " 
                    + Integer.toHexString(b + 256) 
                    + " should be considered quiet NaN";
            assert number.isQuietNaN() : msg;
        }
    }
    
    @Test
    public void testNegativeSignalingNaNIsNotQuietNaN() {
        for (byte b = -4; b < 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = number.toString() + " from bit pattern " 
                    + Integer.toHexString(b + 256) 
                    + " should not be considered quiet NaN";
            assert !number.isQuietNaN() : msg;
        }
    }
    
    @Test
    public void testPositiveQuietNaNIsQuietNaN() {
        for (byte b = 121; b < 124; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = number.toString() + " from bit pattern " 
                    + Integer.toHexString(b) 
                    + " should be considered quiet NaN";
            assert number.isQuietNaN() : msg;
        }
    }
    
    @Test
    public void testPositiveSignalingNaNIsNotQuietNaN() {
        for (byte b = 124; b > 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = number.toString() + " from bit pattern " 
                    + Integer.toHexString(b) 
                    + " should not be considered quiet NaN";
            assert !number.isQuietNaN() : msg;
        }
    }
    
    @Test
    public void testNotNaNAtAllIsCertainlyNotSignalingNaNEither() {
        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
            byte b = (byte) i;
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            if (!number.isNaN()) {
                String msg = "Said to not be NaN, " + number.toString() 
                        + " should not be signaling NaN either";
                assert !number.isSignalingNaN() : msg;
            }
        }
    }
    
    @Test
    public void testNegativeSignalingNaNIsSignalingNaN() {
        for (byte b = -4; b < 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = number.toString() + " from bit pattern " 
                    + Integer.toHexString(b + 256) 
                    + " should be considered signaling NaN";
            assert number.isSignalingNaN() : msg;
        }
    }
    
    @Test
    public void testNegativeQuietNaNIsNotSignalingNaN() {
        for (byte b = -7; b < -4; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = number.toString() + " from bit pattern " 
                    + Integer.toHexString(b + 256) 
                    + " should not be considered signaling NaN";
            assert !number.isSignalingNaN() : msg;
        }
    }
    
    @Test
    public void testPositiveSignalingNaNIsSignalingNaN() {
        for (byte b = 124; b > 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = number.toString() + " from bit pattern " 
                    + Integer.toHexString(b) 
                    + " should be considered signaling NaN";
            assert number.isSignalingNaN() : msg;
        }
    }
    
    @Test
    public void testPositiveQuietNaNIsNotSignalingNaN() {
        for (byte b = 121; b < 124; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msg = number.toString() + " from bit pattern " 
                    + Integer.toHexString(b) 
                    + " should not be considered signaling NaN";
            assert !number.isSignalingNaN() : msg;
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeInfinity() {
        byte b = -8;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        float expected = Float.NEGATIVE_INFINITY;
        float actual = number.to32BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeInfinity() {
        byte b = -8;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        double expected = Double.NEGATIVE_INFINITY;
        double actual = number.to64BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeExponentSeven() {
        Fraction currFract = ONE.times(128).negate();
        Fraction subtrahend = ONE.times(16);
        for (byte b = -16; b < -8; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentSeven() {
        Fraction currFract = ONE.times(128).negate();
        Fraction subtrahend = ONE.times(16);
        for (byte b = -16; b < -8; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }

    @Test
    public void testTo32BitPrimitiveNegativeExponentSix() {
        Fraction currFract = ONE.times(64).negate();
        Fraction subtrahend = ONE.times(8);
        for (byte b = -24; b < -16; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentSix() {
        Fraction currFract = ONE.times(64).negate();
        Fraction subtrahend = ONE.times(8);
        for (byte b = -24; b < -16; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeExponentFive() {
        Fraction currFract = ONE.times(32).negate();
        Fraction subtrahend = ONE.times(4);
        for (byte b = -32; b < -24; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentFive() {
        Fraction currFract = ONE.times(32).negate();
        Fraction subtrahend = ONE.times(4);
        for (byte b = -32; b < -24; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeExponentFour() {
        Fraction currFract = ONE.times(16).negate();
        Fraction subtrahend = ONE.times(2);
        for (byte b = -40; b < -32; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentFour() {
        Fraction currFract = ONE.times(16).negate();
        Fraction subtrahend = ONE.times(2);
        for (byte b = -40; b < -32; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeExponentThree() {
        Fraction currFract = ONE.times(8).negate();
        for (byte b = -48; b < -40; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(ONE);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentThree() {
        Fraction currFract = ONE.times(8).negate();
        for (byte b = -48; b < -40; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(ONE);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeExponentTwo() {
        Fraction currFract = ONE.times(4).negate();
        for (byte b = -56; b < -48; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(ONE_HALF);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentTwo() {
        Fraction currFract = ONE.times(4).negate();
        for (byte b = -56; b < -48; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(ONE_HALF);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeExponentOne() {
        Fraction currFract = ONE.times(2).negate();
        for (byte b = -64; b < -56; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(ONE_QUARTER);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentOne() {
        Fraction currFract = ONE.times(2).negate();
        for (byte b = -64; b < -56; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(ONE_QUARTER);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeExponentZero() {
        Fraction currFract = ONE.negate();
        for (byte b = -71; b < -64; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            currFract = currFract.minus(ONE_EIGHTH);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentZero() {
        Fraction currFract = ONE.negate();
        for (byte b = -71; b < -64; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            currFract = currFract.minus(ONE_EIGHTH);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeOne() {
        QuarterPrecisionNumber number = new QuarterPrecisionNumber((byte) -72);
        float expected = -1.0f;
        float actual = number.to32BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeOne() {
        QuarterPrecisionNumber number = new QuarterPrecisionNumber((byte) -72);
        double expected = -1.0;
        double actual = number.to64BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeExponentNegativeOne() {
        Fraction currFract = ONE_HALF.negate();
        Fraction subtrahend = ONE.divides(16);
        for (byte b = -80; b < -72; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentNegativeOne() {
        Fraction currFract = ONE_HALF.negate();
        Fraction subtrahend = ONE.divides(16);
        for (byte b = -80; b < -72; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeExponentNegativeTwo() {
        Fraction currFract = ONE_QUARTER.negate();
        Fraction subtrahend = ONE.divides(32);
        for (byte b = -88; b < -80; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentNegativeTwo() {
        Fraction currFract = ONE_QUARTER.negate();
        Fraction subtrahend = ONE.divides(32);
        for (byte b = -88; b < -80; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeExponentNegativeThree() {
        Fraction currFract = ONE_EIGHTH.negate();
        Fraction subtrahend = ONE.divides(64);
        for (byte b = -96; b < -88; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentNegativeThree() {
        Fraction currFract = ONE_EIGHTH.negate();
        Fraction subtrahend = ONE.divides(64);
        for (byte b = -96; b < -88; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeExponentNegativeFour() {
        Fraction currFract = ONE.divides(16).negate();
        Fraction subtrahend = ONE.divides(128);
        for (byte b = -104; b < -96; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentNegativeFour() {
        Fraction currFract = ONE.divides(16).negate();
        Fraction subtrahend = ONE.divides(128);
        for (byte b = -104; b < -96; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeExponentNegativeFive() {
        Fraction currFract = ONE.divides(32).negate();
        Fraction subtrahend = ONE.divides(256);
        for (byte b = -112; b < -104; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentNegativeFive() {
        Fraction currFract = ONE.divides(32).negate();
        Fraction subtrahend = ONE.divides(256);
        for (byte b = -112; b < -104; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeExponentNegativeSix() {
        Fraction currFract = ONE.divides(64).negate();
        Fraction subtrahend = ONE.divides(512);
        for (byte b = -120; b < -112; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeExponentNegativeSix() {
        Fraction currFract = ONE.divides(64).negate();
        Fraction subtrahend = ONE.divides(512);
        for (byte b = -120; b < -112; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeSubnormal() {
        Fraction subtrahend = ONE.divides(512);
        Fraction currFract = subtrahend.negate();
        for (byte b = -127; b < -120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeSubnormal() {
        Fraction subtrahend = ONE.divides(512);
        Fraction currFract = subtrahend.negate();
        for (byte b = -127; b < -120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b + 256);
            assertEquals(actual, expected, message);
            currFract = currFract.minus(subtrahend);
        }
    }
    
    @Test
    public void testTo32BitPrimitiveNegativeZero() {
        QuarterPrecisionNumber number 
                = new QuarterPrecisionNumber(Byte.MIN_VALUE);
        float expected = -0.0f;
        float actual = number.to32BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testTo64BitPrimitiveNegativeZero() {
        QuarterPrecisionNumber number 
                = new QuarterPrecisionNumber(Byte.MIN_VALUE);
        double expected = -0.0;
        double actual = number.to64BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testTo32BitPrimitivePositiveZero() {
        QuarterPrecisionNumber number = new QuarterPrecisionNumber((byte) 0);
        float expected = 0.0f;
        float actual = number.to32BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testTo64BitPrimitivePositiveZero() {
        QuarterPrecisionNumber number = new QuarterPrecisionNumber((byte) 0);
        double expected = 0.0;
        double actual = number.to64BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testTo32BitPrimitivePositiveSubnormal() {
        Fraction addend = ONE.divides(512);
        Fraction currFract = addend;
        for (byte b = 1; b < 8; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveSubnormal() {
        Fraction addend = ONE.divides(512);
        Fraction currFract = addend;
        for (byte b = 1; b < 8; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentNegativeSix() {
        Fraction currFract = ONE.divides(64);
        Fraction addend = ONE.divides(512);
        for (byte b = 8; b < 16; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentNegativeSix() {
        Fraction currFract = ONE.divides(64);
        Fraction addend = ONE.divides(512);
        for (byte b = 8; b < 16; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentNegativeFive() {
        Fraction currFract = ONE.divides(32);
        Fraction addend = ONE.divides(256);
        for (byte b = 16; b < 24; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentNegativeFive() {
        Fraction currFract = ONE.divides(32);
        Fraction addend = ONE.divides(256);
        for (byte b = 16; b < 24; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentNegativeFour() {
        Fraction currFract = ONE.divides(16);
        Fraction addend = ONE.divides(128);
        for (byte b = 24; b < 32; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentNegativeFour() {
        Fraction currFract = ONE.divides(16);
        Fraction addend = ONE.divides(128);
        for (byte b = 24; b < 32; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentNegativeThree() {
        Fraction currFract = ONE_EIGHTH;
        Fraction addend = ONE.divides(64);
        for (byte b = 32; b < 40; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentNegativeThree() {
        Fraction currFract = ONE_EIGHTH;
        Fraction addend = ONE.divides(64);
        for (byte b = 32; b < 40; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentNegativeTwo() {
        Fraction currFract = ONE_QUARTER;
        Fraction addend = ONE.divides(32);
        for (byte b = 40; b < 48; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentNegativeTwo() {
        Fraction currFract = ONE_QUARTER;
        Fraction addend = ONE.divides(32);
        for (byte b = 40; b < 48; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentNegativeOne() {
        Fraction currFract = ONE_HALF;
        Fraction addend = ONE.divides(16);
        for (byte b = 48; b < 56; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentNegativeOne() {
        Fraction currFract = ONE_HALF;
        Fraction addend = ONE.divides(16);
        for (byte b = 48; b < 56; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveOne() {
        QuarterPrecisionNumber number = new QuarterPrecisionNumber((byte) 56);
        float expected = 1.0f;
        float actual = number.to32BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testTo64BitPrimitivePositiveOne() {
        QuarterPrecisionNumber number = new QuarterPrecisionNumber((byte) 56);
        double expected = 1.0;
        double actual = number.to64BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentZero() {
        Fraction currFract = ONE;
        for (byte b = 57; b < 64; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            currFract = currFract.plus(ONE_EIGHTH);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentZero() {
        Fraction currFract = ONE;
        for (byte b = 57; b < 64; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            currFract = currFract.plus(ONE_EIGHTH);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentOne() {
        Fraction currFract = ONE.times(2);
        for (byte b = 64; b < 72; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(ONE_QUARTER);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentOne() {
        Fraction currFract = ONE.times(2);
        for (byte b = 64; b < 72; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(ONE_QUARTER);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentTwo() {
        Fraction currFract = ONE.times(4);
        for (byte b = 72; b < 80; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(ONE_HALF);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentTwo() {
        Fraction currFract = ONE.times(4);
        for (byte b = 72; b < 80; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(ONE_HALF);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentThree() {
        Fraction currFract = ONE.times(8);
        for (byte b = 80; b < 88; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(ONE);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentThree() {
        Fraction currFract = ONE.times(8);
        for (byte b = 80; b < 88; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(ONE);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentFour() {
        Fraction currFract = ONE.times(16);
        Fraction addend = ONE.times(2);
        for (byte b = 88; b < 96; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentFour() {
        Fraction currFract = ONE.times(16);
        Fraction addend = ONE.times(2);
        for (byte b = 88; b < 96; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentFive() {
        Fraction currFract = ONE.times(32);
        Fraction addend = ONE.times(4);
        for (byte b = 96; b < 104; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentFive() {
        Fraction currFract = ONE.times(32);
        Fraction addend = ONE.times(4);
        for (byte b = 96; b < 104; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentSix() {
        Fraction currFract = ONE.times(64);
        Fraction addend = ONE.times(8);
        for (byte b = 104; b < 112; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentSix() {
        Fraction currFract = ONE.times(64);
        Fraction addend = ONE.times(8);
        for (byte b = 104; b < 112; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveExponentSeven() {
        Fraction currFract = ONE.times(128);
        Fraction addend = ONE.times(16);
        for (byte b = 112; b < 120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            float expected = (float) currFract.numericApproximation();
            float actual = number.to32BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo64BitPrimitivePositiveExponentSeven() {
        Fraction currFract = ONE.times(128);
        Fraction addend = ONE.times(16);
        for (byte b = 112; b < 120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            double expected = currFract.numericApproximation();
            double actual = number.to64BitPrimitive();
            String message = "Bit pattern " + Integer.toHexString(b);
            assertEquals(actual, expected, message);
            currFract = currFract.plus(addend);
        }
    }
    
    @Test
    public void testTo32BitPrimitivePositiveInfinity() {
        byte b = 120;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        float expected = Float.POSITIVE_INFINITY;
        float actual = number.to32BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testTo64BitPrimitivePositiveInfinity() {
        byte b = 120;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        double expected = Double.POSITIVE_INFINITY;
        double actual = number.to64BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testTo32BitPrimitiveCanonicalNaN() {
        byte b = 124;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        float expected = Float.NaN;
        float actual = number.to32BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testTo64BitPrimitiveCanonicalNaN() {
        byte b = 124;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        double expected = Double.NaN;
        double actual = number.to64BitPrimitive();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToQuarterPrecisionNumber() {
        System.out.println("toQuarterPrecision");
        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
            byte b = (byte) i;
            QuarterPrecisionNumber expected = new QuarterPrecisionNumber(b);
            QuarterPrecisionNumber actual = expected.toQuarterPrecision();
            assertEquals(actual, expected);
        }
    }
    
    @Test
    public void testNegativeZeroPlusSomeNumberIsSomeNumber() {
        QuarterPrecisionNumber zero 
                = new QuarterPrecisionNumber(Byte.MIN_VALUE);
        for (int i = Byte.MIN_VALUE; i < 128; i++) {
            byte b = (byte) i;
            QuarterPrecisionNumber expected = new QuarterPrecisionNumber(b);
            QuarterPrecisionNumber actual = zero.plus(expected);
            String message = "Calculating " + zero.toString() + " + " 
                    + expected.toString();
            assertEquals(actual, expected, message);
        }
    }
    
    @Test
    public void testPositiveZeroPlusNegativeZeroIsPositiveZero() {
        QuarterPrecisionNumber expected = new QuarterPrecisionNumber((byte) 0);
        QuarterPrecisionNumber negativeZero 
                = new QuarterPrecisionNumber(Byte.MIN_VALUE);
        QuarterPrecisionNumber actual = expected.plus(negativeZero);
        String message = "Calculating " + expected.toString() + " + " 
                + negativeZero.toString();
        assertEquals(actual, expected, message);
    }

    @Test
    public void testPositiveZeroPlusSomeNumberIsUsuallySomeNumber() {
        QuarterPrecisionNumber zero = new QuarterPrecisionNumber((byte) 0);
        for (byte b = -127; b > Byte.MIN_VALUE; b++) {
            QuarterPrecisionNumber expected = new QuarterPrecisionNumber(b);
            QuarterPrecisionNumber actual = zero.plus(expected);
            String message = "Calculating " + zero.toString() + " + " 
                    + expected.toString();
            assertEquals(actual, expected, message);
        }
    }
    
    @Test
    public void testPlusPositiveSubnormals() {
        for (byte b = 0; b < 8; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            byte threshold = (byte) (8 - b);
            for (byte c = 0; c < threshold; c++) {
                QuarterPrecisionNumber addend = new QuarterPrecisionNumber(c);
                QuarterPrecisionNumber expected 
                        = new QuarterPrecisionNumber((byte) (b + c));
                QuarterPrecisionNumber actual = number.plus(addend);
                String message = "Adding " + number.toString() + " and " 
                        + addend.toString();
                assertEquals(actual, expected, message);
            }
        }
    }

    @Test
    public void testPlusNegativeSubnormals() {
        for (byte b = Byte.MIN_VALUE; b < -120; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            byte start = (byte) (b + 1);
            for (byte c = start; c < -120; c++) {
                QuarterPrecisionNumber addend = new QuarterPrecisionNumber(c);
                QuarterPrecisionNumber expected 
                        = new QuarterPrecisionNumber((byte) (b 
                                + (Byte.MIN_VALUE ^ c)));
                QuarterPrecisionNumber actual = number.plus(addend);
                String message = "Adding " + number.toString() + " and " 
                        + addend.toString();
                assertEquals(actual, expected, message);
            }
        }
    }
    
    @Test
    public void testNegativeNormalPlusItselfWithinRange() {
        for (byte exponent = -120; exponent < -16; exponent += 8) {
            byte stop = (byte) (exponent + 8);
            for (byte b = exponent; b < stop; b++) {
                QuarterPrecisionNumber addend = new QuarterPrecisionNumber(b);
                QuarterPrecisionNumber expected 
                        = new QuarterPrecisionNumber((byte) (b + 8));
                QuarterPrecisionNumber actual = addend.plus(addend);
                String message = "Adding " + addend.toString() + " to itself";
                assertEquals(actual, expected, message);
            }
        }
    }

    @Test
    public void testPositiveNormalPlusItselfWithinRange() {
        for (byte exponent = 8; exponent < 112; exponent += 8) {
            byte stop = (byte) (exponent + 8);
            for (byte b = exponent; b < stop; b++) {
                QuarterPrecisionNumber addend = new QuarterPrecisionNumber(b);
                QuarterPrecisionNumber expected 
                        = new QuarterPrecisionNumber((byte) (b + 8));
                QuarterPrecisionNumber actual = addend.plus(addend);
                String message = "Adding " + addend.toString() + " to itself";
                assertEquals(actual, expected, message);
            }
        }
    }

    // TODO: Write more tests for plus()
    
    @Test
    public void testNegate() {
        System.out.println("negate");
        for (int i = Byte.MIN_VALUE; i < 128; i++) {
            byte b = (byte) i;
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            byte csb = (byte) (b ^ Byte.MIN_VALUE);
            QuarterPrecisionNumber expected = new QuarterPrecisionNumber(csb);
            QuarterPrecisionNumber actual = number.negate();
            String message = "Negating " + number.toString();
            assertEquals(actual, expected, message);
        }
    }
    
    // TODO: Write tests for minus()

    // TODO: Write tests for times()
    
    // TODO: Write tests for reciprocal()
    
    // TODO: Write tests for divides()
    
    @Test
    public void testNaNIsNeverArithmeticallyEqual() {
        byte[] bitPatterns = {-7, -6, -5, -4, -3, -2, -1, 121, 122, 123, 124, 
            125, 126, Byte.MAX_VALUE};
        int len = bitPatterns.length;
        QuarterPrecisionNumber[] numbers = new QuarterPrecisionNumber[len];
        for (int i = 0; i < len; i++) {
            numbers[i] = new QuarterPrecisionNumber(bitPatterns[i]);
        }
        String[] numberTexts = new String[len];
        for (int j = 0; j < len; j++) {
            int pat = (bitPatterns[j] < 0) ? bitPatterns[j] + 256 
                    : bitPatterns[j];
            numberTexts[j] = numbers[j].toString() + " from bit pattern " 
                    + Integer.toString(pat, 16);
        }
        String msgPart = " should not be arithmetically equal to ";
        for (int a = 0; a < len; a++) {
            for (int b = 0; b < len; b++) {
                String msg = numberTexts[a] + msgPart + numberTexts[b];
                assert !numbers[a].arithmeticallyEqual(numbers[b]) : msg;
            }
        }
    }
    
    private static void assertArithEqualItself(QuarterPrecisionNumber number) {
        String msg = "Number " + number.toString() 
                + " should be arithmetically equal to itself";
        assert number.arithmeticallyEqual(number) : msg;
    }
    
    @Test
    public void testArithmeticallyEqual() {
        System.out.println("arithmeticallyEqual");
        for (byte b = Byte.MIN_VALUE; b < -7; b++) {
            QuarterPrecisionNumber negativeNumber = new QuarterPrecisionNumber(b);
            QuarterPrecisionNumber positiveNumber 
                    = new QuarterPrecisionNumber((byte) (b + 128));
            assertArithEqualItself(negativeNumber);
            assertArithEqualItself(positiveNumber);
        }
    }
    
    @Test
    public void testNegativeNumbersNotEqualToOthers() {
        for (byte b = -127; b < -7; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msgPart = "Number " + number.toString() 
                    + " should not be equal to ";
            for (int c = Byte.MIN_VALUE; c < 128; c++) {
                if (b != c) {
                    QuarterPrecisionNumber other 
                            = new QuarterPrecisionNumber((byte) c);
                    String msg = msgPart + other.toString();
                    assert !number.arithmeticallyEqual(other) : msg;
                }
            }
        }
    }
    
    @Test
    public void testPositiveNumbersNotEqualToOthers() {
        for (byte b = 1; b < 121; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String msgPart = "Number " + number.toString() 
                    + " should not be equal to ";
            for (int c = Byte.MIN_VALUE; c < 128; c++) {
                if (b != c) {
                    QuarterPrecisionNumber other 
                            = new QuarterPrecisionNumber((byte) c);
                    String msg = msgPart + other.toString();
                    assert !number.arithmeticallyEqual(other) : msg;
                }
            }
        }
    }
    
    public void testZeroesArithmeticallyEqualToEachOther() {
        fail("HAVEN'T WRITTEN TEST YET");
    }
    
}
