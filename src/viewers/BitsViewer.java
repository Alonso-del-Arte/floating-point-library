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
package viewers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import math.fp.FloatingPointNumber;
import math.fp.QuarterPrecisionNumber;

/**
 *
 * @author Alonso del Arte
 */
public class BitsViewer {
    
    /**
     * The default color for the sign bit panel. The RGB values for this color 
     * are 152, 152, 224.
     */
    static final Color DEFAULT_SIGN_BIT_COLOR = new Color(10000608);
    
    /**
     * The default color for the exponent bit panels. The RGB values for this 
     * color are 168, 224, 160.
     */
    static final Color DEFAULT_EXPONENT_BITS_COLOR = new Color(11067552);
    
    /**
     * The default color for the mantissa bit panels. The RGB values for this 
     * color are 224, 160, 152.
     */
    static final Color DEFAULT_MANTISSA_BITS_COLOR = new Color(14721176);
    
    void updateValue() {
        //
    }
    
    public void activate() {
        //
    }
    
    public BitsViewer(FloatingPointNumber number) {
        //
    }
    
}
