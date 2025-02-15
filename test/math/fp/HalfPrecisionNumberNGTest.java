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
import java.util.Arrays;

import static math.fp.FloatingPointNumberNGTest.RANDOM;
import math.integer.ShortProcessor;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the HalfPrecisionNumber class.
 * @author Alonso del Arte
 */
public class HalfPrecisionNumberNGTest {
    
    private static final char MINUS_SIGN = '\u2212';
    
    private static final int A_POWER_OF_TWO = 1 << 24;
    
    private static final BigDecimal TWO_TO_THE_24TH 
            = new BigDecimal(A_POWER_OF_TWO);
    
    private static final BigDecimal RECIPROCAL_OF_TWO_TO_THE_24TH 
            = BigDecimal.ONE.divide(TWO_TO_THE_24TH);
    
    @Test
    public void testToStringNegativeInfinity() {
        short sh = -1024;
        HalfPrecisionNumber number = new HalfPrecisionNumber(sh);
        String expected = "\u2212Infinity";
        String actual = number.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive15() {
        double curr = 32768.0;
        double augend = 32.0;
        short start = -2048;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive14() {
        double curr = 16384.0;
        double augend = 16.0;
        short start = -3072;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive13() {
        double curr = 8192.0;
        double augend = 8.0;
        short start = -4096;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive12() {
        double curr = 4096.0;
        double augend = 4.0;
        short start = -5120;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive11() {
        double curr = 2048.0;
        double augend = 2.0;
        short start = -6144;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive10() {
        double curr = 1024.0;
        double augend = 1.0;
        short start = -7168;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive9() {
        double curr = 512.0;
        double augend = 0.5;
        short start = -8192;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive8() {
        double curr = 256.0;
        double augend = 0.25;
        short start = -9216;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive7() {
        double curr = 128.0;
        double augend = 1.0 / 8;
        short start = -10240;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive6() {
        double curr = 64.0;
        double augend = 1.0 / 16;
        short start = -11264;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive5() {
        double curr = 32.0;
        double augend = 1.0 / 32;
        short start = Short.MIN_VALUE + 20480;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive4() {
        double curr = 16.0;
        double augend = 1.0 / 64;
        short start = Short.MIN_VALUE + 19456;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive3() {
        double curr = 8.0;
        double augend = 1.0 / 128;
        short start = Short.MIN_VALUE + 18432;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive2() {
        double curr = 4.0;
        double augend = 1.0 / 256;
        short start = Short.MIN_VALUE + 17408;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentPositive1() {
        double curr = 2.0;
        double augend = 1.0 / 512;
        short start = Short.MIN_VALUE + 16384;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentZero() {
        double curr = 1.0;
        double augend = 1.0 / 1024;
        short start = Short.MIN_VALUE + 15360;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative1() {
        double curr = 0.5;
        int twoToThe11th = 1 << 11;
        double augend = 1.0 / twoToThe11th;
        short start = Short.MIN_VALUE + 14336;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative2() {
        double curr = 1.0 / 4;
        int twoToThe12th = 1 << 12;
        double augend = 1.0 / twoToThe12th;
        short start = Short.MIN_VALUE + 13312;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative3() {
        double curr = 1.0 / 8;
        int twoToThe13th = 1 << 13;
        double augend = 1.0 / twoToThe13th;
        short start = Short.MIN_VALUE + 12288;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative4() {
        double curr = 1.0 / 16;
        int twoToThe14th = 1 << 14;
        double augend = 1.0 / twoToThe14th;
        short start = Short.MIN_VALUE + 11264;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative5() {
        double curr = 1.0 / 32;
        int twoToThe15th = 1 << 15;
        double augend = 1.0 / twoToThe15th;
        short start = Short.MIN_VALUE + 10240;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative6() {
        double curr = 1.0 / 64;
        int twoToThe16th = 1 << 16;
        double augend = 1.0 / twoToThe16th;
        short start = Short.MIN_VALUE + 9216;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative7() {
        double curr = 1.0 / 128;
        int twoToThe17th = 1 << 17;
        double augend = 1.0 / twoToThe17th;
        short start = Short.MIN_VALUE + 8192;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative8() {
        double curr = 1.0 / 256;
        int twoToThe18th = 1 << 18;
        double augend = 1.0 / twoToThe18th;
        short start = Short.MIN_VALUE + 7168;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative9() {
        BigDecimal power = new BigDecimal(512);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe19th = 1 << 19;
        BigDecimal greaterPower = new BigDecimal(twoToThe19th);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = Short.MIN_VALUE + 6144;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative10() {
        int twoToThe10th = 1 << 10;
        BigDecimal power = new BigDecimal(twoToThe10th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe20th = 1 << 20;
        BigDecimal greaterPower = new BigDecimal(twoToThe20th);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = Short.MIN_VALUE + 5120;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative11() {
        int twoToThe11th = 1 << 11;
        BigDecimal power = new BigDecimal(twoToThe11th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe21st = 1 << 21;
        BigDecimal greaterPower = new BigDecimal(twoToThe21st);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = Short.MIN_VALUE + 4096;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative12() {
        int twoToThe12th = 1 << 12;
        BigDecimal power = new BigDecimal(twoToThe12th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe22nd = 1 << 22;
        BigDecimal greaterPower = new BigDecimal(twoToThe22nd);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = Short.MIN_VALUE + 3072;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative13() {
        int twoToThe13th = 1 << 13;
        BigDecimal power = new BigDecimal(twoToThe13th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe23rd = 1 << 23;
        BigDecimal greaterPower = new BigDecimal(twoToThe23rd);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = Short.MIN_VALUE + 2048;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringNegativeNormalExponentNegative14() {
        int twoToThe14th = 1 << 14;
        BigDecimal power = new BigDecimal(twoToThe14th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        short start = Short.MIN_VALUE + 1024;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr = curr.add(RECIPROCAL_OF_TWO_TO_THE_24TH).stripTrailingZeros();
        }
    }
        @Test
    public void testToStringNegativeSubnormal() {
        BigDecimal curr = RECIPROCAL_OF_TWO_TO_THE_24TH;
        short start = Short.MIN_VALUE + 1;
        short stop = Short.MIN_VALUE + 1024;
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = MINUS_SIGN + curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh).substring(4);
            assertEquals(actual, expected, message);
            curr = curr.add(RECIPROCAL_OF_TWO_TO_THE_24TH).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringNegativeZero() {
        HalfPrecisionNumber zero = new HalfPrecisionNumber(Short.MIN_VALUE);
        String expected = "\u22120.0";
        String actual = zero.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringPositiveZero() {
        HalfPrecisionNumber zero = new HalfPrecisionNumber((short) 0);
        String expected = "0.0";
        String actual = zero.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringPositiveSubnormal() {
        BigDecimal curr = RECIPROCAL_OF_TWO_TO_THE_24TH;
        for (short sh = 1; sh < 1024; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr = curr.add(RECIPROCAL_OF_TWO_TO_THE_24TH).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative14() {
        int twoToThe14th = 1 << 14;
        BigDecimal power = new BigDecimal(twoToThe14th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        short start = 1024;
        short stop = 2048;
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr = curr.add(RECIPROCAL_OF_TWO_TO_THE_24TH).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative13() {
        int twoToThe13th = 1 << 13;
        BigDecimal power = new BigDecimal(twoToThe13th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe23rd = 1 << 23;
        BigDecimal greaterPower = new BigDecimal(twoToThe23rd);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = 2048;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative12() {
        int twoToThe12th = 1 << 12;
        BigDecimal power = new BigDecimal(twoToThe12th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe22nd = 1 << 22;
        BigDecimal greaterPower = new BigDecimal(twoToThe22nd);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = 3072;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative11() {
        int twoToThe11th = 1 << 11;
        BigDecimal power = new BigDecimal(twoToThe11th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe21st = 1 << 21;
        BigDecimal greaterPower = new BigDecimal(twoToThe21st);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = 4096;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative10() {
        int twoToThe10th = 1 << 10;
        BigDecimal power = new BigDecimal(twoToThe10th);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe20th = 1 << 20;
        BigDecimal greaterPower = new BigDecimal(twoToThe20th);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = 5120;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative9() {
        BigDecimal power = new BigDecimal(512);
        BigDecimal curr = BigDecimal.ONE.divide(power);
        int twoToThe19th = 1 << 19;
        BigDecimal greaterPower = new BigDecimal(twoToThe19th);
        BigDecimal augend = BigDecimal.ONE.divide(greaterPower);
        short start = 6144;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = curr.toPlainString();
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr = curr.add(augend).stripTrailingZeros();
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative8() {
        double curr = 1.0 / 256;
        int twoToThe18th = 1 << 18;
        double augend = 1.0 / twoToThe18th;
        short start = 7168;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative7() {
        double curr = 1.0 / 128;
        int twoToThe17th = 1 << 17;
        double augend = 1.0 / twoToThe17th;
        short start = 8192;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative6() {
        double curr = 1.0 / 64;
        int twoToThe16th = 1 << 16;
        double augend = 1.0 / twoToThe16th;
        short start = 9216;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative5() {
        double curr = 1.0 / 32;
        int twoToThe15th = 1 << 15;
        double augend = 1.0 / twoToThe15th;
        short start = 10240;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative4() {
        double curr = 1.0 / 16;
        int twoToThe14th = 1 << 14;
        double augend = 1.0 / twoToThe14th;
        short start = 11264;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative3() {
        double curr = 1.0 / 8;
        int twoToThe13th = 1 << 13;
        double augend = 1.0 / twoToThe13th;
        short start = 12288;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative2() {
        double curr = 1.0 / 4;
        int twoToThe12th = 1 << 12;
        double augend = 1.0 / twoToThe12th;
        short start = 13312;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentNegative1() {
        double curr = 0.5;
        int twoToThe11th = 1 << 11;
        double augend = 1.0 / twoToThe11th;
        short start = 14336;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentZero() {
        double curr = 1.0;
        double augend = 1.0 / 1024;
        short start = 15360;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive1() {
        double curr = 2.0;
        double augend = 1.0 / 512;
        short start = 16384;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive2() {
        double curr = 4.0;
        double augend = 1.0 / 256;
        short start = 17408;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive3() {
        double curr = 8.0;
        double augend = 1.0 / 128;
        short start = 18432;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive4() {
        double curr = 16.0;
        double augend = 1.0 / 64;
        short start = 19456;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive5() {
        double curr = 32.0;
        double augend = 1.0 / 32;
        short start = 20480;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive6() {
        double curr = 64.0;
        double augend = 1.0 / 16;
        short start = 21504;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive7() {
        double curr = 128.0;
        double augend = 1.0 / 8;
        short start = 22528;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive8() {
        double curr = 256.0;
        double augend = 0.25;
        short start = 23552;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive9() {
        double curr = 512.0;
        double augend = 0.5;
        short start = 24576;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive10() {
        double curr = 1024.0;
        double augend = 1.0;
        short start = 25600;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive11() {
        double curr = 2048.0;
        double augend = 2.0;
        short start = 26624;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive12() {
        double curr = 4096.0;
        double augend = 4.0;
        short start = 27648;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive13() {
        double curr = 8192.0;
        double augend = 8.0;
        short start = 28672;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive14() {
        double curr = 16384.0;
        double augend = 16.0;
        short start = 29696;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveNormalExponentPositive15() {
        double curr = 32768.0;
        double augend = 32.0;
        short start = 30720;
        short stop = (short) (start + 1024);
        for (short sh = start; sh < stop; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String expected = Double.toString(curr);
            String actual = instance.toString();
            String message = "For bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1);
            assertEquals(actual, expected, message);
            curr += augend;
        }
    }
    
    @Test
    public void testToStringPositiveInfinity() {
        short sh = 31744;
        HalfPrecisionNumber number = new HalfPrecisionNumber(sh);
        String expected = "Infinity";
        String actual = number.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringNegativeNaN() {
        String expected = "NaN";
        for (short sh = -1023; sh < 0; sh++) {
            HalfPrecisionNumber number = new HalfPrecisionNumber(sh);
            String actual = number.toString();
            assertEquals(actual, expected);
        }
    }

    public void testToStringPositiveNaN() {
        String expected = "NaN";
        for (short sh = 31745; sh > 0; sh++) {
            HalfPrecisionNumber number = new HalfPrecisionNumber(sh);
            String actual = number.toString();
            assertEquals(actual, expected);
        }
    }

    /**
     * Test of the getUnbiasedExponent function, of the HalfPrecisionNumber 
     * class.
     */
    @Test
    public void testGetUnbiasedExponent() {
        System.out.println("getUnbiasedExponent");
        for (int i = Short.MIN_VALUE; i < Short.MAX_VALUE; i += 1024) {
            int expected = (i & 31744) >> 10;
            short start = (short) i;
            short end = (short) (start + 1024);
            for (short sh = start; sh < end; sh++) {
                HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
                int actual = instance.getUnbiasedExponent();
                String message = "Getting unbiased exponent of " 
                        + instance.toString();
                assertEquals(actual, expected, message);
            }
        }
    }
    
    @Test
    public void testGetBiasedExponentSubnormalNegative() {
        int expected = -14;
        for (short sh = Short.MIN_VALUE; sh < -31744; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            int actual = instance.getBiasedExponent();
            String message = "Getting biased exponent of " 
                    + instance.toString();
            assertEquals(actual, expected, message);
        }
    }

    @Test
    public void testGetBiasedExponentSubnormalPositive() {
        int expected = -14;
        for (short sh = 0; sh < 1024; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            int actual = instance.getBiasedExponent();
            String message = "Getting biased exponent of " 
                    + instance.toString();
            assertEquals(actual, expected, message);
        }
    }

//    @Test
    public void testGetBiasedExponentNormalNegative_NOT_YET_() {
        int expected = -14;
//        for (short sh )
        HalfPrecisionNumber instance = null;
        int expResult = 0;
        int result = instance.getBiasedExponent();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNormal method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsNormal() {
        System.out.println("isNormal");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isNormal();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSubnormal method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsSubnormal() {
        System.out.println("isSubnormal");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isSubnormal();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInteger method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsInteger() {
        System.out.println("isInteger");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isInteger();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFinite method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsFinite() {
        System.out.println("isFinite");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isFinite();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInfinite method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsInfinite() {
        System.out.println("isInfinite");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isInfinite();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of the isNaN function, of the HalfPrecisionNumber class.
     */
    @Test
    public void testIsNaN() {
        System.out.println("isNaN");
        for (short sh = 31745; sh > 0; sh++) {
            short negSh = (short) (sh + Short.MIN_VALUE);
            HalfPrecisionNumber negativeNaN 
                    = new HalfPrecisionNumber(negSh);
            HalfPrecisionNumber positiveNaN = new HalfPrecisionNumber(sh);
            String negNaNMsg = "Number " + negativeNaN + " from bit pattern " 
                    + Integer.toHexString(negSh).substring(4) 
                    + " should be found to be NaN";
            String posNaNMsg = "Number " + positiveNaN + " from bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1) 
                    + " should be found to be NaN";
            assert negativeNaN.isNaN() : negNaNMsg;
            assert positiveNaN.isNaN() : posNaNMsg;
        }
    }
    
    @Test
    public void testNegativeFinitesAreNotNaN() {
        for (short sh = Short.MIN_VALUE; sh < -1024; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String msg = "Number " + instance.toString() + " should not be NaN";
            assert !instance.isNaN() : msg;
        }
    }

    @Test
    public void testPositiveFinitesAreNotNaN() {
        for (short sh = 0; sh < 31744; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String msg = "Number " + instance.toString() + " should not be NaN";
            assert !instance.isNaN() : msg;
        }
    }
    
    @Test
    public void testNegativeInfinityIsNotNaN() {
        HalfPrecisionNumber negInf = new HalfPrecisionNumber((short) -1024);
        String msg = "Number " + negInf + " should not be NaN";
        assert !negInf.isNaN() : msg;
    }

    @Test
    public void testPositiveInfinityIsNotNaN() {
        HalfPrecisionNumber posInf = new HalfPrecisionNumber((short) 31744);
        String msg = "Number " + posInf + " should not be NaN";
        assert !posInf.isNaN() : msg;
    }

    /**
     * Test of the isQuietNaN function, of the HalfPrecisionNumber class.
     */
    @Test
    public void testIsQuietNaN() {
        System.out.println("isQuietNaN");
        for (short sh = 32256; sh > 0; sh++) {
            short negSh = (short) (sh + Short.MIN_VALUE);
            HalfPrecisionNumber negativeNaN = new HalfPrecisionNumber(negSh);
            HalfPrecisionNumber positiveNaN = new HalfPrecisionNumber(sh);
            String negNaNMsg = "Number " + negativeNaN + " from bit pattern " 
                    + Integer.toHexString(negSh).substring(4) 
                    + " should be found to be quiet NaN";
            String posNaNMsg = "Number " + positiveNaN + " from bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1) 
                    + " should be found to be quiet NaN";
            assert negativeNaN.isQuietNaN() : negNaNMsg;
            assert positiveNaN.isQuietNaN() : posNaNMsg;
        }
    }
    
    @Test
    public void testNegativeInfinityIsNotQuietNaN() {
        HalfPrecisionNumber infinity = new HalfPrecisionNumber((short) -1024);
        String msg = infinity.toString() + " should not be quiet NaN";
        assert !infinity.isQuietNaN() : msg;
    }
    
    @Test
    public void testNegativeNormalIsNotQuietNaN() {
        for (short sh = Short.MIN_VALUE; sh < -1024; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String msg = "Number " + instance.toString() 
                    + " should not be quiet NaN";
            assert !instance.isQuietNaN() : msg;
        }
    }

    @Test
    public void testPositiveNormalIsNotQuietNaN() {
        for (short sh = 0; sh < 31744; sh++) {
            HalfPrecisionNumber instance = new HalfPrecisionNumber(sh);
            String msg = "Number " + instance.toString() 
                    + " should not be quiet NaN";
            assert !instance.isQuietNaN() : msg;
        }
    }

    @Test
    public void testPositiveInfinityIsNotQuietNaN() {
        HalfPrecisionNumber infinity = new HalfPrecisionNumber((short) 31744);
        String msg = infinity.toString() + " should not be quiet NaN";
        assert !infinity.isQuietNaN() : msg;
    }

    @Test
    public void testSignalingNaNIsNotQuietNaN() {
        for (short sh = 31745; sh < 32256; sh++) {
            short negSh = (short) (sh + Short.MIN_VALUE);
            HalfPrecisionNumber negativeNaN = new HalfPrecisionNumber(negSh);
            HalfPrecisionNumber positiveNaN = new HalfPrecisionNumber(sh);
            String negNaNMsg = "Number " + negativeNaN + " from bit pattern " 
                    + Integer.toHexString(negSh).substring(4) 
                    + " should not be found to be quiet NaN";
            String posNaNMsg = "Number " + positiveNaN + " from bit pattern " 
                    + Integer.toHexString(sh + 65536).substring(1) 
                    + " should not be found to be quiet NaN";
            assert !negativeNaN.isQuietNaN() : negNaNMsg;
            assert !positiveNaN.isQuietNaN() : posNaNMsg;
        }
    }
    
    /**
     * Test of isSignalingNaN method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testIsSignalingNaN() {
        System.out.println("isSignalingNaN");
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.isSignalingNaN();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of to32BitPrimitive method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testTo32BitPrimitive() {
        System.out.println("to32BitPrimitive");
        HalfPrecisionNumber instance = null;
        float expResult = 0.0F;
        float result = instance.to32BitPrimitive();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of to64BitPrimitive method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testTo64BitPrimitive() {
        System.out.println("to64BitPrimitive");
        HalfPrecisionNumber instance = null;
        double expResult = 0.0;
        double result = instance.to64BitPrimitive();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toQuarterPrecision method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testToQuarterPrecision() {
        System.out.println("toQuarterPrecision");
        HalfPrecisionNumber instance = null;
        QuarterPrecisionNumber expResult = null;
        QuarterPrecisionNumber result = instance.toQuarterPrecision();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toHalfPrecision method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testToHalfPrecision() {
        System.out.println("toHalfPrecision");
        HalfPrecisionNumber instance = null;
        HalfPrecisionNumber expResult = null;
        HalfPrecisionNumber result = instance.toHalfPrecision();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toSinglePrecision method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testToSinglePrecision() {
        System.out.println("toSinglePrecision");
        HalfPrecisionNumber instance = null;
        SinglePrecisionNumber expResult = null;
        SinglePrecisionNumber result = instance.toSinglePrecision();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toDoublePrecision method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testToDoublePrecision() {
        System.out.println("toDoublePrecision");
        HalfPrecisionNumber instance = null;
        DoublePrecisionNumber expResult = null;
        DoublePrecisionNumber result = instance.toDoublePrecision();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toQuadruplePrecision method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testToQuadruplePrecision() {
        System.out.println("toQuadruplePrecision");
        HalfPrecisionNumber instance = null;
        QuadruplePrecisionNumber expResult = null;
        QuadruplePrecisionNumber result = instance.toQuadruplePrecision();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toOctuplePrecision method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testToOctuplePrecision() {
        System.out.println("toOctuplePrecision");
        HalfPrecisionNumber instance = null;
        OctuplePrecisionNumber expResult = null;
        OctuplePrecisionNumber result = instance.toOctuplePrecision();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plus method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testPlus() {
        System.out.println("plus");
        FloatingPointNumber addend = null;
        HalfPrecisionNumber instance = null;
        FloatingPointNumber expResult = null;
        FloatingPointNumber result = instance.plus(addend);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of negate method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testNegate() {
        System.out.println("negate");
        HalfPrecisionNumber instance = null;
        FloatingPointNumber expResult = null;
        FloatingPointNumber result = instance.negate();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minus method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testMinus() {
        System.out.println("minus");
        FloatingPointNumber subtrahend = null;
        HalfPrecisionNumber instance = null;
        FloatingPointNumber expResult = null;
        FloatingPointNumber result = instance.minus(subtrahend);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of times method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testTimes() {
        System.out.println("times");
        FloatingPointNumber multiplicand = null;
        HalfPrecisionNumber instance = null;
        FloatingPointNumber expResult = null;
        FloatingPointNumber result = instance.times(multiplicand);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reciprocal method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testReciprocal() {
        System.out.println("reciprocal");
        HalfPrecisionNumber instance = null;
        FloatingPointNumber expResult = null;
        FloatingPointNumber result = instance.reciprocal();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divides method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testDivides() {
        System.out.println("divides");
        FloatingPointNumber divisor = null;
        HalfPrecisionNumber instance = null;
        FloatingPointNumber expResult = null;
        FloatingPointNumber result = instance.divides(divisor);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of arithmeticallyEqual method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testArithmeticallyEqual() {
        System.out.println("arithmeticallyEqual");
        FloatingPointNumber other = null;
        HalfPrecisionNumber instance = null;
        boolean expResult = false;
        boolean result = instance.arithmeticallyEqual(other);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bitPatternHexadecimal method, of class HalfPrecisionNumber.
     */
//    @Test
    public void testBitPatternHexadecimal() {
        System.out.println("bitPatternHexadecimal");
        HalfPrecisionNumber instance = null;
        String expResult = "";
        String result = instance.bitPatternHexadecimal();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testByteArrayConstructorPassesBytesAlong() {
        byte mostSignificant = (byte) (RANDOM.nextInt(256) - 128);
        byte leastSignificant = (byte) (RANDOM.nextInt(256) - 128);
        byte[] expected = {mostSignificant, leastSignificant};
        HalfPrecisionNumber number = new HalfPrecisionNumber(expected);
        byte[] actual = number.getBytes();
        assertEquals(actual, expected);
    }
    
    @Test
    public void test16BitIntegerConstructorPassesBytesAlong() {
        byte mostSignificant = (byte) (RANDOM.nextInt(256) - 128);
        byte leastSignificant = (byte) (RANDOM.nextInt(256) - 128);
        byte[] expected = {mostSignificant, leastSignificant};
        short sh = ShortProcessor.fromBytes(expected);
        HalfPrecisionNumber number = new HalfPrecisionNumber(sh);
        byte[] actual = number.getBytes();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testBytesArrayConstructorCorrectlySetsHeldShort() {
        byte[] bytes = new byte[2];
        RANDOM.nextBytes(bytes);
        HalfPrecisionNumber fromShort = new HalfPrecisionNumber(ShortProcessor
                .fromBytes(bytes));
        HalfPrecisionNumber fromBytes = new HalfPrecisionNumber(bytes);
        String expected = fromShort.toString();
        String actual = fromBytes.toString();
        String message = "Reckoning from bytes " + Arrays.toString(bytes);
        assertEquals(actual, expected, message);
    }
    
}
