package co.edu.uptc.view.admin.bonifications;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.BonificationsEmployeeGeneralPanel;

public class BonificationsEmployeeAdmin extends BonificationsEmployeeGeneralPanel {

  public BonificationsEmployeeAdmin(ActionListener listener) {
    super(listener,
        new String[] { "Nombre", "Apellido", "Identificación", "Salario neto", "Días disponibles", "Total restantes" },
        "src/assets/img/employee.jpg", true);
  }

}
