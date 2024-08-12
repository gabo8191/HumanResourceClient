package co.edu.uptc.view.admin.employee;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.ShowEmployeeGeneralPanel;

public class AddEmployeePanel extends ShowEmployeeGeneralPanel {

    public AddEmployeePanel(ActionListener listener) {
        super(listener, new String[] {}, "src/co/edu/uptc/view/assets/img/addEmployee.jpg", true, "Agregar",
                "SaveAddEmployee", false, true);
        this.setTitle("Agregar empleado");
    }

}
