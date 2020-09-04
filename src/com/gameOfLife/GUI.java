package com.gameOfLife;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    JLabel GenerationLabel;
    JLabel AliveLabel;
    JPanel panel;

    public GUI(){
        super("Game Of Life");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);

        panel = new JPanel();

        GenerationLabel = new JLabel();
        AliveLabel = new JLabel();

        GenerationLabel.setName("GenerationLabel");
        AliveLabel.setName("AliveLabel");

        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        add(GenerationLabel);
        add(AliveLabel);
    }

    public void setGenerationLabel(int count){
        GenerationLabel.setText("Generation: " + count);
    }

    public void setAliveLabel(int count){
        AliveLabel.setText("Alive: " + count);
    }
}
