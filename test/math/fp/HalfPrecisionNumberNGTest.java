/*
 * Copyright (C) 2025 Alonso del Arte
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

import java.math.BigDecimal;

import static math.fp.FloatingPointNumberNGTest.RANDOM;
import math.integer.ShortProcessor;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the HalfPrecisionNumber class.
 * @author Alonso del Arte
 */
public class HalfPrecisionNumberNGTest {
    
    private static final char MINUS_SIGN = '\u2212';
    
    private static final int A_POWER_OF_TWO = 1 << 24;
    
    private static final BigDecimal TWO_TO_THE_24TH 
            = new BigDecimal(A_POWER_OF_TWO);
    
    private static final BigDecimal RECIPROCAL_OF_TWO_TO_THE_24TH 
            = BigDecimal.ONE.divide(TWO_TO_THE_24TH);
    
    @Test
    public void testToStringNegativeInfinity() {
        short sh = -1024;
        HalfPrecisionNumber number = new HalfPrecisionNumber(sh);
        String expected = "\u2212Infinity";
        String actual = number.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative11() {
        int twoToThe11th = 1 << 11;
        BigDecimal power = new BigDecimal(twoToThe11th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe21st = 1 << 21;
        BigDecimal greaterPower = new BigDecimal(twoToThe21st);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = Short.MIN_VALUE + 4096;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative12() {
        int twoToThe12th = 1 << 12;
        BigDecimal power = new BigDecimal(twoToThe12th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe22nd = 1 << 22;
        BigDecimal greaterPower = new BigDecimal(twoToThe22nd);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = Short.MIN_VALUE + 3072;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative13() {
        int twoToThe13th = 1 << 13;
        BigDecimal power = new BigDecimal(twoToThe13th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe23rd = 1 << 23;
        BigDecimal greaterPower = new BigDecimal(twoToThe23rd);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = Short.MIN_VALUE + 2048;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative14() {
        int twoToThe14th = 1 << 14;
        BigDecimal power = new BigDecimal(twoToThe14th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        short start = Short.MIN_VALUE + 1024;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr = curr.add(RECIPROCAL_OF_TWO_TO_THE_24TH).stripTrailingZeros();
        }
    }
        @Test
    public void testToStringNegativeSubnormal() {
        BigDecimal curr = RECIPROCAL_OF_TWO_TO_THE_24TH;
        short start = Short.MIN_VALUE + 1;
        short stop = Short.MIN_VALUE + 1024;
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr = curr.add(RECIPROCAL_OF_TWO_TO_THE_24TH).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringNegativeZero() {
        HalfPrecisionNumber zero = new HalfPrecisionNumber(Short.MIN_VALUE);
        String expected = "\u22120.0";
        String actual = zero.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringPositiveZero() {
        HalfPrecisionNumber zero = new HalfPrecisionNumber((short) 0);
        String expected = "0.0";
        String actual = zero.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringPositiveSubnormal() {
        BigDecimal curr = RECIPROCAL_OF_TWO_TO_THE_24TH;
        for (short sh = 1; sh < 1024; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr = curr.add(RECIPROCAL_OF_TWO_TO_THE_24TH).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative14() {
        int twoToThe14th = 1 << 14;
        BigDecimal power = new BigDecimal(twoToThe14th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        short start = 1024;
        short stop = 2048;
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr = curr.add(RECIPROCAL_OF_TWO_TO_THE_24TH).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative13() {
        int twoToThe13th = 1 << 13;
        BigDecimal power = new BigDecimal(twoToThe13th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe23rd = 1 << 23;
        BigDecimal greaterPower = new BigDecimal(twoToThe23rd);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = 2048;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative12() {
        int twoToThe12th = 1 << 12;
        BigDecimal power = new BigDecimal(twoToThe12th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe22nd = 1 << 22;
        BigDecimal greaterPower = new BigDecimal(twoToThe22nd);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = 3072;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative11() {
        int twoToThe11th = 1 << 11;
        BigDecimal power = new BigDecimal(twoToThe11th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe21st = 1 << 21;
        BigDecimal greaterPower = new BigDecimal(twoToThe21st);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = 4096;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringPositiveInfinity() {
        short sh = 31744;
        HalfPrecisionNumber number = new HalfPrecisionNumber(sh);
        String expected = "Infinity";
        String actual = number.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringNegativeNaN() {
        String expected = "NaN";
        for (short sh = -1023; sh < 0; sh++) {
            HalfPrecisionNumber number = new HalfPrecisionNumber(sh);
            String actual = number.toString();
            assertEquals(actual, expected);
        }
    }

    public void testToStringPositiveNaN() {
        String expected = "NaN";
        for (short sh = 31745; sh > 0; sh++) {
            HalfPrecisionNumber number = new HalfPrecisionNumber(sh);
            String actual = number.toString();
            assertEquals(actual, expected);
        }
    }

    /**
     * Test of getUnbiasedExponent method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testGetUnbiasedExponent() {
        System.out.println("getUnbiasedExponent");
//        HalfPrecisionNumber instance = null;
//        int expResult = 0;
//        int result = instance.getUnbiasedExponent();
//        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBiasedExponent method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testGetBiasedExponent() {
        System.out.println("getBiasedExponent");
        HalfPrecisionNumber instance = null;
        int expResult = 0;
        int result = instance.getBiasedExponent();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNormal method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsNormal() {
        System.out.println("isNormal");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isNormal();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSubnormal method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsSubnormal() {
        System.out.println("isSubnormal");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isSubnormal();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInteger method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsInteger() {
        System.out.println("isInteger");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isInteger();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFinite method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsFinite() {
        System.out.println("isFinite");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isFinite();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInfinite method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsInfinite() {
        System.out.println("isInfinite");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isInfinite();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNaN method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsNaN() {
        System.out.println("isNaN");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isNaN();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isQuietNaN method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsQuietNaN() {
        System.out.println("isQuietNaN");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isQuietNaN();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSignalingNaN method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsSignalingNaN() {
        System.out.println("isSignalingNaN");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isSignalingNaN();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of to32BitPrimitive method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testTo32BitPrimitive() {
        System.out.println("to32BitPrimitive");
        HalfPrecisionNumber instance = null;
        float expResult = 0.0F;
        float result = instance.to32BitPrimitive();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of to64BitPrimitive method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testTo64BitPrimitive() {
        System.out.println("to64BitPrimitive");
        HalfPrecisionNumber instance = null;
        double expResult = 0.0;
        double result = instance.to64BitPrimitive();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toQuarterPrecision method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testToQuarterPrecision() {
        System.out.println("toQuarterPrecision");
        HalfPrecisionNumber instance = null;
        QuarterPrecisionNumber expResult = null;
        QuarterPrecisionNumber result = instance.toQuarterPrecision();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toHalfPrecision method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testToHalfPrecision() {
        System.out.println("toHalfPrecision");
        HalfPrecisionNumber instance = null;
        HalfPrecisionNumber expResult = null;
        HalfPrecisionNumber result = instance.toHalfPrecision();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toSinglePrecision method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testToSinglePrecision() {
        System.out.println("toSinglePrecision");
        HalfPrecisionNumber instance = null;
        SinglePrecisionNumber expResult = null;
        SinglePrecisionNumber result = instance.toSinglePrecision();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toDoublePrecision method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testToDoublePrecision() {
        System.out.println("toDoublePrecision");
        HalfPrecisionNumber instance = null;
        DoublePrecisionNumber expResult = null;
        DoublePrecisionNumber result = instance.toDoublePrecision();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toQuadruplePrecision method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testToQuadruplePrecision() {
        System.out.println("toQuadruplePrecision");
        HalfPrecisionNumber instance = null;
        QuadruplePrecisionNumber expResult = null;
        QuadruplePrecisionNumber result = instance.toQuadruplePrecision();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toOctuplePrecision method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testToOctuplePrecision() {
        System.out.println("toOctuplePrecision");
        HalfPrecisionNumber instance = null;
        OctuplePrecisionNumber expResult = null;
        OctuplePrecisionNumber result = instance.toOctuplePrecision();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plus method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testPlus() {
        System.out.println("plus");
        FloatingPointNumber addend = null;
        HalfPrecisionNumber instance = null;
        FloatingPointNumber expResult = null;
        FloatingPointNumber result = instance.plus(addend);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of negate method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testNegate() {
        System.out.println("negate");
        HalfPrecisionNumber instance = null;
        FloatingPointNumber expResult = null;
        FloatingPointNumber result = instance.negate();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minus method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testMinus() {
        System.out.println("minus");
        FloatingPointNumber subtrahend = null;
        HalfPrecisionNumber instance = null;
        FloatingPointNumber expResult = null;
        FloatingPointNumber result = instance.minus(subtrahend);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of times method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testTimes() {
        System.out.println("times");
        FloatingPointNumber multiplicand = null;
        HalfPrecisionNumber instance = null;
        FloatingPointNumber expResult = null;
        FloatingPointNumber result = instance.times(multiplicand);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reciprocal method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testReciprocal() {
        System.out.println("reciprocal");
        HalfPrecisionNumber instance = null;
        FloatingPointNumber expResult = null;
        FloatingPointNumber result = instance.reciprocal();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divides method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testDivides() {
        System.out.println("divides");
        FloatingPointNumber divisor = null;
        HalfPrecisionNumber instance = null;
        FloatingPointNumber expResult = null;
        FloatingPointNumber result = instance.divides(divisor);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of arithmeticallyEqual method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testArithmeticallyEqual() {
        System.out.println("arithmeticallyEqual");
        FloatingPointNumber other = null;
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.arithmeticallyEqual(other);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bitPatternHexadecimal method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testBitPatternHexadecimal() {
        System.out.println("bitPatternHexadecimal");
        HalfPrecisionNumber instance = null;
        String expResult = "";
        String result = instance.bitPatternHexadecimal();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testByteArrayConstructorPassesBytesAlong() {
        byte mostSignificant = (byte) (RANDOM.nextInt(256) - 128);
        byte leastSignificant = (byte) (RANDOM.nextInt(256) - 128);
        byte[] expected = {mostSignificant, leastSignificant};
        HalfPrecisionNumber number = new HalfPrecisionNumber(expected);
        byte[] actual = number.getBytes();
        assertEquals(actual, expected);
    }
    
    @Test
    public void test16BitIntegerConstructorPassesBytesAlong() {
        byte mostSignificant = (byte) (RANDOM.nextInt(256) - 128);
        byte leastSignificant = (byte) (RANDOM.nextInt(256) - 128);
        byte[] expected = {mostSignificant, leastSignificant};
        short sh = ShortProcessor.fromBytes(expected);
        HalfPrecisionNumber number = new HalfPrecisionNumber(sh);
        byte[] actual = number.getBytes();
        assertEquals(actual, expected);
    }
    
//    @Test
    public void testBytesArrayConstructorCorrectlySetsHeldShort() {
        fail("HAVEN'T WRITTEN TEST YET");
    }
    
}
