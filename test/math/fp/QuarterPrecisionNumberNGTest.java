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

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the QuarterPrecisionNumber class. Since there are only 256 possible 
 * values, it is possible for these tests to be much more exhaustive and 
 * complete than is possible for greater precision floating point numbers.
 * @author Alonso del Arte
 */
public class QuarterPrecisionNumberNGTest {
    
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
