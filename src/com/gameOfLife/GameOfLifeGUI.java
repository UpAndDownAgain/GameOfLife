package com.gameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLifeGUI extends JFrame {

    JLabel GenerationLabel;
    JLabel AliveLabel;
    JPanel statsPanel;
    JPanel buttonPanel;
    CellPanel cellPanel;
    JToggleButton pauseButton;
    JButton resetButton;

    boolean pause = false;
    boolean reset = false;

    public GameOfLifeGUI(){
        super("Game Of Life");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);

        statsPanel = new JPanel();
        statsPanel.setName("Stats panel");
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));

        buttonPanel = new JPanel();
        buttonPanel.setName("Button panel");
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        GenerationLabel = new JLabel();
        GenerationLabel.setName("GenerationLabel");
        GenerationLabel.setText("Generation #0");

        AliveLabel = new JLabel();
        AliveLabel.setName("AliveLabel");
        AliveLabel.setText("Alive: 0");

        cellPanel = new CellPanel();
        cellPanel.setName("CellPanel");

        pauseButton = new JToggleButton("pause");
        pauseButton.setName("PauseButton");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pause = pauseButton.isSelected();
            }
        });

        resetButton = new JButton("reset");
        resetButton.setName("ResetButton");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                reset = true;
            }
        });



        setLayout(new BorderLayout());

        add(buttonPanel, BorderLayout.PAGE_START);
        add(statsPanel, BorderLayout.PAGE_END);
        add(cellPanel, BorderLayout.CENTER);

        statsPanel.add(GenerationLabel);
        statsPanel.add(AliveLabel);
        buttonPanel.add(pauseButton);
        buttonPanel.add(resetButton);
    }

    public void setReset(boolean b){
        reset = b;
    }

    public void setGenerationLabel(int count){
        GenerationLabel.setText("Generation #" + count);
    }

    public void setAliveLabel(int count){
        AliveLabel.setText("Alive: " + count);
    }

    public CellPanel getCellPanel() {
        return cellPanel;
    }

    public boolean isPaused(){
        return pause;
    }

    public boolean isReset(){
        return reset;
    }
}
