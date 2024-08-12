package co.edu.uptc.view.generals;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowGeneralNotifications extends JPanel {
  private JLabel title;

  private JLabel nameEmployeelbl;
  private JTextField nameEmployeetxt;

  private JLabel dateNotificationlbl;
  private JTextField dateNotificationtxt;

  private JLabel descriptionlbl;
  private JTextArea descriptiontxt;

  private JButton nextbtn;

  private Image backgroundImage;

  private JLabel messageLbl;

  public ShowGeneralNotifications(ActionListener listener, String[] lockedListArray, String urlImage, String command) {
    ArrayList<String> lockedList = new ArrayList<String>();
    for (String locked : lockedListArray) {

      lockedList.add(locked);
    }
    this.revalidate();
    this.repaint();
    initComponents(listener, lockedList, urlImage, command);
  }

  public void initComponents(ActionListener listener, ArrayList<String> lockedList, String urlImage, String command) {
    this.setLayout(new GridBagLayout());
    backgroundImage = new ImageIcon(urlImage).getImage();
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);

    title = new JLabel("Notificaciones");
    title.setFont(new Font("Segoe UI", Font.BOLD, 35));
    title.setForeground(Color.WHITE);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 3;
    gbc.anchor = GridBagConstraints.CENTER;
    this.add(title, gbc);

    nameEmployeelbl = new JLabel("Nombre del empleado:");
    nameEmployeelbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    nameEmployeelbl.setForeground(Color.WHITE);
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.EAST;
    this.add(nameEmployeelbl, gbc);

    nameEmployeetxt = new JTextField(20);
    nameEmployeetxt.setEditable(false);
    nameEmployeetxt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    nameEmployeetxt.setForeground(Color.BLACK);
    nameEmployeetxt.setEditable(!lockedList.contains("Nombre del empleado"));
    nameEmployeetxt.setBackground(lockedList.contains("Nombre del empleado") ? Color.LIGHT_GRAY : Color.WHITE);
    gbc.gridx = 1;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.WEST;
    this.add(nameEmployeetxt, gbc);

    dateNotificationlbl = new JLabel("Fecha de notificación:");
    dateNotificationlbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    dateNotificationlbl.setForeground(Color.WHITE);
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.EAST;
    this.add(dateNotificationlbl, gbc);

    dateNotificationtxt = new JTextField(20);
    dateNotificationtxt.setEditable(false);
    dateNotificationtxt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    dateNotificationtxt.setForeground(Color.BLACK);
    dateNotificationtxt.setEditable(!lockedList.contains("Fecha de notificación"));
    dateNotificationtxt.setBackground(lockedList.contains("Fecha de notificación") ? Color.LIGHT_GRAY : Color.WHITE);
    gbc.gridx = 1;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.WEST;
    this.add(dateNotificationtxt, gbc);

    descriptionlbl = new JLabel("Descripción:");
    descriptionlbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    descriptionlbl.setForeground(Color.WHITE);
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.EAST;
    this.add(descriptionlbl, gbc);

    descriptiontxt = new JTextArea(5, 20);
    descriptiontxt.setEditable(false);
    descriptiontxt.setLineWrap(true);
    descriptiontxt.setWrapStyleWord(true);
    descriptiontxt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    descriptiontxt.setForeground(Color.BLACK);
    descriptiontxt.setEditable(!lockedList.contains("Descripción"));
    descriptiontxt.setBackground(lockedList.contains("Descripción") ? Color.LIGHT_GRAY : Color.WHITE);
    gbc.gridx = 1;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.WEST;
    this.add(descriptiontxt, gbc);

    nextbtn = new JButton("Siguiente");
    nextbtn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    nextbtn.setBackground(new Color(0, 0, 0));
    nextbtn.setForeground(Color.WHITE);
    nextbtn.addActionListener(listener);
    nextbtn.setActionCommand(command);
    gbc.gridx = 1;
    gbc.gridy++;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.CENTER;
    this.add(nextbtn, gbc);

    messageLbl = new JLabel();
    messageLbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    messageLbl.setForeground(Color.WHITE);
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 3;
    gbc.anchor = GridBagConstraints.CENTER;
    this.add(messageLbl, gbc);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
    g2d.setColor(new Color(0, 0, 0));
    g2d.fillRect(0, 0, getWidth(), getHeight());
    g2d.dispose();
  }

  public JTextField getNameEmployeetxt() {
    return nameEmployeetxt;
  }

  public void setNameEmployeetxt(JTextField nameEmployeetxt) {
    this.nameEmployeetxt = nameEmployeetxt;
  }

  public JTextField getDateNotificationtxt() {
    return dateNotificationtxt;
  }

  public void setDateNotificationtxt(JTextField dateNotificationtxt) {
    this.dateNotificationtxt = dateNotificationtxt;
  }

  public JTextArea getDescriptiontxt() {
    return descriptiontxt;
  }

  public void setDescriptiontxt(JTextArea descriptiontxt) {
    this.descriptiontxt = descriptiontxt;
  }

  public JButton getNextbtn() {
    return nextbtn;
  }

  public void setNextbtn(JButton nextbtn) {
    this.nextbtn = nextbtn;
  }

  public JLabel getMessageLbl() {
    return messageLbl;
  }

  public void setMessageLbl(String message) {
    this.messageLbl.setText(message);
    this.nextbtn.setVisible(false);
  }

  public void setFields(String[] fields) {
    this.nameEmployeetxt.setText(fields[0]);
    this.dateNotificationtxt.setText(fields[1]);
    this.descriptiontxt.setText(fields[2]);
  }

}
