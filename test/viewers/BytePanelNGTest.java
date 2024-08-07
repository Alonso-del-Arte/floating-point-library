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
 * Tests of the BytePanel class.
 * @author Alonso del Arte
 */
public class BytePanelNGTest extends JFrame {
    
    private BitPanel[] makeBitPanelArray(byte value) {
        BitPanel[] array = new BitPanel[8];
        for (short index = 0; index < 8; index++) {
            boolean on = value % 2 != 0;
            value >>= 1;
            Color colorCode = BitPanelNGTest.chooseColor();
            array[index] = new BitPanel(on, colorCode, index);
        }
        return array;
    }
    
    private BitPanel[] makeBitPanelArray(int length) {
        BitPanel[] array = new BitPanel[length];
        for (short index = 0; index < length; index++) {
            boolean on = RANDOM.nextBoolean();
            Color colorCode = BitPanelNGTest.chooseColor();
            array[index] = new BitPanel(on, colorCode, index);
        }
        return array;
    }
    
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        for (int i = Byte.MIN_VALUE; i < 128; i++) {
            byte expected = (byte) i;
            BitPanel[] bitPanels = makeBitPanelArray(expected);
            BytePanel instance = new BytePanel(bitPanels);
            byte actual = instance.getValue();
            assertEquals(actual, expected);
        }
    }
    
    @Test
    public void testConstructorRejectsFewerThanEightPanels() {
        String msgPart = "Shouldn't be able to construct byte panel with ";
        for (int length = 0; length < 8; length++) {
            BitPanel[] bitPanels = makeBitPanelArray(length);
            String msg = msgPart + length + " panel(s) rather than 8";
            Throwable t = assertThrows(() -> {
                BytePanel badPanel = new BytePanel(bitPanels);
                System.out.println(msg + ", but instantiated " 
                        + badPanel.toString());
            }, IllegalArgumentException.class, msg);
            String excMsg = t.getMessage();
            assert excMsg != null : "Exception message should not be null";
            assert !excMsg.isBlank() : "Exception message should not be blank";
            System.out.println("\"" + excMsg + "\"");
        }
    }
    
    @Test
    public void testConstructorRejectsArrayWithNullPanels() {
        String msgPart 
                = "Shouldn't be able to construct byte panel with panel ";
        for (int index = 0; index < 8; index++) {
            BitPanel[] bitPanels = makeBitPanelArray(8);
            bitPanels[index] = null;
            String msg = msgPart + index + " null";
            Throwable t = assertThrows(() -> {
                BytePanel badPanel = new BytePanel(bitPanels);
                System.out.println(msg + ", but instantiated " 
                        + badPanel.toString());
            }, NullPointerException.class, msg);
            String excMsg = t.getMessage();
            assert excMsg != null : "Exception message should not be null";
            assert !excMsg.isBlank() : "Exception message should not be blank";
            System.out.println("\"" + excMsg + "\"");
        }
    }
    
    @Test
    public void testConstructorRejectsNullArray() {
        BitPanel[] bitPanels = null;
        String msg = "Shouldn't be able to instantiate panel with null array";
        Throwable t = assertThrows(() -> {
            BytePanel badPanel = new BytePanel(bitPanels);
            System.out.println(msg + ", but instantiated " 
                    + badPanel.toString());
        }, NullPointerException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be blank";
        System.out.println("\"" + excMsg + "\"");
    }
    
    static class CallCountingBytePanel extends BytePanel {
        
        int prepareCallCount = 0;
        
        int updateValueCallCount = 0;
        
        int subscribeCallCount = 0;
        
        @Override
        void prepare() {
            super.prepare();
            this.prepareCallCount++;
        }
        
        @Override
        void updateValue() {
            super.updateValue();
            this.updateValueCallCount++;
        }
        
        @Override
        void subscribe(BitsViewer subscriber) {
            super.subscribe(subscriber);
            this.subscribeCallCount++;
        }
        
        CallCountingBytePanel(BitPanel[] bitPanels) {
            super(bitPanels);
        }
        
    }
    
}
