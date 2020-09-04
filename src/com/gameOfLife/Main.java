package com.gameOfLife;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scan = new Scanner(System.in);

        int fieldSize;

        System.out.print("field size: ");
        fieldSize = scan.nextInt();

        GameOfLife gameOfLife = new GameOfLife(fieldSize);

        printField(gameOfLife.getCurrentGeneration(), gameOfLife.getFieldSize());
        gameOfLife.evolve();
        System.out.println();
        printField(gameOfLife.getCurrentGeneration(), gameOfLife.getFieldSize());


    }

    public static void printField(boolean[][] field, int fieldSize){
        for(var row : field){
            for(var element : row){
                System.out.print( element ? "0" : " " );
            }
            System.out.println();
        }
    }
}
