/*
 * Copyright (C) 2025 Alonso del Arte
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

import math.fractions.Fraction;

/**
 * Represents an 8-bit or "quarter precision" floating point number. Also called 
 * "minifloat."
 * @author Alonso del Arte
 */
public class QuarterPrecisionNumber extends FloatingPointNumber {
    
    private static final char MINUS_SIGN = '\u2212';
    
    private static final Fraction ONE = new Fraction(1, 1);
    
    private static final Fraction ONE_EIGHTH = ONE.divides(8);
    
    /**
     * Bit mask for the exponent bits. Also happens to be the byte for positive 
     * infinity.
     */
    private static final byte EXPONENT_MASK = 120;

    private static final byte ZERO_BYTE = 0;
    
    private static final byte[] TWO_ZEROS = {ZERO_BYTE, ZERO_BYTE}; // half

    private static final byte[] FOUR_ZEROS = {ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, 
        ZERO_BYTE}; // float

    private static final byte[] EIGHT_ZEROS = {ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, 
        ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE}; // double

    private static final byte[] SIXTEEN_ZEROS = {ZERO_BYTE, ZERO_BYTE, 
        ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, 
        ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, 
        ZERO_BYTE, ZERO_BYTE}; // quadruple

    private static final byte[] THIRTY_TWO_ZEROS = {ZERO_BYTE, ZERO_BYTE, 
        ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, 
        ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, 
        ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE,
        ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, 
        ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE, ZERO_BYTE}; 
// octuple
    
    private final byte heldByte;

    /**
     * Gives the number's unbiased exponent. Will never be negative.
     * @return The number's unbiased exponent. 0 for subnormal numbers, 
     * 2<sup><i>w</i></sup> &minus; 1 for infinities and NaNs, where 
     * <i>w</i> is the number of exponent bits, and numbers in between for the 
     * other numbers.
     */
    @Override
    public int getUnbiasedExponent() {
        return (this.heldByte & EXPONENT_MASK) >> 3;
    }
    
    /**
     * Gives the number's biased exponent. May be negative.
     * @return The number's biased exponent: &minus;6 for subnormal numbers and 
     * normal numbers close to subnormal, 7 for finite numbers with the largest 
     * absolute values, and 8 for infinities and NaN values, and numbers in 
     * between for the other numbers.
     */
    @Override
    public int getBiasedExponent() {
        int absolute = this.heldByte & EXPONENT_MASK;
        if (absolute < 8) {
            return -6;
        }
        return (absolute >> 3) - 7;
    }
    
    /**
     * Tells whether this number is a finite normal number. A normal number, or 
     * normalized number, has an implied leading 1 in its mantissa.
     * @return True if this number's absolute value is at least 0.015625 and at 
     * most 240.0, false in all other cases (namely the NaN values, the 
     * infinities and the numbers from &minus;0.013671875 to 0.013671875).
     */
    @Override
    public boolean isNormal() {
        byte signMasked = (byte) (this.heldByte & Byte.MAX_VALUE);
        return signMasked > 7 && signMasked < 120;
    }
    
    /**
     * Tells whether this number is a subnormal number. A floating point number 
     * is subnormal if its exponent is all zeroes and therefore has no implied 
     * leading 1 in its mantissa.
     * @return True if this number is in the range from &minus;0.013671875 to 
     * 0.013671875, false in all other cases (namely the NaN values, the 
     * infinities and the finite numbers with absolute value greater than 
     * 0.013671875).
     */
    @Override
    public boolean isSubnormal() {
        return (this.heldByte & Byte.MAX_VALUE) < 8;
    }
    
    /**
     * Tells whether this number is zero or not. Remember that there is negative 
     * zero in floating point.
     * @return True if this number is &plusmn;0.0, false otherwise.
     */
    @Override
    public boolean isZero() {
        return (this.heldByte & Byte.MAX_VALUE) == 0;
    }
    
    /**
     * Determines whether this floating point number represents an integer or 
     * not. Keep in mind that infinities and NaN values will always be 
     * considered to not be integers even if they stand in for integers that 
     * overflowed or real integers multiplied by the imaginary unit <i>i</i>.
     * @return True if this floating point number is an integer, false in all 
     * other cases (such as nonzero subnormal numbers). Examples: true for 
     * &minus;240.0, false for negative infinity, true for 7.0, false for 7.5.
     */
    @Override
    public boolean isInteger() {
        return switch(this.heldByte) {
            case Byte.MIN_VALUE, 0 -> true;
            case -8, -7, -6, -5, -4, -3, -2, -1, 120, 121, 122, 123, 124, 125, 
                126, Byte.MAX_VALUE -> false;
            default -> this.toNonNegativeFractionNormal().isInteger();
        };
    }
    
    /**
     * Tells whether or not this number is finite or not. Note that NaN is 
     * considered not finite even though it is also considered not infinite.
     * @return True if this number is normal or subnormal, false in all other 
     * cases (negative infinity, positive infinity, NaN).
     */
    @Override
    public boolean isFinite() {
        return (this.heldByte & EXPONENT_MASK) != EXPONENT_MASK;
    }
    
    /**
     * Tells whether or not this number is infinite or not. Note that NaN is 
     * considered not infinite even though it is also considered not finite.
     * @return True if this number is &plusmn;&infin;, false in all other cases, 
     * including NaN.
     */
    @Override
    public boolean isInfinite() {
        return (this.heldByte & Byte.MAX_VALUE) == EXPONENT_MASK;
    }
    
    /**
     * Indicates whether or not this number is a Not a Number (NaN) value. Note 
     * that the infinities are not considered NaN, even though they don't 
     * represent finite numbers either.
     * @return True if this number is a NaN value, false in all other cases, 
     * including &plusmn;&infin;. Examples: true for the NaNs from the bit 
     * patterns &minus;3 and 125, false for &minus;240.0 and 0.0078125.
     */
    @Override
    public boolean isNaN() {
        return (this.heldByte & Byte.MAX_VALUE) > EXPONENT_MASK;
    }
    
    /**
     * Indicates whether or not this number is a quiet NaN value. A quiet NaN 
     * value is not supposed to indicate any special error condition.
     * @return True if this number's bit pattern is &minus;4, &minus;3, 
     * &minus;2, &minus;1, 124, 125, 126 or 127, false in all other cases.
     */
    @Override
    public boolean isQuietNaN() {
        int masked = this.heldByte & Byte.MAX_VALUE;
        return masked > 123;
    }

    /**
     * Indicates whether or not this number is a signaling NaN value. A 
     * signaling NaN value is supposed to indicate a special error condition, 
     * but there has been no widespread agreement on how different error 
     * conditions are to be signaled.
     * @return True if this number's bit pattern is &minus;7, &minus;6, 
     * &minus;5, 121, 122 or 123, false in all other cases.
     */
    @Override
    public boolean isSignalingNaN() {
        int masked = this.heldByte & Byte.MAX_VALUE;
        return masked > 120 && masked < 124;
    }

    private Fraction toNonNegativeFractionNormal() {
        int mantissaBitPattern = this.heldByte & 7;
        Fraction fraction = ONE.plus(ONE_EIGHTH.times(mantissaBitPattern));
        int exponent = ((this.heldByte & EXPONENT_MASK) >> 3) - 7;
        while (exponent < 0) {
            fraction = fraction.divides(2);
            exponent++;
        }
        while (exponent > 0) {
            fraction = fraction.times(2);
            exponent--;
        }
        return fraction;
    }
    
    private double toDoubleNormal() {
        Fraction fraction = this.toNonNegativeFractionNormal();
        double sign = (this.heldByte < 0) ? -1.0 : 1.0;
        return sign * fraction.numericApproximation();
    }
            
    /**
     * Gives a 32-bit primitive floating point number corresponding to this one. 
     * Since quarter-precision numbers have less precision than single-precision 
     * numbers, there is a precise correspondence between all possible finite 
     * quarter-precision values and the returned primitives, as well as for 
     * &plusmn;&infin;. However, for all NaN bit patterns, this function simply 
     * returns the canonical NaN 32-bit primitive.
     * @return A 32-bit floating point number primitive. For example, 
     * &minus;0.013671875.
     */
    @Override
    public float to32BitPrimitive() {
        return switch (this.heldByte) {
            case Byte.MIN_VALUE -> -0.0f;
            case -127 -> -0.001953125f;
            case -126 -> -0.00390625f;
            case -125 -> -0.005859375f;
            case -124 -> -0.0078125f;
            case -123 -> -0.009765625f;
            case -122 -> -0.01171875f;
            case -121 -> -0.013671875f;
            case -8 -> Float.NEGATIVE_INFINITY;
            case -7, -6, -5, -4, -3, -2, -1, 121, 122, 123, 124, 125, 126, 
                Byte.MAX_VALUE -> Float.NaN;
            case 0 -> 0.0f;
            case 1 -> 0.001953125f;
            case 2 -> 0.00390625f;
            case 3 -> 0.005859375f;
            case 4 -> 0.0078125f;
            case 5 -> 0.009765625f;
            case 6 -> 0.01171875f;
            case 7 -> 0.013671875f;
            case 120 -> Float.POSITIVE_INFINITY;
            default -> (float) this.toDoubleNormal();
        };
    }

    /**
     * Gives a 64-bit primitive floating point number corresponding to this one. 
     * Since quarter-precision numbers have less precision than single-precision 
     * numbers, there is a precise correspondence between all possible finite 
     * quarter-precision values and the returned primitives, as well as for 
     * &plusmn;&infin;. However, for all NaN bit patterns, this function simply 
     * returns the canonical NaN 64-bit primitive.
     * @return A 64-bit floating point number primitive. For example, 
     * &minus;0.013671875.
     */
    @Override
    public double to64BitPrimitive() {
        return switch (this.heldByte) {
            case Byte.MIN_VALUE -> -0.0;
            case -127 -> -0.001953125;
            case -126 -> -0.00390625;
            case -125 -> -0.005859375;
            case -124 -> -0.0078125;
            case -123 -> -0.009765625;
            case -122 -> -0.01171875;
            case -121 -> -0.013671875;
            case -8 -> Double.NEGATIVE_INFINITY;
            case -7, -6, -5, -4, -3, -2, -1, 121, 122, 123, 124, 125, 126, 
                Byte.MAX_VALUE -> Double.NaN;
            case 0 -> 0.0;
            case 1 -> 0.001953125;
            case 2 -> 0.00390625;
            case 3 -> 0.005859375;
            case 4 -> 0.0078125;
            case 5 -> 0.009765625;
            case 6 -> 0.01171875;
            case 7 -> 0.013671875;
            case 120 -> Double.POSITIVE_INFINITY;
            default -> this.toDoubleNormal();
        };
    }

    /**
     * Converts this number to a quarter precision number. Since in this 
     * instance the number is already in quarter precision, there is no 
     * narrowing or widening conversion necessary.
     * @return Either this same instance or a fresh new instance with the same 
     * byte value passed to its constructor.
     */
    @Override
    public QuarterPrecisionNumber toQuarterPrecision() {
        return this;
    }

    @Override
    public HalfPrecisionNumber toHalfPrecision() {
        short sh = switch (this.heldByte) {
            case Byte.MIN_VALUE -> Short.MIN_VALUE;
            case -127 -> -26624;
            case -126 -> -25600;
            case -125 -> -25088;
            case -124 -> -24576;
            case -123 -> -24320;
            case -122 -> -24064;
            case -121 -> -23808;
            case -8 -> -1024;
            case -7, -6, -5, -4, -3, -2, -1, 121, 122, 123, 124, 125, 126, 
                Byte.MAX_VALUE -> Short.MAX_VALUE;
            case 0 -> 0;
            case 1 -> 6144;
            case 2 -> 7168;
            case 3 -> 7680;
            case 4 -> 8192;
            case 5 -> 8448;
            case 6 -> 8704;
            case 7 -> 8960;
            case 120 -> 31744;
            default -> {
                int sign = (this.heldByte < 0) ? 32768 : 0;
                int exponent = ((this.heldByte & 120) + 64) << 7;
                int mantissa = (this.heldByte & 7) << 7;
                yield (short) (sign + exponent + mantissa);
            }
        };
        return new HalfPrecisionNumber(sh);
    }

    // TODO: Write tests for this
    @Override
    public SinglePrecisionNumber toSinglePrecision() {
        return new SinglePrecisionNumber(FOUR_ZEROS);
    }

    // TODO: Write tests for this
    @Override
    public DoublePrecisionNumber toDoublePrecision() {
        return new DoublePrecisionNumber(EIGHT_ZEROS);
    }

    // TODO: Write tests for this
    @Override
    public QuadruplePrecisionNumber toQuadruplePrecision() {
        return new QuadruplePrecisionNumber(SIXTEEN_ZEROS);
    }

    // TODO: Write tests for this
    @Override
    public OctuplePrecisionNumber toOctuplePrecision() {
        return new OctuplePrecisionNumber(THIRTY_TWO_ZEROS);
    }
    
    // TODO: Refactor once all the plus and minus test cases are written
    private QuarterPrecisionNumber plusQPN(QuarterPrecisionNumber qpn) {
        if (this.heldByte == 0) {
            if (qpn.heldByte == Byte.MIN_VALUE) {
                return this;
            } else {
                return qpn;
            }
        }
        if (this.heldByte == Byte.MIN_VALUE) {
            return qpn;
        }
        if (this.isNormal() && qpn.isNormal()) {
            if (this.heldByte > -17 && this.heldByte < -8 && qpn.heldByte > -17 
                    && qpn.heldByte < -8) {
                return new QuarterPrecisionNumber((byte) -8);
            }
            if (this.heldByte > 112 && this.heldByte < 120 && qpn.heldByte > 112 
                    && qpn.heldByte < 120) {
                return new QuarterPrecisionNumber((byte) 120);
            }
            return new QuarterPrecisionNumber((byte) (this.heldByte + 8));
        } 
        if (qpn.heldByte < 0) {
            byte b = (byte) (this.heldByte + (Byte.MIN_VALUE ^ qpn.heldByte));
            return new QuarterPrecisionNumber(b);
        }
        byte b = (byte) (this.heldByte + qpn.heldByte);
        return new QuarterPrecisionNumber(b);
    }
    
    /** WORK IN PROGRESS...
     * Adds a floating point number to this one. This is guaranteed to be a 
     * commutative operation if both operands are of the same runtime class. But 
     * if there are narrowing involved, the result might overflow to an infinity 
     * in one direction or one addend might vanish to 0.
     * @param addend The number to add. For example, 0.25.
     * @return This number plus the addend.
     * <p>Special cases:</p>
     * <ul>
     * <li>Negative zero plus <i>x</i> equals <i>x</i>, even if <i>x</i> is 
     * positive zero.</li>
     * <li></li>
     * <li></li>
     * <li></li>
     * <li></li>
     * <li></li>
     * <li></li>
     * <li></li>
     * <li></li>
     * <li></li>
     * </ul>
     */
    @Override
    public QuarterPrecisionNumber plus(FloatingPointNumber addend) {
        if (addend instanceof QuarterPrecisionNumber qpn) {
            return this.plusQPN(qpn);
//        } else {
//            return this.plus(addend.toQuarterPrecision());
        }
        return this;
    }
    
    /**
     * Negates this number. For the example, suppose this number is 0.009765625.
     * @return This number with the sign bit toggled. For example, 
     * &minus;0.009765625. Note that {@code this.negate().negate().equals(this)} 
     * will be true.
     */
    @Override
    public QuarterPrecisionNumber negate() {
        byte b = (byte) (this.heldByte ^ Byte.MIN_VALUE);
        return new QuarterPrecisionNumber(b);
    }
    
    // TODO: Write tests for this
    @Override
    public QuarterPrecisionNumber minus(FloatingPointNumber subtrahend) {
        return this;
    }
    
    // TODO: Write tests for this
    @Override
    public QuarterPrecisionNumber times(FloatingPointNumber multiplicand) {
        return this;
    }
    
    @Override
    public QuarterPrecisionNumber reciprocal() {
        return this;
    }
    
    // TODO: Write tests for this
    @Override
    public QuarterPrecisionNumber divides(FloatingPointNumber divisor) {
        return this;
    }
    
    private boolean arithEq(QuarterPrecisionNumber alreadyQPN) {
        if (this.isNaN() || alreadyQPN.isNaN()) {
            return false;
        }
        return this.heldByte == alreadyQPN.heldByte;
    }
    
    /** WORK IN PROGRESS... CURRENTLY TESTING WITH QUARTER PREC INSTANCES
     * Determines whether or not this number is arithmetically equal to another 
     * according to the IEEE-754 standard. This diverges somewhat from the 
     * results of {@link #equals(java.lang.Object) equals()}.
     * For the examples, suppose this number is &minus;0.001953125.
     * @param other The number to compare against. Examples: &minus;0.001953125, 
     * &minus;0.0019550323486328125, 0.001953125, 240.0, positive infinity, NaN 
     * from bit pattern 0xFF.
     * @return True if {@code other} is arithmetically equal to this number, 
     * false otherwise. In the examples, true for the first one, false for the 
     * others, even though one of the examples would be equal in a narrowing 
     * conversion and another example is equal in absolute value. Special cases 
     * to consider:
     * <ul>
     * <li>NaN is never arithmetically equal to itself, even if both instances 
     * are constructed from the same bit pattern.</li>
     * </ul>
     */
    @Override
    public boolean arithmeticallyEqual(FloatingPointNumber other) {
        if (other instanceof QuarterPrecisionNumber alreadyQPN) {
            return this.arithEq(alreadyQPN);
        } else {
            return true;
        }
    }
    
    private String toStringNormal() {
        String intermediate = Double.toString(this.toNonNegativeFractionNormal()
                .numericApproximation());
        return (this.heldByte < 0) ? MINUS_SIGN + intermediate : intermediate;
    }
    
    /**
     * Gives a textual representation of this number. For negative numbers, 
     * including negative zero, the "&minus;" character is used.
     * @return A textual representation in base 10. For example, "0.0859375". 
     * Special cases: "NaN" for all NaN values regardless of bit pattern, 
     * "&minus;Infinity" and "Infinity" for negative and positive infinity 
     * respectively.
     */
    @Override
    public String toString() {
        return switch (this.heldByte) {
            case -128 -> MINUS_SIGN + "0.0";
            case -127 -> MINUS_SIGN + "0.001953125";
            case -126 -> MINUS_SIGN + "0.00390625";
            case -125 -> MINUS_SIGN + "0.005859375";
            case -124 -> MINUS_SIGN + "0.0078125";
            case -123 -> MINUS_SIGN + "0.009765625";
            case -122 -> MINUS_SIGN + "0.01171875";
            case -121 -> MINUS_SIGN + "0.013671875";
            case -8 -> MINUS_SIGN + "Infinity";
            case -7, -6, -5, -4, -3, -2, -1, 121, 122, 123, 124, 125, 126, 
                Byte.MAX_VALUE -> "NaN";
            case 0 -> "0.0";
            case 1 -> "0.001953125";
            case 2 -> "0.00390625";
            case 3 -> "0.005859375";
            case 4 -> "0.0078125";
            case 5 -> "0.009765625";
            case 6 -> "0.01171875";
            case 7 -> "0.013671875";
            case 120 -> "Infinity";
            default -> this.toStringNormal();
        };
    }
    
    /**
     * Gives the bit pattern of this number as the textual representation of an 
     * unsigned hexadecimal number. Will be zero-padded on the left as needed.
     * @return A sequence of two hexadecimal digit characters, zero-padded if 
     * necessary. For example, for the byte 60 corresponding to the quarter 
     * precision number 1.5, this function will return "3c". If you prefer the 
     * output to use uppercase letters for the digits A, B, C, D, E, F, simply 
     * use {@code toUpperCase()} on the return of this function.
     */
    @Override
    public String bitPatternHexadecimal() {
        String intermediate 
                = Integer.toHexString(Byte.toUnsignedInt(this.heldByte));
        return (intermediate.length() == 1) ? '0' + intermediate : intermediate;
    }
    
    public QuarterPrecisionNumber(byte b) {
        super(new byte[]{b});
        this.heldByte = b;
    }
    
}
