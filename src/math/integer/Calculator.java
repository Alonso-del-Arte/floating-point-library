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
    
    /**
     * Calculates the greatest common divisor (GCD) of two integers using the 
     * Euclidean algorithm. For now this function is not implemented with 
     * recursion, but that could change in a later version of this program.
     * @param a The first number. Need not be greater or smaller than
     * <code>b</code>. For example, &minus;42.
     * @param b The second number. Need not be greater or smaller than
     * <code>a</code>. For example, &minus;49.
     * @return The GCD. For example, 7. If one of <code>a</code> or 
     * <code>b</code> is 0 but the other is not 0, the result will be the 
     * absolute value of the nonzero number. As for gcd(0, 0), we make no 
     * promises whatsoever that the current behavior will be maintained in later 
     * versions, and should therefore not be relied upon.
     */
    public static long euclideanGCD(long a, long b) {
        if (b == 0L) {
            return Math.abs(a);
        }
        do {
            long temp = b;
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
    
    // TODO: Write tests for this
    public static int randomMod(int n, int m) {
        if (m == 0) {
            String excMsg = "Numbers " + n + " modulo "  + m + " are undefined";
            throw new ArithmeticException(excMsg);
        }
        return 0;
    }
    
}
