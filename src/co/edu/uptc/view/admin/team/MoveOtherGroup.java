package co.edu.uptc.view.admin.team;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoveOtherGroup extends JPanel {
  private JLabel title;

  private JLabel team1;
  private JLabel team2;

  private JTextField team1Field;
  private JTextField team2Field;

  private JButton move;

  private JLabel message;

  public MoveOtherGroup(ActionListener listener) {
    initComponents(listener);
  }

  private void initComponents(ActionListener listener) {
    this.setLayout(new GridLayout(3, 2));
    title = new JLabel("Mover empleados de un equipo a otro");
    this.add(title);

    JLabel empty = new JLabel("");
    this.add(empty);

    team1 = new JLabel("Equipo 1:");
    this.add(team1);

    team1Field = new JTextField();
    this.add(team1Field);

    team2 = new JLabel("Equipo 2:");
    this.add(team2);

    team2Field = new JTextField();
    this.add(team2Field);

    move = new JButton("Mover");
    move.addActionListener(listener);
    move.setActionCommand("MoveEmployeeToOtherGroup");
    this.add(move);

    message = new JLabel("");
    this.add(message);

  }

  public ArrayList<String> getFields() {
    ArrayList<String> fields = new ArrayList<>();
    fields.add(team1Field.getText());
    fields.add(team2Field.getText());
    return fields;
  }

  public String getTeam1() {
    return team1Field.getText();
  }

  public String getTeam2() {
    return team2Field.getText();
  }

  public void setMessage(String string, boolean isCorrect) {
    if (isCorrect) {
      message.setText(string);
      message.setForeground(new java.awt.Color(0, 153, 51));
    } else {
      message.setText(string);
      message.setForeground(new java.awt.Color(255, 0, 0));
    }
  }

}
