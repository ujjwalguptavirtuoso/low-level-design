package lockermanagementsystem.service;

import lockermanagementsystem.model.Buyer;
import lockermanagementsystem.model.LockerUser;
import lockermanagementsystem.model.Slot;

public class NotificationService {

   public void notifyUser(LockerUser lockerUser, String otp, Slot slot){
        System.out.println("Sending notification of otp: " + otp + " to: " + lockerUser + " for slot: " + slot);
    }
}
