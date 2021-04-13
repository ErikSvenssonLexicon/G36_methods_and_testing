package org.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    @DisplayName("given 1 and 1 isEquals will return true")
    public void isEquals(){
        //Arrange
        int guess = 1, hidden = 1;

        //Act and Assert
        assertTrue(App.isEquals(guess, hidden));
    }

    @DisplayName("given guess and hidden isEquals will return false")
    @Test
    public void isEquals_false(){
        int guess = -6;
        int hidden = 234;

        assertFalse(App.isEquals(guess, hidden));
    }

    @Test
    @DisplayName("given guess and hidden getMessage() will return expected")
    public void getMessage_higher(){
        //Arrange
        int guess = 9, hidden = 10;
        String expected = "The secret number is higher";

        //Act
        String result = App.getMessage(guess, hidden);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("given guess and hidden getMessage() will return expected")
    public void getMessage_lower(){
        int guess = 9, hidden = 8;
        String expected = "The secret number is lower";

        String result = App.getMessage(guess,hidden);

        assertEquals(expected, result);
    }

    @DisplayName("given guess and hidden same value getMessage() return expected")
    @Test
    public void getMessage_equals(){
        int guess = 9, hidden = 9;
        String expected = "You guess the right number";

        String result = App.getMessage(guess, hidden);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("given floor = 1 and ceiling = 1 return expected result")
    public void getRandomNumber(){
        int floor = 1, ceiling = 1;
        int expected = 1;

        int result = App.getRandomNumber(floor, ceiling);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("given floor = 2 and ceiling = 1 throws IllegalArgumentException")
    public void getRandomNumber_throws_IllegalArgumentException(){
        assertThrows(
                IllegalArgumentException.class,
                () -> App.getRandomNumber(2, 1)
        );
    }




}
