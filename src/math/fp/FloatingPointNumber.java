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

import java.util.Arrays;

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
    
    /**
     * Indicates whether or not this number is a Not a Number (NaN) value.
     * @return True if this number is a NaN value, false in all other cases.
     */
    public abstract boolean isNaN();
    
    /**
     * Indicates whether or not this number is a quiet NaN value. A quiet NaN 
     * value is not supposed to indicate any special error condition. 
     * @return True if this number is a quiet NaN value, false in all other 
     * cases.
     */
    public abstract boolean isQuietNaN();
    
    /**
     * Indicates whether or not this number is a signaling NaN value. A 
     * signaling NaN value is not supposed to indicate any special error 
     * condition. 
     * @return True if this number is a signaling NaN value, false in all other 
     * cases.
     */
    public abstract boolean isSignalingNaN();
    
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
    
    /**
     * Compares this floating point number object for equality. For the 
     * examples, let's say this object is a 128-bit rational approximation of 
     * the mathematical constant &pi;. 
     * @param obj The object to compare this floating point number object to. 
     * Examples: 64-bit, 128-bit and 256-bit rational approximations of &pi; in 
     * <code>FloatingPointNumber</code> instances; a 128-bit rational 
     * approximation of &radic;10; a <code>BigDecimal</code> approximation of 
     * &pi;; a <code>LocalDateTime</code> object for the time and date right 
     * now; and a <code>Double</code> wrapping <code>Math.PI</code>.
     * @return True only if <code>obj</code> is a 
     * <code>FloatingPointNumber</code> instance of the same runtime class with 
     * the same number of bytes and the same bit pattern, false in all other 
     * cases. In the examples, false, true and false for the three 
     * <code>FloatingPointNumber</code> instances holding approximations of 
     * &pi;, and false for all others.
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
        return Arrays.equals(this.componentBytes, 
                ((FloatingPointNumber) obj).componentBytes);
    }
    
    /**
     * Gives a hash code for this floating point number. The hash codes can't be 
     * guaranteed to be unique if more than four bytes are used to represent the 
     * number.
     * @return A hash code.
     */
    @Override
    public int hashCode() {
        int hash = this.componentBytes.length << 16;
        hash += this.getClass().getName().hashCode();
        for (byte b : this.componentBytes) {
            hash += (b << 7);
            hash ^= b;
        }
        return hash;
    }
    
    // TODO: Write tests for this
    @Override
    public int compareTo(FloatingPointNumber other) {
        return 0;
    }
    
    public FloatingPointNumber(byte[] bytes) {
        if (bytes.length == 0) {
            String excMsg = "Byte array should have at least one number";
            throw new IllegalArgumentException(excMsg);
        }
        this.componentBytes = bytes;
    }
    
}
