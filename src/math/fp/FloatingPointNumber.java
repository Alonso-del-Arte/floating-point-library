/*
 * Copyright (C) 2024 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package math.fp;

/**
 * Represents a floating point number.
 * @author Alonso del Arte
 */
public abstract class FloatingPointNumber 
        implements Comparable<FloatingPointNumber> {
    
    final byte[] componentBytes;
    
    public byte[] getBytes() {
        int length = this.componentBytes.length;
        byte[] copy = new byte[length];
        System.arraycopy(this.componentBytes, 0, copy, 0, length);
        return copy;
    }
    
    public abstract boolean isFinite();
    
    public abstract boolean isInfinite();
    
    public abstract boolean isNaN();
    
    public abstract float to32BitPrimitive();
    
    public abstract double to64BitPrimitive();

    public abstract QuarterPrecisionNumber toQuarterPrecision();
    
    public abstract HalfPrecisionNumber toHalfPrecision();
    
    public abstract SinglePrecisionNumber toSinglePrecision();
    
    public abstract DoublePrecisionNumber toDoublePrecision();
    
    public abstract QuadruplePrecisionNumber toQuadruplePrecision();
    
    public abstract OctuplePrecisionNumber toOctuplePrecision();
    
    public abstract String toHexadecimalString();
    
    // TODO: Write tests for this
    public static FloatingPointNumber apply(byte[] bytes) {
        return null;
    }
    
    // TODO: Write tests for this
    public FloatingPointNumber plus(FloatingPointNumber addend) {
        return this;
    }
    
    // TODO: Write tests for this
    public FloatingPointNumber minus(FloatingPointNumber subtrahend) {
        return this;
    }
    
    // TODO: Write tests for this
    public FloatingPointNumber times(FloatingPointNumber multiplicand) {
        return this;
    }
    
    // TODO: Write tests for this
    public FloatingPointNumber divides(FloatingPointNumber divisor) {
        return this;
    }
    
    @Override
    public boolean equals(Object obj) {
        return false;
    }
    
    // TODO: Write tests for this
    @Override
    public int hashCode() {
        return 0;
    }
    
    // TODO: Write tests for this
    @Override
    public int compareTo(FloatingPointNumber other) {
        return 0;
    }
    
    public FloatingPointNumber(byte[] bytes) {
        this.componentBytes = bytes;
    }
    
}
