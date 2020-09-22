package com.gameOfLife;

import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    private boolean alive;

    public Cell(){
        super();
        setVisible(false);
        setBackground(Color.BLACK);
    }

    public Cell(boolean alive){
        super();
        setAlive(alive);
    }

    public void setAlive(boolean alive){
        this.alive = alive;
        setVisible(this.alive);
    }

    public boolean isAlive() {
        return alive;
    }
}
