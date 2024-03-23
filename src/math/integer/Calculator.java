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

import java.util.Random;

/**
 *
 * @author Alonso del Arte
 */
public class Calculator {
    
    private static final Random RANDOM = new Random(System.nanoTime());
    
    public static int euclideanGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        do {
            int temp = b;
            b = a % b;
            a = temp;
        } while (b != 0);
        return Math.abs(a);
    }
    
    /**
     * Gives a pseudorandomly chosen power of two.
     * @return A pseudorandomly chosen power of two. For example, 16384.
     */
    public static int randomPowerOfTwo() {
        int shift = RANDOM.nextInt(31);
        return 1 << shift;
    }
    
}
