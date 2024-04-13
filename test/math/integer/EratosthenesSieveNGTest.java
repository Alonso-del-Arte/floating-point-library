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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static org.testframe.api.Asserters.assertContainsSame;
import static org.testframe.api.Asserters.assertDoesNotThrow;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the EratosthenesSieve class.
 * @author Alonso del Arte
 */
public class EratosthenesSieveNGTest {
    
    private static final int[] SMALL_PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 
        29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    
    private static Optional<Integer> checkPrime(int p) {
        int a = Math.abs(p);
        switch (a) {
            case 0, 1 -> {
                return Optional.of(1);
            }
            case 2 -> {
                return Optional.empty();
            }
            default -> {
                if (a % 2 == 0) {
                    return Optional.of(2);
                }
                double root = Math.sqrt(a);
                int divisor = 3;
                while (divisor <= root) {
                    if (a % divisor == 0) {
                        return Optional.of(divisor);
                    }
                    divisor += 2;
                }
                return Optional.empty();
            }
        }
    }
    
    /**
     * Test of listPrimes method, of class EratosthenesSieve.
     */
//    @Test
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
     * Test of the randomPrime function, of the EratosthenesSieve class.
     */
    @Test
    public void testRandomPrime() {
        System.out.println("randomPrime");
        int bound = RANDOM.nextInt(Short.MAX_VALUE) + Byte.MAX_VALUE;
        int expected = bound / 100 + 20;
        int initialCapacity = 4 * expected;
        Set<Integer> primes = new HashSet<>(initialCapacity);
        int callCount = 0;
        while (callCount < initialCapacity) {
            int p = EratosthenesSieve.randomPrime(bound);
            String msg = "Number " + p + " should be a prime less than " 
                    + bound;
            assert p < bound : msg;
            Optional<Integer> divHolder = checkPrime(p);
            if (divHolder.isPresent()) {
                int d = divHolder.get();
                String msgPart = (d == 0 || d == 1) ? (d + " is not prime")
                        : ("divisible by " + d);
                String message = "The number " + p 
                        + " was said to be prime but it's " + msgPart;
                fail(message);
            }
            primes.add(p);
            callCount++;
        }
        int actual = primes.size();
        String msg = "Expected at least " + expected + " distinct primes, got " 
                + actual;
        assert expected < actual : msg;
    }

    /**
     * Test of the randomOddPrime function, of the EratosthenesSieve class.
     */
    @Test
    public void testRandomOddPrime() {
        System.out.println("randomOddPrime");
        int initialCapacity = RANDOM.nextInt(64) + 36;
        Set<Integer> primes = new HashSet<>(initialCapacity);
        int callCount = 0;
        while (callCount < initialCapacity) {
            int p = EratosthenesSieve.randomOddPrime();
            String msg = "Expected odd prime, got " + p;
            assert p % 2 != 0 : msg;
            Optional<Integer> divHolder = checkPrime(p);
            if (divHolder.isPresent()) {
                int d = divHolder.get();
                String msgPart = (d == 0 || d == 1) ? (d + " is not prime")
                        : ("divisible by " + d);
                String message = "The number " + p 
                        + " was said to be prime but it's " + msgPart;
                fail(message);
            }
            primes.add(p);
            callCount++;
        }
        int expected = 3 * initialCapacity / 5;
        int actual = primes.size();
        String msg = "Expected at least " + expected 
                + " distinct odd primes, got " + actual;
        assert expected < actual : msg;
    }
    
}
