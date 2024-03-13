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

import java.util.Random;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the Calculator class.
 * @author Alonso del Arte
 */
public class CalculatorNGTest {
    
    static final Random RANDOM = new Random(System.currentTimeMillis());
    
    @Test
    public void testEuclideanGCDSameNumber() {
        int expected = RANDOM.nextInt(Short.MAX_VALUE) + 1;
        int actual = Calculator.euclideanGCD(expected, expected);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of euclideanGCD method, of class Calculator.
     */
//    @Test
    public void testEuclideanGCD() {
        System.out.println("euclideanGCD");
        int a = 0;
        int b = 0;
        int expResult = 0;
        int result = Calculator.euclideanGCD(a, b);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
