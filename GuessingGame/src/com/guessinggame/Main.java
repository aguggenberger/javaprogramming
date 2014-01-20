package com.guessinggame;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int guess, number, max;
    public static Scanner scanner;
    public static Random rand;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        rand = new Random();

        System.out.println("Please enter a max value to play with: ");
        max = scanner.nextInt();
        number = rand.nextInt(max);

        System.out.println("Please guess a number: ");

        while (guess != number){
            guess = scanner.nextInt();
            if (guess > number)
                System.out.println("Your guess was too high!");
            else if (guess < number)
                System.out.println("Your guess was too low!");
        }

       System.out.println("You win!");
    }
}
