/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import PlayerMovement.KeyboardControl;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.net.URL;

/**
 *
 * @author Eason
 */
public class Ship extends PlayerMoving  {
    //gets images for the ships 
     URL url = Ship.class.getResource("SpaceShip.png");
     ImageIcon playerShip = new ImageIcon(url);
     public Ship(int xPos, int yPos, Color color, KeyboardControl control) {
        super(xPos, yPos, color, control);
       
    }

   /**
    * Draw the Players Ship 
    * @param g accepts the object graphics which allow a place for the ship to be drawn on 
    */
    public void draw(Graphics g){
        //Draws Player Ship 
         playerShip.paintIcon(null, g, this.getxPos(), this.getyPos());
        
    }
    /**
     * Use this method to help set the hitbox of the rectangle
     * @return returns the object for the rectangle 
     */
    @Override
     public Rectangle getBounds() {
        Rectangle shipHitbox = new Rectangle(this.getxPos(), this.getyPos(), 100, 50);
        return shipHitbox;
    }
       public void move() {
        // Left arrow key press
        if (control.getKeyStatus(37)) {
            //user moves 5 to the left 
            xPos -=5;
        }
        // Right arrow key press
        if (control.getKeyStatus(39)) {
            //ships moves 5 to the right 
            xPos += 5;
        }
        
        // Move from edge to edge without stopping
        if (xPos > 900) {
            //user stops and can't move beyone that point
            xPos = 900;
        }
        //if user hits the left side 
        if (xPos < 0) {
            //user cannot move beyone that side 
            xPos = 0;
        }
    }
   
}
