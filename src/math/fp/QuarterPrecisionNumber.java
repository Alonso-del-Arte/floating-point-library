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
            case -8 -> Double.NEGATIVE_INFINITY;
            case -7, -6, -5, -4, -3, -2, -1, 121, 122, 123, 124, 125, 126, 127 
                -> Double.NaN;
            case 0 -> 0.0;
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
    
    @Override
    public String toString() {
        return switch (this.heldByte) {
            case -128 -> "\u22120.0";
            case -104 -> "\u22120.0625";
            case -103 -> "\u22120.0703125";
            case -102 -> "\u22120.078125";
            case -101 -> "\u22120.0859375";
            case -100 -> "\u22120.09375";
            case -99 -> "\u22120.1015625";
            case -98 -> "\u22120.109375";
            case -97 -> "\u22120.1171875";
            case -96 -> "\u22120.125";
            case -95 -> "\u22120.140625";
            case -94 -> "\u22120.15625";
            case -93 -> "\u22120.171875";
            case -92 -> "\u22120.1875";
            case -91 -> "\u22120.203125";
            case -90 -> "\u22120.21875";
            case -89 -> "\u22120.234375";
            case -88 -> "\u22120.25";
            case -87 -> "\u22120.28125";
            case -86 -> "\u22120.3125";
            case -85 -> "\u22120.34375";
            case -84 -> "\u22120.375";
            case -83 -> "\u22120.40625";
            case -82 -> "\u22120.4375";
            case -81 -> "\u22120.46875";
            case -80 -> "\u22120.5";
            case -79 -> "\u22120.5625";
            case -78 -> "\u22120.625";
            case -77 -> "\u22120.6875";
            case -76 -> "\u22120.75";
            case -75 -> "\u22120.8125";
            case -74 -> "\u22120.875";
            case -73 -> "\u22120.9375";
            case -8 -> "\u2212Infinity";
            case -7, -6, -5, -4, -3, -2, -1, 121, 122, 123, 124, 125, 126, 127 
                -> "NaN";
            case 0 -> "0.0";
            case 8 -> "0.015625";
            case 9 -> "0.017578125";
            case 10 -> "0.01953125";
            case 11 -> "0.021484375";
            case 12 -> "0.0234375";
            case 13 -> "0.025390625";
            case 14 -> "0.02734375";
            case 15 -> "0.029296875";
            case 16 -> "0.03125";
            case 17 -> "0.03515625";
            case 18 -> "0.0390625";
            case 19 -> "0.04296875";
            case 20 -> "0.046875";
            case 21 -> "0.05078125";
            case 22 -> "0.0546875";
            case 23 -> "0.05859375";
            case 24 -> "0.0625";
            case 25 -> "0.0703125";
            case 26 -> "0.078125";
            case 27 -> "0.0859375";
            case 28 -> "0.09375";
            case 29 -> "0.1015625";
            case 30 -> "0.109375";
            case 31 -> "0.1171875";
            case 32 -> "0.125";
            case 33 -> "0.140625";
            case 34 -> "0.15625";
            case 35 -> "0.171875";
            case 36 -> "0.1875";
            case 37 -> "0.203125";
            case 38 -> "0.21875";
            case 39 -> "0.234375";
            case 40 -> "0.25";
            case 41 -> "0.28125";
            case 42 -> "0.3125";
            case 43 -> "0.34375";
            case 44 -> "0.375";
            case 45 -> "0.40625";
            case 46 -> "0.4375";
            case 47 -> "0.46875";
            case 48 -> "0.5";
            case 49 -> "0.5625";
            case 50 -> "0.625";
            case 51 -> "0.6875";
            case 52 -> "0.75";
            case 53 -> "0.8125";
            case 54 -> "0.875";
            case 55 -> "0.9375";
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
