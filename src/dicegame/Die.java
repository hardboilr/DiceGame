/*
 * Class responsible for rolling 2 x dies
 * 
*/
package dicegame;
import java.util.Random; 

public class Die 
{
//-----------
// Variables
//-----------
    private int faceValue;
    Random roll = new Random(); 
        
//--------------------------------------------------------------------
// the standard math functionality is not used, as the internet tells 
// us that its less efficient and more biased. Therefore we import
// the util.Random and use that instead.
//--------------------------------------------------------------------
    public void Random()
    {
        //Random value starting at 0. Add 1 to result to get rid of 0.
        faceValue = roll.nextInt(6)+1;
        
    }
    
    public int getFaceValue()
    {
    return this.faceValue;   
    }
            
    
    
    
   
   
    

}
