package co.edu.uptc.view.admin.validations;

import java.awt.event.ActionListener;

import co.edu.uptc.view.admin.SearchPanel;

public class ValidationBonificationsEmployeePanel extends SearchPanel {

    public ValidationBonificationsEmployeePanel(ActionListener listener) {
        super(listener, "Validar bonificaciones del empleado",
                "Por favor ingrese el número de identificación del empleado",
                "SearchBonificationEmployee", "SendBonificationEmployee", "Nombre", "Cargo", "Buscar",
                "src/co/edu/uptc/view/assets/img/payrollEmployee.jpg");
    }
}
