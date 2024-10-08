/*
 * Copyright (C) 2024 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package math.integer;

import static math.integer.CalculatorNGTest.RANDOM;

import static org.testframe.api.Asserters.assertThrows;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the LongProcessor class.
 * @author Alonso del Arte
 */
public class LongProcessorNGTest {
    
    @Test
    public void testFromBytesRejectsTooManyBytes() {
        int size = RANDOM.nextInt(8) + Long.BYTES + 2;
        byte[] source = new byte[size];
        String msg = "Using array of " + size 
                + " bytes should have caused an exception";
        Throwable t = assertThrows(() -> {
            long badLong = LongProcessor.fromBytes(source);
            System.out.println(msg + ", not given result " + badLong);
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be blank";
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void testFromBytesEmptyArrayGivesZero() {
        byte[] source = {};
        long expected = 0L;
        long actual = LongProcessor.fromBytes(source);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of the fromBytes function, of the LongProcessor class. For this test 
     * we ensure the target 64-bit integer is positive or 0, not negative. 
     * Admittedly, 0 is extremely unlikely, though not mathematically 
     * impossible.
     */
    @Test
    public void testFromBytes() {
        System.out.println("fromBytes");
        byte[] source = new byte[Long.BYTES];
        RANDOM.nextBytes(source);
        source[0] = (byte) (source[0] & Byte.MAX_VALUE);
        StringBuilder hexNumStr = new StringBuilder();
        long expected = 0L;
        for (byte b : source) {
            expected *= 256;
            long unsigned = Byte.toUnsignedLong(b);
            expected += unsigned;
            hexNumStr.append(Long.toHexString(unsigned));
        }
        long actual = LongProcessor.fromBytes(source);
        String message = "Concatenated bytes are " + hexNumStr;
        assertEquals(actual, expected, message);
    }

    /**
     * Another test of the fromBytes function, of the LongProcessor class. For 
     * this test we ensure the target 64-bit integer is negative.
     */
    @Test
    public void testFromBytesNegative() {
        byte[] source = new byte[Long.BYTES];
        RANDOM.nextBytes(source);
        source[0] = (byte) (source[0] | Byte.MIN_VALUE);
        StringBuilder hexNumStr = new StringBuilder();
        long expected = 0L;
        for (byte b : source) {
            expected *= 256;
            long unsigned = Byte.toUnsignedLong(b);
            expected += unsigned;
            if (unsigned < 16) {
                hexNumStr.append('0');
            }
            hexNumStr.append(Long.toHexString(unsigned));
        }
        long actual = LongProcessor.fromBytes(source);
        String message = "Concatenated bytes are " + hexNumStr;
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testFromBytesArraySizes1To7() {
        for (int size = 1; size < 8; size++) {
            byte[] source = new byte[size];
            RANDOM.nextBytes(source);
            long expected = 0L;
            for (byte b: source) {
                expected *= 256;
                expected += Byte.toUnsignedLong(b);
            }
            try {
                long actual = LongProcessor.fromBytes(source);
                assertEquals(actual, expected);
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                String message = "Array of " + size 
                        + " byte(s) should not have caused exception";
                System.out.println(message);
                System.out.println("\"" + aioobe.getMessage() + "\"");
                fail(message);
            }
        }
    }

    /**
     * Test of toBytes method, of class LongProcessor.
     */
//    @Test
    public void testToBytes() {
        System.out.println("toBytes");
        long source = 0L;
        byte[] expResult = null;
        byte[] result = LongProcessor.toBytes(source);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
