package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.view.resources.ButtonPresentationUI;

public class InitialPresentation extends JPanel {

    private JLabel title;
    private JButton emplButton, adminButton;

    public InitialPresentation(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        this.add(new JLabel(), gbc);

        title = new JLabel("Por favor, seleccione su rol");
        title.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 20, 0, 20);
        this.add(title, gbc);

        emplButton = new JButton("Soy empleado");
        emplButton.addActionListener(listener);
        emplButton.setActionCommand("EmployeeLogin");
        emplButton.setUI(new ButtonPresentationUI());

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(emplButton, gbc);

        adminButton = new JButton("Soy administrador");
        adminButton.addActionListener(listener);
        adminButton.setActionCommand("AdminLogin");
        adminButton.setUI(new ButtonPresentationUI());
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(adminButton, gbc);

    }
}
