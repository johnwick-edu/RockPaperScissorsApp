import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String choices[] = {"Rock","Paper","Scissors"};

        // a variable to control the game loop
        boolean playAgain = true;

        // start the game loop
        while(playAgain){

            System.out.println("Welcome to Rock, Paper, Scissors!");
            System.out.println("Please make a selection: ");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");

            // get user's choice
            System.out.println("Enter your choice (1-3): ");
            int userChoice = scanner.nextInt();


            // validate user's choice
            if(userChoice<1 || userChoice>3){
                System.out.println("Invalid choice! please enter a number between 1 and 3!");
                // restart the loop to get valid input
                continue;
            }


            // converting user's choice to index (0-2)
            // 1-1 = 0
            // 2-1 = 1
            // 3-1 = 2
            int userIndex = userChoice - 1;

            // generate computer's choice (random numeber between 0 and 2)
            int computerIndex = random.nextInt(3); // 0-2

            // display choice
            System.out.println("You chose : "+choices[userIndex]);
            System.out.println("Computer chose : "+choices[computerIndex]);

            // determine the winner
            String result = determineWinne(userIndex, computerIndex);
            System.out.println(result);

            // ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no)");
            scanner.nextLine();
            String playAgainInput = scanner.nextLine();

            if(!playAgainInput.equalsIgnoreCase("yes")){
                playAgain = false;
                System.out.println("Thank you for playing!");
            }

            System.out.println("");
        }

        scanner.close();
    }


    public static String determineWinne(int userChoice, int computerChoice){
        // game logic
        if(userChoice==computerChoice){
            return "It's a tie!";
        }

        // game rules
        /*
            Rock (0) beats Scissors(2)
            Paper(1) beats Rock(0)
            Scissors(2) beats Paper(1)
         */

        // if user selects rock
        if(userChoice==0){
            if(computerChoice==2){
                return  "You win! Rock crushes Scissors.";
            }else if(computerChoice==1){
                return "You lose! Paper covers Rock.";
            }
        }


        // if user selects paper
        if(userChoice==1){
            if(computerChoice==0){
                return "You win! Paper cover Rock.";
            }else if(computerChoice==2){
                return "You lose! Scissors cuts Paper.";
            }
        }

        // if user selects scissors
        if(userChoice==2){
            if(computerChoice==1){
                return "You win! Sissors cuts Paper.";
            }else if(computerChoice==0){
                return "You lose! Rock crushes Scissors.";
            }
        }


        // This will not execute
        return "Error determining the winner.";
    }

}
