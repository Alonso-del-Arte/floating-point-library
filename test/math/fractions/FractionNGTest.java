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

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static math.integer.Calculator.euclideanGCD;
import static math.integer.EratosthenesSieve.randomOddPrime;
import static math.integer.EratosthenesSieve.randomPrime;

import static org.testframe.api.Asserters.assertThrows;

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
        int numer = 2 * RANDOM.nextInt(Short.MAX_VALUE);
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
    public void testToStringNegative() {
        long numer = -2 * RANDOM.nextInt(Short.MAX_VALUE) - 1;
        long denom = RANDOM.nextInt(Short.MAX_VALUE) * 2;
        Fraction fraction = new Fraction(numer, denom);
        long gcd = euclideanGCD(numer, denom);
        String expected = "\u2212" + (-numer / gcd) + "/" + (denom / gcd);
        String actual = fraction.toString();
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
    
    @Test
    public void testDenominatorInLowestTerms() {
        int expected = randomPrime(Short.MAX_VALUE);
        int expNumer = RANDOM.nextInt(expected - 1) + 1;
        int multiplier = RANDOM.nextInt(expected - 2) + 2;
        int numer = multiplier * expNumer;
        int denom = multiplier * expected;
        Fraction fraction = new Fraction(numer, denom);
        long actual = fraction.getDenominator();
        String message = "Denominator of " + fraction.toString() + " should be " 
                + expected;
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testToStringInteger() {
        int numer = RANDOM.nextInt();
        int denom = 1;
        Fraction fraction = new Fraction(numer, denom);
        String expected = Integer.toString(numer).replace("-", "\u2212");
        String actual = fraction.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testIsInteger() {
        System.out.println("isInteger");
        int numer = RANDOM.nextInt();
        int denom = 1;
        Fraction fraction = new Fraction(numer, denom);
        String msg = "Number " + fraction.toString() 
                + " should be considered an integer";
        assert fraction.isInteger() : msg;
    }
    
    @Test
    public void testIsNotInteger() {
        int numer = RANDOM.nextInt(64) + 36;
        int denom = (RANDOM.nextInt(256) + 4) * numer + 1;
        Fraction fraction = new Fraction(numer, denom);
        String msg = "Number " + fraction.toString() 
                + " should not be considered an integer";
        assert !fraction.isInteger() : msg;
    }
    
    @Test
    public void testReferentialEquality() {
        int numer = RANDOM.nextInt();
        int denom = RANDOM.nextInt() | 1;
        Fraction someFraction = new Fraction(numer, denom);
        assertEquals(someFraction, someFraction);
    }
    
    private static Object provideNull() {
        return null;
    }
    
    @Test
    public void testNotEqualsNull() {
        int numer = RANDOM.nextInt();
        int denom = RANDOM.nextInt() | 1;
        Fraction someFraction = new Fraction(numer, denom);
        String msg = someFraction.toString() + " should not equal null";
        Object nil = provideNull();
        assert !someFraction.equals(nil) : msg;
    }
    
    @Test
    public void testNotEqualsDiffClass() {
        int numer = RANDOM.nextInt();
        int denom = RANDOM.nextInt() | 1;
        Fraction someFraction = new Fraction(numer, denom);
        Fraction diffClassFraction = new Fraction(numer, denom) {
            
            @Override
            public String toString() {
                return super.toString().replace("/", "\\");
            }
            
        };
        String message = "Fraction " + someFraction.toString() + " of class " 
                + someFraction.getClass().getName() + " should not equal " 
                + diffClassFraction.toString() + " of class " 
                + diffClassFraction.getClass().getName();
        assertNotEquals(someFraction, diffClassFraction, message);
    }
    
    @Test
    public void testEquals() {
        System.out.println("equals");
        int numer = 2 * RANDOM.nextInt(Short.MAX_VALUE) + 1;
        int denom = (numer + 1) * (RANDOM.nextInt(Byte.MAX_VALUE) + 2);
        Fraction someFraction = new Fraction(numer, denom);
        Fraction sameFraction = new Fraction(numer, denom);
        assertEquals(someFraction, sameFraction);
    }
    
    @Test
    public void testNotEqualsDiffNumer() {
        int denom = randomOddPrime();
        int multDenom = 4 * (RANDOM.nextInt(Byte.MAX_VALUE) + 1) * denom;
        int numerA = multDenom + 1;
        Fraction fractionA = new Fraction(numerA, denom);
        int numerB = multDenom + 2;
        Fraction fractionB = new Fraction(numerB, denom);
        String message = "Fractions " + fractionA.toString() + " and " 
                + fractionB.toString() + " should not be considered equal";
        assertNotEquals(fractionA, fractionB, message);
    }
    
    @Test
    public void testNotEqualsDiffDenom() {
        int numer = randomOddPrime();
        int multNumer = 4 * (RANDOM.nextInt(Byte.MAX_VALUE) + 1) * numer;
        int denomA = multNumer + 1;
        Fraction fractionA = new Fraction(numer, denomA);
        int denomB = multNumer + 2;
        Fraction fractionB = new Fraction(numer, denomB);
        String message = "Fractions " + fractionA.toString() + " and " 
                + fractionB.toString() + " should not be considered equal";
        assertNotEquals(fractionA, fractionB, message);
    }
    
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int initialCapacity = RANDOM.nextInt(64) + 36;
        Set<Fraction> fractions = new HashSet<>(initialCapacity);
        Set<Integer> hashes = new HashSet<>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            int numer = i + RANDOM.nextInt(128) + initialCapacity;
            int denom = randomOddPrime();
            Fraction fraction = new Fraction(numer, denom);
            fractions.add(fraction);
            hashes.add(fraction.hashCode());
        }
        int expected = fractions.size();
        int actual = hashes.size();
        String message = "Set of " + expected 
                + " distinct fractions should have as many distinct hash codes";
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testPlusSameDenominator() {
        int denom = randomOddPrime();
        int numerA = RANDOM.nextInt(denom - 1) + 1;
        Fraction addendA = new Fraction(numerA, denom);
        int expNumer = denom + RANDOM.nextInt(denom - 2) + 1;
        int numerB = expNumer - numerA;
        Fraction addendB = new Fraction(numerB, denom);
        Fraction expected = new Fraction(expNumer, denom);
        Fraction actual = addendA.plus(addendB);
        String message = "Adding " + addendA.toString() + " to " 
                + addendB.toString();
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testPlus() {
        System.out.println("plus");
        int p = randomOddPrime();
        long numerA = 3 * p + RANDOM.nextInt(p - 1) + 1;
        long denomA = 2 * p;
        Fraction addendA = new Fraction(numerA, denomA);
        long numerB = denomA - 1;
        long denomB = numerA + 1;
        Fraction addendB = new Fraction(numerB, denomB);
        long interNumerA = numerA * denomB;
        long interNumerB = numerB * denomA;
        long resNumer = interNumerA + interNumerB;
        long resDenom = denomA * denomB;
        long gcd = euclideanGCD(resNumer, resDenom);
        long numer = resNumer / gcd;
        long denom = resDenom / gcd;
        Fraction expected = new Fraction(numer, denom);
        Fraction actual = addendA.plus(addendB);
        String message = "Adding " + addendA.toString() + " and " 
                + addendB.toString();
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testPlusInt() {
        int denom = RANDOM.nextInt(256) + 4;
        int numer = RANDOM.nextInt(denom - 1) + 1;
        Fraction fraction = new Fraction(numer, denom);
        int addend = 2 * (RANDOM.nextInt(Short.MAX_VALUE) - 16384) + 1;
        Fraction expected = new Fraction(numer + addend * denom, denom);
        Fraction actual = fraction.plus(addend);
        String message = "Adding " + fraction.toString() + " and " + addend;
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testMinusSameDenominator() {
        int denom = randomOddPrime();
        int numerA = denom + RANDOM.nextInt(denom - 1) + 1;
        Fraction minuend = new Fraction(numerA, denom);
        int numerB = RANDOM.nextInt(denom - 2) + 1;
        int expNumer = numerA - numerB;
        if (expNumer == denom) {
            numerB++;
            expNumer--;
        }
        Fraction subtrahend = new Fraction(numerB, denom);
        Fraction expected = new Fraction(expNumer, denom);
        Fraction actual = minuend.minus(subtrahend);
        String message = "Subracting " + subtrahend.toString() + " from " 
                + minuend.toString();
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testMinus() {
        System.out.println("minus");
        int p = randomOddPrime();
        long numerA = 3 * p + RANDOM.nextInt(p - 1) + 1;
        long denomA = 2 * p;
        Fraction minuend = new Fraction(numerA, denomA);
        long numerB = denomA - 1;
        long denomB = numerA + 1;
        Fraction subtrahend = new Fraction(numerB, denomB);
        long interNumerA = numerA * denomB;
        long interNumerB = numerB * denomA;
        long resNumer = interNumerA - interNumerB;
        long resDenom = denomA * denomB;
        long gcd = euclideanGCD(resNumer, resDenom);
        long numer = resNumer / gcd;
        long denom = resDenom / gcd;
        Fraction expected = new Fraction(numer, denom);
        Fraction actual = minuend.minus(subtrahend);
        String message = "Subracting " + subtrahend.toString() + " from " 
                + minuend.toString();
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testMinusInt() {
        int denom = RANDOM.nextInt(256) + 4;
        int squaredDenom = denom * denom;
        int numer = squaredDenom + RANDOM.nextInt(denom - 1) + 1;
        Fraction fraction = new Fraction(numer, denom);
        int subtrahend = RANDOM.nextInt(denom - 1) + 1;
        Fraction expected = new Fraction(numer - subtrahend * denom, denom);
        Fraction actual = fraction.minus(subtrahend);
        String message = "Subtracting " + subtrahend + " from " 
                + fraction.toString();
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testNegate() {
        System.out.println("negate");
        int denom = randomPrime(Short.MAX_VALUE) * randomOddPrime();
        int numer = RANDOM.nextInt(denom - 1) + 1;
        while (euclideanGCD(numer, denom) > 1) {
            numer++;
        }
        Fraction fraction = new Fraction(numer, denom);
        Fraction expected = new Fraction(-numer, denom);
        Fraction actual = fraction.negate();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testZeroNegatedIsStillZero() {
        Fraction expected = new Fraction(0, 1);
        Fraction actual = expected.negate();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testNegatedNegativeIsPositive() {
        int denom = randomPrime(Short.MAX_VALUE) * randomOddPrime();
        int numer = -RANDOM.nextInt(denom - 1) - 1;
        while (euclideanGCD(numer, denom) > 1) {
            numer--;
        }
        Fraction fraction = new Fraction(numer, denom);
        Fraction expected = new Fraction(-numer, denom);
        Fraction actual = fraction.negate();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testConstructorRejectsDenomZero() {
        int numer = RANDOM.nextInt();
        int badDenom = 0;
        String msg = "Should not be able to make fraction " + numer + "/" 
                + badDenom;
        Exception e = assertThrows(() -> {
            Fraction badFraction = new Fraction(numer, badDenom);
            System.out.println("Should not have been able to instantiate " 
                    + badFraction.toString());
        }, ArithmeticException.class, msg);
        String excMsg = e.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be blank";
        String numStr = Long.toString(badDenom);
        String containsMsg = "Exception message should contain \"" + numStr 
                + "\"";
        assert excMsg.contains(numStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void testConstructorRejectsDenomLongMinimum() {
        int numer = RANDOM.nextInt();
        long badDenom = Long.MIN_VALUE;
        String msg = "Should not be able to make fraction " + numer + "/" 
                + badDenom;
        Exception e = assertThrows(() -> {
            Fraction badFraction = new Fraction(numer, badDenom);
            System.out.println("Should not have been able to instantiate " 
                    + badFraction.toString());
        }, ArithmeticException.class, msg);
        String excMsg = e.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be blank";
        String numStr = Long.toString(badDenom);
        String containsMsg = "Exception message should contain \"" + numStr 
                + "\"";
        assert excMsg.contains(numStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void testConstructorTurnsNegativeDenominatorPositive() {
        int numer = RANDOM.nextInt() | 1;
        int denom = ((RANDOM.nextInt() << 1) | Integer.MIN_VALUE) + 1;
        Fraction fraction = new Fraction(numer, denom);
        long gcd = euclideanGCD(numer, denom);
        long expNumer = -numer / gcd;
        long expDenom = -denom / gcd;
        long actNumer = fraction.getNumerator();
        long actDenom = fraction.getDenominator();
        String message = "Given numerator " + numer + " and denominator " 
                + denom + " should be turned to " + expNumer + "/" + expDenom;
        assertEquals(actNumer, expNumer, message);
        assertEquals(actDenom, expDenom, message);
    }
    
}
