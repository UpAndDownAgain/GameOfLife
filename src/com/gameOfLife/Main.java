package com.gameOfLife;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scan = new Scanner(System.in);

        int fieldSize;
        int evolutionCount;

        System.out.print("field size: ");
        fieldSize = scan.nextInt();

        System.out.print("number of evolutions: ");
        evolutionCount = scan.nextInt();

        GameOfLife gameOfLife = new GameOfLife(fieldSize);

        int i = 0;
        do{
            ++i;
            printField(gameOfLife.getCurrentGeneration(), gameOfLife.getFieldSize());
            System.out.println("Cells Alive = " + gameOfLife.getLiveCellCount());
            gameOfLife.evolve();
            System.out.println();
        }while(i < evolutionCount);

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
