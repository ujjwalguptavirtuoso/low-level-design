package openclosedprinciple.good;

import openclosedprinciple.NotificationType;

import java.util.Map;

public class NotificationProviderFactory {

    Map<NotificationType, NotificationProvider> providers;

    public NotificationProvider getNotificationProvider(final NotificationType notificationType){
        return providers.get(notificationType);
    }
}
