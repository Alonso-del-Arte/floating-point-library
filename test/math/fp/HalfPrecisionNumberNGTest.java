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

import static math.fp.FloatingPointNumberNGTest.RANDOM;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the HalfPrecisionNumber class.
 * @author Alonso del Arte
 */
public class HalfPrecisionNumberNGTest {
    
    /**
     * Test of getUnbiasedExponent method, of class HalfPrecisionNumber.
     */
    @Test
    public void testGetUnbiasedExponent() {
        System.out.println("getUnbiasedExponent");
        HalfPrecisionNumber instance = null;
        int expResult = 0;
        int result = instance.getUnbiasedExponent();
        assertEquals(result, expResult);
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
    
}
