/*Eason,Brycen,Gordon
 *This class is a abstract class Used for object that move in the game 
  June 9 2020
 */
package Game;
//imports used for color and hitboxes 
import java.awt.Color;
import java.awt.Rectangle;


public abstract class GameObject {
    //attributes
       int xPos;
    int yPos;
    Color color;
    boolean isColliding;
  public GameObject(){
      
  }
    
    // Constuctor for any Game Object
    public GameObject(int xPosition, int yPosition, Color color) {
        this.xPos = xPosition;
        this.yPos = yPosition;
        this.color = color;
    }
    //method will be used later to get the hitboxes of certain objects in the game 
    public abstract Rectangle getBounds();

    // gettter Gets the X position of any object
    public int getxPos() {
        return xPos;
    }

    // getter Gets the Y position of any object
    public int getyPos() {
        return yPos;
    }

    // getter Gets the color of any object
    public Color getColor() {
        return color;
    }

    // setter Sets the X position of any object
    public void setxPos(int xPosition) {
        this.xPos = xPosition;
    }

    // setter Sets the Y position of any object
    public void setyPos(int yPosition) {
        this.yPos = yPosition;
    }

    // setter Sets the color of any object
    public void setColor(Color color) {
        this.color = color;
    }

    // Checks if the hitboxes of any two objects are intersecting
    public boolean isColliding(GameObject other) {
        isColliding = other.getBounds().intersects(this.getBounds());
        return isColliding;
    }
   
}
