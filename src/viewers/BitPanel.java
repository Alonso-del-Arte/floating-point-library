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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * A panel to display a single bit. An instance of this class is meant to be 
 * grouped with other instances in a {@link BytePanel}.
 * @author Alonso del Arte
 */
public class BitPanel extends JPanel implements MouseListener {
    
    private boolean status;
    
    private final Color color;
    
    private final short indexNum;
    
    /**
     * Retrieves the panel's status. Guaranteed to be the same as the status the 
     * instance was constructed with if {@link #toggleStatus()} hasn't been 
     * called on this instance.
     * @return Either true or false.
     */
    public boolean isOn() {
        return this.status;
    }
    
    /**
     * Toggles the panel's status. Thus the display changes from 0 to 1 or 
     * vice-versa.
     */
    public void toggleStatus() {
        this.status = !this.status;
    }
    
    /**
     * Retrieves this panel's color code. Note that this is immutable.
     * @return The color for the color coding. For example, light green.
     */
    public Color getColorCode() {
        return this.color;
    }
    
    /**
     * Retrieves the panel's index. Note that this is immutable.
     * @return The index. For example, 63 in the case of the sign bit of a 
     * double precision number.
     */
    public short getIndex() {
        return this.indexNum;
    }
    
    void subscribe(BytePanel subscriber) {
        // TODO: Write tests for this
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawString("FOR TESTING PURPOSES ONLY", 50, 50);
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
        // TODO: Write tests for this
    }
    
    @Override
    public void mouseEntered(MouseEvent event) {
        // TODO: Write tests for this
    }
    
    @Override
    public void mouseExited(MouseEvent event) {
        // TODO: Write tests for this
    }
    
    @Override
    public void mousePressed(MouseEvent event) {
        // TODO: Write tests for this
    }
    
    @Override
    public void mouseReleased(MouseEvent event) {
        // TODO: Write tests for this
    }
    
    void activate() {
        // TODO: Write tests for this
    }
    
    /**
     * Sole constructor.
     * @param on The bit, true for 1, false for 0. May be changed with {@link 
     * #toggleStatus()}.
     * @param colorCode The color code for the color coding. For example, light 
     * green for the exponent bits. This is immutable.
     * @param index The index for the bit. For example, 51 for the leading 
     * mantissa bit in a double precision number. This is immutable. Note that 
     * the least significant mantissa bit is always 0.
     * @throws IllegalArgumentException If <code>index</code> is negative.
     */
    public BitPanel(boolean on, Color colorCode, short index) {
        if (index < 0) {
            String excMsg = "Index " + index 
                    + " not valid, should be 0 or positive";
            throw new IllegalArgumentException(excMsg);
        }
        this.status = on;
        this.color = colorCode;
        this.indexNum = index;
    }
    
}
