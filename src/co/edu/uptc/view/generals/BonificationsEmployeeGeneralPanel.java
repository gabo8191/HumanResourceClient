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

public class BonificationsEmployeeGeneralPanel extends JPanel {

        private JLabel title;
        private JLabel titleGeneralInformation;
        private JLabel labelName, labelLastName, labelId;
        private JTextField textFieldName, textFieldLastName, textFieldId;

        private JLabel titleSalaryInformation;
        private JLabel labelGrossSalary, labelNetSalary, labelTransportAid;
        private JTextField textFieldGrossSalary, textFieldNetSalary, textFieldTransportAid;
        private JLabel message;

        private JLabel titleVacationsInformation;
        private JLabel labelAvailableDays, labelDaysTaken, totalDays;
        private JTextField textFieldAvailableDays, textFieldDaysTaken, textFieldTotalDays;

        private JLabel titleBenefitsInformation;
        private JLabel labelProductivityBonus, labelLearningBonus;
        private JTextField textFieldProductivityBonus, textFieldLearningBonus;

        private Image backgroundImage;
        private JButton loadButton;
        private ArrayList<String> lockedList;
        public JLabel successMessage;
        private JLabel errorMessage;

        public BonificationsEmployeeGeneralPanel(ActionListener listener, String[] lockedListArray, String urlImage,
                        boolean isAdmin) {

                lockedList = new ArrayList<String>();
                for (String locked : lockedListArray) {
                        lockedList.add(locked);
                }
                initializeTextFields();
                this.revalidate();
                this.repaint();
                firstColumn(listener, isAdmin);
        }

        public void initializeTextFields() {
                textFieldName = new JTextField(10);
                textFieldLastName = new JTextField(10);
                textFieldId = new JTextField(10);

                textFieldGrossSalary = new JTextField(10);
                textFieldNetSalary = new JTextField(10);
                textFieldTransportAid = new JTextField(10);

                textFieldAvailableDays = new JTextField(10);
                textFieldDaysTaken = new JTextField(10);
                textFieldTotalDays = new JTextField(10);

                textFieldProductivityBonus = new JTextField(10);
                textFieldLearningBonus = new JTextField(10);
        }

        private void firstColumn(ActionListener listener, boolean isAdmin) {
                this.setLayout(new GridBagLayout());
                backgroundImage = new ImageIcon("src/co/edu/uptc/view/assets/img/addEmployee.jpg").getImage();
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(5, 5, 5, 5);

                title = new JLabel("Bonificaciones del empleado");
                title.setFont(new Font("Segoe UI", Font.BOLD, 35));
                title.setForeground(Color.WHITE);
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 6;
                gbc.anchor = GridBagConstraints.CENTER;
                add(title, gbc);

                titleGeneralInformation = new JLabel("Información General");
                titleGeneralInformation.setFont(new Font("Segoe UI", Font.BOLD, 15));
                titleGeneralInformation.setForeground(Color.WHITE);
                gbc.gridy = 1;
                gbc.gridx = 0;
                gbc.gridwidth = 1;
                gbc.anchor = GridBagConstraints.WEST;
                add(titleGeneralInformation, gbc);

                gbc.gridy = 2;
                addLabelAndTextFieldFirstColumn(labelName, textFieldName, "Nombre:", gbc);
                gbc.gridy = 3;
                addLabelAndTextFieldFirstColumn(labelLastName, textFieldLastName, "Apellido:", gbc);
                gbc.gridy = 4;
                addLabelAndTextFieldFirstColumn(labelId, textFieldId, "Identificación:", gbc);

                titleSalaryInformation = new JLabel("Información Salarial");
                titleSalaryInformation.setFont(new Font("Segoe UI", Font.BOLD, 15));
                titleSalaryInformation.setForeground(Color.WHITE);
                gbc.gridy = 5;
                gbc.gridx = 0;
                gbc.gridwidth = 1;
                gbc.anchor = GridBagConstraints.WEST;
                add(titleSalaryInformation, gbc);

                gbc.gridy = 6;
                addLabelAndTextFieldFirstColumn(labelGrossSalary, textFieldGrossSalary, "Salario bruto:", gbc);
                gbc.gridy = 7;
                addLabelAndTextFieldFirstColumn(labelTransportAid, textFieldTransportAid, "Auxilio de transporte:",
                                gbc);
                gbc.gridy = 8;
                addLabelAndTextFieldFirstColumn(labelNetSalary, textFieldNetSalary, "Salario neto:", gbc);

                message = new JLabel(
                                "Salario neto = Salario bruto + Auxilio de transporte + Bono de productividad + Bono de aprendizaje");
                message.setFont(new Font("Segoe UI", Font.PLAIN, 9));
                message.setForeground(Color.WHITE);
                gbc.gridy = 9;
                gbc.gridx = 0;
                gbc.gridwidth = 6;
                gbc.anchor = GridBagConstraints.CENTER;
                add(message, gbc);

                titleBenefitsInformation = new JLabel("Información de Beneficios");
                titleBenefitsInformation.setFont(new Font("Segoe UI", Font.BOLD, 15));
                titleBenefitsInformation.setForeground(Color.WHITE);
                gbc.gridy = 10;
                gbc.gridx = 0;
                gbc.gridwidth = 1;
                gbc.anchor = GridBagConstraints.WEST;
                add(titleBenefitsInformation, gbc);
                gbc.gridy = 11;
                addLabelAndTextFieldFirstColumn(labelProductivityBonus, textFieldProductivityBonus,
                                "Valor del bono de productividad:", gbc);
                gbc.gridy = 12;
                addLabelAndTextFieldFirstColumn(labelLearningBonus, textFieldLearningBonus,
                                "Valor del bono de aprendizaje:",
                                gbc);

                secondColumn(listener, gbc, isAdmin);
        }

        private void addLabelAndTextFieldFirstColumn(JLabel label, JTextField textField, String labelText,
                        GridBagConstraints gbc) {

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

        private void secondColumn(ActionListener listener, GridBagConstraints gbc, boolean isAdmin) {
                gbc = new GridBagConstraints();
                gbc.insets = new Insets(5, 5, 5, 5);

                titleVacationsInformation = new JLabel("Información vacacional");
                titleVacationsInformation.setFont(new Font("Segoe UI", Font.BOLD, 15));
                titleVacationsInformation.setForeground(Color.WHITE);
                gbc.gridy = 1;
                gbc.gridx = 3;
                gbc.gridwidth = 1;
                gbc.anchor = GridBagConstraints.WEST;
                add(titleVacationsInformation, gbc);

                gbc.gridy = 2;
                addLabelAndTextFieldSecondColumn(labelAvailableDays, textFieldAvailableDays, "Días disponibles:", gbc);
                gbc.gridy = 3;
                addLabelAndTextFieldSecondColumn(labelDaysTaken, textFieldDaysTaken, "Días a tomar:", gbc);
                gbc.gridy = 4;
                addLabelAndTextFieldSecondColumn(totalDays, textFieldTotalDays, "Total restantes:", gbc);

                if (isAdmin) {
                        loadButton = new JButton("Cargar");
                        loadButton.setUI(new ButtonSearchUI());
                        loadButton.addActionListener(listener);
                        loadButton.setActionCommand("loadEmployeePayroll");
                        gbc.gridy = 11;
                        gbc.gridx = 3;
                        gbc.gridwidth = 3;
                        gbc.anchor = GridBagConstraints.EAST;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        gbc.ipady = 10;
                        gbc.ipadx = 10;
                        add(loadButton, gbc);

                        successMessage = new JLabel();
                        successMessage.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                        successMessage.setForeground(Color.GREEN);
                        gbc.gridy = 12;
                        gbc.gridx = 3;
                        gbc.gridwidth = 3;
                        gbc.anchor = GridBagConstraints.CENTER;
                        add(successMessage, gbc);

                        errorMessage = new JLabel();
                        errorMessage.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                        errorMessage.setForeground(Color.RED);
                        gbc.gridy = 13;
                        gbc.gridx = 3;
                        gbc.gridwidth = 3;
                        gbc.anchor = GridBagConstraints.CENTER;
                        add(errorMessage, gbc);
                }
        }

        private void addLabelAndTextFieldSecondColumn(JLabel label, JTextField textField, String labelText,
                        GridBagConstraints gbc) {
                label = new JLabel(labelText);
                label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                label.setForeground(Color.WHITE);
                gbc.gridx = 3;
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
                gbc.gridx = 4;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.WEST;
                add(textField, gbc);
        }

        public void setTitle(String title) {
                this.title.setText(title);
        }

        public void setFieldsEmployee(String[] payroll) {
                setTextFieldName(payroll[0]);
                setTextFieldLastName(payroll[1]);
                setTextFieldId(payroll[2]);

                setTextFieldGrossSalary(payroll[3]);
                setTextFieldTransportAid(payroll[4]);
                setTextFieldNetSalary(payroll[5]);
                setTextFieldProductivityBonus(payroll[6]);
                setTextFieldLearningBonus(payroll[7]);

                setTextFieldAvailableDays(payroll[8]);
                setTextFieldDaysTaken(payroll[9]);
                setTextFieldTotalDays(payroll[10]);
        }

        public void setTextFieldLearningBonus(String value) {
                textFieldLearningBonus.setText(value);
        }

        public void setTextFieldTotalDays(String value) {
                textFieldTotalDays.setText(value);
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

        public void setTextFieldGrossSalary(String value) {
                textFieldGrossSalary.setText(value);
        }

        public void setTextFieldNetSalary(String value) {
                textFieldNetSalary.setText(value);
        }

        public void setTextFieldTransportAid(String value) {
                textFieldTransportAid.setText(value);
        }

        public void setTextFieldAvailableDays(String value) {
                textFieldAvailableDays.setText(value);
        }

        public void setTextFieldDaysTaken(String value) {
                textFieldDaysTaken.setText(value);
        }

        public void setTextFieldProductivityBonus(String value) {
                textFieldProductivityBonus.setText(value);
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

        public JTextField getTextFieldGrossSalary() {
                return textFieldGrossSalary;
        }

        public JTextField getTextFieldNetSalary() {
                return textFieldNetSalary;
        }

        public JTextField getTextFieldTransportAid() {
                return textFieldTransportAid;
        }

        public JTextField getTextFieldAvailableDays() {
                return textFieldAvailableDays;
        }

        public JTextField getTextFieldDaysTaken() {
                return textFieldDaysTaken;
        }

        public JTextField getTextFieldProductivityBonus() {
                return textFieldProductivityBonus;
        }

        public JTextField getTextFieldTotalDays() {
                return textFieldTotalDays;
        }

        public ArrayList<String> getFields() {
                ArrayList<String> fields = new ArrayList<>();
                fields.add(textFieldName.getText());
                fields.add(textFieldLastName.getText());
                fields.add(textFieldId.getText());

                fields.add(textFieldGrossSalary.getText());
                fields.add(textFieldTransportAid.getText());

                fields.add(String.valueOf(Long.parseLong(textFieldGrossSalary.getText())
                                + Long.parseLong(textFieldTransportAid.getText())
                                + Long.parseLong(textFieldProductivityBonus.getText())
                                + Long.parseLong(textFieldLearningBonus.getText())));
                fields.add(textFieldProductivityBonus.getText());
                fields.add(textFieldLearningBonus.getText());

                fields.add(textFieldAvailableDays.getText());
                fields.add(textFieldDaysTaken.getText());

                fields.add(String.valueOf(Long.parseLong(textFieldTotalDays.getText())
                                - Long.parseLong(textFieldDaysTaken.getText()) < 0 ? 0
                                                : Long.parseLong(textFieldTotalDays.getText())
                                                                - Long.parseLong(textFieldDaysTaken.getText())));
                return fields;
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
                textFieldName.setText(fields[0]);
                textFieldLastName.setText(fields[1]);
                textFieldId.setText(fields[2]);

                textFieldGrossSalary.setText(fields[3]);
                textFieldTransportAid.setText(fields[4]);
                textFieldNetSalary.setText(fields[5]);
                textFieldProductivityBonus.setText(fields[6]);
                textFieldLearningBonus.setText(fields[7]);

                textFieldAvailableDays.setText(fields[8]);
                textFieldDaysTaken.setText(fields[9]);
                textFieldTotalDays.setText(fields[10]);

                this.revalidate();
                this.repaint();
        }

        public void setMessageSuccess(String message, String newSalaryNet, String totalDays, boolean isError) {
                if (isError) {
                        errorMessage.setText(message);
                        successMessage.setText("");
                } else {
                        successMessage.setText(message);
                        errorMessage.setText("");
                        textFieldNetSalary.setText(newSalaryNet);
                        textFieldDaysTaken.setText("0");
                        textFieldTotalDays.setText(totalDays);

                }

        }

}
