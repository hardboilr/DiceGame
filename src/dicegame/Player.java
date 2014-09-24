/*
* Class containing player, account and scoring rules
*
* created by Tobias Jacobsen aka hardboilr
*/
package dicegame;
import java.util.Scanner;

public class Player 
{
    //----------------------
    // variables for player
    //----------------------
    private double account;
    private String playerName;
    
    //-----------------------
    // variables for scoring
    //-----------------------
    private final double multiplier1 = 1.5; // when faceValueSum == 2, 3, 11 or 12
    private final double multiplier2 = 2.0; // when faceValueSum == 4, 5, 9 or 10
    private final double multiplier3 = 3.0; // when faceValueSum == 6, 7 or 8 
    
    //-----------------------------
    // Multiplier accessor methods
    //-----------------------------
    public double getMultiplier1()
    {
        return multiplier1;
    }
    public double getMultiplier2()
    {
        return multiplier2;
    }
    public double getMultiplier3()
    {
        return multiplier3;
    }
    
    //---------------------------------------------------------
    // the class object will start out with 100 on the account
    //---------------------------------------------------------
    public Player()
    {
       account = 100;
    }
    
    //------------------------
    // name acccessor methods
    //------------------------
    public String getName()
    {
        return playerName;  
    }
    public String setName(String name)
    {
        playerName = name;
        return playerName;
    }
    
    //--------------------------
    // account accessor methods
    //--------------------------
    public double getAccount()
    {
        return account;
    }
    public double setAccount(double input)
    {
        account = account + input;
        return account;
    }
    
    //--------------------------------------------
    // method for printing introduction to player
    //--------------------------------------------
    public void initializeName()
    {
        System.out.println(getName() + " you start with: " + account + " credits on your account. ");
        System.out.println("Enjoy the game!"); 
    }
}