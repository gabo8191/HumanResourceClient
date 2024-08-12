package co.edu.uptc.view.admin.employee;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.ShowEmployeeGeneralPanel;

public class EditEmployeePanel extends ShowEmployeeGeneralPanel {

    public EditEmployeePanel(ActionListener listener) {
        super(listener,
                new String[] { "Es administrador", "Es líder", "Identificación", "Salario bruto", "Salario neto",
                        "Área", "Identificación del equipo" },
                "src/co/edu/uptc/view/assets/img/editEmployee.jpg", true, "Editar",
                "SaveEditEmployee", false, false);
        this.setTitle("Editar empleado");
    }
}
