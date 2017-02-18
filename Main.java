package com.frc5203.stats;

import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    static OptionPanel frame;
    private static int ScrW;
    private static int ScrH;

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            frame = new OptionPanel();

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            ScrW = (int) ((screenSize.getWidth() - frame.getWidth()) / 1.85);
            ScrH = (int) ((screenSize.getHeight() - frame.getHeight()) / 1.85);
            frame.setLocation(ScrW, ScrH);

            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
