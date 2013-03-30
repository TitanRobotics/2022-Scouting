package scouting;

import au.com.bytecode.opencsv.CSVWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Scouter extends JFrame
  implements ActionListener
{
  String team = "";
  String match = "";
  boolean BorR = false;
  boolean OorD = false;

  int auto_attempt = 0;
  int auto3 = 0;
  int auto2 = 0;
  int auto1 = 0;
  int auto_pickup = 0;

  int tele_attempt = 0;
  int tele3_made = 0;
  int tele2_made = 0;
  int tele1_made = 0;
  int climb_level = 0;

  JTextField teamNumber = new JTextField(4);
  JTextField matchNumber = new JTextField(2);
  JLabel color = new JLabel(" Color: ");
  JButton blue = new JButton("Blue");
  JButton red = new JButton("Red");

  JLabel auto = new JLabel("Autonomous");
  JLabel autoAttempt = new JLabel("Autonomous Shots Attempted");
  JButton autoAttemptDown = new JButton("-1");
  JButton autoAttemptUp = new JButton("+1");
  JLabel autoAttemptInt = new JLabel("0");

  JLabel auto6 = new JLabel(" 3(6) Pointer shots Made ");
  JButton auto6Down = new JButton("-1");
  JButton auto6Up = new JButton("+1");
  JLabel auto6Made = new JLabel("0");

  JLabel auto4 = new JLabel(" 2(4) Pointer shots Made ");
  JButton auto4Down = new JButton("-1");
  JButton auto4Up = new JButton("+1");
  JLabel auto4Made = new JLabel("0");

  JLabel auto_2 = new JLabel(" 1(2) Pointer shots Made ");
  JButton auto2Down = new JButton("-1");
  JButton auto2Up = new JButton("+1");
  JLabel auto2Made = new JLabel("0");

  JLabel autoPickup = new JLabel("Autonomous disks picked up");
  JButton autoPickupDown = new JButton("-1");
  JButton autoPickupUp = new JButton("+1");
  JLabel autoPickupMade = new JLabel("0");

  JLabel tele = new JLabel("Tele-OP");
  JLabel teleAttempt = new JLabel(" Tele-Op Shots Attempted ");
  JButton teleAttemptDown = new JButton("-1");
  JButton teleAttemptUp = new JButton("+1");
  JLabel teleAttemptInt = new JLabel("0");

  JLabel tele_3 = new JLabel("    3 Pointer shots Made    ");
  JButton tele_3Down = new JButton("-1");
  JButton tele_3Up = new JButton("+1");
  JLabel tele_3Made = new JLabel("0");

  JLabel tele_2 = new JLabel("    2 Pointer shots Made    ");
  JButton tele_2Down = new JButton("-1");
  JButton tele_2Up = new JButton("+1");
  JLabel tele_2Made = new JLabel("0");

  JLabel tele_1 = new JLabel("    1 Pointer shots Made    ");
  JButton tele_1Down = new JButton("-1");
  JButton tele_1Up = new JButton("+1");
  JLabel tele_1Made = new JLabel("0");

  JLabel climb = new JLabel("    Climb Points Gained:  ");
  JLabel climbPoints = new JLabel(this.climb_level + "    ");
  JButton climb1 = new JButton("10");
  JButton climb2 = new JButton("20");
  JButton climb3 = new JButton("30");

  JButton Offense = new JButton("Offense");
  JButton Defense = new JButton("Defense");

  JButton save = new JButton("Save Results");

  JPanel jp = new JPanel();

  public Scouter()
  {
    setTitle("Scouter 2013");
    setVisible(true);
    setSize(200, 700);
    setResizable(false);
    setDefaultCloseOperation(3);

    JLabel matchInfo = new JLabel("Match Info:");
    this.jp.add(matchInfo);

    this.jp.add(this.teamNumber);
    this.teamNumber.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String inputTeam = Scouter.this.teamNumber.getText();
        Scouter.this.team = inputTeam;
      }
    });
    this.jp.add(this.matchNumber);
    this.matchNumber.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String inputMatch = Scouter.this.matchNumber.getText();
        Scouter.this.match = inputMatch;
      }
    });
    this.jp.add(this.color);
    this.jp.add(this.blue);
    this.blue.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.BorR = false;
      }
    });
    this.jp.add(this.red);
    this.red.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.BorR = true;
      }
    });
    this.jp.add(this.autoAttempt);
    this.jp.add(this.autoAttemptDown);
    this.autoAttemptDown.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.auto_attempt -= 1;
        Scouter.this.autoAttemptInt.setText(str(Scouter.this.auto_attempt));
      }
    });
    this.jp.add(this.autoAttemptInt);
    this.jp.add(this.autoAttemptUp);
    this.autoAttemptUp.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.auto_attempt += 1;
        Scouter.this.autoAttemptInt.setText(str(Scouter.this.auto_attempt));
      }
    });
    this.jp.add(this.auto6);
    this.jp.add(this.auto6Down);
    this.auto6Down.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.auto_attempt -= 1;
        Scouter.this.autoAttemptInt.setText(str(Scouter.this.auto_attempt));
        Scouter.this.auto3 -= 1;
        Scouter.this.auto6Made.setText(str(Scouter.this.auto3));
      }
    });
    this.jp.add(this.auto6Made);
    this.jp.add(this.auto6Up);
    this.auto6Up.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.auto_attempt += 1;
        Scouter.this.autoAttemptInt.setText(str(Scouter.this.auto_attempt));
        Scouter.this.auto3 += 1;
        Scouter.this.auto6Made.setText(str(Scouter.this.auto3));
      }
    });
    this.jp.add(this.auto4);
    this.jp.add(this.auto4Down);
    this.auto4Down.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.auto_attempt -= 1;
        Scouter.this.autoAttemptInt.setText(str(Scouter.this.auto_attempt));
        Scouter.this.auto2 -= 1;
        Scouter.this.auto4Made.setText(str(Scouter.this.auto2));
      }
    });
    this.jp.add(this.auto4Made);
    this.jp.add(this.auto4Up);
    this.auto4Up.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.auto_attempt += 1;
        Scouter.this.autoAttemptInt.setText(str(Scouter.this.auto_attempt));
        Scouter.this.auto2 += 1;
        Scouter.this.auto4Made.setText(str(Scouter.this.auto2));
      }
    });
    this.jp.add(this.auto_2);
    this.jp.add(this.auto2Down);
    this.auto2Down.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.auto_attempt -= 1;
        Scouter.this.autoAttemptInt.setText(str(Scouter.this.auto_attempt));
        Scouter.this.auto1 -= 1;
        Scouter.this.auto2Made.setText(str(Scouter.this.auto1));
      }
    });
    this.jp.add(this.auto2Made);
    this.jp.add(this.auto2Up);
    this.auto2Up.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.auto_attempt += 1;
        Scouter.this.autoAttemptInt.setText(str(Scouter.this.auto_attempt));
        Scouter.this.auto1 += 1;
        Scouter.this.auto2Made.setText(str(Scouter.this.auto1));
      }
    });
    this.jp.add(this.autoPickup);
    this.jp.add(this.autoPickupDown);
    this.autoPickupDown.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.auto_pickup -= 1;
        Scouter.this.autoPickupMade.setText(str(Scouter.this.auto_pickup));
      }
    });
    this.jp.add(this.autoPickupMade);
    this.jp.add(this.autoPickupUp);
    this.autoPickupUp.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.auto_pickup += 1;
        Scouter.this.autoPickupMade.setText(str(Scouter.this.auto_pickup));
      }
    });
    this.jp.add(this.teleAttempt);
    this.jp.add(this.teleAttemptDown);
    this.teleAttemptDown.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.tele_attempt -= 1;
        Scouter.this.teleAttemptInt.setText(str(Scouter.this.tele_attempt));
      }
    });
    this.jp.add(this.teleAttemptInt);
    this.jp.add(this.teleAttemptUp);
    this.teleAttemptUp.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.tele_attempt += 1;
        Scouter.this.teleAttemptInt.setText(str(Scouter.this.tele_attempt));
      }
    });
    this.jp.add(this.tele_3);
    this.jp.add(this.tele_3Down);
    this.tele_3Down.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.tele_attempt -= 1;
        Scouter.this.teleAttemptInt.setText(str(Scouter.this.tele_attempt));
        Scouter.this.tele3_made -= 1;
        Scouter.this.tele_3Made.setText(str(Scouter.this.tele3_made));
      }
    });
    this.jp.add(this.tele_3Made);
    this.jp.add(this.tele_3Up);
    this.tele_3Up.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.tele_attempt += 1;
        Scouter.this.teleAttemptInt.setText(str(Scouter.this.tele_attempt));
        Scouter.this.tele3_made += 1;
        Scouter.this.tele_3Made.setText(str(Scouter.this.tele3_made));
      }
    });
    this.jp.add(this.tele_2);
    this.jp.add(this.tele_2Down);
    this.tele_2Down.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.tele_attempt -= 1;
        Scouter.this.teleAttemptInt.setText(str(Scouter.this.tele_attempt));
        Scouter.this.tele2_made -= 1;
        Scouter.this.tele_2Made.setText(str(Scouter.this.tele2_made));
      }
    });
    this.jp.add(this.tele_2Made);
    this.jp.add(this.tele_2Up);
    this.tele_2Up.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.tele_attempt += 1;
        Scouter.this.teleAttemptInt.setText(str(Scouter.this.tele_attempt));
        Scouter.this.tele2_made += 1;
        Scouter.this.tele_2Made.setText(str(Scouter.this.tele2_made));
      }
    });
    this.jp.add(this.tele_1);
    this.jp.add(this.tele_1Down);
    this.tele_1Down.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.tele_attempt -= 1;
        Scouter.this.teleAttemptInt.setText(str(Scouter.this.tele_attempt));
        Scouter.this.tele1_made -= 1;
        Scouter.this.tele_1Made.setText(str(Scouter.this.tele1_made));
      }
    });
    this.jp.add(this.tele_1Made);
    this.jp.add(this.tele_1Up);
    this.tele_1Up.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.tele_attempt += 1;
        Scouter.this.teleAttemptInt.setText(str(Scouter.this.tele_attempt));
        Scouter.this.tele1_made += 1;
        Scouter.this.tele_1Made.setText(str(Scouter.this.tele1_made));
      }
    });
    this.jp.add(this.climb);
    this.jp.add(this.climbPoints);
    this.jp.add(this.climb1);
    this.climb1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.climb_level = 1;
        Scouter.this.climbPoints.setText("10    ");
      }
    });
    this.jp.add(this.climb2);
    this.climb2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.climb_level = 2;
        Scouter.this.climbPoints.setText("20    ");
      }
    });
    this.jp.add(this.climb3);
    this.climb3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.climb_level = 3;
        Scouter.this.climbPoints.setText("30    ");
      }
    });
    this.jp.add(this.Offense);
    this.Offense.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.OorD = false;
      }
    });
    this.jp.add(this.Defense);
    this.Defense.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.OorD = true;
      }
    });
    this.jp.add(this.save);
    this.save.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Scouter.this.save(Scouter.this.team, Scouter.this.match, Scouter.this.BorR, Scouter.this.OorD, Scouter.this.auto_attempt, Scouter.this.auto3, Scouter.this.auto2, Scouter.this.auto1, Scouter.this.auto_pickup, Scouter.this.tele_attempt, Scouter.this.tele3_made, Scouter.this.tele2_made, Scouter.this.tele1_made, Scouter.this.climb_level);
      }
    });
    add(this.jp);
  }

  public static void main(String[] args)
  {
    Scouter t = new Scouter();
  }

  public void save(String i, String j, boolean k, boolean m, int aa, int a3, int a2, int a1, int ap, int ta, int t3, int t2, int t1, int c)
  {
    String BlueOrRed;
    if (k)
      BlueOrRed = "Red";
    else
      BlueOrRed = "Blue";
    String OfOrDe;
    if (m)
      OfOrDe = "Defense";
    else {
      OfOrDe = "Offense";
    }

    //String csv = "C:\\Users\\Public\\Scouter 2013\\CSV files\\" + i + "_" + j + ".csv";
    CSVWriter writer = null;
    try {
      writer = new CSVWriter(new FileWriter(System.getProperty("user.dir")+i+"_"+j+ ".csv"));
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    String[] info = (i + "#" + j + "#" + BlueOrRed + "#" + OfOrDe + "#" + aa + "#"
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

  public void actionPerformed(ActionEvent event)
  {
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
}