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

import static math.integer.CalculatorNGTest.RANDOM;

import static org.testframe.api.Asserters.assertThrows;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the BitPanel class.
 * @author Alonso del Arte
 */
public class BitPanelNGTest extends JFrame {
    
    private static final int RGB_THRESHOLD = 1 << 24;
    
    private static Color chooseColor() {
        int rgb = RANDOM.nextInt(RGB_THRESHOLD);
        return new Color(rgb);
    }
    
    @Test
    public void testGetStatusConstructedWithTrue() {
        short index = (short) RANDOM.nextInt(64);
        BitPanel instance = new BitPanel(true, chooseColor(), index);
        assert instance.getStatus() : "Instance should have status bit on";
    }
    
    @Test
    public void testGetStatusConstructedWithFalse() {
        short index = (short) RANDOM.nextInt(64);
        BitPanel instance = new BitPanel(false, chooseColor(), index);
        assert !instance.getStatus() : "Instance should have status bit off";
    }
    
    @Test
    public void testToggleStatus() {
        System.out.println("toggleStatus");
        boolean expected = RANDOM.nextBoolean();
        short index = (short) RANDOM.nextInt(64);
        BitPanel instance = new BitPanel(expected, chooseColor(), index);
        expected = !expected;
        instance.toggleStatus();
        String msg = "Status should've been toggled";
        assert instance.getStatus() == expected : msg;
        expected = !expected;
        instance.toggleStatus();
        assert instance.getStatus() == expected : msg;
    }
    
    @Test
    public void testGetColorCode() {
        Color expected = chooseColor();
        short index = (short) RANDOM.nextInt(64);
        BitPanel instance = new BitPanel(RANDOM.nextBoolean(), expected, index);
        Color actual = instance.getColorCode();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testConstructorRejectsNegativeIndex() {
        short badIndex = (short) (RANDOM.nextInt() | Short.MIN_VALUE);
        String msg = "Should not have been able to create bit panel with index " 
                + badIndex;
        Throwable t = assertThrows(() -> {
            BitPanel badPanel = new BitPanel(RANDOM.nextBoolean(), 
                    chooseColor(), badIndex);
            System.out.println(msg + ", but created " + badPanel.toString());
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be blank";
        System.out.println("\"" + excMsg + "\"");
    }
    
}
