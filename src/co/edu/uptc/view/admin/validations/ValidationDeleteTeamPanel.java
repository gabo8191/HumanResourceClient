package co.edu.uptc.view.admin.validations;

import java.awt.event.ActionListener;

import co.edu.uptc.view.admin.SearchPanel;

public class ValidationDeleteTeamPanel extends SearchPanel {

    public ValidationDeleteTeamPanel(ActionListener listener) {
        super(listener, "Eliminar equipo", "Ingrese el nombre del equipo a eliminar", "SearchDeleteTeam",
                "SendDeleteTeam",
                "Equipo", "Área", "Eliminar", "src/co/edu/uptc/view/assets/img/deleteTeam.jpg");
    }
}
