package com.frc5203.stats;

import javax.swing.*;
import java.awt.*;


class StatsPanel extends JFrame{

    private JPanel sliderPanel;
    private JButton submitButton;

    static JTextField teamNumber;
    static JTextArea autoInput;
    static JTextArea comments;
    static JSlider shootingSlider;
    static JSlider movementSlider;
    static JSlider gearSlider;
    static JSlider humanSpeed;
    static JSlider humanBalls;
    static JSlider pilotGears;
    static JSlider climbing;
    static JSlider win;
    static JSlider overallSlider;

    StatsPanel(int width, int height){
        setTitle("5203 Stats Application");
        setSize(width, height);

        sliderPanel = new JPanel();
        sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        teamNumber = new JTextField();
        teamNumber.setColumns(10);
        addTextFields(teamNumber);

        autoInput = new JTextArea();
        autoInput.setColumns(20);
        autoInput.setRows(1);
        autoInput.setLineWrap(true);
        autoInput.setBackground(Color.LIGHT_GRAY);
        addTextAreas(autoInput, "Autonomous Description: ");
        
        shootingSlider = new JSlider(0, 10);
        shootingSlider.setPaintTicks(true);
        shootingSlider.setPaintLabels(true);
        shootingSlider.setMajorTickSpacing(2);
        shootingSlider.setMinorTickSpacing(1);
        addSlider("Shooting Score:                    ", shootingSlider);

        movementSlider = new JSlider(0, 10);
        movementSlider.setPaintTicks(true);
        movementSlider.setPaintLabels(true);
        movementSlider.setMajorTickSpacing(2);
        movementSlider.setMinorTickSpacing(1);
        addSlider("Maneuverability Score:       ", movementSlider);

        gearSlider = new JSlider(0, 13);
        gearSlider.setPaintTicks(true);
        gearSlider.setPaintLabels(true);
        gearSlider.setMajorTickSpacing(2);
        gearSlider.setMinorTickSpacing(1);
        addSlider("Gear Score:                            ", gearSlider);

        humanSpeed = new JSlider(0, 10);
        humanSpeed.setPaintTicks(true);
        humanSpeed.setPaintLabels(true);
        humanSpeed.setMajorTickSpacing(2);
        humanSpeed.setMinorTickSpacing(1);
        addSlider("Human Speed Score:          ", humanSpeed);

        humanBalls = new JSlider(0, 10);
        humanBalls.setPaintTicks(true);
        humanBalls.setPaintLabels(true);
        humanBalls.setMajorTickSpacing(2);
        humanBalls.setMinorTickSpacing(1);
        addSlider("Human Ball Efficiency:        ", humanBalls);

        pilotGears = new JSlider(0, 10);
        pilotGears.setPaintTicks(true);
        pilotGears.setPaintLabels(true);
        pilotGears.setMajorTickSpacing(2);
        pilotGears.setMinorTickSpacing(1);
        addSlider("Pilot Gear Efficiency:          ", pilotGears);

        climbing = new JSlider(0, 1);
        climbing.setPaintTicks(true);
        climbing.setPaintLabels(true);
        climbing.setMajorTickSpacing(1);
        climbing.setMinorTickSpacing(1);
        addSlider("Can they climb?:                   ", climbing);

        win = new JSlider(0, 1);
        win.setPaintTicks(true);
        win.setPaintLabels(true);
        win.setMajorTickSpacing(1);
        win.setMinorTickSpacing(1);
        addSlider("Did they win:                          ", win);

        overallSlider = new JSlider(0, 10);
        overallSlider.setPaintTicks(true);
        overallSlider.setPaintLabels(true);
        overallSlider.setMajorTickSpacing(2);
        overallSlider.setMinorTickSpacing(1);
        addSlider("Overall Score:                       ", overallSlider);

        comments = new JTextArea();
        comments.setColumns(25);
        comments.setRows(1);
        comments.setLineWrap(true);
        comments.setBackground(Color.LIGHT_GRAY);
        addTextAreas(comments, "Comments: ");

        submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.isDefaultButton();
        submitButton.addActionListener(e -> {
            DataCreation dc = new DataCreation();
            JOptionPane.showOptionDialog(null,
                    "Your data has been saved.",
                    "Save Location",
                    JOptionPane.OK_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new String[]{"Thanks"},
                    "default");
        });

        add(sliderPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void addTextFields(JTextField t){
        JPanel panel = new JPanel();
        panel.add(new JLabel("Team Number: "));
        panel.add(t);
        sliderPanel.add(panel);
    }

    private void addTextAreas(JTextArea a, String description){
        JPanel p = new JPanel();
        p.add(new JLabel(description));
        p.add(a);
        sliderPanel.add(p);
    }

    private void addSlider(String description, JSlider s)
    {
        JPanel panel = new JPanel();

        panel.add(new JLabel(description));
        panel.add(s);
        sliderPanel.add(panel);
    }
}
