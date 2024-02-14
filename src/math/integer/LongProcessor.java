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
package math.integer;

/**
 * Static class to process 64-bit integers arrays and arrays of bytes. 
 * @author Alonso del Arte
 */
public class LongProcessor {
    
    /**
     * Converts an array of bytes to a signed 64-bit integer.
     * @param source The bytes to convert, with the most significant byte first 
     * and the least significant byte last. The first byte's first bit is 
     * understood to be the sign bit. For example, {1, 3, 5, 7, 9, 11, 13, 15}. 
     * These correspond to the hexadecimal representation 1030507090B0D0F.
     * @return The converted 64-bit integer. For example, 72907546742689039.
     * @throws IllegalArgumentException If <code>source</code> has 9 or more 
     * bytes.
     * @throws ArrayIndexOutOfBoundsException If <code>source</code> has 1 to 7 
     * bytes.
     */
    public static long fromBytes(byte[] source) {
        int len = source.length;
        if (len == 0) return 0L;
        if (len > Double.BYTES) {
            int excess = len - Double.BYTES;
            String excMsg = "Source array has " + len + " bytes, " + excess 
                    + " too many";
            throw new IllegalArgumentException(excMsg);
        }
        long intermediate = 0L;
        for (int i = 0; i < 8; i++) {
            intermediate *= 256;
            intermediate += Byte.toUnsignedLong(source[i]);
        }
        return intermediate;
    }
    
    // TODO: Write tests for this
    public static byte[] toBytes(long source) {
        byte[] bytes = {};
        return bytes;
    }
    
}
