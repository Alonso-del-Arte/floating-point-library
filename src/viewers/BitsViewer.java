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

/**
 *
 * @author Alonso del Arte
 */
public class BitsViewer {
    
    /**
     * The default color for the sign bit panel. The RGB values for this color 
     * are 184, 184, 255.
     */
    static final Color DEFAULT_SIGN_BIT_COLOR = new Color(12105983);
    
    /**
     * The default color for the exponent bit panels. The RGB values for this 
     * color are 200, 255, 192.
     */
    static final Color DEFAULT_EXPONENT_BITS_COLOR = new Color(13172672);
    
    /**
     * The default color for the mantissa bit panels. The RGB values for this 
     * color are 255, 192, 184.
     */
    static final Color DEFAULT_MANTISSA_BITS_COLOR = new Color(16761016);
    
}
