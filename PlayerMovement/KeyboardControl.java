/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerMovement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//Note thjs code was taken from somewhere else as I had no idea how keyboard input works    
public class KeyboardControl implements KeyListener {
     private boolean[] keyStatus; 
    
    public KeyboardControl()
    {
        keyStatus = new boolean[256]; 
    }
    /**
     * Used to get what key is pressed 
     * @param keyCode accepts a integer (ASCII) number for key type
     * @return a boolean
     */
    public boolean getKeyStatus(int keyCode){
          //if the key is not within the ascii range
        if(keyCode < 0 || keyCode > 255)
        {
          //Key Doesn't exist 
            return false; 
            
        }
        else
        {
             //Key Does exist and returns what key it is 
            return keyStatus[keyCode]; 
        }
    }
    /**
     * Resets the controller 
     */
    public void resetController()
    {   //Sets the keycode to a non existing keycode 
        keyStatus = new boolean[256]; 
    }
    
    //Used if a key is typed comes along with the keyEven and keyListener
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }
   //Used if a key is Pressed comes along with the keyEven and keyListener
    @Override
    public void keyPressed(KeyEvent ke) {
        //when key is pressed a there will be a command that will allow the user to move and play 
        keyStatus[ke.getKeyCode()] = true; 
    }
   //Used if a key is released  comes along with the keyEven and keyListener
    @Override
    public void keyReleased(KeyEvent ke) {
        //When key is released commands become unresonsive in the game 
        keyStatus[ke.getKeyCode()] = false; 
    }
    
}
