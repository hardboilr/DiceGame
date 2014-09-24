/*
 * This is where the magic happens!
 *
 * created by Tobias Jacobsen aka hardboilr
 */

package dicegame;
import java.util.Scanner;
import java.util.Arrays;

public class GameEngine 
{
    //-----------------------------------------------
    // Create our class objects 
    //(I can make these private but not sure it makes 
    //(sense to do it in this particular project.
    //-----------------------------------------------
    Die die1 = new Die();
    Die die2 = new Die();
    GameTurn Turn = new GameTurn(); //too lazy to change Turn to turn. Sorry :-)
    Player player1 = new Player();
    
    private int faceValue1;
    private int faceValue2;
    private int faceValueSum = faceValue1+faceValue2;
    private int guess1;
    private int guess2;
    private int guessSum = guess1+guess2;
    private double bet;
    private int round;
    private double reward;
    private double penalty;
    private double rewardSum;
    private double penaltySum;
    
    public GameEngine() 
    {
        // Welcome screen
        System.out.println(" _____________________________________");
        System.out.println("|                                     |");
        System.out.println("| Welcome to the Dice Betting Game!   |");
        System.out.println("|_____________________________________|");

        // Input player name
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String inputName = input.nextLine();
        player1.setName(inputName);
        
        // Now run the logic for the game rounds
        lineJump();
        player1.initializeName();
        lineJump();
        while (player1.getAccount() > 0)
        {
            rollDie();
            Bet();
            if (bet ==0) 
            {
                // this is needed to make sure that we can display the
                // full history when history method is called
                Turn.addGuess1History(0);
                Turn.addGuess2History(0);
                Turn.addRewardHistory(0);
                Turn.addPenaltyHistory(0);
                break;  
            } 
            Guess();
            scoring();
        }
        // when account is depleted to 0 or user choose to bet 0
        // we display a service message and run the history+statistics.
        gameEnded();
        displayHistory();
        gameStatistics();
    }
    
    public void displayHistory()
    {
        //System.out.println("Current history length is: " + Turn.getTurnHistoryLength());
        while (Turn.getTurnHistoryLength() == 1)
        {
            System.out.println("No history to display");
            System.exit(0);
        }
        for (int i = 0; i < Turn.getTurnHistoryLength() ; i++) 
        {
            System.out.println("------------------------------------------------");
            System.out.println("In round " + Turn.getTurnHistory(i) + " you betted " + Turn.getBetHistory(i) +" credits.");
            System.out.println("The dies rolled were " + Turn.getFaceValue1History(i) + " & " + Turn.getFaceValue2History(i) +
                                " and you guessed " + Turn.getGuess1History(i) + " & " + Turn.getGuess2History(i) +"." );
            System.out.println("Your reward was " + Turn.getRewardHistory(i) + " and your penalty was " + Turn.getPenaltyHistory(i));
            System.out.println("------------------------------------------------");
        }
    }
        
    public void gameStatistics()
    {
//---------------------------
// Method for game statistics.
// First run a for-loop to sum rewards and penalities.
// then print out the stuff. 
//---------------------- 
        for (int i = 0; i < Turn.getTurnHistoryLength() ; i++)
        {
            rewardSum = rewardSum + Turn.getRewardHistory(i);
            penaltySum = penaltySum + Turn.getPenaltyHistory(i);
        }
        System.out.println("The game lasted for: " + Turn.getTurnHistoryLength()+ " turns.");
        System.out.println("The total reward sum was: " + rewardSum);
        System.out.println("The total penalty sum was: " + penaltySum);
        System.out.println("The final account balance was: " + player1.getAccount());
    }
    
    public void rollDie()
    {
//---------------------------------
// method for rolling the two dies 
//---------------------------------
        die1.Random();
        die2.Random();
        
        // need to get create a readout of the values created on each die
        // from the Random above, so we can calculate the sum. This is because
        // we have yet to store them in the arrayList.
        // and we are too lazy to later sum them from the arraylist. :-)  
        this.faceValue1 = die1.getFaceValue();
        this.faceValue2 = die2.getFaceValue();
        faceValueSum = faceValue1+faceValue2;
        System.out.println("The sum of the dies is: " + faceValueSum);
        
        // then we make sure to add 1 to around and add our relevant data
        // to the arrayList for later usage.
        round++;
        Turn.addTurnHistory(round);     
        Turn.addFaceValue1History(faceValue1);
        Turn.addFaceValue2History(faceValue2);
        
        // <<<TESTING>>>
        // display faceValue1+2 for testing purposes
        //System.out.println("Die 1 is: " + faceValue1);
        //System.out.println("Die 2 is: " + faceValue2);
    }
    
    public void Guess()
    {
//---------------------------------------------------------------------
// method for receiving and validating user input. 
// first run a while-loop while guessSum is not equal to faceValuesum. 
// Inside make sure that input is positive and its a number. 
// when guessSum == faceValueSum we break the loop.
// also make sure to add the guesses to the Arraylist.
//---------------------------------------------------------------------
        Scanner scan = new Scanner(System.in);
        while (guessSum != faceValueSum)
        {
            do
            {   
                System.out.println("Please input guess1: ");
                while (!scan.hasNextInt())
                {
                    System.out.println("Invalid input. Has to be a number");
                    scan.next();
                } 
                guess1 = scan.nextInt();
            } while (guess1 <= 0);

            System.out.println("Thank you! You guessed: " + guess1);
            System.out.println("");

            do
            {
                System.out.println("Please input guess2: ");
                while (!scan.hasNextInt())
                {
                    System.out.println("Invalid input. Has to be a number");
                    scan.next();
                }
                guess2 = scan.nextInt();
            } while (guess2 <=0);

            System.out.println("Thank you! You guessed: " + guess2);
            int guessSum = guess1+guess2;
            if (guessSum != faceValueSum)
            {
                System.out.println("Your sum of guesses did not match the sum of face values."
                + " Please try again.");
            }
            else if (guessSum == faceValueSum)
            {
                break;
            }
        } 
        Turn.addGuess1History(guess1);
        Turn.addGuess2History(guess2);
        
        // <<TESTING>> - testing purposes only
        //System.out.println("guess 2: " + guess1 + " was stored");
        //System.out.println("guess 2: " + guess2 + " was stored");
    }
    
    public void Bet()
    {
//---------------------------------------------
// Same validation process as guess method.
// Asks user to input bet. Bet is default 0;  
// also checks if bet exceeds account balance.
// Thanks message and bet is added to history. 
// !!! ON A DANISH KEYBOARD YOU INPUT DOUBLE LIKE 25,5 AND NOT 25.5 !!!
//---------------------------------------------
        Scanner scan = new Scanner(System.in);
        do 
        {
            System.out.println("Please make a positive bet: ");
            while (!scan.hasNextDouble())
            {
                System.out.println("Invalid input. Has to be a positive number");
                scan.next(); // this is important!
            }
            bet = scan.nextDouble();
        } while (bet < 0);
        while (bet > player1.getAccount())
        {
            System.out.println("Your bet exceeded your account balance. Please make a new bet.");
            bet = scan.nextDouble();
        }
        System.out.println("Thank you! You betted " + bet);
        System.out.println("");
        Turn.addBetHistory(bet);
    }
    
    public void scoring()
    {
//-------------------------------------------------------------------
// method responsible for calculating the correct score based on the 
// reward multiplier from the player object. Also calculate penalty.
// in all cases add entries to both Arraylists: reward and penalty, 
// to make sure that the length of the arrayLists are equal. 
// we need this for displaying the history correctly
//-------------------------------------------------------------------
        
        if (guess1 == faceValue1 || guess2 == faceValue1)
        {
            if (faceValueSum == 2 || faceValueSum == 3 || faceValueSum == 11 || faceValueSum == 12)
            {
                reward = bet * player1.getMultiplier1();
                penalty = 0;
                System.out.println("You guessed correct and won " + reward + "!");
                player1.setAccount(reward);
                System.out.println("You account is now " + player1.getAccount());
                lineJump();
                Turn.addRewardHistory(reward);
                Turn.addPenaltyHistory(penalty);
            }
            else if (faceValueSum == 4 || faceValueSum == 5 || faceValueSum == 9 || faceValueSum == 10)
            {
                reward = bet * player1.getMultiplier2();
                penalty = 0;
                System.out.println("You guessed correct and won " + reward + "!");
                player1.setAccount(reward);
                System.out.println("You account is now " + player1.getAccount());
                lineJump();
                Turn.addRewardHistory(reward);
                Turn.addPenaltyHistory(penalty);
            }
            else if (faceValueSum == 6 || faceValueSum == 7 || faceValueSum == 8)
            {
                reward = bet * player1.getMultiplier3();
                penalty = 0;
                System.out.println("You guessed correct and won " + reward + "!");
                player1.setAccount(reward);
                System.out.println("New account balance is: " + player1.getAccount());
                lineJump();
                Turn.addRewardHistory(reward);
                Turn.addPenaltyHistory(penalty);
            }
        }
        else 
        {
            reward = 0;
            penalty = bet *-1;
            System.out.println("You've guessed wrong!");
            player1.setAccount(penalty);
            System.out.println(penalty + " has been deducted from your account."
                           + " New account balance is: " + player1.getAccount());
            lineJump();
            Turn.addRewardHistory(reward);
            Turn.addPenaltyHistory(penalty);
        }
    }
    
    public void gameEnded()
    {
//---------------------------------------------------------------
// method for printing some feedback to the user when game over.
// for the fun of it, add a custom message when player ends
// the game prematurely.
//---------------------------------------------------------------
        
        if (player1.getAccount() ==0)
        {
            System.out.println("The game has now ended because your account is empty");
        }
        else if (bet == 0) 
        {
            System.out.println("The game was terminated");
        }
        else 
        {
            // Don't think this case is possible, but whatevaar!
            System.out.println("The game has ended because your account became negative");   
        }
    }
   
    public void lineJump()
    {
//---------------------------------------------
// Utility method to create some space between 
// the various methods that have print output.
//---------------------------------------------
        char c = '\n';
        int length = 1;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        System.out.print(String.valueOf(chars));
    }
}