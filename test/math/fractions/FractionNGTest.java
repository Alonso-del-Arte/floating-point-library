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
package math.fractions;

import java.util.Random;

import static math.integer.EratosthenesSieve.randomPrime;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the Fraction class.
 * @author Alonso del Arte
 */
public class FractionNGTest {
    
    private static final Random RANDOM = new Random();
    
    @Test
    public void testGetNumerator() {
        int expected = 2 * RANDOM.nextInt();
        int denom = Math.abs(expected) + 1;
        Fraction fraction = new Fraction(expected, denom);
        long actual = fraction.getNumerator();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testGetDenominator() {
        int numer = 2 * RANDOM.nextInt();
        int expected = Math.abs(numer) + 1;
        Fraction fraction = new Fraction(numer, expected);
        long actual = fraction.getDenominator();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToString() {
        System.out.println("toString");
        int numer = 2 * RANDOM.nextInt();
        int denom = numer + 1;
        Fraction fraction = new Fraction(numer, denom);
        String expected = numer + "/" + denom;
        String actual = fraction.toString().replace(" ", "");
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringLowestTerms() {
        int expDenom = randomPrime(Short.MAX_VALUE);
        int expNumer = RANDOM.nextInt(expDenom - 1) + 1;
        int multiplier = RANDOM.nextInt(expDenom - 2) + 2;
        int numer = multiplier * expNumer;
        int denom = multiplier * expDenom;
        Fraction fraction = new Fraction(numer, denom);
        String expected = expNumer + "/" + expDenom;
        String actual = fraction.toString().replace(" ", "");
        assertEquals(actual, expected);
    }
    
    @Test
    public void testNumeratorInLowestTerms() {
        int expDenom = randomPrime(Short.MAX_VALUE);
        int expected = RANDOM.nextInt(expDenom - 1) + 1;
        int multiplier = RANDOM.nextInt(expDenom - 2) + 2;
        int numer = multiplier * expected;
        int denom = multiplier * expDenom;
        Fraction fraction = new Fraction(numer, denom);
        long actual = fraction.getNumerator();
        String message = "Numerator of " + fraction.toString() + " should be " 
                + expected;
        assertEquals(actual, expected, message);
    }
    
}
