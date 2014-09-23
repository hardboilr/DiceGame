/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dicegame;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class GameEngine 
{
    //public int faceValue1;
    
    private Die die1 = new Die();
    private Die die2 = new Die();
    private int faceValue1;
    private int faceValue2;
    private int faceValueSum = faceValue1+faceValue2;
    private int guess1;
    private int guess2;
    private int guessSum = guess1+guess2;
    private int bet;
    private int round;
    private Player player = new Player();
    private String player1;
    private int i;
    GameTurn Turn = new GameTurn();
    
    
    public GameEngine() 
    {
        
        //Welcome screen
        System.out.println(" _____________________________________");
        System.out.println("|                                     |");
        System.out.println("| Welcome to the Dice Betting Game!   |");
        System.out.println("|_____________________________________|");
        
        

        // Input player name
        Scanner input = new Scanner(System.in);
        Player player1 = new Player();
        
        System.out.println("Please enter your name: ");
        String inputName = input.nextLine();
        player1.setName(inputName);
        player1.initializeName();
        lineJump();
        rollDie();
        Bet();
        Guess();
//        Turn.addTurnHistory(5);
//        Turn.addTurnHistory(10);
//        System.out.println(Turn.getTurnHistory(0));
//        System.out.println(Turn.getTurnHistory(1));
//        System.out.println(Turn.getTurnHistoryLength());
        displayHistory();
//        System.out.println(Turn.turnHistSize);
        
//        int k = 0;
//        
//        Turn.getBetHistory(k);
//        System.out.println(Turn.getBetHistory(k));

        // Adding entries into Game History
        Turn.addFaceValue1History(faceValue1);
        Turn.addFaceValue2History(faceValue2);
        Turn.addGuess1History(guess1);
        Turn.addGuess2History(guess2);
      
        
    }
    
   
    public void displayHistory()
    {
        
        for (int i = 0; i < Turn.getTurnHistoryLength() ; i++) 
        {
            System.out.println("------------------------------------------------");
            System.out.println("In round " + Turn.getTurnHistory(i) + " you betted " + Turn.getBetHistory(i) +" credits.");
            System.out.println("The dies rolled were " + Turn.getFaceValue1History(i) + " & " + Turn.getFaceValue2History(i) +
                                " and you guessed " + Turn.getGuess1History(i) + " & " + Turn.getGuess2History(i) +"." );
            System.out.println("Your reward was NEED TO CODE THIS");
            System.out.println("------------------------------------------------");
        }
                
        
    }
    
    public void rollDie()
    {
        die1.Random();
        die2.Random();
        this.faceValue1 = die1.getFaceValue();
        this.faceValue2 = die2.getFaceValue();
        faceValueSum = faceValue1+faceValue2;
        System.out.println("The sum of the dies is: " + faceValueSum);
        round++;
        Turn.addTurnHistory(round);     
        Turn.addFaceValue1History(faceValue1);
        Turn.addFaceValue2History(faceValue2);
        // display faceValue1+2 for testing purposes
        System.out.println("Die 1 is: " + faceValue1);
        System.out.println("Die 2 is: " + faceValue2);
        
    }
    
    public void Guess()
    {
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
//        guess1 = 0; // 'reset' guess1
//        guess2 = 0; // 'reset' guess2
        
        // DELETE - testing purposes only
        System.out.println("guess 2: " + guess1 + " was stored");
        System.out.println("guess 2: " + guess2 + " was stored");
        
    }
    
    public void Bet()
    {
        //------------------------------------------------------------
        // Creates and object of the Scanner class.
        // Asks user to input bet. Bet is default 0;  
        // Then do: Ask for input. If not integer, try again
        // If negative integer do again. 
        // When positive integer inputted, do loop breaks.
        // Thanks message and bet is added to history. 
        // bet is set back to 0;, so we can start over in next turn.
        //------------------------------------------------------------
        Scanner scan = new Scanner(System.in);
        do 
        {
            System.out.println("Please make a positive bet: ");
            while (!scan.hasNextInt())
            {
                System.out.println("Invalid input. Has to be a number");
                scan.next(); // this is important!
            }
            bet = scan.nextInt();
        } while (bet <= 0);
        
        System.out.println("Thank you! You betted: " + bet);
        System.out.println("");
        Turn.addBetHistory(bet);
    }
    
    public void lineJump()
    {
        char c = '\n';
        int length = 1;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        System.out.print(String.valueOf(chars));
    }
  
    /*
    public void delay()
    {
        try
        {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {}
    }
    */
}


    
  
    
   
    
   
    
  

    
 
    
    /*
    // Variables
    public int guess1, guess2;
    public int guessSum = guess1+guess2;
    public double bet = 0;
    public int die1;
    public int die2;
    private static int faceValue1;
    private static int faceValue2;

//public char exit = 'e'; //if bet 0, stop game and show history + game statistics
    public double score;
    public double reward;
    public double penalty;
    public int turn;
    
//-Array lists-//
    ArrayList<Integer> die1Hist = new ArrayList<Integer>();
    ArrayList<Integer> die2Hist = new ArrayList<Integer>();
    ArrayList<Integer> guess1Hist = new ArrayList<Integer>();
    ArrayList<Integer> guess2Hist = new ArrayList<Integer>();
    ArrayList<Double> betHist = new ArrayList<Double>();
    ArrayList<Double> rewardHist = new ArrayList<Double>();
    ArrayList<Double> penaltyHist = new ArrayList<Double>();
    ArrayList<Integer> turnsHist = new ArrayList<Integer>();
    
    public void intializeDies()
    {
        Die die1 = new Die();
        Die die2 = new Die();
        faceValue1 = die1.rollDie();
        faceValue2 = die2.rollDie();
        System.out.println(faceValue1);
        System.out.println(faceValue2);
    }
    
    
    
    public GameEngine()
    {
        intializeDies();
        /*
        //int guess1, guess2;
        System.out.println("Welcome to the dice betting game!");
        //int guess1;
        Scanner scan = new Scanner(System.in); // Initialize the scanner so we can use keyboard-input
                
        while (Player.credits > 0)
        {
            Die start = new Die(); //Initiate the die construct
            System.out.println("Please place a bet: ");
            bet = scan.nextInt();
            
            // ------------------------------------------------------
            // Logic for testing if bet is above credit amount

            while (bet > Player.credits)
            {
                System.out.println("Your bet exceeded your balance");
                System.out.println("Please place a new bet: ");
                bet = scan.nextInt();   
            }
            
            if (bet == 0)
            {
                //Stop the game and show statistics + history
                break;
            }

            System.out.println("Bet accepted");                
            //--------------------------------------------------------

            do 
            {
                System.out.println("Please input guess 1: ");
                guess1 = scan.nextInt(); // stores input1 to var guess1
                guessSum = guess1;
                System.out.println("GuessSum is " + guessSum);

                while (guess1 > 6 || guess1 < 1 || guess1 > Die.dieSum)
                {
                    if (guess1 > Die.dieSum)
                    {
                        guess1 = 0;
                        System.out.println("Your sum of guess 1 exceeded the sum of dies. Please try again");
                        System.out.println("Please input guess 1: ");
                        guess1 = scan.nextInt();
                        guessSum = guess1;
                    }
                    else 
                    {
                        guess1 = 0;
                        System.out.println("Invalid input. Please try again");
                        System.out.println("Please input guess 1: ");
                        guess1 = scan.nextInt();
                        guessSum = guess1;
                    }
                }

                System.out.println("Please input guess 2: ");
                guess2 = scan.nextInt(); // stores input2 to var guess2
                guessSum = guess1+guess2;

                while (guess2 > 6 || guess2 < 1 || guessSum > Die.dieSum || guessSum < Die.dieSum)
                {
                    if (guessSum > Die.dieSum)
                    {
                        guess2 = 0;
                        System.out.println("Your sum of guesses exceeded the sum of dies. Please try again");
                        System.out.println("Please input guess 2: ");
                        guess2 = scan.nextInt();
                        guessSum = guess1+guess2;
                    }
                    else if (guessSum < Die.dieSum)
                    {
                        guess2 = 0;
                        System.out.println("Your sum of guess did not meet the sume of dies. Please try again");
                        System.out.println("Please input guess 2: ");
                        guess2 = scan.nextInt();
                        guessSum = guess1+guess2;
                    }
                    else 
                    {
                        guess2 = 0;
                        System.out.println("Invalid input. Please try again");
                        System.out.println("Please input guess2: ");
                        guess2 = scan.nextInt();
                        guessSum = guess1+guess2;
                    }

                }
            }
            while (guessSum != Die.dieSum);

            // Logic for scoring
            if (Die.dieSum == 2 || Die.dieSum == 3 || Die.dieSum == 11 || Die.dieSum == 12)
            {
                score = bet * 1.5;
            }
            else if (Die.dieSum == 4 || Die.dieSum == 5 || Die.dieSum == 9 || Die.dieSum == 10)
            {
                score = bet * 2; 
            }
            else if (Die.dieSum == 6 || Die.dieSum == 7 || Die.dieSum == 8)
            {
                score = bet * 3;
            }

            //Logic for testing the guess against the roll

            if (guess1 == Die.die1 || guess2 == Die.die1)
            {
                reward = score;
                Player.credits = Player.credits + reward;
                System.out.println("You've guessed correct and scored: "+ score 
                                + " New credit balance is: " + Player.credits);
                System.out.println("Try again!");
            }
            else //(guess1 != Die.die1 || guess2 != Die.die1)
            {
                penalty = bet;
                Player.credits = Player.credits - penalty;
                System.out.println("You've guessed wrong!");
                System.out.println(bet + " has been deducted from your credits."
                                     + " New credit balance is: " + Player.credits);
                
                
                
                
            }
            
            turn++;
            die1Hist.add (Die.die1);
            die2Hist.add (Die.die2);
            guess1Hist.add (guess1);
            guess2Hist.add (guess2);
            betHist.add (bet);
            rewardHist.add (reward);
            penaltyHist.add (penalty);
            turnsHist.add (turn); 
            
            //Prints history for testing
            System.out.println(die1Hist);
            System.out.println(die2Hist);
            System.out.println(guess1Hist);
            System.out.println(guess2Hist);
            System.out.println(betHist);
            System.out.println(rewardHist);
            System.out.println(penaltyHist);
            System.out.println(turnsHist);
            
        }
        
        if (Player.credits == 0)
        {
            System.out.println("You lost");
        }
        else 
        {
            System.out.println("The game ended");    
        }
       
        //-- Code for calculating and displaying Game Statistics + Game History
        //---------------------------------------------------------------------

        // Game statistic calculations
        
        // Summing the total reward sum
        int rewardSum = 0;
        
        for (int i = 0; i < rewardHist.size(); i++) 
        {
            rewardSum += rewardHist.get(i);
        }
        
        // Summing the total penalty sum
        int penaltySum = 0;
        
        for (int i = 0; i < penaltyHist.size(); i++)
        {
            penaltySum += penaltyHist.get(i);
        }
        
        
        
        System.out.println("--Game History--"); 
// Ex. In game 1 the die values were 4 and 6. 
//You betted 40.
//You guessed 5 and 5 
//Your reward was 150
//Your penalty was 0
        
        
        int step  = 1;
        
        for (int i = 0; i < turn; i++)
        {
            System.out.println("In turn: " + step + " you betted: " + betHist.get(i));
            System.out.println("You guessed: " + die1Hist.get(i)+" and " + die2Hist.get(i));
            System.out.println("Your reward was: " + rewardHist.get(i) +" and your penalty was: " + penaltyHist.get(i));
            System.out.println("");
            step++;
        }

        System.out.println("-- Game Statistics --");
        System.out.println("The game lasted: " + turn + " turns.");
        System.out.println("You won a total of: " + rewardSum);
        System.out.println("You lost a total of: " + penaltySum);
        System.out.println("Your final account total is: " + Player.credits);
    
       
        
        
        
     
        
            
    }   
 */      

    


