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
    
    // TODO: Write tests for this
    public static short fromBytes(byte[] source) {
        int len = source.length;
        if (len == 0) return 0;
        if (len > Short.BYTES) {
            int excess = len - Short.BYTES;
            String excMsg = "Source array has " + len + " bytes, " + excess 
                    + " too many";
            throw new IllegalArgumentException(excMsg);
        }
        return source[0];
    }
    
    // TODO: Write tests for this
    public static byte[] toBytes(long source) {
        byte[] bytes = {};
        return bytes;
    }
    
}
