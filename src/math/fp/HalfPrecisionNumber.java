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
    
    private static final byte[] ONE_ZERO = {ZERO_BYTE}; // quarter

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
    
    private final short heldShort;

    // TODO: Write tests for this
    @Override
    public int getUnbiasedExponent() {
        return Integer.MIN_VALUE;
    }
    
    // TODO: Write tests for this
    @Override
    public int getBiasedExponent() {
        return Integer.MAX_VALUE;
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
        // TODO: Refactor to simpler arithmetic once all negative exponent tests 
        //  have been written
        int shift = switch (exponent) {
            case -13 -> 23;
            case -12 -> 22;
            case -11 -> 21;
            case -10 -> 20;
            case -9 -> 19;
            default -> 24;
        };
        int power = 1 << shift;
        BigDecimal divisor = new BigDecimal(power);
        BigDecimal pow = BigDecimal.ONE.divide(divisor);
        int mantissaBits = 1024 + (this.heldShort & 1023);
        BigDecimal mantissa = new BigDecimal(mantissaBits);
        BigDecimal figuredNumber = mantissa.multiply(pow).stripTrailingZeros();
        String sign = (this.heldShort < 0) ? MINUS_SIGN_STR : "";
        return sign + figuredNumber.toPlainString();
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
                    // TODO: Refactor to not calculate exponent here
                    int exponent = ((this.heldShort & 31744) >> 10) - 15;
                    if (exponent > -14) {
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
     * 
     * @param bytes 
     */
    HalfPrecisionNumber(byte[] bytes) {
        super(bytes);
        // TODO: Write test that this field is set correctly
        this.heldShort = (short) ~bytes[0];
    }
    
    /**
     * 
     * @param sh 
     */
    public HalfPrecisionNumber(short sh) {
        super(ShortProcessor.toBytes(sh));
        this.heldShort = sh;
    }
    
}
