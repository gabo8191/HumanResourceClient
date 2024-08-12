package co.edu.uptc.view.admin.validations;

import java.awt.event.ActionListener;

import co.edu.uptc.view.admin.SearchPanel;

public class ValidationShowTeam extends SearchPanel {

    public ValidationShowTeam(ActionListener listener) {
        super(listener, "Buscar equipo", "Por favor ingrese el ID del equipo a buscar", "SearchShowTeam",
                "SendShowTeam",
                "Equipo", "Área",
                "Buscar", "src/co/edu/uptc/view/assets/img/showTeam.jpg");
    }

}
