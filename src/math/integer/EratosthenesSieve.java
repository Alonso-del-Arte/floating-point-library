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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Gathers prime numbers using the Eratosthenes sieve.
 * @author Alonso del Arte
 */
public class EratosthenesSieve {
    
    private static final Random RANDOM 
            = new Random(System.currentTimeMillis());
    
    // TODO: Write tests for this
    public static List<Integer> listPrimes(int threshold) {
        List<Integer> list = new ArrayList<>();
        return list;
    }
    
    private static boolean checkPrime(int p) {
        switch (p) {
            case 0:
            case 1:
                return false;
            case 2:
                return true;
            default:
                if (p % 2 == 0) {
                    return false;
                }
                double root = Math.sqrt(p);
                int divisor = 3;
                while (divisor <= root) {
                    if (p % divisor == 0) {
                        return false;
                    }
                    divisor += 2;
                }
                return true;
        }
    }
    
    /**
     * 
     * @param bound
     * @return 
     */
    public static int randomPrime(int bound) {
        int p = RANDOM.nextInt(bound);
        if (p < 2) {
            return 2;
        }
        while (!checkPrime(p)) {
            p--;
        }
        return p;
    }
    
}
