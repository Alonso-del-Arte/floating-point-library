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
public class BitPanel extends JPanel {
    
    private boolean status;
    
    private final Color color;
    
    private final short indexNum;
    
    /**
     * Retrieves the panel's status. Guaranteed to be the same as the status the 
     * instance was constructed with if {@link #toggleStatus()} hasn't been 
     * called on this status.
     * @return Either true or false.
     */
    public boolean getStatus() {
        return this.status;
    }
    
    /**
     * Toggles the panel's status. Thus the display changes from 0 to 1 or 
     * vice-versa.
     */
    public void toggleStatus() {
        this.status = !this.status;
    }
    
    // TODO: Write test for this
    public Color getColorCode() {
        return Color.DARK_GRAY;
    }
    
    // TODO: Write test for this
    public int getIndex() {
        return -1;
    }
    
    // TODO: Write test for this
    public BitPanel(boolean on, Color colorCode, short index) {
        if (index < 0) {
            String excMsg = "Index " + index 
                    + " not valid, should be 0 or positive";
            throw new IllegalArgumentException(excMsg);
        }
        this.status = on;
        this.color = Color.BLACK;
        this.indexNum = Short.MAX_VALUE;
    }
    
}
