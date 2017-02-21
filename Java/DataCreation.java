package com.frc5203.stats;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataCreation {

    public DataCreation(){
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yy[HH_mm_ss]");
        Date date = new Date();

        File statsFile = new File("stats-" + dateFormat.format(date) + ".sql");
        try{
            OutputStream out = new FileOutputStream(statsFile, false);
        }catch(IOException e){
            e.printStackTrace();
        }

        try{
            FileWriter fw = new FileWriter("stats-" + dateFormat.format(date) + ".sql", false);
            fw.write("CREATE DATABASE IF NOT EXISTS stats");
            fw.write("CREATE TABLE IF NOT EXISTS stats_keeper (teamNumber VARCHAR(10), autoInput VARCHAR(100), shooting VARCHAR(2), movement VARCHAR(2), gears VARCHAR(2), humanBalls VARCHAR(2), humanSpeed VARCHAR(2), pilotGears VARCHAR(2), climbing VARCHAR(1), win VARCHAR(1), overall VARCHAR(2), comments VARCHAR(200)); \n");
            fw.write("INSERT INTO stats_keeper (teamNumber, autoInput, shooting, movement, gears, humanBalls, humanSpeed, pilotGears, climbing, win, overall, comments) VALUES ('" + StatsPanel.teamNumber.getText() + "', '" + StatsPanel.autoInput.getText() + "', " + StatsPanel.shootingSlider.getValue() + ", " + StatsPanel.movementSlider.getValue() + ", " + StatsPanel.gearSlider.getValue() + ", " + StatsPanel.humanBalls.getValue() + ", " + StatsPanel.humanSpeed.getValue() + ", " + StatsPanel.pilotGears.getValue() + ", " + StatsPanel.climbing.getValue() + ", " + StatsPanel.win.getValue() + ", " + StatsPanel.overallSlider.getValue() + ", '" + StatsPanel.comments.getText() + "');");
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
