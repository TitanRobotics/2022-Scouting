package org.usfirst.frc2022;

import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.miginfocom.swing.MigLayout;

public class AboutGUI extends JFrame{
    
    JPanel panel;
    JTextPane info;

    public AboutGUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException{
        setTitle("About Scouter 2013");
        setVisible(false);
        setResizable(false);
        setPreferredSize(new Dimension(430,430));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        panel = new JPanel(new MigLayout("fill"));
        info = new JTextPane();
        info.setEditable(false);
        info.setFont(new Font(Font.SANS_SERIF, 1, 16));
        info.setText("Scouter 2013 was created by the IMSA Titans. \n \n"
                + "Authors: \n Evan Derse \n Nick Magerko \n Emma Sloan \n \n"
                + "The first text box is for team number, second is for match number. \n"
                + "Pyramid shots are being calculated as shots dumped to the top of the pyramid. \n"
                + "The output will be a csv file with (in order): \n"
                + "Team number, Match number, Color, Sweet Spot, Pickup type, Defense, Auto shots attempted,"
                + "Auto 3(6) pointers, Auto 2(4) pointers, Auto 1(2) pointers, Auto disks picked up,"
                + "Teleop shots attempted, Teleop 3 pointers, Teleop 2 pointers, Teleop 1 pointers,"
                + "Pyramid shots made, Climb level, Fouls, Technical fouls, Total Score, Notes");
        
        panel.add(info, "wrap");
        
        this.add(info);
        this.pack();
        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
    }

    
}
