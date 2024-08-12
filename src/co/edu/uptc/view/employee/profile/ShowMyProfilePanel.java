package co.edu.uptc.view.employee.profile;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.ShowEmployeeGeneralPanel;

public class ShowMyProfilePanel extends ShowEmployeeGeneralPanel {

    public ShowMyProfilePanel(ActionListener listener) {

        super(listener,
                new String[] { "Nombre", "Apellido", "Identificación", "Año de nacimiento", "Mes de nacimiento",
                        "Día de nacimiento", "Género", "Ciudad", "Correo electrónico", "Teléfono", "Área", "Cargo",
                        "Es administrador", "Es líder", "Salario bruto", "Salario neto",
                        "Identificación del equipo",
                }, "src/co/edu/uptc/view/assets/img/showMyProfile.jpg", false, null, null, true, false);
        this.setTitle("Mi perfil");
    }

}
