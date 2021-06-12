 /*Eason Liang
    June 9 2020 
    This class is used for the player where the ships moves 
 */
package Game;
import PlayerMovement.KeyboardControl;
import java.awt.Color;
import java.awt.Graphics;

//Class is abstract and extends from gameObject
public abstract class PlayerMoving extends GameObject{
    //declare a new keyboard object 
      KeyboardControl control;
     public PlayerMoving(int xPos, int yPos, Color color, KeyboardControl control){
    
        //Calls the parent constructor from gameObject
        super(xPos, yPos, color);
        this.control = control;
    }
     //draws the player ships 
     public void draw(Graphics g){
         
     }
}
