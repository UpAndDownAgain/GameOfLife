package com.gameOfLife;

import javax.swing.*;
import java.awt.*;

public class CellPanel extends JPanel {

    private Cell[][] cellArray;

    public CellPanel(){
        super();
    }

    public void initialize(int size){
        this.setLayout(new GridLayout(size, size, 1, 1));
        this.cellArray = new Cell[size][size];

        for(var row : cellArray){
            for(var cell : row){
                cell = new Cell();
                this.add(cell);
            }
        }
    }

    public void update(boolean[][] newGen){
        if(cellArray != null){
            for(int i = 0; i < newGen.length; ++i){
                for(int j = 0; j < newGen.length; ++j){
                    if(cellArray[i][j].isAlive() != newGen[i][j]){
                        cellArray[i][j].setAlive(newGen[i][j]);
                    }
                }
            }
            repaint();
        }else {
            initialize(newGen.length);
            update(newGen);
        }
    }

}
