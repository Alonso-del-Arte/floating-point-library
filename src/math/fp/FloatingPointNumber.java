/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package math.fp;

/**
 * Represents a floating point number.
 * @author Alonso del Arte
 */
public abstract class FloatingPointNumber {
    
    private final byte[] componentBytes;

    public FloatingPointNumber(byte[] bytes) {
        this.componentBytes = bytes;
    }
    
}
