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
 * Tests of the ShortProcessor class.
 * @author Alonso del Arte
 */
public class ShortProcessorNGTest {
    
    /**
     * Test of the fromBytes function, of the ShortProcessor class.
     */
    @Test
    public void testFromBytesRejectsTooManyBytes() {
        int size = RANDOM.nextInt(8) + Short.BYTES + 2;
        byte[] source = new byte[size];
        String msg = "Using array of " + size 
                + " bytes should have caused an exception";
        Throwable t = assertThrows(() -> {
            short badShort = ShortProcessor.fromBytes(source);
            System.out.println(msg + ", not given result " + badShort);
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be blank";
        System.out.println("\"" + excMsg + "\"");
    }

    @Test
    public void testFromBytesEmptyArrayGivesZero() {
        byte[] source = {};
        short expected = 0;
        short actual = ShortProcessor.fromBytes(source);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of toBytes method, of class ShortProcessor.
     */
//    @Test
    public void testToBytes() {
        System.out.println("toBytes");
        long source = 0L;
        byte[] expResult = null;
        byte[] result = ShortProcessor.toBytes(source);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
