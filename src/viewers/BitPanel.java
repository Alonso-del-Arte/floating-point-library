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
    
    public boolean getStatus() {
        return true;
    }
    
    public void toggleStatus() {
        // TODO: Write tests for this
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
        this.color = Color.BLACK;
        this.indexNum = Short.MAX_VALUE;
    }
    
}
