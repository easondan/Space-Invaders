/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;


public class Score {
    //A score attributes has a person's name and their own score 
 String name;
    int score;
//Constructor
    public Score(){
        name = ";";
        score=  0;
        
    }
    /**
     * Constructor to set the score
     * @param name accepts a string
     * @param score  accepts a integer
     */
  public Score(String name,int score){
      this.name = name;
      this.score= score;
  }
  /**
   * getter gets the name of the user 
   * @return gives a value of the person's name
   */
    public String getName() {
        return name;
    }
    /**
     * changes the name of a user 
     * @param name accepts a string 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getter gets the person's score
     * @return a integer is returned from the method 
     */
    public int getScore() {
        return score;
    }
    /**
     * Sets the score of the user 
     * @param score accepts a integer for the score  
     */
    public void setScore(int score) {
        this.score = score;
    }
   //To String summerizes the person's score \
     @Override
    public String toString() {
        return "Name:"+name+"\tScore "+score;
    }
    
}
