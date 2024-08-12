package co.edu.uptc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.view.resources.ButtonOptionsPresentationUI;

public class OptionsPanelPresentation extends JPanel {

    private JButton validate;

    public OptionsPanelPresentation(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 30;
        gbc.ipady = 30;

        validate = new JButton("Validar Datos");
        validate.addActionListener(listener);
        validate.setActionCommand("Validate");
        validate.setUI(new ButtonOptionsPresentationUI());
        this.add(validate, gbc);
    }

}
