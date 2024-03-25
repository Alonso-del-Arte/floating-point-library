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

import java.util.List;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the EratosthenesSieve class.
 * @author Alonso del Arte
 */
public class EratosthenesSieveNGTest {
    
    /**
     * Test of listPrimes method, of class EratosthenesSieve.
     */
    @Test
    public void testListPrimes() {
        System.out.println("listPrimes");
        int threshold = 0;
        List expResult = null;
        List result = EratosthenesSieve.listPrimes(threshold);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of randomPrime method, of class EratosthenesSieve.
     */
    @Test
    public void testRandomPrime() {
        System.out.println("randomPrime");
        int bound = 0;
        int expResult = 0;
        int result = EratosthenesSieve.randomPrime(bound);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
