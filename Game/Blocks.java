/*Eason,Gordon,Brycen
  June 15 2020 
 */
package Game;
//import packages used for the game's shields/blocks
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
//Class that is extended and come from the abstract gameobject class
public class Blocks extends GameObject {
    //attributes for the blocks 
 int width;
    int height;
   
     

    // Constructor for Shield objects
    public Blocks(int xPos, int yPos, int width, int height, Color color) {
        //Calls the constructor from gameobject
        super(xPos, yPos, color);
        //Paramaters equal to the attributes 
        this.width = width;
        this.height = height;

    }

    //getter gets the width of the shield
    public int getWidth() {
        return width;
    }
    //getter gets the height of the shield
    public int getHeight() {
        return height;
    }
    //setter sets the width of the shield
    public void setWidth(int width) {
        this.width = width;
    }
    //setter sets the height of the shield
    public void setHeight(int height) {
        this.height = height;
    }

    // Used to draw shield objects
   
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(this.getxPos(), this.getyPos(), 90, 10);
    }

    // Used to get the hit box of a shield object
    @Override
    public Rectangle getBounds() {
        Rectangle shieldHitbox = new Rectangle(this.getxPos(), this.getyPos(), 90, 10);
        return shieldHitbox;
    }

  //Atttributes for the blocks
    @Override
    public String toString() {
        return "Blocks{" + "width=" + width + ", height=" + height + '}';
    }

}
