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
    @Override
    public int compareTo(Fraction other) {
        return 0;
    }
    
    public Fraction(long numer, long denom) {
        this.numerator = numer;
        this.denominator = denom;
    }
    
}
