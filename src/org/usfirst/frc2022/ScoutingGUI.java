package org.usfirst.frc2022;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.miginfocom.swing.MigLayout;

public class ScoutingGUI extends JFrame
  implements ActionListener{
    
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
    }
    
    /**
    * Converts the primitive int parameter into
    * a String
    * 
    * @param num
    * @return String conversion
    */
    private String str(int num){
        return new Integer(num).toString();
    }

    /**
    * Converts the String parameter into
    * a primitive int type
    * 
    * @param str
    * @return Primitive integer
    */
    private int integer(String str){
        Integer number = Integer.parseInt(str);
        return number.intValue();
    }
    
    /**
     * Displays the "About Scouter" dialog
     */
    
    //Declaration of data-holding variables
    
    boolean bOrR = false;
    int pickup = 1;
    int dLevel = 0;
    int climbLevel = 0;
    
    //Declaration of GUI elements
    
    JMenuBar menuBar = new JMenuBar();
    //JMenu file = new JMenu("File");
    //JMenuItem saveAs = new JMenuItem("Save");
    //JMenuItem exit = new JMenuItem("Exit");
    JMenu help = new JMenu("Help");
    JMenuItem about = new JMenuItem("About Scouter");
    
    JTextField teamNumber = new JTextField(4);
    JTextField matchNumber = new JTextField(2);
    JLabel matchInfo = new JLabel("Match Info:");
    JLabel color = new JLabel(" Color: ");
    ButtonGroup colorGroup = new ButtonGroup();
    JToggleButton blue = new JToggleButton("Blue");
    JToggleButton red = new JToggleButton("Red");

    JLabel startingPos = new JLabel("Starting Position:");
    JTextField sPos = new JTextField(15);   
    JLabel sweetSpot = new JLabel("Sweet Spot Location:");
    JTextField sSpot = new JTextField(15);
    JLabel notesLabel = new JLabel("Other notes:");
    JTextField notes = new JTextField(30);
    
    ButtonGroup pickupGroup = new ButtonGroup();
    JToggleButton floorPickup = new JToggleButton("Floor Pickup");
    JToggleButton feederPickup = new JToggleButton("Feeder Pickup");
    JToggleButton bothPickup = new JToggleButton("Both Pickup Types");
    
    JButton[] add = new JButton[12];
    JButton[] subtract = new JButton[12];
    JLabel[] label = new JLabel[12];
    
    //JLabel auto = new JLabel("Autonomous");
    JLabel autoAttempt = new JLabel(" Autonomous Shots Attempted");
    JLabel auto6 = new JLabel(" 3(6) Pointer shots Made ");
    JLabel auto4 = new JLabel(" 2(4) Pointer shots Made ");
    JLabel auto2 = new JLabel(" 1(2) Pointer shots Made ");
    JLabel autoPickup = new JLabel(" Autonomous disks picked up");
    //JLabel tele = new JLabel("Tele-OP");
    JLabel teleAttempt = new JLabel(" Tele-Op Shots Attempted");
    JLabel tele3 = new JLabel(" 3 Pointer shots Made");
    JLabel tele2 = new JLabel(" 2 Pointer shots Made");
    JLabel tele1 = new JLabel(" 1 Pointer shots Made");
    
    JLabel pyramid = new JLabel(" Pyramid shots Made");
    
    JLabel fouls = new JLabel(" Fouls Made");
    JLabel tFouls = new JLabel(" Technical Fouls Made");
    
    JLabel climb = new JLabel("Climb Points Gained:");
    JLabel climbPoints = new JLabel(this.climbLevel + "    ");
    ButtonGroup climbGroup = new ButtonGroup();
    JToggleButton climb0 = new JToggleButton("0");
    JToggleButton climb1 = new JToggleButton("10");
    JToggleButton climb2 = new JToggleButton("20");
    JToggleButton climb3 = new JToggleButton("30");
    
    ButtonGroup defenseGroup = new ButtonGroup();
    JToggleButton defenseGood = new JToggleButton("Good Defense");
    JToggleButton defenseFair = new JToggleButton("Fair Defense");
    JToggleButton defensePoor = new JToggleButton("Poor Defense");
    JToggleButton defenseNo = new JToggleButton("No Defense");
  
    final JFileChooser fc = new JFileChooser();
    JButton save = new JButton("Save Results");

    JPanel jp = new JPanel(new MigLayout("fill"));
    
    public ScoutingGUI()throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
            
        //Create the window
        setTitle("Scouter 2013");
        setVisible(true);
        setSize(530, 710);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Initialize uninitialized GUI elements
        for (int i = 0; i<12; i++){
            add[i] = new JButton("+1");
            subtract[i] = new JButton("-1");
            label[i] = new JLabel("0");
        }
        
        //Create menu bar
        
        menuBar.add(help);
        help.add(about);
        //menuBar.add(file);
        //file.add(saveAs);
        //file.addSeparator();
        //file.add(exit);
        
        //Add menu item action listener(s)
        
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Scouter.aboutScouter.setVisible(true);
            }
        });
        
        //Add GUI elements to JPanel
        this.setJMenuBar(menuBar);
        this.jp.add(matchInfo,"split 6");
        this.jp.add(teamNumber);
        this.jp.add(matchNumber);
        this.jp.add(color);
        this.jp.add(blue);
        this.jp.add(red, "wrap");
        colorGroup.add(blue);
        colorGroup.add(red);
        this.jp.add(startingPos,"split 2");
        this.jp.add(sPos, "wrap");  
        this.jp.add(sweetSpot,"split 2");
        this.jp.add(sSpot, "wrap");        
        this.jp.add(feederPickup,"split 3");
        this.jp.add(floorPickup);
        this.jp.add(bothPickup, "wrap");
        pickupGroup.add(feederPickup);
        pickupGroup.add(floorPickup);
        pickupGroup.add(bothPickup);
        
        
        //Add action listeners to previous GUI elements

        this.blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bOrR = false;
            }
        });
    
        this.red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bOrR = true;
            }
        });
        
        //Add identical buttons and their respective labels/action listeners
        
        for (int i = 0; i<12; i++){
            this.jp.add(this.subtract[i], "split 4");                      // -1
            this.jp.add(this.label[i]);                         // 0
            this.jp.add(this.add[i]);                           // +1
            
            if (i == 0){                    
                this.jp.add(autoAttempt, "wrap");
            }
            else if (i == 1){
                this.jp.add(auto6, "wrap");
            }
            else if (i == 2){
                this.jp.add(auto4,"wrap");
            }
            else if (i == 3){
                this.jp.add(auto2,"wrap");
            }
            else if (i == 4){
                this.jp.add(autoPickup,"wrap");
            }
            else if (i == 5){
                this.jp.add(teleAttempt,"wrap");
            }
            else if (i == 6){
                this.jp.add(tele3,"wrap");
            }
            else if (i == 7){
                this.jp.add(tele2,"wrap");
            }
            else if (i==8){
                this.jp.add(tele1,"wrap");
            }
            else if (i==9){
                this.jp.add(pyramid,"wrap");
            }
            else if (i==10){
                this.jp.add(fouls,"wrap");
            }
            else{
                this.jp.add(tFouls,"wrap");
            }

            final int j = i;                                    //appease the inner class

            subtract[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(integer(label[j].getText()) - 1 < 0){
                        java.awt.Toolkit.getDefaultToolkit().beep();
                    }
                    else{
                        label[j].setText(str(integer(label[j].getText()) - 1));
                    }
                }
            });

            add[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label[j].setText(str(integer(label[j].getText()) + 1)); //add 1
                }
            });
        }
        
        //Add final GUI elements
        
        this.jp.add(this.climb,"split 6");
        this.jp.add(this.climbPoints);
        this.jp.add(this.climb0);
        this.jp.add(this.climb1);
        this.jp.add(this.climb2);
        this.jp.add(this.climb3,"wrap");
        climbGroup.add(climb0);
        climbGroup.add(climb1);
        climbGroup.add(climb2);
        climbGroup.add(climb3);
        this.jp.add(this.defenseGood,"split 4");
        this.jp.add(this.defenseFair);
        this.jp.add(this.defensePoor);
        this.jp.add(this.defenseNo,"wrap");
        defenseGroup.add(defenseGood);
        defenseGroup.add(defenseFair);
        defenseGroup.add(defensePoor);
        defenseGroup.add(defenseNo);
        this.jp.add(notesLabel,"split 2");
        this.jp.add(notes,"wrap");
        this.jp.add(this.save);
        
        //Add action listeners to previous GUI elements
        
        this.climb0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                climbLevel = 0;
                climbPoints.setText("0    ");
            }
        });
        
        this.climb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                climbLevel = 1;
                climbPoints.setText("10    ");
            }
        });
    
        this.climb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                climbLevel = 2;
                climbPoints.setText("20    ");
            }
        });
    
        this.climb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                climbLevel = 3;
                climbPoints.setText("30    ");
            }
        });
        
       this.feederPickup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pickup = 1;
            }
        });
       this.bothPickup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               pickup = 2;
            }
        });
       this.floorPickup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               pickup = 3;
            }
        });
    
        this.defenseGood.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dLevel = 3;
            }
        });
    
        this.defenseFair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dLevel = 2;
            }
        });
        this.defensePoor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dLevel = 1;
            }
        });
              
        this.defenseNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dLevel = 0;
            }
        });
        
        this.save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                int returnVal = fc.showSaveDialog(jp);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    String path = file.getAbsolutePath();
                
                    int[] data = new int[12];
                    for (int i = 0; i<12; i++){
                        data[i] = integer(label[i].getText());
                    }

                    Scouter.save(path, teamNumber.getText(), matchNumber.getText(), pickup, bOrR,
                            dLevel, data[0], data[1], data[2], data[3], data[4], 
                            data[5], data[6], data[7], data[8], data[9], data[10], data[11], climbLevel, 
                            sSpot.getText(), sPos.getText(), notes.getText());                }
            }
        });
        
        //Add the JPanel with all of the elements to the window
        add(this.jp);
        jp.updateUI();
        //Set the look and feel of the window to the OS's look and feel
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
    }
    
}
