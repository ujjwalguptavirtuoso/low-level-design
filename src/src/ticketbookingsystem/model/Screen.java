package ticketbookingsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    private String id;
    private String name;
    private Theatre theatre;
    private List<Seat> seatList;

    public Screen(String id, String name, Theatre theatre) {
        this.id = id;
        this.name = name;
        this.theatre = theatre;
        this.seatList = new ArrayList<>();
    }

    public void addSeat(Seat seat){
        this.seatList.add(seat);
    }


    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
