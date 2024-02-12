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

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the IntProcessor class.
 * @author Alonso del Arte
 */
public class IntProcessorNGTest {
    
    /**
     * Test of fromBytes method, of class IntProcessor.
     */
    @Test
    public void testFromBytes() {
        System.out.println("fromBytes");
        byte[] source = null;
        int expResult = 0;
        int result = IntProcessor.fromBytes(source);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toBytes method, of class IntProcessor.
     */
    @Test
    public void testToBytes() {
        System.out.println("toBytes");
        int source = 0;
        byte[] expResult = null;
        byte[] result = IntProcessor.toBytes(source);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
