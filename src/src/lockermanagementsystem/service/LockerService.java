package lockermanagementsystem.service;

import lockermanagementsystem.model.Locker;
import lockermanagementsystem.model.LockerItem;
import lockermanagementsystem.model.Size;
import lockermanagementsystem.model.Slot;
import lockermanagementsystem.repository.ILockerRepository;
import lockermanagementsystem.strategies.ISlotAssignmentStrategy;
import lockermanagementsystem.strategies.ISlotFilteringStrategy;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

public class LockerService {

    private final ILockerRepository lockerRepository;
    private final ISlotFilteringStrategy slotFilteringStrategy;
    private final ISlotAssignmentStrategy slotAssignmentStrategy;

    public LockerService(ILockerRepository lockerRepository, ISlotFilteringStrategy slotFilteringStrategy, ISlotAssignmentStrategy slotAssignmentStrategy) {
        this.lockerRepository = lockerRepository;
        this.slotFilteringStrategy = slotFilteringStrategy;
        this.slotAssignmentStrategy = slotAssignmentStrategy;
    }

    public Locker createLocker(final String lockerId){
        return lockerRepository.createLocker(lockerId);
    }

    public List<Slot> getAllAvailableSlots(){
        return lockerRepository.getAllAvailableSlots();
    }

    public Slot createSlot(final Locker locker, final Size slotSize) {
        final Slot slot = new Slot(UUID.randomUUID().toString(), slotSize, locker);
        locker.addSlot(slot);
        return slot;
    }

    public Slot allocateSlot(@NonNull final LockerItem lockerItem) {

        final List<Slot> allAvailableSlots = lockerRepository.getAllAvailableSlots();
        final List<Slot> filteredSlots = slotFilteringStrategy.filterSlots(allAvailableSlots, lockerItem);
        final Slot slotToBeAllocated = slotAssignmentStrategy.pickSlot(filteredSlots);

        if (slotToBeAllocated == null) {
            //throw new NoSlotAvailableException();
        }

        slotToBeAllocated.allocatePackage(lockerItem);
        return slotToBeAllocated;
    }

    void deAllocateSlot(final Slot slot){

    }

}
