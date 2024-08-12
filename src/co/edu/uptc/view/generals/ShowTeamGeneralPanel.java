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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.view.resources.ButtonSearchUI;

public class ShowTeamGeneralPanel extends JPanel {

    private JLabel title, teamName, teamLeader, teamId, teamIdLeader, teamArea;
    private JLabel titleTeamInformation, titleLeaderInformation;
    private JTextField teamNameField, teamLeaderField, teamIdField, teamIdLeaderField, teamAreaField;
    private Image backgroundImage;
    private JButton buttonEdit;
    private ArrayList<String> lockedListArray;
    public JLabel messageSuccess, messageError;
    public boolean isAdd;

    public ShowTeamGeneralPanel(ActionListener listener, String[] lockedList, String urlImage, boolean isEdit,
            String textLbl, String command, boolean isAdd) {
        this.isAdd = isAdd;
        lockedListArray = new ArrayList<String>();
        addValuesToLockedList(lockedList);
        this.revalidate();
        initialize();
        this.repaint();
        firstColumn(listener, lockedListArray, urlImage, isEdit, textLbl, command, isAdd);
    }

    public void addValuesToLockedList(String[] lockedList) {
        lockedListArray = new ArrayList<String>();
        for (String string : lockedList) {
            lockedListArray.add(string);
        }
    }

    public void initialize() {
        teamNameField = new JTextField(20);
        teamLeaderField = new JTextField(20);
        teamIdField = new JTextField(20);
        teamIdLeaderField = new JTextField(20);
        teamAreaField = new JTextField(20);
    }

    private void firstColumn(ActionListener listener, ArrayList<String> lockedList, String urlImage, boolean isEdit,
            String textLbl, String command, boolean isAdd) {
        this.setLayout(new GridBagLayout());
        backgroundImage = new ImageIcon(urlImage).getImage();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        title = new JLabel("Equipo");
        title.setFont(new Font("Segoe UI", Font.BOLD, 35));
        title.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        add(title, gbc);

        titleTeamInformation = new JLabel("Información del equipo");
        titleTeamInformation.setFont(new Font("Segoe UI", Font.BOLD, 15));
        titleTeamInformation.setForeground(Color.WHITE);
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(titleTeamInformation, gbc);

        gbc.gridy = 2;
        addLabelAndTextFieldFirstColumn(teamName, teamNameField, "Nombre del equipo:", gbc, lockedList);
        gbc.gridy = 3;
        addLabelAndTextFieldFirstColumn(teamId, teamIdField, "Id del equipo:", gbc, lockedList);
        gbc.gridy = 4;
        addLabelAndTextFieldFirstColumn(teamArea, teamAreaField, "Área del equipo:", gbc, lockedList);

        secondColumn(listener, gbc, lockedList, isEdit, textLbl, command, isAdd);
    }

    private void addLabelAndTextFieldFirstColumn(JLabel label, JTextField textField, String labelText,
            GridBagConstraints gbc, ArrayList<String> lockedList) {

        label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        label.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(label, gbc);

        String fieldName = label.getText().replace(":", "").trim();
        textField.setEditable(!lockedList.contains(fieldName));

        if (lockedList.contains(fieldName)) {
            textField.setBackground(Color.LIGHT_GRAY);
        }

        textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        textField.setForeground(Color.BLACK);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(textField, gbc);
    }

    private void secondColumn(ActionListener listener, GridBagConstraints gbc, ArrayList<String> lockedList,
            boolean isEdit, String textLbl, String command, boolean isAdd) {
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        titleLeaderInformation = new JLabel("Información del líder");
        titleLeaderInformation.setFont(new Font("Segoe UI", Font.BOLD, 15));
        titleLeaderInformation.setForeground(Color.WHITE);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(titleLeaderInformation, gbc);

        if (!isAdd) {
            gbc.gridy = 2;
            addLabelAndTextFieldSecondColumn(teamLeader, teamLeaderField, "Líder del equipo:", gbc, lockedList);
        }
        gbc.gridy++;
        addLabelAndTextFieldSecondColumn(teamIdLeader, teamIdLeaderField, "Id del líder:", gbc, lockedList);

        if (isEdit) {
            buttonEdit = new JButton(textLbl);
            buttonEdit.setUI(new ButtonSearchUI());
            buttonEdit.addActionListener(listener);
            buttonEdit.setActionCommand(command);
            gbc.gridy++;
            gbc.gridx = 3;
            gbc.gridwidth = 3;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.ipady = 10;
            gbc.ipadx = 10;
            add(buttonEdit, gbc);

            messageSuccess = new JLabel("");
            messageSuccess.setFont(new Font("Segoe UI", Font.BOLD, 12));
            messageSuccess.setForeground(Color.GREEN);
            messageSuccess.setHorizontalAlignment(JLabel.CENTER);
            messageSuccess.setVerticalAlignment(JLabel.CENTER);
            gbc.gridy++;
            gbc.gridx = 3;
            gbc.gridwidth = 3;
            gbc.anchor = GridBagConstraints.WEST;
            add(messageSuccess, gbc);

            messageError = new JLabel("");
            messageError.setFont(new Font("Segoe UI", Font.BOLD, 12));
            messageError.setForeground(Color.RED);
            messageError.setHorizontalAlignment(JLabel.CENTER);
            messageError.setVerticalAlignment(JLabel.CENTER);
            gbc.gridy++;
            gbc.gridx = 3;
            gbc.gridwidth = 3;
            gbc.anchor = GridBagConstraints.WEST;
            add(messageError, gbc);

        }
    }

    private void addLabelAndTextFieldSecondColumn(JLabel label, JTextField textField, String labelText,
            GridBagConstraints gbc, ArrayList<String> lockedList) {
        label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        label.setForeground(Color.WHITE);
        String fieldName = label.getText().replace(":", "").trim();
        gbc.gridx = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(label, gbc);

        textField.setEditable(!lockedList.contains(fieldName));
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        textField.setForeground(Color.BLACK);
        if (lockedList.contains(fieldName)) {
            textField.setBackground(Color.LIGHT_GRAY);
        }
        gbc.gridx = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(textField, gbc);
    }

    public void setTitle(String title) {
        this.title.setText(title);
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

    public void setFields(String[] fields) {
        setTeamNameField(fields[0]);
        setTeamAreaField(fields[1]);
        setTeamIdField(fields[2]);
        setTeamLeaderField(fields[3]);
        setTeamIdLeaderField(fields[4]);
    }

    public void setTeamNameField(String value) {
        teamNameField.setText(value);
    }

    public void setTeamLeaderField(String value) {
        teamLeaderField.setText(value);
    }

    public void setTeamIdField(String value) {
        teamIdField.setText(value);
    }

    public void setTeamIdLeaderField(String value) {
        teamIdLeaderField.setText(value);
    }

    public void setTeamAreaField(String value) {
        teamAreaField.setText(value);
    }

    public String getTeamLeaderField() {
        return teamLeaderField.getText().isEmpty() ? "*" : teamLeaderField.getText();
    }

    public String getTeamIdField() {
        return teamIdField.getText().isEmpty() ? "*" : teamIdField.getText();
    }

    public String getTeamIdLeaderField() {
        return teamIdLeaderField.getText().isEmpty() ? "*" : teamIdLeaderField.getText();
    }

    public String getTeamNameField() {
        return teamNameField.getText().isEmpty() ? "*" : teamNameField.getText();
    }

    public String getTeamAreaField() {
        return teamAreaField.getText().isEmpty() ? "*" : teamAreaField.getText();
    }

    public ArrayList<String> getFields() {
        ArrayList<String> fields = new ArrayList<String>();
        fields.add(getTeamNameField());
        fields.add(getTeamAreaField());
        fields.add(getTeamIdField());
        fields.add(getTeamLeaderField());
        fields.add(getTeamIdLeaderField());
        return fields;
    }

    public void setMessageSuccess(String message) {
        messageSuccess.setText(message);
        messageError.setText("");
    }

    public void setMessageError(String message) {
        messageError.setText(message);
        messageSuccess.setText("");
    }

}
