package lockermanagementsystem.controller;

import lockermanagementsystem.model.Locker;
import lockermanagementsystem.model.Size;
import lockermanagementsystem.model.Slot;
import lockermanagementsystem.service.LockerService;
import lockermanagementsystem.service.OtpService;

import java.util.ArrayList;
import java.util.List;

public class LockerController {

    private final LockerService lockerService;
    private final OtpService otpService;

    public LockerController(final LockerService lockerService, final OtpService otpService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
    }

    public Locker createLocker(final String lockerId){
        return lockerService.createLocker(lockerId);
    }

    public Slot createSlot(final Locker locker, final Size slotSize){
          return lockerService.createSlot(locker, slotSize);
    }

    public List<Slot> getAvailableSlots(){
           return lockerService.getAllAvailableSlots();
    }

    public boolean unlockSlot(final Slot slot, final String otp){
        return otpService.validateOtp(slot, otp);
        //post validation some physical mechanism will open the slot
    }

    public void deAllocateSlot(final Slot slot){
           slot.deallocateSlot();
    }


}
