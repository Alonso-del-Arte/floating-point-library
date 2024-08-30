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
 * Static class to process 16-bit integers arrays and arrays of bytes. 
 * @author Alonso del Arte
 */
public class ShortProcessor {
    
    /**
     * Converts an array of bytes to a signed 16-bit integer.
     * @param source The bytes to convert, with the most significant byte first 
     * and the least significant byte last. If the array has two bytes, the 
     * first byte's first bit is understood to be the sign bit. For example, {1, 
     * 3}, which corresponds to the hexadecimal representation 103. The array 
     * may have less than two bytes, in which case the single byte becomes the 
     * least significant byte and the number is positive, even in the case of a 
     * negative byte, or if the array is empty the number is 0. For a negative 
     * number, the array must have two bytes with the first byte being at least 
     * &minus;128 and at most &minus;1. For example, {&minus;128, 126}, 
     * corresponding to the hexadecimal representation 807E.
     * @return The converted 16-bit integer. For example, 259, corresponding to 
     * the 103 example. Or, for example, if the array only has one byte, say 
     * &minus;1, that becomes 255. With the 807E example, the result would be 
     * &minus;32642.
     * @throws IllegalArgumentException If {@code source} has 3 or more bytes.
     */
    public static short fromBytes(byte[] source) {
        int len = source.length;
        if (len == 0) return 0;
        if (len > Short.BYTES) {
            int excess = len - Short.BYTES;
            String excMsg = "Source array has " + len + " bytes, " + excess 
                    + " too many";
            throw new IllegalArgumentException(excMsg);
        }
        int intermediate = source[0] & 255;
        if (len == 2) {
            intermediate <<= 8;
            intermediate += (source[1] & 255);
        }
        return (short) intermediate;
    }
    
    /**
     * Converts a 16-bit integer to an array of two bytes.
     * @param source The 16-bit integer to convert from. Three examples: 1000, 
     * 103, &minus;32510.
     * @return An array of two bytes, the first byte is the most significant 
     * byte of {@code source}, the second byte is the least significant. In the 
     * examples, 1000 becomes {3, &minus;24}, 103 becomes {0, 103} and 
     * &minus;32510 becomes {&minus;127, 2}.
     */
    public static byte[] toBytes(short source) {
        byte mostSignificant = (byte) (source >> 8);
        byte leastSignificant = (byte) source;
        return new byte[]{mostSignificant, leastSignificant};
    }
    
}
