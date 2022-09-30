package openclosedprinciple.bad;

import openclosedprinciple.EmailThirdParty;
import openclosedprinciple.Notification;
import openclosedprinciple.NotificationType;
import openclosedprinciple.SMSThirdParty;

public class NotificationService {

    private EmailThirdParty emailThirdParty;
    private SMSThirdParty smsThirdParty;

    public NotificationService(EmailThirdParty emailThirdParty, SMSThirdParty smsThirdParty) {
        this.emailThirdParty = emailThirdParty;
        this.smsThirdParty = smsThirdParty;
    }

    public void sendNotification(final Notification notification){
        if(notification.getNotificationType() == NotificationType.SMS){
            smsThirdParty.sendSMS(notification.getMessage());
        }else if(notification.getNotificationType() == NotificationType.EMAIL){
            emailThirdParty.sendEmail(notification.getMessage());
        }
    }
}
