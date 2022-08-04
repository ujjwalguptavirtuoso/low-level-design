package lockermanagementsystem.repository;

import lockermanagementsystem.model.Locker;
import lockermanagementsystem.model.Slot;

import java.util.ArrayList;
import java.util.List;

public class LockerRepositoryInMemory implements ILockerRepository{
     private final List<Locker> allLockers;

    public LockerRepositoryInMemory() {
        this.allLockers = new ArrayList<>();
    }

    Locker getLocker(final String lockerId){
        for(Locker locker : this.allLockers){
            if(locker.getId().equals(lockerId)){
                return locker;
            }
        }
        return null;
    }

    @Override
    public Locker createLocker(String lockerId) {
        if(getLocker(lockerId)!= null){
            // allready exists locker
            return null; // or some exception
        }
        final Locker newLocker = new Locker(lockerId);
        allLockers.add(newLocker);
        return newLocker;
    }

    @Override
    public List<Slot> getAllAvailableSlots() {
        final List<Slot> result = new ArrayList<>();
        for (Locker locker : allLockers) {
            result.addAll(locker.getAvailableSlots());
        }
        return result;
    }


}
