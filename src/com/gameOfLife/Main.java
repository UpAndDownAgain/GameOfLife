package com.gameOfLife;

public class Main {

    public static void main(String[] args) {
    int size = 50;

    Board board = new Board(size);
    GameOfLifeGUI window = new GameOfLifeGUI();
    Controller controller = new Controller(board, window);

    controller.start();
    }
}
