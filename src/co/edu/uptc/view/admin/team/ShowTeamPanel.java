package co.edu.uptc.view.admin.team;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.ShowTeamGeneralPanel;

public class ShowTeamPanel extends ShowTeamGeneralPanel {

    public ShowTeamPanel(ActionListener listener) {
        super(listener,
                new String[] { "Nombre del equipo", "Id del equipo", "Área del equipo",
                        "Líder del equipo", "Id del líder" },
                "src/co/edu/uptc/view/assets/img/showTeam.jpg", false,
                "Mostrar",
                "SaveShowTeam", false);
        this.setTitle("Mostrar equipo");
    }

}
