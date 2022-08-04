package lockermanagementsystem.controller;

import lockermanagementsystem.model.Buyer;
import lockermanagementsystem.model.LockerItem;
import lockermanagementsystem.model.Slot;
import lockermanagementsystem.service.LockerService;
import lockermanagementsystem.service.NotificationService;
import lockermanagementsystem.service.OtpService;
import lombok.NonNull;

public class OrderController {

    private final OtpService otpService;
    private final NotificationService notificationService;
    private final LockerService lockerService;

    public OrderController(@NonNull final NotificationService notificationService,
                           @NonNull final OtpService otpService,
                           @NonNull final LockerService lockerService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
        this.notificationService = notificationService;
    }

    public Slot allocateLocker(@NonNull final Buyer buyer, @NonNull final LockerItem lockerItem) {
        final Slot slot = lockerService.allocateSlot(lockerItem);
        final String otp = otpService.generateOtp(slot);
        notificationService.notifyUser(buyer, otp, slot);
        return slot;
    }

}
