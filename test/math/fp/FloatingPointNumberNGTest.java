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
    
    private class FloatingPointNumberImpl extends FloatingPointNumber {

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
            return null;
        }

        // TODO: Write tests for this
        @Override
        public HalfPrecisionNumber toHalfPrecision() {
            return null;
        }

        // TODO: Write tests for this
        @Override
        public SinglePrecisionNumber toSinglePrecision() {
            return null;
        }

        // TODO: Write tests for this
        @Override
        public DoublePrecisionNumber toDoublePrecision() {
            return null;
        }

        // TODO: Write tests for this
        @Override
        public QuadruplePrecisionNumber toQuadruplePrecision() {
            return null;
        }

        // TODO: Write tests for this
        @Override
        public OctuplePrecisionNumber toOctuplePrecision() {
            return null;
        }
    
        // TODO: Write tests for this
        @Override
        public String toHexadecimalString() {
            return "SORRY, NOT IMPLEMENTED YET";
        }
    
        FloatingPointNumberImpl(byte[] bytes) {
            super(bytes);
        }
        
    }
    
}
