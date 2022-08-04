package lockermanagementsystem.strategies;

import lockermanagementsystem.model.Slot;
import lombok.NonNull;

import java.util.List;

public interface ISlotAssignmentStrategy {

    Slot pickSlot(@NonNull List<Slot> slots);
}
