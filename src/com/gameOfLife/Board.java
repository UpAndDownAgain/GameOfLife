package com.gameOfLife;

import java.util.Random;

public class Board {

    private static int DEFAULT_FIELD_SIZE = 10;
    final private int fieldSize;
    private boolean[][] currentGeneration;
    private int liveCellCount = -1;



    public Board(int fieldSize){
        this.fieldSize = fieldSize;
        initializeNewField();
    }

    public Board(){
        this.fieldSize = DEFAULT_FIELD_SIZE;
        initializeNewField();
    }


    public boolean[][] getCurrentGeneration(){
        return this.currentGeneration.clone();
    }

    public int getFieldSize(){
        return this.fieldSize;
    }

    public int getLiveCellCount(){

        if(liveCellCount == -1){

            liveCellCount = 0;

            for(var row : currentGeneration){
                for(var cell : row){
                    if(cell){
                        ++liveCellCount;
                    }
                }
            }
        }

        return liveCellCount;
    }

    public void generateNewGeneratio0n(){

        /*
        cell is alive and has 2 or 3 neighbours -> cell survives
        cell is alive and has <2 neighbours -> dies of boredom
        cell is alive and has >3 neighbours -> dies of overpopulation
        cell is dead and has 3 neighbours -> cell is reborn
         */

        boolean[][] newGeneration = new boolean[fieldSize][fieldSize];

        for(int i = 0; i < fieldSize; ++i){
            for(int j = 0; j < fieldSize; ++j) {
                if(currentGeneration[i][j]){
                    int neighboursCount = countLiveNeighbours(i, j);
                    newGeneration[i][j] = neighboursCount >= 2 && neighboursCount <= 3;
                }else{
                    newGeneration[i][j] = countLiveNeighbours(i, j) == 3;
                }
            }
        }
        currentGeneration = newGeneration;
    }

    public void initializeNewField(){
        Random rng = new Random();
        currentGeneration = new boolean[fieldSize][fieldSize];

        for(int i = 0; i < fieldSize; ++i){
            for(int j = 0; j < fieldSize; ++j){
                currentGeneration[i][j] = rng.nextBoolean();
            }
        }
    }

    private int countLiveNeighbours(int x, int y){
        int counter = 0;

        for(int i = -1; i < 2; ++i) {
            for(int j = -1; j < 2; ++j){
                if(i == 0 && j == 0){
                    continue;
                }
                if(currentGeneration[(fieldSize + x + i)% fieldSize][(fieldSize + y + i) % fieldSize]){
                    ++counter;
                }
            }
        }
        return counter;
    }
}
