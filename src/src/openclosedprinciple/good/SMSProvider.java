package openclosedprinciple.good;

import openclosedprinciple.EmailThirdParty;
import openclosedprinciple.Notification;
import openclosedprinciple.SMSThirdParty;

public class SMSProvider implements NotificationProvider{

    SMSThirdParty smsThirdParty;

    @Override
    public void send(Notification notification) {
         smsThirdParty.sendSMS(notification.getMessage());
    }
}
