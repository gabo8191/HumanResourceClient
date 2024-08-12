package co.edu.uptc.view.admin.validations;

import java.awt.event.ActionListener;

import co.edu.uptc.view.admin.SearchPanel;

public class ValidationDeleteEmployeePanel extends SearchPanel {

    public ValidationDeleteEmployeePanel(ActionListener listener) {
        super(listener, "Eliminar empleado", "Por favor ingrese el ID del empleado a eliminar", "SearchDeleteEmployee",
                "SendDeleteEmployee",
                "Nombre", "Cargo", "Eliminar", "src/co/edu/uptc/view/assets/img/deleteEmployee.jpg");
    }

}
