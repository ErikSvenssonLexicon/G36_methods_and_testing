package org.example;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class App 
{
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main( String[] args )
    {
        //Main loop - on false terminate application
        boolean isRunning = true;

        while(isRunning){

            System.out.print("Do you want to play? (y/n) ");
            String answer = getStringInput();
            if(answer.equalsIgnoreCase("n")){
                isRunning = false;
            }else {
                boolean isWin;
                isWin = playGame();
                if(isWin){
                    System.out.println("Congratulations you won the game!");
                }else{
                    System.out.println("Better luck next time.");
                }
            }
        }
        System.out.println("Goodbye see you soon!");

    }

    public static boolean playGame() {
        int hiddenNumber = getRandomNumber(1, 100);
        int maxTries = 6;
        int guess;
        boolean isWin = false;
        for(int i = 0; i<maxTries; i++){
            System.out.println("Guess " + (i+1) + " of " + maxTries);
            System.out.print("Number is between 1 and 100, please make a guess: ");
            guess = getIntInput();
            isWin = isEquals(guess, hiddenNumber);
            System.out.println(getMessage(guess, hiddenNumber));
            if(isWin){
                break;
            }
        }
        return isWin;
    }

    private static int getIntInput() {
        boolean valid = false;
        int number = 0;
        while(!valid){
            try{
                number = Integer.parseInt(getStringInput().trim());
                valid = true;
            }catch (NumberFormatException ex){
                System.out.println("Try entering a number again");
            }
        }
        return number;
    }

    private static String getStringInput() {
        return SCANNER.nextLine();
    }

    /**
     *
     * @param guess int that is external in data
     * @param hidden int that comes from random number class
     * @return true if guess is equal to hidden
     */
    public static boolean isEquals(int guess, int hidden){
        return guess == hidden;
    }


    public static String getMessage(int guess, int hidden){
        if(guess > hidden){
            return "The secret number is lower";
        }else if(guess < hidden){
            return "The secret number is higher";
        }else {
            return "You guess the right number";
        }

    }

    public static int getRandomNumber(int floor, int ceiling) throws IllegalArgumentException{
        if(floor > ceiling){
            throw new IllegalArgumentException("Aborted operation. Cause: floor is higher than ceiling");
        }
        return ThreadLocalRandom.current().nextInt(floor, ceiling+1);
    }



}
