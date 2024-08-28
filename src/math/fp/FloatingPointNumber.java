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
    
    /**
     * Gives the number's unbiased exponent. Should never be negative.
     * @return The number's unbiased exponent. Should be 0 for subnormal 
     * numbers, 2<sup><i>w</i></sup> &minus; 1 for infinities and NaNs, where 
     * <i>w</i> is the number of exponent bits.
     */
    public abstract int getUnbiasedExponent();
    
    /**
     * Gives the number's biased exponent. May be negative.
     * @return The number's biased exponent. Should be the same for subnormal 
     * numbers and the normal numbers closest to the subnormal numbers.
     */
    public abstract int getBiasedExponent();
    
    /**
     * Indicates whether or not this number is normal. A number is said to be 
     * normal in the IEEE-754 sense if its floating point representation 
     * includes a tacit 1.  
     * @return True if this number is finite and normal, false in all other 
     * cases. Examples: true for rational approximations of <i>e</i> and &pi;; 
     * false for &minus;0.0, infinity and canonical NaN.
     */
    public abstract boolean isNormal();
    
    /**
     * Indicates whether or not this number is subnormal. A number is said to be 
     * subnormal in the IEEE-754 sense if its floating point representation does 
     * not include a tacit 1.  
     * @return True if this number is finite and subnormal, false in all other 
     * cases. Examples: true for &minus;0.0; false for rational approximations 
     * of <i>e</i> and &pi;, infinity and canonical NaN.
     */
    public abstract boolean isSubnormal();
    
    // TODO: Write tests for this
    public boolean isZero() {
        boolean allZeroSoFar = true;
        int index = 0;
        while (allZeroSoFar && index < this.componentBytes.length) {
            allZeroSoFar &= (this.componentBytes[index] == 0);
            index++;
        }
        return allZeroSoFar;
    }
    
    /**
     * Determines whether this floating point number represents an integer or 
     * not. Keep in mind that infinities and NaN values will always be 
     * considered to not be integers even if they stand in for integers that 
     * overflowed or real integers multiplied by the imaginary unit <i>i</i>.
     * @return True if this floating point number is an integer, false in all 
     * other cases (such as nonzero subnormal numbers). Examples: true for 
     * &minus;240.0, false for positive infinity, true for 7.0, false for 
     * 7.068583470577035.
     */
    public abstract boolean isInteger();
    
    /**
     * Tells whether or not this number is finite or not. Note that NaN is 
     * considered not finite even though it is also considered not infinite.
     * @return True if this number is normal or subnormal, false in all other 
     * cases (negative infinity, positive infinity, NaN).
     */
    public abstract boolean isFinite();
    
    /**
     * Tells whether or not this number is infinite or not. Note that NaN is 
     * considered not infinite even though it is also considered not finite.
     * @return True if this number is &plusmn;&infin;, false in all other cases, 
     * including NaN.
     */
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
     * signaling NaN value is supposed to indicate a special error condition, 
     * but there has been no widespread agreement on how different error 
     * conditions are to be signaled. The Java Virtual Machine bypasses the 
     * whole issue by always or almost always giving a canonical quiet NaN for 
     * operations that give NaN (such as taking the square root of a negative 
     * number).
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
    
    /**
     * Gives the bit pattern of this number as the textual representation of an 
     * unsigned hexadecimal number. The nice thing about hexadecimal is that one 
     * hexadecimal digit neatly corresponds to four bits. For the example, 
     * suppose this is floating point number made up of the bytes &minus;1 
     * (unsigned 255), &minus;128 (unsigned 128), 3, 5, 90.
     * @return A sequence of twice as many hexadecimal digit characters as the 
     * number has component bytes. In the example, this would be "FF8003055A".
     */
    public String bitPatternHexadecimal() {
        int capacity = 2 * this.componentBytes.length;
        StringBuilder builder = new StringBuilder(capacity);
        for (byte b : this.componentBytes) {
            String str = Integer.toHexString(Byte.toUnsignedInt(b));
            if (str.length() == 1) {
                str = '0' + str;
            }
            builder.append(str);
        }
        return builder.toString();
    }
    
    // TODO: Write tests for this
    public static FloatingPointNumber apply(byte[] bytes) {
        return null;
    }
    
    /**
     * Adds a floating point number to this one. This is guaranteed to be a 
     * commutative operation if both operands are of the same runtime class. But 
     * if there are narrowing or widening conversions involved, the result might 
     * overflow to an infinity in one direction or one addend might vanish to 0.
     * @param addend The number to add. For example, 0.25.
     * @return This number plus the addend.
     */
    public abstract FloatingPointNumber plus(FloatingPointNumber addend);
    
    /**
     * Negates this number. For the example, suppose this number is 3.1415927 
     * (the 32-bit approximation to &pi;).
     * @return This number with the sign bit toggled. For example, 
     * &minus;3.1415927. Note that {@code this.negate().negate().equals(this)} 
     * should be true.
     */
    public abstract FloatingPointNumber negate();
    
    /**
     * Subtracts a floating point number from this one. Overflows or underflows 
     * might occur if the operands are of different runtime classes. A default 
     * implementation is provided which uses {@link 
     * #plus(math.fp.FloatingPointNumber) plus} and {@link #negate()}. Depending 
     * on the implementations of those functions, it may or may not be more 
     * efficient to override this function.
     * @param subtrahend The number to subtract. For example, 3.125.
     * @return This number minus the subtrahend.
     */
    public FloatingPointNumber minus(FloatingPointNumber subtrahend) {
        return this.plus(subtrahend.negate());
    }
    
    /**
     * Multiplies this number by a floating point number to this one. This is 
     * guaranteed to be a commutative operation if both operands are of the same 
     * runtime class. But if there are narrowing or widening conversions 
     * involved, the result might overflow to an infinity in one direction or 
     * one multiplicand might vanish to 0, causing the result to also vanish to 
     * 0.
     * @param multiplicand The number to multiply by. For example, 0.25.
     * @return This number times the multiplicand.
     */
    public abstract FloatingPointNumber times(FloatingPointNumber multiplicand);
    
    /**
     * Divides 1.0 by this number. For the example, suppose this number is 
     * 3.1415927 (the 32-bit approximation to &pi;).
     * @return 1.0 divided by this number. For example, 0.31830987.
     */
    public abstract FloatingPointNumber reciprocal();
    
    // TODO: Write tests for this
    /**
     * Divides this number by a floating point number. This operation should 
     * never cause an exception.
     * @param divisor The number to divide by. For example, 3.125. The numbers 
     * 0.0, &minus;0.0, the infinities and the various NaNs are all acceptable 
     * divisors.
     * @return This number divided by the divisor. 
     */
    public FloatingPointNumber divides(FloatingPointNumber divisor) {
        return this;
    }
    
    public abstract boolean arithmeticallyEqual(FloatingPointNumber other);
    
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
