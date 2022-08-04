package lockermanagementsystem.repository;

import lockermanagementsystem.model.Locker;
import lockermanagementsystem.model.Slot;

import java.util.List;

public interface ILockerRepository {

       Locker createLocker(String lockerId);

       List<Slot> getAllAvailableSlots();
}
