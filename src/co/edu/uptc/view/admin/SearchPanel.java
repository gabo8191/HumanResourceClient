package co.edu.uptc.view.admin;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.view.resources.ButtonSearchUI;

public class SearchPanel extends JPanel {
    private Image backgroundImage;
    private JLabel title, id, description, name, job;
    private JTextField idField, nameField, jobField;
    private JButton validate, showEmployee;
    private JLabel message;

    public SearchPanel(ActionListener listener, String title, String description, String actionCommand1,
            String actionCommand2, String nameLbl,
            String jobLbl, String textBtn, String imageUrl) {
        initComponents(listener, title, description, actionCommand1, actionCommand2, nameLbl, jobLbl, textBtn,
                imageUrl);
    }

    public void initComponents(ActionListener listener, String titleText, String descriptionDescription,
            String actionCommand1, String actionCommand2, String nameLbl, String jobLbl, String textBtn,
            String imageUrl) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        backgroundImage = new ImageIcon(imageUrl).getImage();

        title = new JLabel(titleText);
        title.setFont(new Font("Segoe UI", Font.BOLD, 35));
        title.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(title, gbc);

        description = new JLabel(descriptionDescription);
        description.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        description.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(description, gbc);

        id = new JLabel("Identificación: ");
        id.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        id.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(id, gbc);

        idField = new JTextField(20);
        idField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        idField.setForeground(Color.BLACK);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(idField, gbc);

        validate = new JButton("Validar");
        validate.addActionListener(listener);
        validate.setActionCommand(actionCommand1);
        validate.setUI(new ButtonSearchUI());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(validate, gbc);

        name = new JLabel(nameLbl);
        name.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        name.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(name, gbc);

        nameField = new JTextField(20);
        nameField.setEditable(false);
        nameField.setBackground(Color.GRAY);
        nameField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        nameField.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(nameField, gbc);

        job = new JLabel(jobLbl);
        job.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        job.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(job, gbc);

        jobField = new JTextField(20);
        jobField.setEditable(false);
        jobField.setBackground(Color.GRAY);
        jobField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        jobField.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(jobField, gbc);

        showEmployee = new JButton(textBtn);
        showEmployee.addActionListener(listener);
        showEmployee.setActionCommand(actionCommand2);
        showEmployee.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        showEmployee.setUI(new ButtonSearchUI());
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(showEmployee, gbc);

        message = new JLabel();
        message.setFont(new Font("Segoe UI", Font.BOLD, 12));
        message.setForeground(Color.RED);
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(message, gbc);

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

    public String getIdField() {

        return idField.getText().isEmpty() ? "*" : idField.getText();
    }

    public void setTextFieldName(String name) {
        nameField.setText(name);
    }

    public void setTextFieldJob(String job) {
        jobField.setText(job);
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }

}
