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
    private ArrayList<Integer> faceValue1Hist = new ArrayList<>();
    private ArrayList<Integer> faceValue2Hist = new ArrayList<>();
    private ArrayList<Integer> guess1Hist = new ArrayList<>();
    private ArrayList<Integer> guess2Hist = new ArrayList<>();
    private ArrayList<Integer> betHist = new ArrayList<>();
    // kinda redundant because we can derive this number
    // from one of the other lists, but convenient. :-)
    private ArrayList<Integer> turnHist = new ArrayList<>();
    
    private ArrayList<Double> rewardHist = new ArrayList<>();
    private ArrayList<Double> penaltyHist = new ArrayList<>();
    
    
    //------------------------------
    // TurnHistory accessor methods
    //------------------------------
    public void addTurnHistory (int input)
    {
        this.turnHist.add (input);
    }
    public int getTurnHistory (int input)
    {
        return turnHist.get(input);
    }
    public int getTurnHistoryLength()
    {
        return turnHist.size();
    }
    
    //-------------------------------
    // FaceValue1+2 accessor methods
    //-------------------------------
    public void addFaceValue1History(int input)
    {
       this.faceValue1Hist.add (input);
    }
     public void addFaceValue2History(int input)
    {
       this.faceValue2Hist.add (input);
    } 
    public int getFaceValue1History(int input)
    {
        return faceValue1Hist.get (input);
    }
    public int getFaceValue2History (int input)
    {
        return faceValue2Hist.get (input);
    }
    //---------------------------
    // Guess1+2 accessor methods
    //---------------------------
    public void addGuess1History(int input)
    {
       this.guess1Hist.add (input);
    } 
    public void addGuess2History(int input)
    {
       this.guess2Hist.add (input);
    } 
    public int getGuess1History(int input)
    {
        return guess1Hist.get (input);
    }
    public int getGuess2History(int input)
    {
        return guess2Hist.get (input);
    }
    //------------------------------
    // Bet history accessor methods
    //------------------------------
    public void addBetHistory (int input)
    {
        this.betHist.add (input);
    }
    public int getBetHistory (int input)
    {
        return betHist.get (input);
    }
    
    //--------------------------------
    // Score history accessor methods
    //--------------------------------
    public void addRewardHistory (double input)
    {
        this.rewardHist.add (input);
    }
    public double getRewardHistory (double input)
    {
        return rewardHist.get ((int) input);
    }
    
    public void addPenaltyHistory (double input)
    {
        this.penaltyHist.add (input);
    }
    public double getPenaltyHistory (double input)
    {
        return penaltyHist.get ((int) input);
    }
}
