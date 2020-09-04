package com.gameOfLife;

import java.util.Random;

public class GameOfLife {

    private static int DEFAULT_FIELD_SIZE = 10;
    final private int fieldSize;
    private boolean[][] currentGeneration;
    private int liveCellCount = -1;



    public GameOfLife(int fieldSize){
        this.fieldSize = fieldSize;
        generateField(fieldSize);
    }

    public GameOfLife(){
        this.fieldSize = DEFAULT_FIELD_SIZE;
        generateField(this.fieldSize);
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

    public void evolve(){

        /*
        cell is alive and has 2 or 3 neighbours -> cell survives
        cell is alive and has <2 neighbours -> dies of boredom
        cell is alive and has >3 neighbours -> dies of overpopulation
        cell is dead and has 3 neighbours -> cell is reborn
         */

        boolean[][] newGeneration = new boolean[fieldSize][fieldSize];

        for(int i = 0; i < fieldSize; ++i){
            for(int j = 0; j < fieldSize; ++j){

                int liveNeighbours = countLiveNeighbours(i, j);
                boolean isAlive = false;

                //cell is dead and has exactly 3 neighbours -> cell is reborn
                if( !currentGeneration[i][j] && liveNeighbours == 3 ){
                    isAlive = true;
                }

                //cell is alive and has 2 or 3 neighbours -> cell survives
                else if( currentGeneration[i][j] && (liveNeighbours == 2 || liveNeighbours == 3) ){
                    isAlive = true;
                }

                newGeneration[i][j] = isAlive;
            }
        }
        currentGeneration = newGeneration;
        liveCellCount = -1;
    }

    private void generateField(int fieldSize){
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

        for(int i = -1; i <= 1; ++i) {

            int position = validatePosition(x + i);

            if (currentGeneration[position][y]) {
                ++counter;
            }
        }

        for(int i = -1; i <= 1; ++i) {
            int position = validatePosition(y + i);

            if (currentGeneration[x][position]) {
                ++counter;
            }
        }


        return counter;
    }

    private int validatePosition(int position){

        if(position < 0){
            position = fieldSize-1;
        }
        if(position > fieldSize-1){
            position = 0;
        }

        return position;
    }




}
