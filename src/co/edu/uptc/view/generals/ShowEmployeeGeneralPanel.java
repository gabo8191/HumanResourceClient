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

public class ShowEmployeeGeneralPanel extends JPanel {

        private JLabel title;

        private JLabel titleMainInformation;
        private JLabel labelName, labelLastName, labelId, labelYearBirth, labelMonthBirth, labelDayBirth;
        private JTextField textFieldName, textFieldLastName, textFieldId, textFieldYearBirth,
                        textFieldMonthBirth, textFieldDayBirth;

        private JLabel titleSecondaryInformation;
        private JLabel labelGender, labelCity;
        private JTextField textFieldGender, textFieldCity;

        private JLabel titleJobInformation;
        private JLabel labelArea, labelPosition, labelIsAdmin, labelIsLeader, labelIdTeam;
        private JTextField textFieldArea, textFieldPosition, textFieldIsAdmin, textFieldIsLeader, textFieldIdTeam;

        private JLabel titleSalaryInformation;
        private JLabel labelSalaryGross, labelSalaryNet;
        private JTextField textFieldSalaryGross, textFieldSalaryNet;

        private JLabel titleContactInformation;
        private JLabel labelEmail, labelPhone;
        private JTextField textFieldEmail, textFieldPhone;

        private Image backgroundImage;
        private JButton buttonEdit;
        private JLabel messageSuccess, messageError, message;

        public ShowEmployeeGeneralPanel(ActionListener listener, String[] lockedList, String urlImage, boolean isEdit,
                        String textLbl, String command, boolean isProfile, boolean isAdd) {
                ArrayList<String> lockedListArray = new ArrayList<String>();
                for (String string : lockedList) {
                        lockedListArray.add(string);
                }

                initializeTextFields();
                this.revalidate();
                this.repaint();
                firstColumn(listener, lockedListArray, urlImage, isEdit, textLbl, command, isProfile, isAdd);
        }

        private void initializeTextFields() {
                textFieldName = new JTextField(20);
                textFieldLastName = new JTextField(20);
                textFieldId = new JTextField(20);
                textFieldYearBirth = new JTextField(20);
                textFieldMonthBirth = new JTextField(20);
                textFieldDayBirth = new JTextField(20);

                textFieldGender = new JTextField(20);
                textFieldCity = new JTextField(20);

                textFieldArea = new JTextField(20);
                textFieldPosition = new JTextField(20);
                textFieldIsAdmin = new JTextField(20);
                textFieldIsLeader = new JTextField(20);
                textFieldIdTeam = new JTextField(20);

                textFieldSalaryGross = new JTextField(20);
                textFieldSalaryNet = new JTextField(20);

                textFieldEmail = new JTextField(20);
                textFieldPhone = new JTextField(20);
        }

        private void firstColumn(ActionListener listener, ArrayList<String> lockedList, String urlImage,
                        boolean isEdit, String textLbl, String command, boolean isProfile, boolean isAdd) {
                this.setLayout(new GridBagLayout());
                backgroundImage = new ImageIcon(urlImage).getImage();
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(5, 5, 5, 5);

                title = new JLabel("Mostrar mi perfil");
                title.setFont(new Font("Segoe UI", Font.BOLD, 35));
                title.setForeground(Color.WHITE);
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 6;
                gbc.anchor = GridBagConstraints.CENTER;
                add(title, gbc);

                titleMainInformation = new JLabel("Información Principal");
                titleMainInformation.setFont(new Font("Segoe UI", Font.BOLD, 15));
                titleMainInformation.setForeground(Color.WHITE);
                gbc.gridy = 1;
                gbc.gridwidth = 1;
                gbc.anchor = GridBagConstraints.WEST;
                add(titleMainInformation, gbc);

                gbc.gridy = 2;
                addLabelAndTextFieldFirstColumn(labelName, textFieldName, "Nombre:", gbc, lockedList);
                gbc.gridy = 3;
                addLabelAndTextFieldFirstColumn(labelLastName, textFieldLastName, "Apellido:", gbc, lockedList);
                gbc.gridy = 4;
                addLabelAndTextFieldFirstColumn(labelId, textFieldId, "Identificación:", gbc, lockedList);
                gbc.gridy = 5;
                addLabelAndTextFieldFirstColumn(labelYearBirth, textFieldYearBirth, "Año de nacimiento:", gbc,
                                lockedList);
                gbc.gridy = 6;
                addLabelAndTextFieldFirstColumn(labelMonthBirth, textFieldMonthBirth, "Mes de nacimiento:", gbc,
                                lockedList);
                gbc.gridy = 7;
                addLabelAndTextFieldFirstColumn(labelDayBirth, textFieldDayBirth, "Día de nacimiento:", gbc,
                                lockedList);

                titleSecondaryInformation = new JLabel("Información Secundaria");
                titleSecondaryInformation.setFont(new Font("Segoe UI", Font.BOLD, 15));
                titleSecondaryInformation.setForeground(Color.WHITE);
                gbc.gridy = 8;
                gbc.gridx = 0;
                gbc.gridwidth = 1;
                gbc.anchor = GridBagConstraints.WEST;
                add(titleSecondaryInformation, gbc);

                gbc.gridy = 9;
                addLabelAndTextFieldFirstColumn(labelGender, textFieldGender, "Género:", gbc, lockedList);
                gbc.gridy = 10;
                addLabelAndTextFieldFirstColumn(labelCity, textFieldCity, "Ciudad:", gbc, lockedList);

                titleContactInformation = new JLabel("Información de Contacto");
                titleContactInformation.setFont(new Font("Segoe UI", Font.BOLD, 15));
                titleContactInformation.setForeground(Color.WHITE);
                gbc.gridy = 11;
                gbc.gridx = 0;
                gbc.gridwidth = 1;
                gbc.anchor = GridBagConstraints.WEST;
                add(titleContactInformation, gbc);

                gbc.gridy = 12;
                addLabelAndTextFieldFirstColumn(labelEmail, textFieldEmail, "Correo electrónico:", gbc, lockedList);
                gbc.gridy = 13;
                addLabelAndTextFieldFirstColumn(labelPhone, textFieldPhone, "Teléfono:", gbc, lockedList);

                secondColumn(listener, gbc, lockedList, isEdit, textLbl, command, isProfile, isAdd);
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
                        boolean isEdit, String textLbl, String command, boolean isProfile, boolean isAdd) {
                gbc = new GridBagConstraints();
                gbc.insets = new Insets(5, 5, 5, 5);

                titleJobInformation = new JLabel("Información Laboral");
                titleJobInformation.setFont(new Font("Segoe UI", Font.BOLD, 15));
                titleJobInformation.setForeground(Color.WHITE);
                gbc.gridy = 1;
                gbc.gridx = 3;
                gbc.gridwidth = 1;
                gbc.anchor = GridBagConstraints.WEST;
                add(titleJobInformation, gbc);

                gbc.gridy = 2;
                addLabelAndTextFieldSecondColumn(labelArea, textFieldArea, "Área:", gbc, lockedList);
                gbc.gridy = 3;
                addLabelAndTextFieldSecondColumn(labelPosition, textFieldPosition, "Cargo:", gbc, lockedList);
                if (isEdit) {
                        gbc.gridy = 4;
                        message = new JLabel("Digite true si es líder o administrador y false si no lo es");
                        message.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 10));
                        message.setForeground(Color.WHITE);
                        add(message, gbc);
                }

                gbc.gridy++;
                addLabelAndTextFieldSecondColumn(labelIdTeam, textFieldIdTeam, "Identificación del equipo:", gbc,
                                lockedList);

                gbc.gridy++;
                addLabelAndTextFieldSecondColumn(labelIsAdmin, textFieldIsAdmin, "Es administrador:", gbc, lockedList);
                gbc.gridy++;
                addLabelAndTextFieldSecondColumn(labelIsLeader, textFieldIsLeader, "Es líder:", gbc, lockedList);

                if (!isAdd) {

                        titleSalaryInformation = new JLabel("Información salarial");
                        titleSalaryInformation.setFont(new Font("Segoe UI", Font.BOLD, 15));
                        titleSalaryInformation.setForeground(Color.WHITE);
                        gbc.gridy++;
                        gbc.gridx = 3;
                        gbc.gridwidth = 1;
                        gbc.anchor = GridBagConstraints.WEST;
                        add(titleSalaryInformation, gbc);

                        gbc.gridy++;
                        addLabelAndTextFieldSecondColumn(labelSalaryGross, textFieldSalaryGross, "Salario bruto:", gbc,
                                        lockedList);
                        gbc.gridy++;
                        addLabelAndTextFieldSecondColumn(labelSalaryNet, textFieldSalaryNet, "Salario neto:", gbc,
                                        lockedList);
                }

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

                        messageSuccess = new JLabel();
                        messageSuccess.setFont(new Font("Segoe UI", Font.BOLD, 12));
                        messageSuccess.setForeground(Color.GREEN);
                        messageSuccess.setHorizontalAlignment(JLabel.CENTER);
                        messageSuccess.setVerticalAlignment(JLabel.CENTER);
                        gbc.gridy++;
                        add(messageSuccess, gbc);

                        messageError = new JLabel();
                        messageError.setFont(new Font("Segoe UI", Font.BOLD, 12));
                        messageError.setForeground(Color.RED);
                        messageError.setHorizontalAlignment(JLabel.CENTER);
                        messageError.setVerticalAlignment(JLabel.CENTER);
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
                if (lockedList.contains(fieldName)) {
                        textField.setBackground(Color.LIGHT_GRAY);
                }
                textField.setForeground(Color.BLACK);
                gbc.gridx = 4;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.WEST;
                add(textField, gbc);
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

        public void setTitle(String title) {
                this.title.setText(title);
        }

        public void setTextFieldName(String value) {
                textFieldName.setText(value);
        }

        public void setTextFieldLastName(String value) {
                textFieldLastName.setText(value);
        }

        public void setTextFieldId(String value) {
                textFieldId.setText(value);
        }

        public void setTextFieldYearBirth(String value) {
                textFieldYearBirth.setText(value);
        }

        public void setTextFieldMonthBirth(String value) {
                textFieldMonthBirth.setText(value);
        }

        public void setTextFieldDayBirth(String value) {
                textFieldDayBirth.setText(value);
        }

        public void setTextFieldGender(String value) {
                textFieldGender.setText(value);
        }

        public void setTextFieldCity(String value) {
                textFieldCity.setText(value);
        }

        public void setTextFieldEmail(String value) {
                textFieldEmail.setText(value);
        }

        public void setTextFieldPhone(String value) {
                textFieldPhone.setText(value);
        }

        public void setTextFieldArea(String value) {
                textFieldArea.setText(value);
        }

        public void setTextFieldPosition(String value) {
                textFieldPosition.setText(value);
        }

        public void setTextFieldIdTeam(String value) {
                textFieldIdTeam.setText(value);
        }

        public void setTextFieldIsAdmin(String value) {
                textFieldIsAdmin.setText(value);
        }

        public void setTextFieldIsLeader(String value) {
                textFieldIsLeader.setText(value);
        }

        public void setTextFieldSalaryGross(String value) {
                textFieldSalaryGross.setText(value);
        }

        public void setTextFieldSalaryNet(String value) {
                textFieldSalaryNet.setText(value);
        }

        public void setFieldsEmployee(String[] employee) {
                setTextFieldName(employee[0]);
                setTextFieldLastName(employee[1]);
                setTextFieldGender(employee[2]);
                setTextFieldId(employee[3]);
                setTextFieldEmail(employee[4]);
                setTextFieldPhone(employee[5]);
                setTextFieldCity(employee[6]);
                setTextFieldYearBirth(employee[7]);
                setTextFieldMonthBirth(employee[8]);
                setTextFieldDayBirth(employee[9]);

                setTextFieldArea(employee[10]);
                setTextFieldPosition(employee[11]);
                setTextFieldIsLeader(employee[12]);
                setTextFieldIsAdmin(employee[13]);
                setTextFieldSalaryGross(employee[17]);
                setTextFieldSalaryNet(employee[19]);
                setTextFieldIdTeam(employee[22]);
        }

        public void setIdTeamEditable(boolean value) {
                textFieldIdTeam.setEditable(value);
                textFieldIdTeam.setBackground(Color.LIGHT_GRAY);
        }

        public void setIsLeaderEditable(boolean value) {
                textFieldIsLeader.setEditable(value);
                textFieldIsLeader.setBackground(Color.LIGHT_GRAY);
        }

        public JTextField getTextFieldName() {
                return textFieldName;
        }

        public JTextField getTextFieldLastName() {
                return textFieldLastName;
        }

        public JTextField getTextFieldId() {
                return textFieldId;
        }

        public JTextField getTextFieldYearBirth() {
                return textFieldYearBirth;
        }

        public JTextField getTextFieldMonthBirth() {
                return textFieldMonthBirth;
        }

        public JTextField getTextFieldDayBirth() {
                return textFieldDayBirth;
        }

        public JTextField getTextFieldGender() {
                return textFieldGender;
        }

        public JTextField getTextFieldCity() {
                return textFieldCity;
        }

        public JTextField getTextFieldEmail() {
                return textFieldEmail;
        }

        public JTextField getTextFieldPhone() {
                return textFieldPhone;
        }

        public JTextField getTextFieldArea() {
                return textFieldArea;
        }

        public JTextField getTextFieldPosition() {
                return textFieldPosition;
        }

        public JTextField getTextFieldIdTeam() {
                return textFieldIdTeam;
        }

        public JTextField getTextFieldIsAdmin() {
                return textFieldIsAdmin;
        }

        public JTextField getTextFieldIsLeader() {
                return textFieldIsLeader;
        }

        public JTextField getTextFieldSalaryGross() {
                return textFieldSalaryGross;
        }

        public JTextField getTextFieldSalaryNet() {
                return textFieldSalaryNet;
        }

        public String[] getFields() {
                String[] fields = new String[17];
                fields[0] = getTextFieldName().getText().isEmpty() ? "*" : getTextFieldName().getText();
                fields[1] = getTextFieldLastName().getText().isEmpty() ? "*" : getTextFieldLastName().getText();
                fields[2] = getTextFieldGender().getText().isEmpty() ? "*" : getTextFieldGender().getText();
                fields[3] = getTextFieldId().getText().isEmpty() ? "*" : getTextFieldId().getText();
                fields[4] = getTextFieldEmail().getText().isEmpty() ? "*" : getTextFieldEmail().getText();
                fields[5] = getTextFieldPhone().getText().isEmpty() ? "*" : getTextFieldPhone().getText();
                fields[6] = getTextFieldCity().getText().isEmpty() ? "*" : getTextFieldCity().getText();
                fields[7] = getTextFieldYearBirth().getText().isEmpty() ? "*" : getTextFieldYearBirth().getText();
                fields[8] = getTextFieldMonthBirth().getText().isEmpty() ? "*" : getTextFieldMonthBirth().getText();
                fields[9] = getTextFieldDayBirth().getText().isEmpty() ? "*" : getTextFieldDayBirth().getText();
                fields[10] = getTextFieldArea().getText().isEmpty() ? "*" : getTextFieldArea().getText();
                fields[11] = getTextFieldPosition().getText().isEmpty() ? "*" : getTextFieldPosition().getText();
                fields[12] = getTextFieldIsLeader().getText().isEmpty() ? "*" : getTextFieldIsLeader().getText();
                fields[13] = getTextFieldIsAdmin().getText().isEmpty() ? "*" : getTextFieldIsAdmin().getText();
                fields[14] = getTextFieldSalaryGross().getText().isEmpty() ? "*" : getTextFieldSalaryGross().getText();
                fields[15] = getTextFieldSalaryNet().getText().isEmpty() ? "*" : getTextFieldSalaryNet().getText();
                fields[16] = getTextFieldIdTeam().getText().isEmpty() ? "*" : getTextFieldIdTeam().getText();
                return fields;
        }

        public void setMessageSuccess(String message) {
                this.messageSuccess.setText(message);
                this.messageError.setText("");
        }

        public void setMessageError(String message) {
                this.messageError.setText(message);
                this.messageSuccess.setText("");
        }

}
