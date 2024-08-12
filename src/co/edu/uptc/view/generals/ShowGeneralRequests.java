package co.edu.uptc.view.generals;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ShowGeneralRequests extends JPanel {
  private JLabel title;

  private JLabel nameEmployeelbl;
  private JTextField nameEmployeetxt;

  private JLabel idEmployeelbl;
  private JTextField idEmployeetxt;

  private JLabel dateRequestlbl;
  private JTextField dateRequesttxt;

  private JLabel typeRequestlbl;
  private JComboBox<String> typeRequestcbx;

  private JLabel descriptionlbl;
  private JTextArea descriptiontxt;

  private JLabel commentlbl;
  private JTextArea commenttxt;

  private JButton approvebtn;
  private JButton denybtn;
  private JButton sendbtn;

  private Image backgroundImage;

  private JLabel messageLbl;

  public ShowGeneralRequests(ActionListener listener, String[] lockedListArray, String urlImage,
      boolean isAdmin) {
    ArrayList<String> lockedList = new ArrayList<String>();
    for (String locked : lockedListArray) {

      lockedList.add(locked);
    }
    this.revalidate();
    this.repaint();
    initComponents(listener, lockedList, urlImage, isAdmin);
  }

  public void initComponents(ActionListener listener, ArrayList<String> lockedList, String urlImage,
      boolean isAdmin) {
    this.setLayout(new GridBagLayout());
    backgroundImage = new ImageIcon(urlImage).getImage();
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);

    title = new JLabel("Solicitudes");
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

    idEmployeelbl = new JLabel("Identificación del empleado:");
    idEmployeelbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    idEmployeelbl.setForeground(Color.WHITE);
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.EAST;
    this.add(idEmployeelbl, gbc);

    idEmployeetxt = new JTextField(20);
    idEmployeetxt.setEditable(false);
    idEmployeetxt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    idEmployeetxt.setForeground(Color.BLACK);
    idEmployeetxt.setEditable(!lockedList.contains("Identificación del empleado"));
    idEmployeetxt.setBackground(lockedList.contains("Identificación del empleado") ? Color.LIGHT_GRAY : Color.WHITE);
    gbc.gridx = 1;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.WEST;
    this.add(idEmployeetxt, gbc);

    dateRequestlbl = new JLabel("Fecha de solicitud:");
    dateRequestlbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    dateRequestlbl.setForeground(Color.WHITE);
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.EAST;
    this.add(dateRequestlbl, gbc);

    dateRequesttxt = new JTextField(20);
    dateRequesttxt.setEditable(false);
    dateRequesttxt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    dateRequesttxt.setForeground(Color.BLACK);
    dateRequesttxt.setEditable(!lockedList.contains("Fecha de solicitud"));
    dateRequesttxt.setBackground(lockedList.contains("Fecha de solicitud") ? Color.LIGHT_GRAY : Color.WHITE);
    gbc.gridx = 1;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.WEST;
    this.add(dateRequesttxt, gbc);

    typeRequestlbl = new JLabel("Tipo de solicitud:");
    typeRequestlbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    typeRequestlbl.setForeground(Color.WHITE);
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.EAST;
    this.add(typeRequestlbl, gbc);

    typeRequestcbx = new JComboBox<String>();
    typeRequestcbx.addItem("Permiso");
    typeRequestcbx.addItem("Vacaciones");
    typeRequestcbx.addItem("Incapacidad");
    typeRequestcbx.addItem("Otro");
    typeRequestcbx.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    typeRequestcbx.setForeground(Color.BLACK);
    typeRequestcbx.setEditable(!lockedList.contains("Tipo de solicitud"));
    typeRequestcbx.setBackground(lockedList.contains("Tipo de solicitud") ? Color.LIGHT_GRAY : Color.WHITE);
    typeRequestcbx.setEnabled(!lockedList.contains("Tipo de solicitud"));
    gbc.gridx = 1;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.WEST;
    this.add(typeRequestcbx, gbc);

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

    commentlbl = new JLabel("Comentario:");
    commentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    commentlbl.setForeground(Color.WHITE);
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.EAST;
    this.add(commentlbl, gbc);

    commenttxt = new JTextArea(5, 20);
    commenttxt.setLineWrap(true);
    commenttxt.setWrapStyleWord(true);
    commenttxt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    commenttxt.setForeground(Color.BLACK);
    commenttxt.setEditable(!lockedList.contains("Comentario"));
    commenttxt.setBackground(lockedList.contains("Comentario") ? Color.LIGHT_GRAY : Color.WHITE);
    gbc.gridx = 1;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.WEST;
    this.add(commenttxt, gbc);

    messageLbl = new JLabel();
    messageLbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    messageLbl.setForeground(Color.WHITE);
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 3;
    gbc.anchor = GridBagConstraints.CENTER;
    this.add(messageLbl, gbc);

    if (isAdmin) {

      approvebtn = new JButton("Aprobar");
      approvebtn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
      approvebtn.setForeground(Color.WHITE);
      approvebtn.setBackground(new Color(0, 0, 0));
      approvebtn.addActionListener(listener);
      approvebtn.setActionCommand("ApproveRequest");
      gbc.gridx = 0;
      gbc.gridy++;
      gbc.gridwidth = 1;
      gbc.anchor = GridBagConstraints.CENTER;
      this.add(approvebtn, gbc);

      denybtn = new JButton("Denegar");
      denybtn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
      denybtn.setForeground(Color.WHITE);
      denybtn.setBackground(new Color(0, 0, 0));
      denybtn.addActionListener(listener);
      denybtn.setActionCommand("DenyRequest");
      gbc.gridx = 1;
      gbc.anchor = GridBagConstraints.CENTER;
      this.add(denybtn, gbc);

    } else {
      sendbtn = new JButton("Enviar");
      sendbtn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
      sendbtn.setForeground(Color.WHITE);
      sendbtn.setBackground(new Color(0, 0, 0));
      sendbtn.addActionListener(listener);
      sendbtn.setActionCommand("SendRequest");
      gbc.gridx = 0;
      gbc.gridy++;
      gbc.gridwidth = 3;
      gbc.anchor = GridBagConstraints.CENTER;
      this.add(sendbtn, gbc);
    }

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

  public void setEmployeeName(String name) {
    nameEmployeetxt.setText(name);
  }

  public void setRequestDate(String date) {
    dateRequesttxt.setText(date);
  }

  public void setFields(String[] fields) {
    nameEmployeetxt.setText(fields[0]);
    dateRequesttxt.setText(fields[1]);
    idEmployeetxt.setText(fields[2]);
  }

  public ArrayList<String> getFields() {
    ArrayList<String> fields = new ArrayList<String>();
    fields.add(nameEmployeetxt.getText());
    fields.add(idEmployeetxt.getText());
    fields.add(dateRequesttxt.getText());
    fields.add((String) typeRequestcbx.getSelectedItem());
    fields.add(descriptiontxt.getText().equals("") ? "*" : descriptiontxt.getText());
    fields.add(commenttxt.getText().equals("") ? "*" : commenttxt.getText());
    return fields;
  }

  public void setMessageLbl(String message, boolean isCorrect, boolean isAdmin) {
    messageLbl.setText(message);
    messageLbl.setForeground(isCorrect ? Color.GREEN : Color.RED);
    if (isAdmin) {
      approvebtn.setEnabled(false);
      denybtn.setEnabled(false);
    } else {
      sendbtn.setEnabled(false);
    }

  }

  public void setFieldsToRequests(String[] fields) {
    nameEmployeetxt.setText(fields[0]);
    idEmployeetxt.setText(fields[1]);
    dateRequesttxt.setText(fields[2]);
    typeRequestcbx.setSelectedItem(fields[3]);
    descriptiontxt.setText(fields[4]);
  }

}
