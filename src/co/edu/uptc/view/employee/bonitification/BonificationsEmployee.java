package co.edu.uptc.view.employee.bonitification;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.BonificationsEmployeeGeneralPanel;

public class BonificationsEmployee extends BonificationsEmployeeGeneralPanel {

  public BonificationsEmployee(ActionListener listener) {
    super(listener,
        new String[] { "Nombre", "Apellido", "Identificación", "Salario bruto", "Auxilio de transporte", "Salario neto",
            "Valor del bono de productividad", "Valor del bono de aprendizaje", "Días disponibles", "Días a tomar",
            "Total restantes" },
        "src/assets/img/employee.jpg", false);
  }

}
