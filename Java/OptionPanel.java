package com.frc5203.stats;

import javax.swing.*;
import java.awt.*;

class OptionPanel extends JFrame {

    private JPanel optionPanel;
    public JButton fat;
    public JButton slim;

    OptionPanel(){
        setTitle("FRC Team 5203");
        setSize(300, 200);

        optionPanel = new JPanel();
        optionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        fat = new JButton("Fat Layout");
        fat.setVisible(true);
        fat.addActionListener(e -> {
            StatsPanel panel = new StatsPanel(800, 475);
            panel.setVisible(true);
            setVisible(false);
        });

        slim = new JButton("Slim Layout");
        slim.setVisible(true);
        slim.addActionListener(e -> {
            StatsPanel panel = new StatsPanel(450, 725);
            panel.setVisible(true);
            setVisible(false);
        });

        optionPanel.add(fat);
        optionPanel.add(slim);

        setContentPane(optionPanel);
        pack();
        setVisible(true);
    }

}
