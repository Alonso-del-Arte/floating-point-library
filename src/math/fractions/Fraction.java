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
 *
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
    
    // TODO: Write tests for this
    public Fraction plus(Fraction addend) {return this;
//        return new Fraction(this.numerator + addend.numerator, 
//                this.denominator);
    }
    
    // TODO: Write tests for this
    public Fraction plus(int addend) {
        return this;
    }
    
    // TODO: Write tests for this
    public Fraction negate() {
        return this;
    }
    
    // TODO: Write tests for this
    public Fraction minus(Fraction subtrahend) {
        return this;
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
    
    // TODO: Write tests for this
    @Override
    public int hashCode() {
        return 0;
    }
    
    // TODO: Write tests for this
    @Override
    public int compareTo(Fraction other) {
        return 0;
    }
    
    @Override
    public String toString() {
        String absolute = Math.abs(this.numerator) + "/" + this.denominator;
        if (this.numerator < 0) {
            return "\u2212" + absolute;
        } else {
            return absolute;
        }
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
