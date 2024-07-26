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
public class BytePanel extends JPanel {
    
    // TODO: Write tests for this
    public byte getValue() {
        return Byte.MIN_VALUE;
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
    }
    
}
