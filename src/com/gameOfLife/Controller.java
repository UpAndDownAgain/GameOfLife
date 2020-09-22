package com.gameOfLife;

public class Controller extends Thread{

    private Board board;
    private GameOfLifeGUI window;

    public Controller(Board board, GameOfLifeGUI window) {
        this.board = board;
        this.window = window;
    }

    @Override
    public void run() {
        int generationCount = 0;

        while (true){
            var thread = new UpdateThread(board, window, generationCount);
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(window.isReset()){
                generationCount = 0;
                board.initializeNewField();
                window.setReset(false);
            }
            if(!window.isPaused()){
                board.generateNewGeneratio0n();
                ++generationCount;
            }
            try {
                sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
