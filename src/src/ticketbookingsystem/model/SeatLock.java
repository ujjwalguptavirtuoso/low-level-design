package ticketbookingsystem.model;

import java.util.Date;

public class SeatLock {

    private Seat seat;
    private Show show;
    private Integer timeoutInSeconds;
    private Date lockTime;
    private String lockedBy; // userId

    boolean isLockExpired(){
        return true;
    }
}
