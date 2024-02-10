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
import java.util.Random;

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
    public void testConstructorRejectsEmptyArray() {
        byte[] bytes = {};
        try {
            FloatingPointNumber badNumber = new FloatingPointNumberImpl(bytes);
            String message = "Should not have been able to use create " 
                    + badNumber.getClass() + '@' 
                    + Integer.toHexString(badNumber.hashCode()) 
                    + " with empty array";
            fail(message);
        } catch (IllegalArgumentException iae) {
            System.out.println("Empty array correctly caused exception");
            String excMsg = iae.getMessage();
            assert excMsg != null : "Message should not be null";
            assert !excMsg.isBlank() : "Message should not be blank";
            System.out.println("\"" + excMsg + "\"");
        } catch (RuntimeException re) {
            String message = re.getClass().getName() 
                    + " is the wrong exception for empty array to constructor";
            fail(message);
        }
    }
    
    private static class FloatingPointNumberImpl extends FloatingPointNumber {

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
        public String toString() {
            StringBuilder intermediate = new StringBuilder();
            for (int i = 0; i < this.componentBytes.length; i++) {
                intermediate.append(Byte.toString(this.componentBytes[i]));
            }
            return intermediate.toString();
        }
        
        @Override
        public String toHexadecimalString() {
            return "FOR TESTING PURPOSES ONLY";
        }
    
        FloatingPointNumberImpl(byte[] bytes) {
            super(bytes);
        }
        
    }
    
}
