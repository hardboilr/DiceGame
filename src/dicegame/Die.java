/*
 * Class responsible for rolling 2 x dies
 * 
 * 
 */
package dicegame;
import java.util.Random; 



public class Die 
{
    //-Variables-//
    public static int die1, die2, dieSum;
    //-----------//
    
    public Die() 
    {
    Random roll = new Random(); // constructor for random 
    die1 = roll.nextInt(6)+1; //rolls a six-faced die (0-5) and add 1 to result so (1-6)
    die2 = roll.nextInt(6)+1;
//die1 = (int)(Math.random()*6)+1;    
//die2 = (int)(Math.random()*6)+1; <-- random generator that can do without importing the util.Random. 
// not used because the internet tells us that its less efficient and more biased than util.Random. :-)
      
    dieSum = die1+die2;
    System.out.println("The sum of dies is: " + dieSum); 
    //-- help for testing purposes --------/
    System.out.println("Die 1 is: " + die1);
    System.out.println("Die 2 is: " + die2);
    //--------------------------------------
    }
}
