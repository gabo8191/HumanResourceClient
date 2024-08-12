package co.edu.uptc.view.admin.team;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.ShowTeamGeneralPanel;

public class AddTeamPanel extends ShowTeamGeneralPanel {

    public AddTeamPanel(ActionListener listener) {
        super(listener, new String[] {}, "src/co/edu/uptc/view/assets/img/addTeam.jpg", true, "Agregar",
                "SaveAddTeam", true);
        this.setTitle("Nuevo equipo");
    }
}
