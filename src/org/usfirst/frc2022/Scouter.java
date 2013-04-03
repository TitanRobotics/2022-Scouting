package org.usfirst.frc2022;

import au.com.bytecode.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.UnsupportedLookAndFeelException;

public class Scouter 
{
    public static AboutGUI aboutScouter;
    
    public static void save(String path, String i, String j, int pu, boolean k, int m, int aa, int a3, int a2, int a1, int ap, int ta, int t3, int t2, int t1,int p, int f, int tf, int c, String ss, String sp, String n) {

        String BlueOrRed;
        if (k){
          BlueOrRed = "Red";}
            else{
          BlueOrRed = "Blue";}
        
        String PickupType=String.valueOf(pu);
        if (PickupType.equals("1")){
            PickupType = "Feeder Pickup Only";}
        if (PickupType.equals("2")){
            PickupType = "Feeder and Floor Pickup";}
        if (PickupType.equals("3")){
            PickupType = "Floor Pickup Only";}
        
        String DefenseLevel=String.valueOf(m);
        if (DefenseLevel.equals("3")){
          DefenseLevel = "Good Defense";}
        if (DefenseLevel.equals("2")){
          DefenseLevel = "Meh Defense";}
        if (DefenseLevel.equals("1")){
          DefenseLevel = "Bad Defense";}
        if (DefenseLevel.equals("0")) { //This is weird but it doesn't work otherwise
          DefenseLevel = "No Defense";
        }
        
        int sum = 6*a3 + 4*a2 + 2*a1 + 3*t3 + 2*t2 + t1 + 5*p + 10*c - 3*f - 20*tf;

        CSVWriter writer = null;
        try {
          writer = new CSVWriter(new FileWriter(path+".csv"));
        }
        catch (IOException e) {
          e.printStackTrace();
        }

        String[] info = (i + "#" + j + "#" + BlueOrRed + "#" + sp + "#" +  ss + "#" + PickupType + "#" 
                + DefenseLevel + "#" + aa + "#" + a3 + "#" + a2 + "#" + a1 + "#" + ap + "#" + 
                ta + "#" + t3 + "#" + t2 + "#" + t1 + "#" + p + "#" + c + "#" + f + "#" + tf + "#" 
                + sum + "#" + n).split("#");

        writer.writeNext(info);
        try
        {
          writer.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException
    {
      ScoutingGUI GUI = new ScoutingGUI();
      aboutScouter = new AboutGUI();
    }
}