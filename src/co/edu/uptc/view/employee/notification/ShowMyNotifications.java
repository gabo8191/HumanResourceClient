package co.edu.uptc.view.employee.notification;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.ShowGeneralNotifications;

public class ShowMyNotifications extends ShowGeneralNotifications {

  public ShowMyNotifications(ActionListener listener) {
    super(listener, new String[] { "Nombre del empleado", "Fecha de notificación", "Descripción" },
        "src/co/edu/uptc/view/assets/img/NotificationEmployee.jpg", "NextNotificationEmployee");
  }

}
