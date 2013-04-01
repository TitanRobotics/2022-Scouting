package org.usfirst.frc2022;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
    
    //Declaration of data-holding variables
    
    String team = "";
    String match = "";
    boolean BorR = false;
    int Dlevel = 0;
    int climb_level = 0;
    
    //Declaration of GUI elements
    
    JTextField teamNumber = new JTextField(4);
    JTextField matchNumber = new JTextField(2);
    JLabel matchInfo = new JLabel("Match Info:");
    JLabel color = new JLabel(" Color: ");
    JButton blue = new JButton("Blue");
    JButton red = new JButton("Red");

    JButton[] add = new JButton[12];
    JButton[] subtract = new JButton[12];
    JLabel[] label = new JLabel[12];
    
    //JLabel auto = new JLabel("Autonomous");
    JLabel autoAttempt = new JLabel("Autonomous Shots Attempted");
    JLabel auto6 = new JLabel(" 3(6) Pointer shots Made ");
    JLabel auto4 = new JLabel(" 2(4) Pointer shots Made ");
    JLabel auto_2 = new JLabel(" 1(2) Pointer shots Made ");
    JLabel autoPickup = new JLabel("Autonomous disks picked up");
    //JLabel tele = new JLabel("Tele-OP");
    JLabel teleAttempt = new JLabel(" Tele-Op Shots Attempted ");
    JLabel tele_3 = new JLabel("    3 Pointer shots Made    ");
    JLabel tele_2 = new JLabel("    2 Pointer shots Made    ");
    JLabel tele_1 = new JLabel("    1 Pointer shots Made    ");
    
    JLabel pyramid = new JLabel("    Pyramid shots Made    ");
    
    JLabel fouls = new JLabel("    Fouls Made    ");
    JLabel tfouls = new JLabel("    Technical Fouls Made    ");
    
    JLabel climb = new JLabel("    Climb Points Gained:  ");
    JLabel climbPoints = new JLabel(this.climb_level + "    ");
    JButton climb1 = new JButton("10");
    JButton climb2 = new JButton("20");
    JButton climb3 = new JButton("30");
    
  JButton DefenseGood = new JButton("Good Defense");
  JButton DefenseMeh = new JButton("Meh Defense");
  JButton DefenseBad = new JButton("Bad Defense");
  JButton DefenseNo = new JButton("No Defense");
  
    final JFileChooser fc = new JFileChooser();
    JButton save = new JButton("Save Results");

    JPanel jp = new JPanel();
    
    public ScoutingGUI()throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
            
        //Create the window
        setTitle("Scouter 2013");
        setVisible(true);
        setSize(400, 575);
        setResizable(true);
        setDefaultCloseOperation(3);
        
        //Initialize uninitialized GUI elements
        for (int i = 0; i<12; i++){
            add[i] = new JButton("+1");
            subtract[i] = new JButton("-1");
            label[i] = new JLabel("0");
        }
        
        //Add GUI elements to JPanel
        this.jp.add(matchInfo);
        this.jp.add(teamNumber);
        this.jp.add(matchNumber);
        this.jp.add(color);
        this.jp.add(blue);
        this.jp.add(red);
        
        //Add action listeners to previous GUI elements

    
        this.blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BorR = false;
            }
        });
    
        this.red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BorR = true;
            }
        });
        
        //Add identical buttons and their respective labels/action listeners
        
        for (int i = 0; i<12; i++){
            if (i == 0){                    
                this.jp.add(autoAttempt);
            }
            else if (i == 1){
                this.jp.add(auto6);
            }
            else if (i == 2){
                this.jp.add(auto4);
            }
            else if (i == 3){
                this.jp.add(auto_2);
            }
            else if (i == 4){
                this.jp.add(autoPickup);
            }
            else if (i == 5){
                this.jp.add(teleAttempt);
            }
            else if (i == 6){
                this.jp.add(tele_3);
            }
            else if (i == 7){
                this.jp.add(tele_2);
            }
            else if (i==8){
                this.jp.add(tele_1);
            }
            else if (i==9){
                this.jp.add(pyramid);
            }
            else if (i==10){
                this.jp.add(fouls);
            }
            else{
                this.jp.add(tfouls);
            }
            this.jp.add(this.subtract[i]);                      // -1
            this.jp.add(this.label[i]);                         // 0
            this.jp.add(this.add[i]);                           // +1

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
        
        this.jp.add(this.climb);
        this.jp.add(this.climbPoints);
        this.jp.add(this.climb1);
        this.jp.add(this.climb2);
        this.jp.add(this.climb3);
        this.jp.add(this.DefenseGood);
        this.jp.add(this.DefenseMeh);
        this.jp.add(this.DefenseBad);
        this.jp.add(this.DefenseNo);
        this.jp.add(this.save);
        
        //Add action listeners to previous GUI elements
        this.climb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                climb_level = 1;
                climbPoints.setText("10    ");
            }
        });
    
        this.climb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                climb_level = 2;
                climbPoints.setText("20    ");
            }
        });
    
        this.climb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                climb_level = 3;
                climbPoints.setText("30    ");
            }
        });
    
        this.DefenseGood.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dlevel = 3;
            }
        });
    
        this.DefenseMeh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dlevel = 2;
            }
        });
        this.DefenseBad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dlevel = 1;
            }
        });
              
        this.DefenseNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dlevel = 0;
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

                    Scouter.save(path, teamNumber.getText(), matchNumber.getText(), BorR, 
                            Dlevel, data[0], data[1], data[2], data[3], data[4], 
                            data[5], data[6], data[7], data[8], data[9], data[10], data[11], climb_level);                }
            }
        });
        
        //Add the JPanel with all of the elements to the window
        add(this.jp);
        
        //Set the look and feel of the window to the OS's look and feel
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
    }
    
}
