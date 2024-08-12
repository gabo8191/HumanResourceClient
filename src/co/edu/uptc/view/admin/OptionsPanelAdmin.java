package co.edu.uptc.view.admin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.view.resources.ButtonOptionsAdminUI;

public class OptionsPanelAdmin extends JPanel {
    private JButton showEmployee, editEmployee, addEmployee, deleteEmployee;
    private JButton showTeam, editTeam, addTeam, deleteTeam;
    private JButton viewBonifications;
    private JButton viewNotifications;
    private JButton viewRequests;

    private JButton moveOtherGrouop;

    public OptionsPanelAdmin(ActionListener listener) {
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

        showEmployee = new JButton("Mostrar empleado");
        showEmployee.addActionListener(listener);
        showEmployee.setActionCommand("ShowEmployeeValidation");
        showEmployee.setUI(new ButtonOptionsAdminUI());
        this.add(showEmployee, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridy++;

        editEmployee = new JButton("Editar empleado");
        editEmployee.addActionListener(listener);
        editEmployee.setActionCommand("EditEmployeeValidation");
        editEmployee.setUI(new ButtonOptionsAdminUI());
        this.add(editEmployee, gbc);
        gbc.gridy++;

        deleteEmployee = new JButton("Eliminar empleado");
        deleteEmployee.addActionListener(listener);
        deleteEmployee.setActionCommand("DeleteEmployeeView");
        deleteEmployee.setUI(new ButtonOptionsAdminUI());
        this.add(deleteEmployee, gbc);
        gbc.gridy++;

        addEmployee = new JButton("Agregar empleado");
        addEmployee.addActionListener(listener);
        addEmployee.setActionCommand("AddEmployeeView");
        addEmployee.setUI(new ButtonOptionsAdminUI());
        this.add(addEmployee, gbc);
        gbc.gridy++;

        showTeam = new JButton("Mostrar equipo");
        showTeam.addActionListener(listener);
        showTeam.setActionCommand("ShowTeamValidation");
        showTeam.setUI(new ButtonOptionsAdminUI());
        this.add(showTeam, gbc);
        gbc.gridy++;

        editTeam = new JButton("Editar equipo");
        editTeam.addActionListener(listener);
        editTeam.setActionCommand("EditTeamValidation");
        editTeam.setUI(new ButtonOptionsAdminUI());
        this.add(editTeam, gbc);
        gbc.gridy++;

        addTeam = new JButton("Agregar equipo");
        addTeam.addActionListener(listener);
        addTeam.setActionCommand("AddTeam");
        addTeam.setUI(new ButtonOptionsAdminUI());
        this.add(addTeam, gbc);
        gbc.gridy++;

        deleteTeam = new JButton("Eliminar equipo");
        deleteTeam.addActionListener(listener);
        deleteTeam.setActionCommand("DeleteTeamValidation");
        deleteTeam.setUI(new ButtonOptionsAdminUI());
        this.add(deleteTeam, gbc);
        gbc.gridy++;

        viewBonifications = new JButton("Ver bonificaciones");
        viewBonifications.addActionListener(listener);
        viewBonifications.setActionCommand("ViewBonificationsEmployee");
        viewBonifications.setUI(new ButtonOptionsAdminUI());
        this.add(viewBonifications, gbc);
        gbc.gridy++;

        viewNotifications = new JButton("Ver notificaciones");
        viewNotifications.addActionListener(listener);
        viewNotifications.setActionCommand("ViewNotificationsEmployee");
        viewNotifications.setUI(new ButtonOptionsAdminUI());
        this.add(viewNotifications, gbc);
        gbc.gridy++;

        viewRequests = new JButton("Ver solicitudes");
        viewRequests.addActionListener(listener);
        viewRequests.setActionCommand("ViewRequestsEmployee");
        viewRequests.setUI(new ButtonOptionsAdminUI());
        this.add(viewRequests, gbc);
        gbc.gridy++;

        moveOtherGrouop = new JButton("Mover a otro grupo");
        moveOtherGrouop.addActionListener(listener);
        moveOtherGrouop.setActionCommand("MoveEmployeeToOtherGroupView");
        moveOtherGrouop.setUI(new ButtonOptionsAdminUI());
        this.add(moveOtherGrouop, gbc);
        gbc.gridy++;

    }

}
