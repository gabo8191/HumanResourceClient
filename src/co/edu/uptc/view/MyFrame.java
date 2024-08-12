package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.uptc.view.admin.OptionsPanelAdmin;
import co.edu.uptc.view.admin.bonifications.BonificationsEmployeeAdmin;
import co.edu.uptc.view.admin.employee.AddEmployeePanel;
import co.edu.uptc.view.admin.employee.EditEmployeePanel;
import co.edu.uptc.view.admin.employee.ShowEmployee;
import co.edu.uptc.view.admin.notifications.ShowAllNotifications;
import co.edu.uptc.view.admin.requests.ShowRequestAdmin;
import co.edu.uptc.view.admin.team.AddTeamPanel;
import co.edu.uptc.view.admin.team.EditTeamPanel;
import co.edu.uptc.view.admin.team.MoveOtherGroup;
import co.edu.uptc.view.admin.team.ShowTeamPanel;
import co.edu.uptc.view.admin.validations.ValidationBonificationsEmployeePanel;
import co.edu.uptc.view.admin.validations.ValidationDeleteEmployeePanel;
import co.edu.uptc.view.admin.validations.ValidationDeleteTeamPanel;
import co.edu.uptc.view.admin.validations.ValidationEditEmployeePanel;
import co.edu.uptc.view.admin.validations.ValidationEditTeam;
import co.edu.uptc.view.admin.validations.ValidationShowEmployeePanel;
import co.edu.uptc.view.admin.validations.ValidationShowTeam;
import co.edu.uptc.view.employee.OptionsPanelEmployee;
import co.edu.uptc.view.employee.bonitification.BonificationsEmployee;
import co.edu.uptc.view.employee.notification.ShowMyNotifications;
import co.edu.uptc.view.employee.profile.EditMyProfilePanel;
import co.edu.uptc.view.employee.profile.ShowMyProfilePanel;
import co.edu.uptc.view.employee.request.ShowRequestEmployee;

public class MyFrame extends JFrame {
    private InitialPresentation presentationPanel;
    private ValidationDataPanel validationDataPanel;
    private OptionsPanelPresentation optionsPanel;

    private OptionsPanelEmployee optionsPanelEmployee;
    private ShowMyProfilePanel showMyProfilePanel;
    private EditMyProfilePanel editMyProfilePanel;
    private ShowRequestEmployee showRequestEmployeePanel;
    private ShowMyNotifications showMyNotificationsPanel;

    private OptionsPanelAdmin optionsPanelAdmin;
    private ValidationShowEmployeePanel validationShowEmployeePanel;
    private ShowEmployee showEmployeePanel;
    private ValidationEditEmployeePanel editEmployeeValidationPanel;
    private EditEmployeePanel editEmployeePanel;
    private ValidationDeleteEmployeePanel deleteEmployeeValidationPanel;
    private AddEmployeePanel addEmployeePanel;
    private ValidationShowTeam validationShowTeamPanel;
    private ShowTeamPanel showTeamPanel;
    private ValidationEditTeam validationEditTeamPanel;
    private EditTeamPanel editTeamPanel;
    private AddTeamPanel addTeamPanel;
    private ValidationDeleteTeamPanel deleteTeamPanel;
    private UserPresentation userPresentation;
    private ValidationBonificationsEmployeePanel validationPayrollEmployeePanel;
    private BonificationsEmployeeAdmin payrollEmployeePanel;
    private BonificationsEmployee showBonificationsEmployeePanel;
    private ShowRequestAdmin showRequestAdminPanel;
    private ShowAllNotifications showAllNotificationsPanel;
    private MoveOtherGroup moveOtherGroup;

    public MyFrame(ActionListener listener) {
        this.setSize(1080, 920);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("My Frame");
        this.setLayout(new BorderLayout());
        initComponents(listener);
        this.setVisible(true);
    }

    public void initComponents(ActionListener listener) {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        presentationPanel = new InitialPresentation(listener);
        presentationPanel.setSize(1080, 100);
        presentationPanel.setBackground(Color.WHITE);
        contentPane.add(presentationPanel, BorderLayout.NORTH);

        optionsPanel = new OptionsPanelPresentation(listener);
        optionsPanel.setPreferredSize(new Dimension(200, 920));
        optionsPanel.setBackground(Color.decode("#272727"));
        contentPane.add(optionsPanel, BorderLayout.WEST);

        validationDataPanel = new ValidationDataPanel(listener);
        validationDataPanel.setSize(780, 920);
        validationDataPanel.setBackground(new Color(0, 125, 125));
        contentPane.add(validationDataPanel, BorderLayout.CENTER);

        this.setContentPane(contentPane);
    }

    public void switchPresentation(boolean isUser, ActionListener listener) {
        if (isUser) {
            this.remove(presentationPanel);
        }
        userPresentation = new UserPresentation(listener);
        userPresentation.setSize(1080, 100);
        userPresentation.setBackground(Color.WHITE);
        this.add(userPresentation, BorderLayout.NORTH);
        this.revalidate();
        this.repaint();
    }

    public void switchToPanelPresentation(ActionListener listener) {
        removePanels();
        removePanel(showMyProfilePanel);
        removePanel(editMyProfilePanel);
        removePanel(optionsPanelAdmin);
        removePanel(optionsPanelEmployee);
        removePanel(userPresentation);
        removePanel(showMyNotificationsPanel);
        removePanel(showRequestEmployeePanel);
        removePanel(showBonificationsEmployeePanel);

        createAndShowPanel(validationDataPanel, listener);
        presentationPanel = new InitialPresentation(listener);
        presentationPanel.setSize(1080, 100);
        presentationPanel.setBackground(Color.WHITE);
        this.add(presentationPanel, BorderLayout.NORTH);
        this.revalidate();
        this.repaint();
        optionsPanel = new OptionsPanelPresentation(listener);
        optionsPanel.setPreferredSize(new Dimension(200, 920));
        optionsPanel.setBackground(Color.decode("#272727"));
        this.add(optionsPanel, BorderLayout.WEST);
        this.revalidate();
        this.repaint();
    }

    public void switchToPanelOptions(boolean isAdmin, boolean isEmployee, ActionListener listener) {
        if (optionsPanelEmployee != null) {
            this.remove(optionsPanelEmployee);
        }
        if (optionsPanelAdmin != null) {
            this.remove(optionsPanelAdmin);
        }

        if (optionsPanel != null) {
            this.remove(optionsPanel);
        }
        if (isEmployee && !isAdmin) {
            optionsPanelEmployee = new OptionsPanelEmployee(listener);
            optionsPanelEmployee.setPreferredSize(new Dimension(200, 920));
            optionsPanelEmployee.setBackground(Color.decode("#272727"));
            this.add(optionsPanelEmployee, BorderLayout.WEST);
        } else if (isAdmin && !isEmployee) {
            optionsPanelAdmin = new OptionsPanelAdmin(listener);
            optionsPanelAdmin.setPreferredSize(new Dimension(200, 920));
            optionsPanelAdmin.setBackground(Color.decode("#272727"));
            this.add(optionsPanelAdmin, BorderLayout.WEST);
        }
        this.revalidate();
        this.repaint();
    }

    public void switchToPanelRole(boolean isAdmin, boolean isEmployee, ActionListener listener, String[] employee) {
        if (validationDataPanel != null) {
            this.remove(validationDataPanel);
        }
        if (validationShowEmployeePanel != null) {
            this.remove(validationShowEmployeePanel);
        }
        if (isAdmin && !isEmployee) {
            validationShowEmployeePanel = new ValidationShowEmployeePanel(listener);
            validationShowEmployeePanel.setSize(780, 920);
            this.add(validationShowEmployeePanel, BorderLayout.CENTER);
        }
        if (isEmployee && !isAdmin) {
            showMyProfilePanel = new ShowMyProfilePanel(listener);
            showMyProfilePanel.setSize(780, 920);
            this.add(showMyProfilePanel, BorderLayout.CENTER);
            setFieldsToMyProfile(employee);
        }
        this.revalidate();
        this.repaint();
    }

    public void switchToPanelEmployee(int casePanel, ActionListener listener) {
        switch (casePanel) {
            case 1:
                handleShowMyProfile(listener);
                break;
            case 2:
                handleEditMyProfile(listener);
                break;
            case 3:
                handleShowRequestEmployee(listener);
                break;
            case 4:
                handleShowBonificationsEmployee(listener);
                break;
            case 5:
                handleShowMyNotifications(listener);
                break;
        }
    }

    public void handleShowMyNotifications(ActionListener listener) {
        removePanel(showMyNotificationsPanel);
        removePanel(editMyProfilePanel);
        removePanel(showMyProfilePanel);
        removePanel(showRequestEmployeePanel);
        removePanel(showBonificationsEmployeePanel);
        showMyNotificationsPanel = new ShowMyNotifications(listener);
        createAndShowPanel(showMyNotificationsPanel, listener);
    }

    public void handleShowBonificationsEmployee(ActionListener listener) {
        removePanel(editMyProfilePanel);
        removePanel(showMyProfilePanel);
        removePanel(showRequestEmployeePanel);
        removePanel(showBonificationsEmployeePanel);
        removePanel(showMyNotificationsPanel);
        showBonificationsEmployeePanel = new BonificationsEmployee(listener);
        showBonificationsEmployeePanel.setSize(780, 920);
        this.add(showBonificationsEmployeePanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public void handleShowRequestEmployee(ActionListener listener) {
        removePanel(editMyProfilePanel);
        removePanel(showMyProfilePanel);
        removePanel(showRequestEmployeePanel);
        removePanel(showBonificationsEmployeePanel);
        removePanel(showMyNotificationsPanel);

        showRequestEmployeePanel = new ShowRequestEmployee(listener);
        showRequestEmployeePanel.setSize(780, 920);
        this.add(showRequestEmployeePanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public void handleShowMyProfile(ActionListener listener) {
        removePanel(editMyProfilePanel);
        removePanel(showMyProfilePanel);
        removePanel(showRequestEmployeePanel);
        removePanel(showBonificationsEmployeePanel);
        removePanel(showMyNotificationsPanel);

        showMyProfilePanel = new ShowMyProfilePanel(listener);
        showMyProfilePanel.setSize(780, 920);
        this.add(showMyProfilePanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public void handleEditMyProfile(ActionListener listener) {
        removePanel(editMyProfilePanel);
        removePanel(showMyProfilePanel);
        removePanel(showRequestEmployeePanel);
        removePanel(showBonificationsEmployeePanel);
        removePanel(showMyNotificationsPanel);
        editMyProfilePanel = new EditMyProfilePanel(listener);
        editMyProfilePanel.setSize(780, 920);
        this.add(editMyProfilePanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public void switchToPanelAdmin(int casePanel, ActionListener listener) {
        switch (casePanel) {
            case 1:
                handleShowEmployeeValidation(listener);
                break;
            case 2:
                handleShowEmployee(listener);
                break;
            case 3:
                handleEditEmployeeValidation(listener);
                break;
            case 4:
                handleEditEmployee(listener);
                break;
            case 5:
                handleDeleteEmployeeValidation(listener);
                break;
            case 6:
                handleAddEmployee(listener);
                break;
            case 7:
                handleShowTeamValidation(listener);
                break;
            case 8:
                handleShowTeam(listener);
                break;
            case 9:
                handleEditTeamValidation(listener);
                break;
            case 10:
                handleEditTeam(listener);
                break;
            case 11:
                handleAddTeamValidation(listener);
                break;
            case 12:
                handleDeleteTeamValidation(listener);
                break;
            case 13:
                handlePayrollEmployeeValidation(listener);
                break;
            case 14:
                handlePayrollEmployee(listener);
                break;
            case 15:
                handleShowRequestAdmin(listener);
                break;
            case 16:
                handleShowAllNotifications(listener);
                break;
            case 17:
                handleMoveOtherGroup(listener);
                break;
        }
    }

    private void handleMoveOtherGroup(ActionListener listener) {
        removePanel(moveOtherGroup);
        moveOtherGroup = new MoveOtherGroup(listener);
        createAndShowPanel(moveOtherGroup, listener);
    }

    public void handleShowAllNotifications(ActionListener listener) {
        removePanel(showAllNotificationsPanel);
        showAllNotificationsPanel = new ShowAllNotifications(listener);
        createAndShowPanel(showAllNotificationsPanel, listener);
    }

    public void handleShowRequestAdmin(ActionListener listener) {
        removePanel(showRequestAdminPanel);
        showRequestAdminPanel = new ShowRequestAdmin(listener);
        createAndShowPanel(showRequestAdminPanel, listener);
    }

    public void removePanels() {
        removePanel(validationShowEmployeePanel);
        removePanel(showEmployeePanel);
        removePanel(editEmployeeValidationPanel);
        removePanel(editEmployeePanel);
        removePanel(deleteEmployeeValidationPanel);
        removePanel(addEmployeePanel);
        removePanel(validationShowTeamPanel);
        removePanel(showTeamPanel);
        removePanel(validationEditTeamPanel);
        removePanel(editTeamPanel);
        removePanel(addTeamPanel);
        removePanel(deleteTeamPanel);
        removePanel(validationPayrollEmployeePanel);
        removePanel(payrollEmployeePanel);
        removePanel(showAllNotificationsPanel);
        removePanel(showRequestAdminPanel);
        removePanel(moveOtherGroup);
    }

    private void removePanel(Component panel) {
        if (panel != null) {
            this.remove(panel);
        }
    }

    private void createAndShowPanel(Component newPanel, ActionListener listener) {
        removePanels();
        newPanel.setSize(780, 920);
        this.add(newPanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public void handleShowEmployeeValidation(ActionListener listener) {
        removePanel(validationShowEmployeePanel);
        validationShowEmployeePanel = new ValidationShowEmployeePanel(listener);
        createAndShowPanel(validationShowEmployeePanel, listener);
    }

    public void handleShowEmployee(ActionListener listener) {
        removePanel(showEmployeePanel);
        showEmployeePanel = new ShowEmployee(listener);
        createAndShowPanel(showEmployeePanel, listener);
    }

    public void handleEditEmployeeValidation(ActionListener listener) {
        removePanel(editEmployeeValidationPanel);
        editEmployeeValidationPanel = new ValidationEditEmployeePanel(listener);
        createAndShowPanel(editEmployeeValidationPanel, listener);
    }

    public void handleEditEmployee(ActionListener listener) {
        removePanel(editEmployeePanel);
        editEmployeePanel = new EditEmployeePanel(listener);
        createAndShowPanel(editEmployeePanel, listener);
    }

    public void handleDeleteEmployeeValidation(ActionListener listener) {
        removePanel(deleteEmployeeValidationPanel);
        deleteEmployeeValidationPanel = new ValidationDeleteEmployeePanel(listener);
        createAndShowPanel(deleteEmployeeValidationPanel, listener);
    }

    public void handleAddEmployee(ActionListener listener) {
        removePanel(addEmployeePanel);
        addEmployeePanel = new AddEmployeePanel(listener);
        createAndShowPanel(addEmployeePanel, listener);
    }

    public void handleShowTeamValidation(ActionListener listener) {
        removePanel(validationShowTeamPanel);
        validationShowTeamPanel = new ValidationShowTeam(listener);
        createAndShowPanel(validationShowTeamPanel, listener);
    }

    public void handleShowTeam(ActionListener listener) {
        removePanel(showTeamPanel);
        showTeamPanel = new ShowTeamPanel(listener);
        createAndShowPanel(showTeamPanel, listener);
    }

    public void handleEditTeamValidation(ActionListener listener) {
        removePanel(validationEditTeamPanel);
        validationEditTeamPanel = new ValidationEditTeam(listener);
        createAndShowPanel(validationEditTeamPanel, listener);
    }

    public void handleEditTeam(ActionListener listener) {
        removePanel(editTeamPanel);
        editTeamPanel = new EditTeamPanel(listener);
        createAndShowPanel(editTeamPanel, listener);
    }

    public void handleAddTeamValidation(ActionListener listener) {
        removePanel(addTeamPanel);
        addTeamPanel = new AddTeamPanel(listener);
        createAndShowPanel(addTeamPanel, listener);
    }

    public void handleDeleteTeamValidation(ActionListener listener) {
        removePanel(deleteTeamPanel);
        deleteTeamPanel = new ValidationDeleteTeamPanel(listener);
        createAndShowPanel(deleteTeamPanel, listener);
    }

    public void handlePayrollEmployeeValidation(ActionListener listener) {
        removePanel(validationPayrollEmployeePanel);
        validationPayrollEmployeePanel = new ValidationBonificationsEmployeePanel(listener);
        createAndShowPanel(validationPayrollEmployeePanel, listener);
    }

    public void handlePayrollEmployee(ActionListener listener) {
        removePanel(payrollEmployeePanel);
        payrollEmployeePanel = new BonificationsEmployeeAdmin(listener);
        createAndShowPanel(payrollEmployeePanel, listener);
    }

    public void showErrorMessage(String message) {
        validationDataPanel.setError(message);
    }

    public void setMessageUpdateMyProfile(String message, boolean isCorrect) {
        if (isCorrect) {
            editMyProfilePanel.setMessageSuccess(message);
        } else {
            editMyProfilePanel.setMessageError(message);
        }
    }

    public void setMessageUpdateEmployee(String message, boolean isCorrect) {
        if (isCorrect) {
            editEmployeePanel.setMessageSuccess(message);
        } else {
            editEmployeePanel.setMessageError(message);
        }
    }

    public void setMessageAddEmployee(String message, boolean isCorrect) {
        if (isCorrect) {
            addEmployeePanel.setMessageSuccess(message);
        } else {
            addEmployeePanel.setMessageError(message);
        }
    }

    public void setFieldsToMyProfile(String[] employee) {
        showMyProfilePanel.setFieldsEmployee(employee);
    }

    public void setFieldsToMyProfileEdit(String[] employee) {
        editMyProfilePanel.setFieldsEmployee(employee);
    }

    public void setFieldsToShowEmployee(String[] employee) {
        showEmployeePanel.setFieldsEmployee(employee);
    }

    public void setFieldsToEditEmployee(String[] employee) {
        editEmployeePanel.setFieldsEmployee(employee);
    }

    public void setFieldIdTeamEditable(boolean value) {
        editEmployeePanel.setIdTeamEditable(value);
    }

    public void setFieldIsLeaderEditable(boolean value) {
        editEmployeePanel.setIsLeaderEditable(value);
    }

    public void setFieldsToShowTeam(String[] team) {
        showTeamPanel.setFields(team);
    }

    public void setFieldsToEditTeam(String[] team) {
        editTeamPanel.setFields(team);
    }

    public void setFieldNameSearchEmployeeShow(String name) {
        validationShowEmployeePanel.setTextFieldName(name);
    }

    public void setFieldJobSearchEmployeeShow(String job) {
        validationShowEmployeePanel.setTextFieldJob(job);
    }

    public void setFieldNameEditEmployeeEdit(String name) {
        editEmployeeValidationPanel.setTextFieldName(name);
    }

    public void setFieldJobEditEmployeeEdit(String job) {
        editEmployeeValidationPanel.setTextFieldJob(job);
    }

    public void setFieldNameDeleteEmployee(String name) {
        deleteEmployeeValidationPanel.setTextFieldName(name);
    }

    public void setFieldJobDeleteEmployee(String job) {
        deleteEmployeeValidationPanel.setTextFieldJob(job);
    }

    public void setFieldNameSearchTeamShow(String name) {
        validationShowTeamPanel.setTextFieldName(name);
    }

    public void setFieldAreaSearchTeamShow(String area) {
        validationShowTeamPanel.setTextFieldJob(area);
    }

    public void setFieldNameEditTeamEdit(String name) {
        validationEditTeamPanel.setTextFieldName(name);
    }

    public void setFieldAreaEditTeamEdit(String area) {
        validationEditTeamPanel.setTextFieldJob(area);
    }

    public void setFieldNameDeleteTeam(String name) {
        deleteTeamPanel.setTextFieldName(name);
    }

    public void setFieldAreaDeleteTeam(String area) {
        deleteTeamPanel.setTextFieldJob(area);
    }

    public String getIdEditEmployee() {
        return editEmployeeValidationPanel.getIdField();
    }

    public String getIdSearchEmployeeShow() {
        return validationShowEmployeePanel.getIdField();
    }

    public String getIdDeleteEmployee() {
        return deleteEmployeeValidationPanel.getIdField();
    }

    public String getIdSearchTeamShow() {
        return validationShowTeamPanel.getIdField();
    }

    public String getIdEditTeam() {
        return validationEditTeamPanel.getIdField();
    }

    public String getIdDeleteTeam() {
        return deleteTeamPanel.getIdField();
    }

    public String[] getFieldsEditMyProfile() {
        return editMyProfilePanel.getFields();
    }

    public String[] getFieldsEditEmployee() {
        return editEmployeePanel.getFields();
    }

    public String[] getFieldsAddEmployee() {
        return addEmployeePanel.getFields();
    }

    public ArrayList<String> getFieldsAddTeam() {
        return addTeamPanel.getFields();
    }

    public ArrayList<String> getFieldsEditTeam() {
        return editTeamPanel.getFields();
    }

    public String getFieldId() {
        return validationDataPanel.getIdField().getText();
    }

    public String getFieldYearBirth() {
        return validationDataPanel.getYearBirthField().getText();
    }

    public void setMessageUpdateTeam(String message, boolean isCorrect) {
        if (isCorrect) {
            editTeamPanel.setMessageSuccess(message);
        } else {
            editTeamPanel.setMessageError(message);
        }
    }

    public void setMessageAddTeam(String message, boolean isCorrect) {
        if (isCorrect) {
            addTeamPanel.setMessageSuccess(message);
        } else {
            addTeamPanel.setMessageError(message);
        }
    }

    public void setMessageSearchEmployee(String message) {
        validationShowEmployeePanel.setMessage(message);
    }

    public void setMessageEditEmployee(String message) {
        editEmployeeValidationPanel.setMessage(message);
    }

    public void setMessageDeleteEmployee(String message) {
        deleteEmployeeValidationPanel.setMessage(message);
    }

    public void setMessageSearchTeam(String message) {
        validationShowTeamPanel.setMessage(message);
    }

    public void setMessageEditTeam(String message) {
        validationEditTeamPanel.setMessage(message);
    }

    public void setMessageDeleteTeam(String message) {
        deleteTeamPanel.setMessage(message);
    }

    public String getIdSearchBonificationEmployee() {
        return validationPayrollEmployeePanel.getIdField();
    }

    public void setMessageBonificationEmployee(String message) {
        validationPayrollEmployeePanel.setMessage(message);
    }

    public void setFieldNameBonificationEmployee(String employee) {
        validationPayrollEmployeePanel.setTextFieldName(employee);
    }

    public void setFieldJobBonificationEmployee(String job) {
        validationPayrollEmployeePanel.setTextFieldJob(job);
    }

    public void setFieldsToBonificationEmployee(String[] employee) {
        payrollEmployeePanel.setFieldsEmployee(employee);
    }

    public void setFieldsToNotifications(String[] notification) {
        showMyNotificationsPanel.setFields(notification);
    }

    public void setFieldsToNotificationsAdmin(String[] notification) {
        showAllNotificationsPanel.setFields(notification);
    }

    public void setFieldsToMyBonifications(String[] bonifications) {
        showBonificationsEmployeePanel.setFields(bonifications);
    }

    public void setFieldsToMyRequests(String[] request) {
        showRequestEmployeePanel.setFields(request);
    }

    public ArrayList<String> getFieldsEmployeePayroll() {
        return payrollEmployeePanel.getFields();
    }

    public void setMessageEmployeePayroll(String message, String salaryNet, String totalDays, boolean isError) {
        payrollEmployeePanel.setMessageSuccess(message, salaryNet, totalDays, isError);
    }

    public void setMessageNotificationEmployee(String message) {
        showMyNotificationsPanel.setMessageLbl(message);
    }

    public void setMessageNotificationAdmin(String message) {
        showAllNotificationsPanel.setMessageLbl(message);
    }

    public ArrayList<String> getFieldsMyRequest() {
        return showRequestEmployeePanel.getFields();
    }

    public void setMessageMyRequest(String message, boolean isCorrect) {
        showRequestEmployeePanel.setMessageLbl(message, isCorrect, false);
    }

    public void setFieldsToRequests(String[] requests) {
        showRequestAdminPanel.setFieldsToRequests(requests);
    }

    public ArrayList<String> getFieldsRequests() {
        return showRequestAdminPanel.getFields();
    }

    public void setMessageRequestAdmin(String message, boolean isCorrect) {
        showRequestAdminPanel.setMessageLbl(message, isCorrect, true);
    }

    public ArrayList<String> getFieldsMoveEmployeeToOtherGroup() {
        return moveOtherGroup.getFields();

    }

    public void setMessageMoveEmployeeToOtherGroup(String string, boolean isCorrect) {
        moveOtherGroup.setMessage(string, isCorrect);

    }

}
