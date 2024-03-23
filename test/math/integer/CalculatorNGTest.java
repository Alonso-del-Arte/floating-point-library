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
    
    @Test
    public void testEuclideanGCDNegativeAPositiveB() {
        int expected = RANDOM.nextInt(Short.MAX_VALUE) + 1;
        int a = -expected;
        int actual = Calculator.euclideanGCD(a, expected);
        assertEquals(actual, expected);
    }
    
    @Test
    public void testEuclideanGCDSameNegativeNumber() {
        int expected = RANDOM.nextInt(Short.MAX_VALUE) + 1;
        int a = -expected;
        int actual = Calculator.euclideanGCD(a, a);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of the euclideanGCD function, of the Calculator class.
     */
    @Test
    public void testEuclideanGCD() {
        System.out.println("euclideanGCD");
        int expected = RANDOM.nextInt(Byte.MAX_VALUE) + 1;
        int n = RANDOM.nextInt(Byte.MAX_VALUE) + 1;
        int a = expected * n;
        int b = expected * (n + 1);
        int actual = Calculator.euclideanGCD(a, b);
        String message = "gcd(" + a + ", " + b + ") expected to be " + expected;
        assertEquals(actual, expected, message);
    }
    
}
