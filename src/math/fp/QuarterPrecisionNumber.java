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
 * Represents an 8-bit or "quarter precision" floating point number. Also called 
 * "minifloat."
 * @author Alonso del Arte
 */
public class QuarterPrecisionNumber extends FloatingPointNumber {

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
            case -72 -> -1.0f;
            case -8 -> Float.NEGATIVE_INFINITY;
            case 0 -> 0.0f;
            case 56 -> 1.0f;
            case 120 -> Float.POSITIVE_INFINITY;
            default -> Float.NaN;
        };
    }

    @Override
    public double to64BitPrimitive() {
        return switch (this.heldByte) {
            case Byte.MIN_VALUE -> -0.0;
            case -72 -> -1.0;
            case -8 -> Double.NEGATIVE_INFINITY;
            case 0 -> 0.0;
            case 56 -> 1.0;
            case 120 -> Double.POSITIVE_INFINITY;
            default -> Double.NaN;
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
            
    @Override
    public String toString() {
        return switch (this.heldByte) {
            case -128 -> "\u22120.0";
            case -72 -> "\u22121.0";
            case -71 -> "\u22121.125";
            case -70 -> "\u22121.25";
            case -69 -> "\u22121.375";
            case -68 -> "\u22121.5";
            case -67 -> "\u22121.625";
            case -66 -> "\u22121.75";
            case -65 -> "\u22121.875";
            case -7, -6, -5, -4, -3, -2, -1, 121, 122, 123, 124, 125, 126, 127 
                -> "NaN";
            case -8 -> "\u2212Infinity";
            case 56 -> "1.0";
            case 57 -> "1.125";
            case 58 -> "1.25";
            case 59 -> "1.375";
            case 60 -> "1.5";
            case 61 -> "1.625";
            case 62 -> "1.75";
            case 63 -> "1.875";
            case 120 -> "Infinity";
            default -> "0.0";
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
