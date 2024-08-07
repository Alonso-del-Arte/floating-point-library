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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
    
    @Test
    public void testDefaultPanelHeight() {
        int expected = 200;
        int actual = BitPanel.DEFAULT_PANEL_HEIGHT;
        assertEquals(actual, expected);
    }
    
    @Test
    public void testDefaultPanelWidth() {
        int expected = 100;
        int actual = BitPanel.DEFAULT_PANEL_WIDTH;
        assertEquals(actual, expected);
    }
    
    @Test
    public void testDefaultPreferredDimension() {
        Dimension expected = new Dimension(BitPanel.DEFAULT_PANEL_WIDTH, 
                BitPanel.DEFAULT_PANEL_HEIGHT);
        Dimension actual = BitPanel.DEFAULT_PREFERRED_DIMENSION;
        assertEquals(actual, expected);
    }
    
    static Color chooseColor() {
        int rgb = RANDOM.nextInt(RGB_THRESHOLD);
        return new Color(rgb);
    }
    
    @Test
    public void testIsOnForInstanceConstructedWithTrue() {
        short index = (short) RANDOM.nextInt(64);
        BitPanel instance = new BitPanel(true, chooseColor(), index);
        assert instance.isOn() : "Instance should have status bit on";
    }
    
    @Test
    public void testIsOnForInstanceConstructedWithFalse() {
        short index = (short) RANDOM.nextInt(64);
        BitPanel instance = new BitPanel(false, chooseColor(), index);
        assert !instance.isOn() : "Instance should have status bit off";
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
        assert instance.isOn() == expected : msg;
        expected = !expected;
        instance.toggleStatus();
        assert instance.isOn() == expected : msg;
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
    public void testGetIndex() {
        System.out.println("getIndex");
        short expected = (short) RANDOM.nextInt(64);
        BitPanel instance = new BitPanel(RANDOM.nextBoolean(), chooseColor(), 
                expected);
        short actual = instance.getIndex();
        assertEquals(actual, expected);
    }
    
    private MouseEvent[] makeMouseEventArray(Component instance) {
        long when = System.currentTimeMillis();
        MouseEvent enterEvent = new MouseEvent(instance, 
                MouseEvent.MOUSE_ENTERED, when, 0, 0, 0, 0, false);
        when++;
        MouseEvent clickEvent = new MouseEvent(instance, 
                MouseEvent.MOUSE_CLICKED, when, 0, 0, 0, 1, false);
        when++;
        MouseEvent exitEvent = new MouseEvent(instance, 
                MouseEvent.MOUSE_ENTERED, when, 0, 0, 0, 0, false);
        MouseEvent[] array = {enterEvent, clickEvent, exitEvent};
        return array;
    }
    
    @Test
    public void testActivate() {
        System.out.println("activate");
        Color colorCode = chooseColor();
        short index = (short) RANDOM.nextInt(64);
        BitPanel instance = new BitPanel(RANDOM.nextBoolean(), colorCode, 
                index);
        instance.activate();
        MouseListener[] expected = {instance};
        MouseListener[] actual = instance.getMouseListeners();
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
    
    private static class CallCountingBitPanel extends BitPanel {
        
        int mouseClickedCallCount = 0;
        
        int mouseEnteredCallCount = 0;
        
        int mouseExitedCallCount = 0;
        
        MouseEvent mostRecentMouseEvent = null;

        @Override
        public void mouseClicked(MouseEvent event) {
            super.mouseClicked(event);
            this.mostRecentMouseEvent = event;
            this.mouseClickedCallCount++;
        }
        
        @Override
        public void mouseEntered(MouseEvent event) {
            super.mouseEntered(event);
            this.mostRecentMouseEvent = event;
            this.mouseEnteredCallCount++;
        }
        
        @Override
        public void mouseExited(MouseEvent event) {
            super.mouseExited(event);
            this.mostRecentMouseEvent = event;
            this.mouseExitedCallCount++;
        }
        
        public CallCountingBitPanel(boolean on, Color colorCode, short index) {
            super(on, colorCode, index);
        }
        
    }
    
}
