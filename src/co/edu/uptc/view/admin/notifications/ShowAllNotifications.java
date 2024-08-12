package co.edu.uptc.view.admin.notifications;

import java.awt.event.ActionListener;

import co.edu.uptc.view.generals.ShowGeneralNotifications;

public class ShowAllNotifications extends ShowGeneralNotifications {

  public ShowAllNotifications(ActionListener listener) {
    super(listener, new String[] { "Nombre del empleado", "Fecha de notificación", "Descripción" },
        "src/co/edu/uptc/view/assets/img/NotificationAdmin.jpg", "NextNotificationAdmin");
  }
}
