package lockermanagementsystem.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class Slot {

    private final String slotId;
    private final Size size;
    private final Locker locker;
    private LockerItem currentLockerItem;
    private Date allocationDate;

    public Slot(String slotId, Size size, Locker locker) {
        this.slotId = slotId;
        this.size = size;
        this.locker = locker;
        this.currentLockerItem = null;
    }

    public synchronized void allocatePackage(LockerItem lockerItem){
        if(this.currentLockerItem != null){
            //throw some exception
        }
        this.currentLockerItem = lockerItem;
        this.allocationDate = new Date();
    }

    synchronized public void deallocateSlot() {
        this.currentLockerItem = null;
    }

    synchronized public boolean isAvailable() {
        return this.currentLockerItem == null;
    }

}
