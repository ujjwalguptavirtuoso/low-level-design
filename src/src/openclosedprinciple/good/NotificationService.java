package openclosedprinciple.good;

import openclosedprinciple.Notification;

public class NotificationService implements NotificationProvider{

    NotificationProviderFactory notificationProviderFactory;

    public void setNotificationProviderFactory(NotificationProviderFactory notificationProviderFactory) {
        this.notificationProviderFactory = notificationProviderFactory;
    }


    @Override
    public void send(Notification notification) {
        notificationProviderFactory.getNotificationProvider(notification.getNotificationType()).send(notification);
    }
}
