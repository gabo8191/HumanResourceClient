package co.edu.uptc.view;

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

public class ValidationDataPanel extends JPanel {

    private JLabel title, id, yearBirth, error;
    private JTextField idField, yearBirthField;
    private JButton validate;
    private Image backgroundImage;

    public ValidationDataPanel(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());

        backgroundImage = new ImageIcon("src/co/edu/uptc/view/assets/img/validateData.jpg").getImage();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        title = new JLabel("Validación de datos");
        title.setFont(new Font("Segoe UI", Font.BOLD, 35));
        title.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(title, gbc);

        id = new JLabel("Identificación");
        id.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        id.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(id, gbc);

        idField = new JTextField(20);
        idField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        idField.setForeground(Color.BLACK);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(idField, gbc);

        yearBirth = new JLabel("Año de nacimiento");
        yearBirth.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        yearBirth.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(yearBirth, gbc);

        yearBirthField = new JTextField(20);
        yearBirthField.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        yearBirthField.setForeground(Color.BLACK);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(yearBirthField, gbc);

        validate = new JButton("Validar");
        validate.addActionListener(listener);
        validate.setActionCommand("ValidateData");
        validate.setUI(new ButtonSearchUI());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(validate, gbc);

        error = new JLabel("");
        error.setFont(new Font("Segoe UI", Font.BOLD, 15));
        error.setForeground(Color.RED);
        error.setHorizontalAlignment(JLabel.CENTER);
        error.setVerticalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(error, gbc);

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

    public JTextField getIdField() {
        return idField;
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public JTextField getYearBirthField() {
        return yearBirthField;
    }

    public void setYearBirthField(JTextField yearBirthField) {
        this.yearBirthField = yearBirthField;
    }

    public void setError(String error) {
        this.error.setText(error);
    }

}
