/*June  9 2020
   This is the Enemy Alien Class 
    
 */
package Game;
  //imports 
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.net.URL;
/**
 *
 * @author Eason
 */
//extends to parent class Game moving objects 
public class Enemy extends GameMoving {
    //attibutes for an enemy alien
     public int enemy;
     public int width;
     public int height;
     //inserts new imageicon for the alien
     URL url = Enemy.class.getResource("AlienShip.png");
     ImageIcon alien = new ImageIcon(url);
     //constructor for the enemy 
     public Enemy(int xPos, int yPos, int xVel, int yVel, int enemyType, Color color, int width, int height) {
         //calls from the parent class GameMoving 
         super(xPos, yPos, xVel, yVel, color);
         //sets the parmaters equal to the attributes 
        this.enemy = enemyType;
        this.width = width;
        this.height = height;
    }
/**
 * Draws method used to draw the alien
 * @param g accepts the object graphics which allow a place for the ship to be drawn on 
 */
public void draw(Graphics g){
    //draw the alien icon 
    alien.paintIcon(null, g, xPos, yPos);
}
  public void move() {
        xPos += xVel;
    }
/**
 * Used to get the hitBox for aliens
 * @return a rectangle object which will be later treated as a hitbox 
 */
    @Override
    public Rectangle getBounds() {
        //Object used for hitbox 
        Rectangle enemyHitBox = new Rectangle(this.getxPos(), this.getyPos(), width, height);
        return enemyHitBox;
    }
   
}
