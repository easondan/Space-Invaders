/*Eason,Brycen,Gordon
  June 9 2020
   This abstract class is used for objects that move in the game without a control
 */
package Game;

import java.awt.Color;


public abstract class GameMoving extends GameObject {
    //attributes of a game moving objects extends to the parent class GameObject
    int xVel;
    int yVel;

   
    //constructor for the game moving object 
     public GameMoving(int xPosition, int yPosition, int xVelocity, int yVelocity, Color color)
    {
        //Calls the constructor from the parent class
        super(xPosition, yPosition, color);
        //paramater values set to the attributes 
        xVel = xVelocity;
        yVel = yVelocity;
    
    }
     /**
      * Getter gets the value of the x velocity
      * @return gives the x velocity value in an integer
      */
      public int getxVel() {
        return xVel;
    }
      /**
       * setter changes the x velocity
       * @param xVel accepts an integer value
       */
    public void setxVel(int xVel) {
        this.xVel = xVel;
    }
    /**
      * Getter gets the value of the y velocity
      * @return gives the y velocity value in an integer
      */
    public int getyVel() {
        return yVel;
    }
    /**
       * setter changes the y velocity
       * @param yVel accepts an integer value
       */
    public void setyVel(int yVel) {
        this.yVel = yVel;
    }
    /**
     * This method allows objects such as ships alien ships to move 
     */
    public void move(){
          this.xPos += xVel;
        this.yPos += yVel;
    }
    /**
     * To string method sumerizes everything 
     * @return give information about the class 
     */
    public String toString(){
        return "X Velocity "+xVel+"y Velocity "+yVel;
    }
    
}
