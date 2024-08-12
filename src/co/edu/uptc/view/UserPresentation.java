package co.edu.uptc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.view.resources.ButtonPresentationUI;

public class UserPresentation extends JPanel {

    private JButton exiButton;

    public UserPresentation(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(new JLabel(), gbc);

        exiButton = new JButton("Salir");
        exiButton.addActionListener(listener);
        exiButton.setActionCommand("Exit");
        exiButton.setUI(new ButtonPresentationUI());
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 20, 0, 20);
        this.add(exiButton, gbc);

    }
}
