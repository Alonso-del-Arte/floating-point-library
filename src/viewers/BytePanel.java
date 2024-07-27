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
 * Holds eight bit panels together. The constructor requires eight non-null bit 
 * panels.
 * @author Alonso del Arte
 */
public class BytePanel extends JPanel {
    
    private final BitPanel[] panels;
    
    /**
     * Calculates the aggregate value of the bit panels. This is mutable, it 
     * changes according to the values of the individual bit panels being 
     * toggled. For the example, suppose every other bit panel is on and the 
     * others are off, with the least significant bit panel being on.
     * @return The aggregate value of the bit panels. In the example, this would 
     * be 64 + 16 + 4 + 1 = 85.
     */
    public byte getValue() {
        byte value = 0;
        for (int i = 7; i > -1; i--) {
            value <<= 1;
            if (this.panels[i].isOn()) {
                value++;
            }
        }
        return value;
    }
    
    /**
     * Sole constructor.
     * @param bitPanels An array of bit panels. Should have no fewer than eight 
     * panels. However, extra panels will be ignored. A separate byte panel 
     * should be instantiated for the extra bit panels.
     * @throws IllegalArgumentException If there are fewer than eight bit panels 
     * in {@code bitPanels}.
     * @throws NullPointerException If {@code bitPanels} is null, or if any of 
     * the first eight panels are null.
     */
    public BytePanel(BitPanel[] bitPanels) {
        if (bitPanels == null) {
            String excMsg = "Bit panels array should not be null";
            throw new NullPointerException(excMsg);
        }
        int len = bitPanels.length;
        if (len < Byte.SIZE) {
            int deficit = Byte.SIZE - len;
            String excMsg = "Bit panels array only has " + len 
                    + " bit panel(s), needs " + deficit + " more";
            throw new IllegalArgumentException(excMsg);
        }
        for (int i = 0; i < Byte.SIZE; i++) {
            if (bitPanels[i] == null) {
                String excMsg = "Bit panel " + i + " should not be null";
                throw new NullPointerException(excMsg);
            }
        }
        this.panels = bitPanels;
    }
    
}
