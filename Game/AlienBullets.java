
/*Eason,Gordon,Brycen
 * June 9 2020
   This class is used for the alien's bullet
 */
package Game;
//import used to create the alien bullets class
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


//Extends this to the parent class GameMoving
public class AlienBullets extends GameMoving {
         //Enemies shoot beams
    // constructor for beam
    public  AlienBullets(int xPos, int yPos, int diameter, Color color) {
        //Calls the parent constructor 
        super(xPos, yPos, 0, 0, color);
    }
    
/**
 * This method will be used to draw alien's beams
 * @param g will accept a Graphics Objects which is used to drawn on 
 */
    public void draw(Graphics g) {
        //sets the color depending what is set in the constructor 
        g.setColor(color);
        //draw the bullet
        g.fillRect(this.getxPos(), this.getyPos(), 7, 15);
    }
    
  /**
   * This method is used to get the hitbox of a bullet
   * @return gets the object Rectangle back
   */
    @Override
    public Rectangle getBounds() {
        //set the hitboxes for the alien bullets 
        Rectangle beamHitbox = new Rectangle(xPos, yPos, 7, 15);
        return beamHitbox;
    }
}
