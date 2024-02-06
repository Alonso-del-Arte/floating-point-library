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

/**
 * Represents a floating point number.
 * @author Alonso del Arte
 */
public abstract class FloatingPointNumber {
    
    private final byte[] componentBytes;
    
    public abstract float to32BitPrimitive();
    
    public abstract double to64BitPrimitive();

    public abstract QuarterPrecisionNumber toQuarterPrecision();
    
    public abstract HalfPrecisionNumber toHalfPrecision();
    
    public abstract SinglePrecisionNumber toSinglePrecision();
    
    public abstract DoublePrecisionNumber toDoublePrecision();
    
    public abstract QuadruplePrecisionNumber toQuadruplePrecision();
    
    public abstract OctuplePrecisionNumber toOctuplePrecision();
    
    public FloatingPointNumber(byte[] bytes) {
        this.componentBytes = bytes;
    }
    
}
