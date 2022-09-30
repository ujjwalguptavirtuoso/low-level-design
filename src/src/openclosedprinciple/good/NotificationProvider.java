package openclosedprinciple.good;

import openclosedprinciple.Notification;

public interface NotificationProvider {

    void send (Notification notification);
}
