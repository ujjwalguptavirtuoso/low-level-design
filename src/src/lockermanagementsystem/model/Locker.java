package lockermanagementsystem.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Locker {

    private String id;
    private List<Slot> slots;

    public Locker(String id) {
        this.id = id;
        this.slots = new ArrayList<>();
    }

    public List<Slot> getAvailableSlots(){
        final List<Slot> result = new ArrayList<>();
        for (Slot slot : this.slots) {
            if (slot.isAvailable()) {
                result.add(slot);
            }
        }
        return result;
    }

    public void addSlot(Slot slot){
        slots.add(slot);
    }
}
