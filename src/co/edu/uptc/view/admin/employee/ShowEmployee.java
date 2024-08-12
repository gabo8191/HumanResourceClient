package co.edu.uptc.view.admin.employee;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.ShowEmployeeGeneralPanel;

public class ShowEmployee extends ShowEmployeeGeneralPanel {

    public ShowEmployee(ActionListener listener) {
        super(listener,
                new String[] { "Nombre", "Apellido", "Identificación", "Año de nacimiento", "Mes de nacimiento",
                        "Día de nacimiento", "Género", "Ciudad", "Correo electrónico", "Teléfono", "Área", "Cargo",
                        "Es administrador", "Es líder", "Salario bruto", "Salario neto", "Identificación del equipo" },
                "src/co/edu/uptc/view/assets/img/showMyProfile.jpg",
                false, null, null, false, false);
        this.setTitle("Perfil del empleado");
    }

}
