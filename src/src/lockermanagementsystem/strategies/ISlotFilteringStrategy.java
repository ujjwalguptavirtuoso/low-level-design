package lockermanagementsystem.strategies;

import lockermanagementsystem.model.LockerItem;
import lockermanagementsystem.model.Slot;
import lombok.NonNull;

import java.util.List;

public interface ISlotFilteringStrategy {

    List<Slot> filterSlots(@NonNull List<Slot> slots, @NonNull LockerItem lockerItem);
}
