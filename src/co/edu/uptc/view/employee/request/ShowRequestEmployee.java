package co.edu.uptc.view.employee.request;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.ShowGeneralRequests;

public class ShowRequestEmployee extends ShowGeneralRequests {

  public ShowRequestEmployee(ActionListener listener) {
    super(
        listener,
        new String[] { "Nombre del empleado", "Fecha de solicitud", "Comentario", "Identificación del empleado" },
        "src/co/edu/uptc/view/assets/img/RequestEmployee.jpg", false);
  }

}
