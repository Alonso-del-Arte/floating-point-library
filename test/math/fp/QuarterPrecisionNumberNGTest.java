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
    public void testPositveNaNIsNotNormal() {
        for (byte b = 121; b > 0; b++) {
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
    
    
}
