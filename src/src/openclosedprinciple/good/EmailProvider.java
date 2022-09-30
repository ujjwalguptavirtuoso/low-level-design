package openclosedprinciple.good;

import openclosedprinciple.EmailThirdParty;
import openclosedprinciple.Notification;

public class EmailProvider implements NotificationProvider{

    EmailThirdParty emailThirdParty;

    @Override
    public void send(Notification notification) {
          emailThirdParty.sendEmail(notification.getMessage());
    }
}
