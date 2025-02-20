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

import java.math.BigDecimal;

import math.integer.ShortProcessor;

/**
 * Represents a 16-bit or "half precision" floating point number.
 * @author Alonso del Arte
 */
public class HalfPrecisionNumber extends FloatingPointNumber {
    
    private static final char MINUS_SIGN = '\u2212';
    
    private static final String MINUS_SIGN_STR = Character.toString(MINUS_SIGN);
    
    private static final int A_POWER_OF_TWO = 1 << 24;
    
    private static final BigDecimal TWO_TO_THE_24TH 
            = new BigDecimal(A_POWER_OF_TWO);
    
    private static final BigDecimal RECIPROCAL_OF_TWO_TO_THE_24TH 
            = BigDecimal.ONE.divide(TWO_TO_THE_24TH);
    
    private static final byte ZERO_BYTE = 0;
    
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
    
    private final short heldShort;

    @Override
    public int getUnbiasedExponent() {
        return (this.heldShort & 31744) >> 10;
    }
    
    // TODO: Write tests for this
    @Override
    public int getBiasedExponent() {
        return -14;
    }
    
    // TODO: Write tests for this
    @Override
    public boolean isNormal() {
        return false;
    }
    
    // TODO: Write tests for this
    @Override
    public boolean isSubnormal() {
        return false;
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
    
    /**
     * Indicates whether or not this number is a Not a Number (NaN) value. Note 
     * that the infinities are not considered NaN, even though they don't 
     * represent finite numbers either.
     * @return True if this number is a NaN value, false in all other cases, 
     * including &plusmn;&infin;. Examples: NaNs from the bit patterns FC21 and 
     * 7C21 return true for this function, false for the numbers &minus;65504.0 
     * and 0.000001966953277587890625.
     */
    @Override
    public boolean isNaN() {
        return (this.heldShort & Short.MAX_VALUE) > 31744;
    }
    
    @Override
    public boolean isQuietNaN() {
        int masked = this.heldShort & Short.MAX_VALUE;
        return masked > 32255;
    }

    // TODO: Write tests for this
    @Override
    public boolean isSignalingNaN() {
        return false;
    }

    // TODO: Write tests for this
    @Override
    public float to32BitPrimitive() {
        return -0.0f;
    }

    // TODO: Write tests for this
    @Override
    public double to64BitPrimitive() {
        return 0.0;
    }

    @Override
    public QuarterPrecisionNumber toQuarterPrecision() {
        byte b = switch (this.heldShort) {
            case Short.MIN_VALUE -> Byte.MIN_VALUE;
            case -26624 -> -127;
            case -25600 -> -126;
            case -25088 -> -125;
            case -24576 -> -124;
            case -24320 -> -123;
            case -24064 -> -122;
            case -23808 -> -121;
            case -1024 -> -8;
            case 0 -> 0;
            case 6144 -> 1;
            case 7168 -> 2;
            case 7680 -> 3;
            case 8192 -> 4;
            case 8448 -> 5;
            case 8704 -> 6;
            case 8960 -> 7;
            case 31744 -> 120;
            default -> {
                if ((this.heldShort & Short.MAX_VALUE) > 31744) {
                    yield 127;
                }
                int sign = (this.heldShort < 0) ? 128 : 0;
                int exponent = ((this.heldShort & 31744) - 8192) >> 7;
                int mantissa = (this.heldShort & 1023) >> 7;
                yield (byte) (sign + exponent + mantissa);
            }
        };
        return new QuarterPrecisionNumber(b);
    }

    @Override
    public HalfPrecisionNumber toHalfPrecision() {
        return this;
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
    public FloatingPointNumber plus(FloatingPointNumber addend) {
        return this;
    }
    
    @Override
    public FloatingPointNumber negate() {
        return this;
    }
    
    // TODO: Write tests for this
    @Override
    public FloatingPointNumber minus(FloatingPointNumber subtrahend) {
        return this;
    }
    
    // TODO: Write tests for this
    @Override
    public FloatingPointNumber times(FloatingPointNumber multiplicand) {
        return this;
    }
    
    @Override
    public FloatingPointNumber reciprocal() {
        return this;
    }
    
    // TODO: Write tests for this
    @Override
    public FloatingPointNumber divides(FloatingPointNumber divisor) {
        return this;
    }
    
    // TODO: Write tests for this
    @Override
    public boolean arithmeticallyEqual(FloatingPointNumber other) {
        return true;
    }
    
    private String toStringNormal() {
        int exponent = ((this.heldShort & 31744) >> 10) - 15;
        BigDecimal pow;
        if (exponent < 11) {
            int shift = 10 - exponent;
            int power = 1 << shift;
            BigDecimal divisor = new BigDecimal(power);
            pow = BigDecimal.ONE.divide(divisor);
        } else {
            int shift = exponent - 10;
            int power = 1 << shift;
            pow = BigDecimal.valueOf(power);
        }
        int mantissaBits = 1024 + (this.heldShort & 1023);
        BigDecimal mantissa = new BigDecimal(mantissaBits);
        BigDecimal figuredNumber = mantissa.multiply(pow).stripTrailingZeros();
        String sign = (this.heldShort < 0) ? MINUS_SIGN_STR : "";
        String maybeReady = sign + figuredNumber.toPlainString();
        if (maybeReady.contains(".")) {
            return maybeReady;
        } else {
            return maybeReady.concat(".0");
        }
    }
    
    @Override
    public String toString() {
        return switch (this.heldShort) {
            case Short.MIN_VALUE -> MINUS_SIGN + "0.0";
            case -1024 -> MINUS_SIGN + "Infinity";
            case 0 -> "0.0";
            case 31744 -> "Infinity";
            default -> {
                if ((this.heldShort > -1024 && this.heldShort < 0) 
                        || this.heldShort > 31744) {
                    yield "NaN";
                } else {
                    if ((this.heldShort & 31744) != 0) {
                        yield this.toStringNormal();
                    }
                    int mantissa = this.heldShort & Short.MAX_VALUE;
                    BigDecimal multiplicand = new BigDecimal(mantissa);
                    BigDecimal product 
                            = RECIPROCAL_OF_TWO_TO_THE_24TH
                                    .multiply(multiplicand)
                                    .stripTrailingZeros();
                    String sign = (this.heldShort < 0) ? MINUS_SIGN_STR : "";
                    yield sign + product.toPlainString();
                }
            }
        };
    }
            
    // TODO: Write tests for this
    @Override
    public String bitPatternHexadecimal() {
        return "SORRY, NOT IMPLEMENTED YET";
    }
    
    /**
     * Secondary constructor. For the example, consider the number 
     * 0.00264739990234375 with bit pattern 196C.
     * @param bytes The bytes to create the instance from. For example, the 
     * bytes 25 and 108. The first byte provides the sign bit, all of the 
     * exponent bits and the two highest explicit mantissa bits. The second byte 
     * provides the rest of the mantissa bits.
     */
    HalfPrecisionNumber(byte[] bytes) {
        super(bytes);
        this.heldShort = ShortProcessor.fromBytes(bytes);
    }
    
    /**
     * Primary constructor. For the example, consider the number 
     * 0.00264739990234375 with bit pattern 196C.
     * @param sh The 16-bit integer to create the instance from. For example, 
     * 6508.
     */
    public HalfPrecisionNumber(short sh) {
        super(ShortProcessor.toBytes(sh));
        this.heldShort = sh;
    }
    
}
