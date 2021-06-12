 /*June 9 2020
  Bullet Class which is a class specifically used for the player's ships bullets not 
 */
package Game;
//imports 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


//Public class extends to abstractclass gamemoving 
public class Bullet extends GameMoving {

//Attributes for the bullet
    int yVelocity;
    int Size;
    //constructor for the attributes 
 public Bullet(int xPos, int yPos, int yVel, Color color) {
     //calls a parent class constructor 
        super(xPos, yPos, 0, 0, color);
        //sets the yvelocity to the one in the method
        this.yVelocity = yVel;
    }

   //gets the velocity
        public int getyVelocity() {
        return yVelocity;
    }
//sets the velocity
    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }
//gets the size of the ship's bullet
    public int getSize() {
        return Size;
    }
//setter sets the size of the bullet
    public void setSize(int Size) {
        this.Size = Size;
    }
    /**
     * Draws a bullet
     * @param g accepts a Graphics object which will be used later on to draw the player's bullet
     */
    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillRect(this.getxPos(), this.getyPos(), 10, 30);
       
        
    }
  /**
   * This method is used to get the hitbox of the player's bullet
   * @return gets the object of the bullet 
   */
    @Override
    public Rectangle getBounds() {
       Rectangle bulletHitbox = new Rectangle(this.getxPos(), this.getyPos(), 5, 5);
        return bulletHitbox;
    }

    
    
}
