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

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the QuarterPrecisionNumber class. Since there are only 256 possible 
 * values, it is possible for these tests to be much more exhaustive and 
 * complete than is possible for greater precision floating point numbers.
 * @author Alonso del Arte
 */
public class QuarterPrecisionNumberNGTest {
    
    @Test
    public void testToStringNegativeInfinity() {
        byte b = -8;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String expected = "\u2212Infinity";
        String actual = number.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringPositiveInfinity() {
        byte b = 120;
        QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
        String expected = "Infinity";
        String actual = number.toString();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testToStringNegativeNaN() {
        String expected = "NaN";
        for (byte b = -7; b < 0; b++) {
            QuarterPrecisionNumber number = new QuarterPrecisionNumber(b);
            String actual = number.toString();
            assertEquals(actual, expected);
        }
    }
    
    @Test
    public void testToStringNegativeZero() {
        QuarterPrecisionNumber number 
                = new QuarterPrecisionNumber(Byte.MIN_VALUE);
        String expected = "\u22120.0";
        String actual = number.toString();
        assertEquals(actual, expected);
    }
    
}
