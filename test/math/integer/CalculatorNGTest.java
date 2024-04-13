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

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.testframe.api.Asserters.assertDoesNotThrow;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the Calculator class.
 * @author Alonso del Arte
 */
public class CalculatorNGTest {
    
    static final Random RANDOM = new Random(System.currentTimeMillis());
    
    /**
     * Gives a pseudorandomly chosen power of two. This duplicates {@link 
     * Calculator#randomPowerOfTwo()}, but that one will be tested and possibly 
     * refactored, while this one won't.
     * @return A pseudorandomly chosen power of two. For example, 16384.
     */
    private static int randomPowerOfTwo() {
        int shift = RANDOM.nextInt(31);
        return 1 << shift;
    }

    
    @Test
    public void testRandomPowerOfTwo() {
        int initialCapacity = 31;
        Set<Integer> expected = new HashSet<>(initialCapacity);
        Set<Integer> actual = new HashSet<>(initialCapacity);
        int power = 1;
        do {
            expected.add(power);
            power <<= 1;
        } while (power > 0);
        int maxNumberOfTries = 16 * initialCapacity;
        int triesSoFar = 0;
        while (triesSoFar < maxNumberOfTries) {
            actual.add(Calculator.randomPowerOfTwo());
            triesSoFar++;
        }
        assertEquals(actual, expected);
    }
    
    @Test
    public void testEuclideanGCDSameNumber() {
        int expected = RANDOM.nextInt(Short.MAX_VALUE) + 1;
        long actual = Calculator.euclideanGCD(expected, expected);
        assertEquals(actual, expected);
    }
    
    @Test
    public void testEuclideanGCDNegativeAPositiveB() {
        int expected = RANDOM.nextInt(Short.MAX_VALUE) + 1;
        int a = -expected;
        long actual = Calculator.euclideanGCD(a, expected);
        assertEquals(actual, expected);
    }
    
    @Test
    public void testEuclideanGCDSameNegativeNumber() {
        int expected = RANDOM.nextInt(Short.MAX_VALUE) + 1;
        int a = -expected;
        long actual = Calculator.euclideanGCD(a, a);
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
        long actual = Calculator.euclideanGCD(a, b);
        String message = "gcd(" + a + ", " + b + ") expected to be " + expected;
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testEuclideanGCDPositiveAZeroB() {
        int expected = (RANDOM.nextInt() | randomPowerOfTwo()) 
                & Integer.MAX_VALUE;
        int b = 0;
        String msg = "Calculating gcd(" + expected + ", " + b 
                + ") should not cause exception";
        assertDoesNotThrow(() -> {
            long actual = Calculator.euclideanGCD(expected, b);
            String message = "Expecting gcd(" + expected + ", " + b + ") to be " 
                    + expected;
            assertEquals(actual, expected, message);
        }, msg);
    }
    
    @Test
    public void testEuclideanGCDNegativeAZeroB() {
        int a = (RANDOM.nextInt() | randomPowerOfTwo()) | Integer.MIN_VALUE;
        int b = 0;
        String msg = "Calculating gcd(" + a + ", " + b 
                + ") should not cause exception";
        assertDoesNotThrow(() -> {
            int expected = Math.abs(a);
            long actual = Calculator.euclideanGCD(a, b);
            String message = "Expecting gcd(" + a + ", " + b + ") to be " 
                    + expected;
            assertEquals(actual, expected, message);
        }, msg);
    }
    
}
