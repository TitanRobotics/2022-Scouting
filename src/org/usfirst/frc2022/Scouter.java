package org.usfirst.frc2022;

import au.com.bytecode.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.UnsupportedLookAndFeelException;

public class Scouter 
{
    public static void save(String path, String i, String j, boolean k, int m, int aa, int a3, 
                        int a2, int a1, int ap, int ta, int t3, int t2, int t1, int c) {
        String BlueOrRed;
        if (k){
          BlueOrRed = "Red";}
            else{
          BlueOrRed = "Blue";}
        String DefenseLevel=String.valueOf(m);
        if (DefenseLevel.equals("3")){
          DefenseLevel = "Good Defense";}
        if (DefenseLevel.equals("2")){
          DefenseLevel = "Meh Defense";}
        if (DefenseLevel.equals("1")){
          DefenseLevel = "Bad Defense";}
        else {
          DefenseLevel = "No Defense";
        }

        CSVWriter writer = null;
        try {
          writer = new CSVWriter(new FileWriter(path+".csv"));
        }
        catch (IOException e) {
          e.printStackTrace();
        }

        String[] info = (i + "#" + j + "#" + BlueOrRed + "#" + DefenseLevel + "#" + aa + "#"
                + a3 + "#" + a2 + "#" + a1 + "#" + ap + "#" + ta + "#" + t3 + "#"
                + t2 + "#" + t1 + "#" + c).split("#");

        writer.writeNext(info);
        try
        {
          writer.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {
      ScoutingGUI GUI = new ScoutingGUI();
    }
}