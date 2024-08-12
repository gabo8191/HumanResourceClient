package co.edu.uptc.view.admin.requests;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.ShowGeneralRequests;

public class ShowRequestAdmin extends ShowGeneralRequests {

  public ShowRequestAdmin(ActionListener listener) {
    super(
        listener,
        new String[] { "Nombre del empleado", "Fecha de solicitud", "Tipo de solicitud", "Descripción",
            "Identificación del empleado" },
        "src/co/edu/uptc/view/assets/img/RequestAdmin.jpg", true);
  }
}
