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
 *32-bit
 * @author Alonso del Arte
 */
public class SinglePrecisionNumber extends FloatingPointNumber {

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
    public String toHexadecimalString() {
        return "SORRY, NOT IMPLEMENTED YET";
    }
    
    // TODO: Write tests for this
    public static SinglePrecisionNumber fromPrimitive(float number) {
        return new SinglePrecisionNumber(FOUR_ZEROS);
    }
    
    SinglePrecisionNumber(byte[] bytes) {
        super(bytes);
    }
    
}
