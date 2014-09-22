/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;
import java.util.ArrayList;

public class GameTurn 
{
    // Arraylists
    private final ArrayList<Integer> faceValue1Hist = new ArrayList<>();
    private final ArrayList<Integer> faceValue2Hist = new ArrayList<>();
    private final ArrayList<Integer> guess1Hist = new ArrayList<>();
    private final ArrayList<Integer> guess2Hist = new ArrayList<>();
    private final ArrayList<Integer> betHist = new ArrayList<>();
    
    // Variables
    
    
   
    
    
    public void addFaceValue1History(int input)
    {
       this.faceValue1Hist.add (input);
    }
      
    public void addFaceValue2History(int input)
    {
       this.faceValue2Hist.add (input);
    } 
      
    public void addGuess1History(int input)
    {
       this.guess1Hist.add (input);
    } 
    
    public void addGuess2History(int input)
    {
       this.guess2Hist.add (input);
    } 
    
    public void addBetHistory (int input)
    {
        this.betHist.add (input);
    }
    
    public void displayHistory()
    {
        int step  = 1;
        
        for (int i = 0; i < turn; i++)
        {
            System.out.println("In turn: " + step + " you betted: " + betHist.get(i));
            System.out.println("You guessed: " + die1Hist.get(i)+" and " + die2Hist.get(i));
            System.out.println("Your reward was: " + rewardHist.get(i) +" and your penalty was: " + penaltyHist.get(i));
            System.out.println("");
            step++;
        }
    }
         
}
