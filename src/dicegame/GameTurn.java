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
    // kinda redundant because we can derive this number
    // from one of the other lists, but convenient.
    private final ArrayList<Integer> turnHist = new ArrayList<>(); 
    
    // Variables
    
    public void addTurnHistory (int input)
    {
        this.turnHist.add (input);
    }
   
    public void addFaceValue1History(int input)
    {
       this.faceValue1Hist.add (input);
    }
      
    public void getFaceValue1History(int i)
    {
        this.faceValue1Hist.get (i);
        System.out.println(i);
        
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
    
    public void getBetHistory(int input)
    {
        betHist.get (input);
//        return input;
    }
}
