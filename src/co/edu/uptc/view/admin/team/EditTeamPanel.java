package co.edu.uptc.view.admin.team;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.ShowTeamGeneralPanel;

public class EditTeamPanel extends ShowTeamGeneralPanel {

    public EditTeamPanel(ActionListener listener) {
        super(listener, new String[] { "Id del equipo", "Líder del equipo", "Id del líder" },
                "src/co/edu/uptc/view/assets/img/editTeam.jpg",
                true,
                "Editar",
                "SaveEditTeam", false);
        this.setTitle("Editar equipo");
    }

}
