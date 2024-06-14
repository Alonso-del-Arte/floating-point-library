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

import math.fractions.Fraction;

/**
 * Represents an 8-bit or "quarter precision" floating point number. Also called 
 * "minifloat."
 * @author Alonso del Arte
 */
public class QuarterPrecisionNumber extends FloatingPointNumber {
    
    private static final Fraction ONE = new Fraction(1, 1);
    
    private static final Fraction ONE_EIGHTH = ONE.divides(8);

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

    // TODO: Write tests for this
    @Override
    public boolean isNormal() {
        return (this.heldByte & 120) != 120;
    }
    
    // TODO: Write tests for this
    @Override
    public boolean isSubnormal() {
        return this.heldByte != -8;
    }
    
    // TODO: Write tests for this
    @Override
    public boolean isInteger() {
        return true;
    }
    
    // TODO: Write tests for this
    @Override
    public boolean isFinite() {
        return false;
    }
    
    // TODO: Write tests for this
    @Override
    public boolean isInfinite() {
        return false;
    }
    
    // TODO: Write tests for this
    @Override
    public boolean isNaN() {
        return false;
    }
    
    // TODO: Write tests for this
    @Override
    public boolean isQuietNaN() {
        return false;
    }

    // TODO: Write tests for this
    @Override
    public boolean isSignalingNaN() {
        return false;
    }

    private Fraction toNonNegativeFractionNormal() {
        int mantissaBitPattern = this.heldByte & 7;
        Fraction fraction = ONE.plus(ONE_EIGHTH.times(mantissaBitPattern));
        int exponent = ((this.heldByte & 120) >> 3) - 7;
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
     * WORK IN PROGRESS...
     * Gives a 32-bit primitive floating point number corresponding to this one. 
     * Since quarter-precision numbers have less precision than single-precision 
     * numbers, there should be a precise correspondence between all possible 
     * quarter-precision values and the returned primitives. However, for NaN 
     * values other than canonical NaN, we make no promises.
     * @return A 32-bit floating point number primitive.
     */
    @Override
    public float to32BitPrimitive() {
        return switch (this.heldByte) {
            case Byte.MIN_VALUE -> -0.0f;
            case -120 -> 1.0f;
            case -111 -> 1.1f;
            case -8 -> Float.NEGATIVE_INFINITY;
            case -7, -6, -5, -4, -3, -2, -1, 121, 122, 123, 124, 125, 126, 127 
                -> Float.NaN;
            case 0 -> 0.0f;
            case 120 -> Float.POSITIVE_INFINITY;
            default -> (float) this.toDoubleNormal();
        };
    }

    @Override
    public double to64BitPrimitive() {
        return switch (this.heldByte) {
            case Byte.MIN_VALUE -> -0.0;
            case -120 -> 1.0;
            case -111 -> 1.1;
            case -102 -> 1.2;
            case -93 -> 1.3;
            case -84 -> 1.4;
            case -75 -> 1.5;
            case -8 -> Double.NEGATIVE_INFINITY;
            case -7, -6, -5, -4, -3, -2, -1, 121, 122, 123, 124, 125, 126, 127 
                -> Double.NaN;
            case 0 -> 0.0;
            case 8 -> 1.0;
            case 17 -> 1.1;
            case 26 -> 1.2;
            case 35 -> 1.3;
            case 44 -> 1.4;
            case 53 -> 1.5;
            case 120 -> Double.POSITIVE_INFINITY;
            default -> this.toDoubleNormal();
        };
    }

    // TODO: Write tests for this
    @Override
    public QuarterPrecisionNumber toQuarterPrecision() {
        return new QuarterPrecisionNumber((byte) 0);
    }

    // TODO: Write tests for this
    @Override
    public HalfPrecisionNumber toHalfPrecision() {
        return new HalfPrecisionNumber(TWO_ZEROS);
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
    
    // TODO: Write tests for this
    @Override
    public boolean arithmeticallyEqual(FloatingPointNumber other) {
        return true;
    }
    
    private String toStringNormal() {
        String intermediate = Double.toString(this.toNonNegativeFractionNormal()
                .numericApproximation());
        return (this.heldByte < 0) ? "\u2212" + intermediate : intermediate;
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
            case -128 -> "\u22120.0";
            case -127 -> "\u22120.001953125";
            case -126 -> "\u22120.00390625";
            case -125 -> "\u22120.005859375";
            case -124 -> "\u22120.0078125";
            case -123 -> "\u22120.009765625";
            case -122 -> "\u22120.01171875";
            case -121 -> "\u22120.013671875";
            case -8 -> "\u2212Infinity";
            case -7, -6, -5, -4, -3, -2, -1, 121, 122, 123, 124, 125, 126, 127 
                -> "NaN";
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
    
    // TODO: Write tests for this
    @Override
    public String toHexadecimalString() {
        return "SORRY, NOT IMPLEMENTED YET";
    }
    
    public QuarterPrecisionNumber(byte b) {
        super(new byte[]{b});
        this.heldByte = b;
    }
    
}
