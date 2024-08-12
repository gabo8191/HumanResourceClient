package co.edu.uptc.view.admin.validations;

import java.awt.event.ActionListener;

import co.edu.uptc.view.admin.SearchPanel;

public class ValidationShowEmployeePanel extends SearchPanel {

    public ValidationShowEmployeePanel(ActionListener listener) {
        super(listener, "Buscar empleado", "Por favor ingrese la identificación del empleado a buscar",
                "SearchShowEmployee", "SendShowEmployee",
                "Nombre", "Cargo", "Buscar", "src/co/edu/uptc/view/assets/img/showEmployee.png");
    }

}
