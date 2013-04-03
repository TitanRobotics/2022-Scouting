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
        setPreferredSize(new Dimension(460,160));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        panel = new JPanel(new MigLayout("fill"));
        info = new JTextPane();
        info.setEditable(false);
        info.setFont(new Font(Font.SANS_SERIF, 1, 16));
        info.setText("Scouter 2013 was created by the IMSA Titans. \n \n"
                + "Authors: \n Evan Derse \n Nick Magerko \n Emma Sloane");
        
        panel.add(info, "growx, wrap");
        
        this.add(info);
        this.pack();
        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
    }

    
}
