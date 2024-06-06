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
            case -71 -> -1.125f;
            case -70 -> -1.25f;
            case -69 -> -1.375f;
            case -68 -> -1.5f;
            case -67 -> -1.625f;
            case -66 -> -1.75f;
            case -65 -> -1.875f;
            case -8 -> Float.NEGATIVE_INFINITY;
            case 0 -> 0.0f;
            case 56 -> 1.0f;
            case 57 -> 1.125f;
            case 58 -> 1.25f;
            case 59 -> 1.375f;
            case 60 -> 1.5f;
            case 61 -> 1.625f;
            case 62 -> 1.75f;
            case 63 -> 1.875f;
            case 64 -> 2.0f;
            case 65 -> 2.25f;
            case 66 -> 2.5f;
            case 67 -> 2.75f;
            case 68 -> 3.0f;
            case 69 -> 3.25f;
            case 70 -> 3.5f;
            case 71 -> 3.75f;
            case 120 -> Float.POSITIVE_INFINITY;
            default -> Float.NaN;
        };
    }

    @Override
    public double to64BitPrimitive() {
        return switch (this.heldByte) {
            case Byte.MIN_VALUE -> -0.0;
            case -72 -> -1.0;
            case -71 -> -1.125;
            case -70 -> -1.25;
            case -69 -> -1.375;
            case -68 -> -1.5;
            case -67 -> -1.625;
            case -66 -> -1.75;
            case -65 -> -1.875;
            case -8 -> Double.NEGATIVE_INFINITY;
            case 0 -> 0.0;
            case 56 -> 1.0;
            case 57 -> 1.125;
            case 58 -> 1.25;
            case 59 -> 1.375;
            case 60 -> 1.5;
            case 61 -> 1.625;
            case 62 -> 1.75;
            case 63 -> 1.875;
            case 64 -> 2.0;
            case 65 -> 2.25;
            case 66 -> 2.5;
            case 67 -> 2.75;
            case 68 -> 3.0;
            case 69 -> 3.25;
            case 70 -> 3.5;
            case 71 -> 3.75;
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
    
    private String toStringNormal() {
        int mantissaBitPattern = this.heldByte & 7;
        Fraction fraction = ONE.plus(ONE_EIGHTH.times(mantissaBitPattern));
//        int exponent = ((Math.abs(this.heldByte) & 120) >> 3) - 8;
//        while (exponent > 0) {
//            fraction = fraction.times(2);
//            exponent--;
//        }
        String intermediate = Double.toString(fraction.numericApproximation());
        return (this.heldByte < 0) ? "\u2212" + intermediate : intermediate;
    }
            
    @Override
    public String toString() {
        return switch (this.heldByte) {
            case -128 -> "\u22120.0";
            case -64 -> "\u22122.0";
            case -63 -> "\u22122.25";
            case -62 -> "\u22122.5";
            case -61 -> "\u22122.75";
            case -60 -> "\u22123.0";
            case -59 -> "\u22123.25";
            case -58 -> "\u22123.5";
            case -57 -> "\u22123.75";
//            case -56 -> "\u22122.0";
//            case -55 -> "\u22122.25";
//            case -54 -> "\u22122.5";
//            case -53 -> "\u22122.75";
//            case -52 -> "\u22123.0";
//            case -51 -> "\u22123.25";
//            case -50 -> "\u22123.5";
//            case -49 -> "\u22123.75";
//            case -48 -> "\u22124.0";
//            case -47 -> "\u22124.5";
//            case -46 -> "\u22125.0";
//            case -45 -> "\u22125.5";
//            case -44 -> "\u22126.0";
//            case -43 -> "\u22126.5";
//            case -42 -> "\u22127.0";
//            case -41 -> "\u22127.5";
//            case -40 -> "\u22128.0";
//            case -39 -> "\u22129.0";
//            case -38 -> "\u221210.0";
//            case -37 -> "\u221211.0";
//            case -36 -> "\u221212.0";
//            case -35 -> "\u221213.0";
//            case -34 -> "\u221214.0";
//            case -33 -> "\u221215.0";
//            case -32 -> "\u221216.0";
//            case -31 -> "\u221218.0";
//            case -30 -> "\u221220.0";
//            case -29 -> "\u221222.0";
//            case -28 -> "\u221224.0";
//            case -27 -> "\u221226.0";
//            case -26 -> "\u221228.0";
//            case -25 -> "\u221230.0";
//            case -24 -> "\u221232.0";
//            case -23 -> "\u221236.0";
//            case -22 -> "\u221240.0";
//            case -21 -> "\u221244.0";
//            case -20 -> "\u221248.0";
//            case -19 -> "\u221252.0";
//            case -18 -> "\u221256.0";
//            case -17 -> "\u221260.0";
//            case -16 -> "\u221264.0";
//            case -15 -> "\u221272.0";
//            case -14 -> "\u221280.0";
//            case -13 -> "\u221288.0";
//            case -12 -> "\u221296.0";
//            case -11 -> "\u2212104.0";
//            case -10 -> "\u2212112.0";
//            case -9 -> "\u2212120.0";
            case -7, -6, -5, -4, -3, -2, -1, 121, 122, 123, 124, 125, 126, 127 
                -> "NaN";
            case -8 -> "\u2212Infinity";
            case 0 -> "0.0";
            case 64 -> "2.0";
            case 65 -> "2.25";
            case 66 -> "2.5";
            case 67 -> "2.75";
            case 68 -> "3.0";
            case 69 -> "3.25";
            case 70 -> "3.5";
            case 71 -> "3.75";
            case 72 -> "4.0";
            case 73 -> "4.5";
            case 74 -> "5.0";
            case 75 -> "5.5";
            case 76 -> "6.0";
            case 77 -> "6.5";
            case 78 -> "7.0";
            case 79 -> "7.5";
            case 80 -> "8.0";
            case 81 -> "9.0";
            case 82 -> "10.0";
            case 83 -> "11.0";
            case 84 -> "12.0";
            case 85 -> "13.0";
            case 86 -> "14.0";
            case 87 -> "15.0";
            case 88 -> "16.0";
            case 89 -> "18.0";
            case 90 -> "20.0";
            case 91 -> "22.0";
            case 92 -> "24.0";
            case 93 -> "26.0";
            case 94 -> "28.0";
            case 95 -> "30.0";
            case 96 -> "32.0";
            case 97 -> "36.0";
            case 98 -> "40.0";
            case 99 -> "44.0";
            case 100 -> "48.0";
            case 101 -> "52.0";
            case 102 -> "56.0";
            case 103 -> "60.0";
            case 104 -> "64.0";
            case 105 -> "72.0";
            case 106 -> "80.0";
            case 107 -> "88.0";
            case 108 -> "96.0";
            case 109 -> "104.0";
            case 110 -> "112.0";
            case 111 -> "120.0";
            case 112 -> "128.0";
            case 113 -> "144.0";
            case 114 -> "160.0";
            case 115 -> "176.0";
            case 116 -> "192.0";
            case 117 -> "208.0";
            case 118 -> "224.0";
            case 119 -> "240.0";
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
