package com.gameOfLife;

public class UpdateThread extends Thread {

    private Board board;
    private GameOfLifeGUI window;
    private int generationCounter;

    public UpdateThread(Board board, GameOfLifeGUI window, int generationCounter) {
        this.board = board;
        this.window = window;
        this.generationCounter = generationCounter;
    }

    @Override
    public void run() {
        window.setGenerationLabel(generationCounter);
        window.setAliveLabel(board.getLiveCellCount());
        window.repaint();
        window.getCellPanel().update(board.getCurrentGeneration());
    }
}
