
package dicegame;

import java.util.Scanner;

public class Player 
{
    private int account;
    private String playerName;
    
    public Player()
    {
       account = 100;
    }
    
    public String getName()
    {
        return playerName;  
    }
    
    public String setName(String name)
    {
        playerName = name;
        return playerName;
    }
    
    public void writeName()
    {
        System.out.println("You start with: " + account + " credits on your account. ");
        System.out.println("Enjoy the game " + getName() + "!"); 
    }
    
   
}
