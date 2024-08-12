package co.edu.uptc.view.employee.profile;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.ShowEmployeeGeneralPanel;

public class EditMyProfilePanel extends ShowEmployeeGeneralPanel {

    public EditMyProfilePanel(ActionListener listener) {
        super(listener,
                new String[] { "Nombre", "Apellido", "Identificación", "Año de nacimiento", "Mes de nacimiento",
                        "Día de nacimiento", "Género", "Área", "Cargo",
                        "Es administrador", "Es líder", "Salario bruto", "Salario neto",
                        "Identificación del equipo" },
                "src/co/edu/uptc/view/assets/img/editMyProfile.jpg", true, "Editar", "SaveEditMyProfile", true, false);
        this.setTitle("Editar mi perfil");
    }
}
