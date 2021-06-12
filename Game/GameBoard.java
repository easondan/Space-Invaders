/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import javax.swing.JFrame;

import PlayerMovement.KeyboardControl;


public class GameBoard extends JFrame{
public static KeyboardControl controller;
  public static  GameBoard gr = new GameBoard();
  private Draw game;
    
    public GameBoard()
    {
        // Add text to title bar 
        super("Space Intruders");
        
        // Make sure the program exits when the close button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        game = new Draw();
       
        
        // Add the Breakout instance to this frame's content pane to display it
        this.getContentPane().add(game); 
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        // Start the game
        game.start();  
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //makes the gameboard be visible 
              gr.setVisible(true);
             
            }
        });
    }
    
}
