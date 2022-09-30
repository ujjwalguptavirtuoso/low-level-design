package ticketbookingsystem.provider;

import ticketbookingsystem.model.Seat;
import ticketbookingsystem.model.SeatLock;
import ticketbookingsystem.model.Show;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatLockProviderInMemory implements SeatLockProvider{

    private  Integer lockTimeout; // Bonus feature.
    private  Map<Show, Map<Seat, SeatLock>> locks;

    public SeatLockProviderInMemory( final Integer lockTimeout) {
        this.locks = new HashMap<>();
        this.lockTimeout = lockTimeout;
    }

    @Override
    public synchronized void lockSeats(Show show, List<Seat> seats, String user) {
        for (Seat seat : seats) {
            lockSeat(show, seat, user, lockTimeout);
        }
    }

    @Override
    public void unlockSeats(Show show, List<Seat> seat, String user) {

    }

    @Override
    public boolean validateLock(Show show, Seat seat, String user) {
        return false;
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
        return null;
    }

    private void unlockSeat(final Show show, final Seat seat) {
        if (!locks.containsKey(show)) {
            return;
        }
        locks.get(show).remove(seat);
    }

    public boolean validateLock(final Show show, final Seat seat,  final String user) {
        return isSeatLocked(show, seat) && locks.get(show).get(seat).getLockedBy().equals(user);
    }

    private void lockSeat(final Show show, final Seat seat, final String user, final Integer timeoutInSeconds) {
        if (!locks.containsKey(show)) {
            locks.put(show, new HashMap<>());
        }
        final SeatLock lock = new SeatLock(seat, show, timeoutInSeconds, new Date(), user);
        locks.get(show).put(seat, lock);
    }

    private boolean isSeatLocked(final Show show, final Seat seat) {
        return locks.containsKey(show) && locks.get(show).containsKey(seat) && !locks.get(show).get(seat).isLockExpired();
    }
}
