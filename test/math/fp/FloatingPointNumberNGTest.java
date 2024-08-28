/*
 * Copyright (C) 2024 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
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

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.testframe.api.Asserters.assertThrows;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the FloatingPointNumber class.
 * @author Alonso del Arte
 */
public class FloatingPointNumberNGTest {
    
    static final Random RANDOM = new Random();
    
    @Test
    public void testGetBytes() {
        System.out.println("getBytes");
        int length = RANDOM.nextInt(16) + 4;
        byte[] expected = new byte[length];
        RANDOM.nextBytes(expected);
        byte[] bytes = new byte[length];
        System.arraycopy(expected, 0, bytes, 0, length);
        FloatingPointNumber number = new FloatingPointNumberImpl(bytes);
        byte[] actual = number.getBytes();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testGetBytesDoesNotLeakFieldRef() {
        int length = RANDOM.nextInt(16) + 4;
        byte[] expected = new byte[length];
        RANDOM.nextBytes(expected);
        byte[] bytes = new byte[length];
        System.arraycopy(expected, 0, bytes, 0, length);
        FloatingPointNumber number = new FloatingPointNumberImpl(bytes);
        byte[] retrieved = number.getBytes();
        for (byte i = 0; i < length; i++) {
            retrieved[i] = (byte) (retrieved[i] + i);
        }
        byte[] actual = number.getBytes();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testIsZero() {
        System.out.println("isZero");
        int len = RANDOM.nextInt(8) + 2;
        byte[] bytes = new byte[len];
        FloatingPointNumber number = new FloatingPointNumberImpl(bytes);
        String msg = "Number from bit pattern " + number.bitPatternHexadecimal() 
                + " should be considered zero";
        assert number.isZero() : msg;
    }
    
    @Test
    public void testIsNotZero() {
        int len = RANDOM.nextInt(8) + 2;
        byte[] bytes = new byte[len];
        byte replacementByteSign = RANDOM.nextBoolean() ? Byte.MIN_VALUE : 0;
        byte replacementByte = (byte) (replacementByteSign + RANDOM.nextInt(127) 
                + 1);
        int replacementIndex = RANDOM.nextInt(len);
        bytes[replacementIndex] = replacementByte;
        FloatingPointNumber number = new FloatingPointNumberImpl(bytes);
        String msg = "Number from bit pattern " + number.bitPatternHexadecimal() 
                + " should not be considered zero";
        assert !number.isZero() : msg;
    }
    
    @Test
    public void testNegativeZeroIsZero() {
        int len = RANDOM.nextInt(8) + 2;
        byte[] bytes = new byte[len];
        bytes[0] = Byte.MIN_VALUE;
        FloatingPointNumber number = new FloatingPointNumberImpl(bytes);
        String msg = "Number from bit pattern " + number.bitPatternHexadecimal() 
                + " should be considered zero";
        assert number.isZero() : msg;
    }
    
    private static FloatingPointNumber makeNumber() {
        int length = RANDOM.nextInt(16) + 4;
        byte[] bytes = new byte[length];
        RANDOM.nextBytes(bytes);
        return new FloatingPointNumberImpl(bytes);
    }
    
    @Test
    public void testReferentialEquality() {
        FloatingPointNumber number = makeNumber();
        assertEquals(number, number);
    }
    
    private static Object provideNull() {
        return null;
    }
    
    @Test
    public void testNotEqualsNull() {
        FloatingPointNumber number = makeNumber();
        Object obj = provideNull();
        String msg = number.toString() + " should not equal null";
        assert !number.equals(obj) : msg;
    }
    
    @Test
    public void testNotEqualsDiffClass() {
        Object number = makeNumber();
        Object obj = LocalDate.now().getDayOfWeek();
        String msg = number.toString() + " should not equal " + obj.toString();
        assert !number.equals(obj) : msg;
    }
    
    @Test
    public void testEquals() {
        System.out.println("equals");
        FloatingPointNumber someNumber = makeNumber();
        byte[] bytes = someNumber.getBytes();
        FloatingPointNumber sameNumber = new FloatingPointNumberImpl(bytes);
        assertEquals(someNumber, sameNumber);
    }
    
    @Test
    public void testNotEqualsDiffLenByteArray() {
        FloatingPointNumber numberA = makeNumber();
        byte[] originalBytes = numberA.getBytes();
        int lenA = originalBytes.length;
        int lenB = lenA + 1;
        byte[] bytes = new byte[lenB];
        System.arraycopy(originalBytes, 0, bytes, 0, lenA);
        bytes[lenA] = (byte) (RANDOM.nextInt() % 256);
        FloatingPointNumber numberB = new FloatingPointNumberImpl(bytes);
        String msg = "Given that " + numberA.toString() + " is made up of " 
                + lenA + " bytes and " + numberB.toString() + " is made up of " 
                + lenB + " bytes, they should not be considered equal";
        assert !numberA.equals(numberB) : msg;
    }
    
    @Test
    public void testNotEqualsDiffBytes() {
        FloatingPointNumber someNumber = makeNumber();
        byte[] bytes = someNumber.getBytes();
        int index = RANDOM.nextInt(bytes.length);
        bytes[index] = (byte) ((bytes[index] << 1) + 1);
        FloatingPointNumber otherNumber = new FloatingPointNumberImpl(bytes);
        String msg = someNumber.toString() + " should not equal " 
                + otherNumber.toString();
        assert !someNumber.equals(otherNumber) : msg;
    }
    
    @Test
    public void testNotEqualsDiffFPClassTest() {
        FloatingPointNumber someNumber = makeNumber();
        byte[] bytes = someNumber.getBytes();
        FloatingPointNumber kindaSameNumber 
                = new FloatingPointNumberImpl(bytes) {
            
            @Override
            public String toString() {
                return "(0)" + super.toString();
            }
            
        };
        String msg = "Given that " + someNumber.toString() 
                + " is an instance of " + someNumber.getClass().getName() 
                + " and " + kindaSameNumber.toString() + " is an instance of " 
                + kindaSameNumber.getClass().getName() 
                + ", they should not be considered equal";
        assert !someNumber.equals(kindaSameNumber) : msg;
    }
    
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int initialCapacity = RANDOM.nextInt(64) + 16;
        Set<FloatingPointNumber> numbers = new HashSet<>(initialCapacity);
        Set<Integer> hashes = new HashSet<>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            FloatingPointNumber number = makeNumber();
            numbers.add(number);
            hashes.add(number.hashCode());
        }
        int expected = numbers.size();
        int actual = hashes.size();
        String message = "The set of " + expected 
                + " numbers should correspond to as many hash codes";
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testDiffClassHashDiff() {
        FloatingPointNumber someNumber = makeNumber();
        byte[] bytes = someNumber.getBytes();
        FloatingPointNumber kindaSameNumber 
                = new FloatingPointNumberImpl(bytes) {
            
            @Override
            public String toString() {
                return "fp:" + super.toString();
            }
            
        };
        int hashA = someNumber.hashCode();
        int hashB = kindaSameNumber.hashCode();
        String msg = someNumber.getClass().getName() + " holding value " 
                + someNumber.toString() + " hashes to " + hashA 
                + " which should be different from " 
                + kindaSameNumber.getClass().getName() + " holding value " 
                + kindaSameNumber.toString() + " hashing to " + hashB;
        assert hashA != hashB : msg;
    }
    
    private static String hexConvert(byte b) {
        String intermediate = Integer.toHexString(Byte.toUnsignedInt(b));
        return (intermediate.length() == 1) ? '0' + intermediate : intermediate;
    }
    
    @Test
    public void testBitPatternHexadecimal() {
        System.out.println("bitPatternHexadecimal");
        FloatingPointNumber number = makeNumber();
        int capacity = 2 * number.componentBytes.length;
        StringBuilder intermediate = new StringBuilder(capacity);
        for (byte b : number.componentBytes) {
            intermediate.append(hexConvert(b));
        }
        String expected = intermediate.toString();
        String actual = number.bitPatternHexadecimal();
        String message = "Reckoning bit pattern for number from bytes " 
                + Arrays.toString(number.componentBytes);
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testMinus() {
        System.out.println("minus");
        FloatingPointNumber minuend = makeNumber();
        int len = minuend.componentBytes.length;
        byte[] bytes = new byte[len];
        RANDOM.nextBytes(bytes);
        FloatingPointNumber subtrahend = new FloatingPointNumberImpl(bytes);
        FloatingPointNumber expected = minuend.plus(subtrahend.negate());
        FloatingPointNumber actual = minuend.minus(subtrahend);
        String message = "Subtracting " + subtrahend.toString() + " from " 
                + minuend.toString();
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testConstructorRejectsEmptyArray() {
        byte[] bytes = {};
        String msg = "Constructor should reject empty byte array";
        Throwable t = assertThrows(() -> {
            FloatingPointNumber badNumber = new FloatingPointNumberImpl(bytes);
            System.out.println("Should not have been able to use create " 
                    + badNumber.getClass() + '@' 
                    + Integer.toHexString(badNumber.hashCode()) 
                    + " with empty array");
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Message should not be null";
        assert !excMsg.isBlank() : "Message should not be blank";
        System.out.println("\"" + excMsg + "\"");
    }
    
    private static class FloatingPointNumberImpl extends FloatingPointNumber {
        
        @Override
        public int getUnbiasedExponent() {
            return 0;
        }
    
        @Override
        public int getBiasedExponent() {
            return (1 << 19) - 1;
        }
        
        @Override
        public boolean isNormal() {
            return false;
        }

        @Override
        public boolean isSubnormal() {
            return false;
        }
        
        @Override
        public boolean isInteger() {
            return true;
        }
    
        @Override
        public boolean isFinite() {
            return false;
        }
    
        @Override
        public boolean isInfinite() {
            return false;
        }
    
        @Override
        public boolean isNaN() {
            return false;
        }
    
        @Override
        public boolean isQuietNaN() {
            return false;
        }

        @Override
        public boolean isSignalingNaN() {
            return false;
        }

        @Override
        public float to32BitPrimitive() {
            return -0.0f;
        }

        @Override
        public double to64BitPrimitive() {
            return 0.0;
        }

        @Override
        public QuarterPrecisionNumber toQuarterPrecision() {
            return null;
        }

        @Override
        public HalfPrecisionNumber toHalfPrecision() {
            return null;
        }

        @Override
        public SinglePrecisionNumber toSinglePrecision() {
            return null;
        }

        @Override
        public DoublePrecisionNumber toDoublePrecision() {
            return null;
        }

        @Override
        public QuadruplePrecisionNumber toQuadruplePrecision() {
            return null;
        }

        @Override
        public OctuplePrecisionNumber toOctuplePrecision() {
            return null;
        }
    
        @Override
        public FloatingPointNumber plus(FloatingPointNumber addend) {
            if (addend instanceof FloatingPointNumberImpl sameTypeNum) {
                int len = this.componentBytes.length;
                byte[] addedBytes = new byte[len];
                for (int i = 0; i < len; i++) {
                    addedBytes[i] = (byte) (this.componentBytes[i] 
                            + sameTypeNum.componentBytes[i]);
                }
                return new FloatingPointNumberImpl(addedBytes);
            }
            return this;
        }
    
        @Override
        public FloatingPointNumber negate() {
            int len = this.componentBytes.length;
            byte[] negatedBytes = new byte[len];
            for (int i = 0; i < len; i++) {
                negatedBytes[i] = (byte) (~this.componentBytes[i]);
            }
            return new FloatingPointNumberImpl(negatedBytes);
        }
    
        @Override
        public FloatingPointNumber times(FloatingPointNumber multiplicand) {
            return this;
        }
    
        @Override
        public FloatingPointNumber reciprocal() {
            return this;
        }
    
        @Override
        public boolean arithmeticallyEqual(FloatingPointNumber other) {
            return true;
        }
            
        @Override
        public String toString() {
            StringBuilder intermediate = new StringBuilder();
            for (int i = 0; i < this.componentBytes.length; i++) {
                intermediate.append(Byte.toString(this.componentBytes[i]));
            }
            return intermediate.toString();
        }
        
        FloatingPointNumberImpl(byte[] bytes) {
            super(bytes);
        }
        
    }
    
}
