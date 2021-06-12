/*Eason,Gordon,Brycen
   June 10 2020
   This method will be used to set up to draw and run animations for the user can play
 */
package Game;

import PlayerMovement.KeyboardControl;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Draw extends JPanel {

    //Variables cruical for the game to run
    private final int WIDTH = 1000;
    private final int HEIGHT = 800;
    private final int FPS = 5000;
    public static int scoreCount;
    public static ActionListener e;
    private int level6 = 0;
    KeyboardControl controller = new KeyboardControl();
    Timer gameTimer;
    //sets up the game's lives and the level
    public int lives = 3;
    public static int level = 1;
    //Use random to fire random alien beams
    Random r = new Random();
    //calls the mainmenu class
    MainMenu mr = new MainMenu();
    //initiaes variables which will be used as objects
    private Ship playerShip;
    private Enemy enemy;
    private Bullet bullet;
    private AlienBullets beam;
    private Blocks blocks;
    boolean hitMarker;
    int AlienSpeed;
    int highScore;
    //Boolean to check if player/alien bullets can fire
    private boolean newBulletCanFire = true;
    private boolean newBeamCanFire = true;
    //ArrayList Objects
    private ArrayList<Enemy> enemyList = new ArrayList();
    private ArrayList<AlienBullets> beamList = new ArrayList();
    private ArrayList<Blocks> blockList = new ArrayList();
    //Used to write to the file later
    public static File file;

    //Insert the background image
    URL url = Draw.class.getResource("SpaceBackground.png");
    ImageIcon background = new ImageIcon(url);

    //Create a 2d arraylist which will be used to set up and eventually display the alien/enemy in the game
    public final void setupGame() {
        
        for (int row = 0; row < 7; row++) {
            for (int column = 0; column < 5; column++) {
                enemy = new Enemy((20 + (row * 100)), (20 + (column * 60)), level, 0, column, null, 40, 40);
                enemyList.add(enemy);
            }
        }
        //set up the playership location and movements
        playerShip = new Ship(375, 730, null, controller);
        //resets the controlller to prevent complications
        controller.resetController();
        //use a 2 for loops to create a 2d array which is used to set up and eventually display the ally sheield in the game
        for (int row = 0; row < level; row++) {
            for (int column = 0; column < 100; column++) {
                //Calls constructor for the blocks
                blocks = new Blocks(0 + (column * 50), 700 - (row * 10), 70, 10, Color.GREEN);
                //each block created into a array list
                blockList.add(blocks);
            }
        }

    }
//Using the paint compoent which will have us draw in our Jpanel

    @Override
    public void paint(Graphics g) {
        // Sets background image
        background.paintIcon(null, g, 0, -150);
        //draw the player's ship
        playerShip.draw(g);
        //draws the aliens using a for loop which will go through the array
        for (int i = 0; i < enemyList.size(); i++) {
            //draws the enemy/alien ships
            enemyList.get(i).draw(g);
        }
        //using a for loop to move through the array for blocks
        for (int index = 0; index < blockList.size(); index++) {
            //draws the blocks
            blockList.get(index).draw(g);
        }
        //When a person presses the spacebar or holds it
        if (controller.getKeyStatus(32)) {
            //If newbulletcanfire is true then
            if (newBulletCanFire) {
                //sets up the bullets for the player ship
                bullet = new Bullet(playerShip.getxPos() + 22, playerShip.getyPos() - 20, 0, Color.GREEN);
                //bullets can fire become true as there is no collusion with a ship or the bullets has not exit the screen
                newBulletCanFire = false;
            }

        }
        //if there is a bullet after the keypress
        if (bullet != null) {
            //draw the bullet
            bullet.draw(g);
        }
        // if new beam can fire is true
        if (newBeamCanFire == true) {
            //for loop for and goes through the arraylist of enemy/alien
            for (int index = 0; index < enemyList.size(); index++) {
                //makes the bullets fire at random depend on what number the randomizer lands which makes the alien fire
                if (r.nextInt(35) == index) {
                    //Set up the bullets
                    beam = new AlienBullets(enemyList.get(index).getxPos(), enemyList.get(index).getyPos(), 0, Color.YELLOW);
                    beamList.add(beam);
                }
                //once beams are constructed no new beams cannot be fired
                newBeamCanFire = false;
            }
        }
        //draw the alien/enemy beams
        for (int index = 0; index < beamList.size(); index++) {
            beamList.get(index).draw(g);
        }
        //sets up score display
        g.setColor(Color.RED);
        g.drawString("Score: " + scoreCount, 450, 20);
        // Sets the life counter display
        g.setColor(Color.RED);
        g.drawString("Lives:" + lives, 11, 20);
        // Sets level display
        g.setColor(Color.RED);
        g.drawString("Level: " + level, 900, 20);


    }

    /**
     * This method will be used to run the game
     *
     * @param Fps accepts an integer
     */
    public void updateGameState(int Fps) {
        // enables the ship to move left and right
        playerShip.move();
        if ((enemyList.get(enemyList.size() - 1).getxPos() + enemyList.get(enemyList.size() - 1).getxVel()) > 950 || (enemyList.get(0).getxPos() + enemyList.get(0).getxVel()) < 0) {
            for (int index = 0; index < enemyList.size(); index++) {
                enemyList.get(index).setxVel(enemyList.get(index).getxVel() * -1);
                enemyList.get(index).setyPos(enemyList.get(index).getyPos() + 10);
            }
        } else {
            for (int index = 0; index < enemyList.size(); index++) {
                enemyList.get(index).move();
            }
        }
        // if key is pressed and bullets and set up and drawn
        if (bullet != null) {
            //bullet will start to travel up
            bullet.setyPos(bullet.getyPos() - 15);
            //if bullet hit the top
            if (bullet.getyPos() < 0) {
                //user can fire bullet again
                newBulletCanFire = true;
            }
            //use for loop to go through and check the enemy arraylist
            for (int index = 0; index < enemyList.size(); index++) {
                //check if a bullet has hit each enemy
                if (bullet.isColliding(enemyList.get(index))) {
                    //Score increaes
                    scoreCount += 100 * (level*level6);
                    //call constructor for a new bullet
                    bullet = new Bullet(0, 0, 0, null);
                    //user can fire another bullet
                    newBulletCanFire = true;
                    //removes enemy from the list and the screen
                    enemyList.remove(index);
                }
            }

        }
        //if a beam has been fired 
        if (beam != null) {
            //use for loop to go through the beam list 
            for (int index = 0; index < beamList.size(); index++) {
                //Moves the beams down the JPanel 
                beamList.get(index).setyPos(beamList.get(index).getyPos() + (level * 3));
                //if a enemy bullet falls lower than 800
                if (beamList.get(index).getyPos() > 800) {
                    //the bullet is removed
                    beamList.remove(index);

                }
            }
        }
        //for loop which goes through the blockList
        for (int j = 0; j < blockList.size(); j++) {
            //goes through the list of alien beams 
            for (int index = 0; index < beamList.size(); index++) {
                //check if each alien beam has hit a ally shield
                if (beamList.get(index).isColliding(blockList.get(j))) {
                    //if the color of the block is green 
                    if (blockList.get(j).getColor() == Color.GREEN) {
                        //removes the block from the arraylist 
                        blockList.remove(j);
                        //removes the alien beams from the array list 
                        beamList.remove(index);
                    }
                }
            }
        }
        //use for loop to check if a alien bullet has hit the play ship
        for (int index = 0; index < beamList.size(); index++) {
            //checks if the alien bullet has hit the player
            if (beamList.get(index).isColliding(playerShip)) {
                //removes the alien bullet when colliding 
                beamList.remove(index);
                //lose a life 
                lives = lives - 1;
            }

        }
        //if there is nothing in in the array list for beams 
        if (beamList.isEmpty()) {
            //more beams can be fired 
            newBeamCanFire = true;
        }
        // use for loop to check the location of each alien 
        for (int input = 0; input < enemyList.size(); input++) {
            // if any of the aliens go below a certain point 
            if (enemyList.get(input).getyPos() > 700) {
                //resets the game and sets you back up to the same level
                enemyList.clear();
                blockList.clear();
                beamList.clear();
                //call method to set up the game 
                setupGame();

            }

        }
        //Jar file doesn't work with this 
        //if you lives hit zero 
        if (lives == 0) {
            //use try and catch for file writter 
            try {
                //get the file path 
                file = new File("src//Game//Score.txt");
                //use filewritter to find the file and allow file to append
                FileWriter fw = new FileWriter(file, true);
                //get the person name
                fw.write(JOptionPane.showInputDialog("Enter you name") + "\n");
                //use the person score 
                fw.write(Integer.toString(scoreCount) + "\n");
                //close the extension 
                fw.close();
                //if file cannot be found throws exception
            } catch (Exception E) {
                //print message 
                System.out.println("ERROR");
            }
            //Tells user game over 
            JOptionPane.showMessageDialog(null, "GAME OVER");
            //asks user if they want to play again using confirm dialog yes or no 
            int choice = JOptionPane.showConfirmDialog(null, "Would you Like to Play Again", "Reset", JOptionPane.YES_NO_OPTION);
            //If user selectes no
            if (choice == 1) {
                System.exit(0);
                //if User seleves yes 
            } else if (choice == 0) {
                //clear the arraylists
                enemyList.clear();
                beamList.clear();
                blockList.clear();
                //sets the level back to one 
                level = 1;
                //sets the lives to 3 again 
                lives = 3;
                //score count becomes zero
                scoreCount = 0;
                //bullets from both sides are allow to fire again
                newBulletCanFire = true;
                newBeamCanFire = true;
                //calls method to set up the game 
                setupGame();

            }
        }
        //if the user presses the esc key the mainmenu will show up 
        if (controller.getKeyStatus(27)) {
            mr.setVisible(true);
            this.setVisible(false);
        }
        //if the user presses e the game will exit 
        if (controller.getKeyStatus(69)) {

            JOptionPane.showMessageDialog(null, "You Will Exit The Game Now ");
            System.exit(0);
        }
        //if the play has destroyed all the ships 
        if (enemyList.isEmpty()) {
            //clears the beams and the blocks
            beamList.clear();
            blockList.clear();
            //sets the lives back up to 3 again
            lives = 3;
            //prevents the level from going to high 
            if (level != 6) {
                //increases the level 
                level += 1;
            }
            if(level==6){
                level6++;
            }
            //calls method to prepare the game and nessary things for each level 
            setupGame();
        }
    }

//Set up the JPanel which will be used as a play field 
    public Draw() {
        // Set the size of the Panel
        this.setSize(WIDTH, HEIGHT);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // Register KeyboardController as KeyListener
        controller = new KeyboardControl();
        this.addKeyListener(controller);

        // Call setupGame to initialize fields
        this.setupGame();
        this.setFocusable(true);

    }

    /**
     * Method to start the Timer that drives the animation for the game.
     */
    public void start() {
        //time use to run the game and animations 
        gameTimer = new Timer(1000 / FPS, new ActionListener() {

            // Tracks the number of frames that have been produced.
            private int frameNumber = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the game's state and repaint the screen
                updateGameState(frameNumber++);
                repaint();
            }
        });
        Timer gameTimerHitMarker = new Timer(1000, new ActionListener() {

            // Tracks the number of frames that have been produced.
            // May be useful for limiting action rates
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the game's state and repaint the screen
                hitMarker = false;
            }
        });

        gameTimer.setRepeats(true);
        gameTimer.start();
        gameTimerHitMarker.setRepeats(true);
        gameTimerHitMarker.start();
    }

}
