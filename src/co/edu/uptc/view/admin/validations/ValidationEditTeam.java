package co.edu.uptc.view.admin.validations;

import java.awt.event.ActionListener;

import co.edu.uptc.view.admin.SearchPanel;

public class ValidationEditTeam extends SearchPanel {

    public ValidationEditTeam(ActionListener listener) {
        super(listener, "Buscar equipo", "Por favor ingrese el ID del equipo a editar", "SearchEditTeam",
                "SendEditTeam", "Equipo", "Área",
                "Buscar", "src/co/edu/uptc/view/assets/img/editTeam.jpg");
    }

}
