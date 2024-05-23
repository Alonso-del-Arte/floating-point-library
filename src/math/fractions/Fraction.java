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

import static math.integer.Calculator.euclideanGCD;

/**
 * Represents a rational number symbolically. This class is limited to fractions 
 * with numerators and denominators in the range of <code>long</code>.
 * @author Alonso del Arte
 */
public class Fraction implements Comparable<Fraction> {
    
    private final long numerator, denominator;
    
    public long getNumerator() {
        return this.numerator;
    }
    
    public long getDenominator() {
        return this.denominator;
    }
    
    /**
     * Tells whether this fraction is an integer or not.
     * @return True if this fraction is an integer, false otherwise. For 
     * example, true for 22, false for <sup>22</sup>&frasl;<sub>7</sub>.
     */
    public boolean isInteger() {
        return this.denominator == 1L;
    }
    
    /**
     * Adds a fraction to this one. For the example, let's say this fraction is 
     * <sup>1</sup>&frasl;<sub>2</sub>.
     * @param addend The fraction to add to this one. For example, 
     * <sup>1</sup>&frasl;<sub>8</sub>.
     * @return The sum of this fraction and <code>addend</code>. For example, 
     * <sup>5</sup>&frasl;<sub>8</sub>.
     */
    public Fraction plus(Fraction addend) {
        long interNumerA = this.numerator * addend.denominator;
        long interNumerB = addend.numerator * this.denominator;
        long numer = interNumerA + interNumerB;
        long denom = this.denominator * addend.denominator;
        return new Fraction(numer, denom);
    }
    
    /**
     * Adds an integer to this fraction. For the example, let's say this 
     * fraction is <sup>25</sup>&frasl;<sub>68</sub>.
     * @param addend The integer to add. For example, 18025.
     * @return The sum. For example, <sup>1225725</sup>&frasl;<sub>68</sub>.
     */
    public Fraction plus(int addend) {
        long numer = this.numerator + this.denominator * addend;
        return new Fraction(numer, this.denominator);
    }
    
    /**
     * Multiplies this fraction by &minus;1. For the example, let's say this 
     * fraction is <sup>25</sup>&frasl;<sub>68</sub>.
     * @return This fraction negated. For example, 
     * &minus;<sup>25</sup>&frasl;<sub>68</sub>. In the special case of 0, we 
     * make no guarantees as to whether the returned object is the original 
     * object or a fresh instance.
     */
    public Fraction negate() {
        return new Fraction(-this.numerator, this.denominator);
    }
    
    /**
     * Subtracts a fraction from this one. For the example, let's say this 
     * fraction is <sup>1</sup>&frasl;<sub>2</sub>.
     * @param subtrahend The fraction to subtract from this one. For example, 
     * <sup>1</sup>&frasl;<sub>8</sub>.
     * @return This fraction minus <code>subtrahend</code>. For example, 
     * <sup>3</sup>&frasl;<sub>8</sub>.
     */
    public Fraction minus(Fraction subtrahend) {
        return this.plus(subtrahend.negate());
    }
    
    /**
     * Subtracts an integer from this fraction. For the example, let's say this 
     * fraction is <sup>25</sup>&frasl;<sub>68</sub>.
     * @param subtrahend The integer to subtract. For example, 18025.
     * @return This fraction minus <code>subtrahend</code>. For example, 
     * &minus;<sup>1225675</sup>&frasl;<sub>68</sub>.
     */
    public Fraction minus(int subtrahend) {
        return this.plus(-subtrahend);
    }
    
    /**
     * Multiplies this fraction by another. For the example, suppose this 
     * fraction is <sup>2</sup>&frasl;<sub>3</sub>.
     * @param multiplicand The fraction to multiply by. For example, 
     * <sup>5</sup>&frasl;<sub>7</sub>.
     * @return The product of this fraction and the multiplicand. In the 
     * example, <sup>10</sup>&frasl;<sub>21</sub>.
     */
    public Fraction times(Fraction multiplicand) {
        long numer = this.numerator * multiplicand.numerator;
        long denom = this.denominator * multiplicand.denominator;
        return new Fraction(numer, denom);
    }
    
    /**
     * Multiplies this fraction by an integer. For the example, suppose this 
     * fraction is <sup>2</sup>&frasl;<sub>3</sub>.
     * @param multiplicand The integer to multiply by. For example, 7.
     * @return The product of this fraction and the multiplicand. In the 
     * example, <sup>14</sup>&frasl;<sub>3</sub>.
     */
    public Fraction times(int multiplicand) {
        long numer = this.numerator * multiplicand;
        return new Fraction(numer, this.denominator);
    }
    
    /**
     * Takes the reciprocal of this fraction. The reciprocal of a fraction is 1 
     * divided by the fraction. For the example, suppose this fraction is 
     * <sup>3</sup>&frasl;<sub>7</sub>.
     * @return The reciprocal. For example, <sup>7</sup>&frasl;<sub>3</sub>.
     * @throws ArithmeticException If this fraction is 0.
     */
    public Fraction reciprocal() {
        return new Fraction(this.denominator, this.numerator);
    }
    
    /**
     * Divides this fraction by another. For the example, suppose this fraction 
     * is <sup>2</sup>&frasl;<sub>3</sub>.
     * @param divisor The fraction to divide this fraction by. For example, 
     * <sup>5</sup>&frasl;<sub>7</sub>.
     * @return This fraction divided by <code>divisor</code>. For example, 
     * <sup>14</sup>&frasl;<sub>15</sub>.
     * @throws ArithmeticException If <code>divisor</code> is 0.
     */
    public Fraction divides(Fraction divisor) {
        if (divisor.numerator == 0L) {
            String excMsg = "Can't divide " + this.toString() + " by 0";
            throw new ArithmeticException(excMsg);
        }
        return this.times(divisor.reciprocal());
    }
    
    // TODO: Write tests for this
    public Fraction divides(int divisor) {
        return this;
    }
    
    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        Fraction other = (Fraction) obj;
        if (this.numerator != other.numerator) {
            return false;
        }
        return this.denominator == other.denominator;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = (int) this.numerator;
        hash += (int) (this.denominator << 16);
        return hash;
    }
    
    // TODO: Write tests for this
    @Override
    public int compareTo(Fraction other) {
        return 0;
    }
    
    @Override
    public String toString() {
        String intermediate = Math.abs(this.numerator) + "/" + this.denominator;
        if (this.numerator < 0L) {
            intermediate = "\u2212" + intermediate;
        }
        if (this.denominator == 1L) {
            intermediate = intermediate.replace("/1", "");
        }
        return intermediate;
    }
    
    public Fraction(long numer, long denom) {
        if ((denom & Long.MAX_VALUE) == 0L) {
            String excMsg = "Denominator " + denom + " is not valid";
            throw new ArithmeticException(excMsg);
        }
        int sign = Long.signum(denom);
        long adjust = euclideanGCD(numer, denom) * sign;
        this.numerator = numer / adjust;
        this.denominator = denom / adjust;
    }
    
}
