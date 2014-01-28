package com.ticktactoe;

import java.util.Scanner;

/**
 * Created by aguggenberger on 1/28/14.
 */
public class Game {

    private int row, col;
    private Scanner scan = new Scanner(System.in);
    private char[][] board = new char[3][3];
    private char turn = 'X';

    public Game(){

        for (int i = 0; i < 3; i++){
            for (int j = 0; j< 3; j++){
                board[i][j] = '_';
            }
        }
    }

    public void Play() {

        boolean playing = true;
        PrintBoard();
        while (playing){
            System.out.println("Please enter a row and column:");

            row = scan.nextInt() - 1;
            col = scan.nextInt() - 1;
            board[row][col] = turn;

            if (GameOver(row, col)){
                playing = false;
                System.out.println("Game over! Player " + turn + " wins!");
            }

            PrintBoard();
            //Switch players
            if (turn == 'X')
                turn = 'O';
            else
                turn = 'X';

            if (playing)
                System.out.println("Player " + turn + " turn.");
        }
    }

    private void PrintBoard(){
        for (int i = 0; i < 3; i++){
            System.out.println();
            for (int j = 0; j < 3; j++){
                if (j == 0)
                    System.out.print("| ");
                System.out.print(board[i][j] + " | ");
            }
        }
        System.out.println();
    }

    public boolean GameOver(int rowMove, int colMove){

        boolean result;
        //check perpendicular victory
        if (board[0][colMove] == board[1][colMove] &&
                board[0][colMove] == board[2][colMove])
            result = true;
        else if (board[rowMove][0] == board[rowMove][1] &&
                board[rowMove][0] == board[rowMove][2])
            result = true;

            //check diagonal victory
        else if (board[0][0] == board[1][1] &&
                board[0][0] == board[2][2] &&
                board[1][1] != '_')
            result = true;
        else if (board[0][2] == board[1][1] &&
                board[0][2] == board[2][0] &&
                board[1][1] != '_')
            result = true;
        else
            result = false;
        return result;
    }

}
