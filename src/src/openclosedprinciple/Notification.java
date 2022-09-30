package openclosedprinciple;

import lombok.Getter;

@Getter
public class Notification {

    private final String message;
    private final NotificationType notificationType;

    public Notification(String message, NotificationType notificationType) {
        this.message = message;
        this.notificationType = notificationType;
    }
}
