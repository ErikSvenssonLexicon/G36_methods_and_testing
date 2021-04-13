package org.example;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!");
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
