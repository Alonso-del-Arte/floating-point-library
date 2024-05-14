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
    
    // TODO: Write tests for this
    public Fraction negate() {
        return this;
    }
    
    // TODO: Write tests for this
    public Fraction minus(Fraction subtrahend) {
        return new Fraction(this.numerator - subtrahend.numerator, 
                this.denominator);
    }
    
    // TODO: Write tests for this
    public Fraction minus(int subtrahend) {
        return this;
    }
    
    // TODO: Write tests for this
    public Fraction times(Fraction multiplicand) {
        return this;
    }
    
    // TODO: Write tests for this
    public Fraction times(int multiplicand) {
        return this;
    }
    
    // TODO: Write tests for this
    public Fraction reciprocal() {
        return this;
    }
    
    // TODO: Write tests for this
    public Fraction divides(Fraction divisor) {
        return this;
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
