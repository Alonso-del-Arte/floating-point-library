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

import javax.swing.JFrame;
import javax.swing.JPanel;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the BitsViewer class.
 * @author Alonso del Arte
 */
public class BitsViewerNGTest extends JFrame {
    
    @Test
    public void testDefaultSignBitColor() {
        Color expected = new Color(184, 184, 255);
        Color actual = BitsViewer.DEFAULT_SIGN_BIT_COLOR;
        assertEquals(actual, expected);
    }
    
}
