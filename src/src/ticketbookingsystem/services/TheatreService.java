package ticketbookingsystem.services;

import ticketbookingsystem.model.Screen;
import ticketbookingsystem.model.Seat;
import ticketbookingsystem.model.Theatre;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TheatreService {

    private Map<String, Theatre>  theatreMap;
    private  Map<String, Screen> screenMap;
    private  Map<String, Seat> seatMap;

    public TheatreService(){
        this.theatreMap = new HashMap<>();
        this.screenMap = new HashMap<>();
        this.seatMap = new HashMap<>();
    }

    public Theatre createTheatre(String name){
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre = new Theatre(theatreId, name);
        theatreMap.put(theatreId, theatre);
        return theatre;
    }

    public Screen createScreenInTheatre(String screenName,Theatre theatre) {
        Screen screen = createScreen(screenName, theatre);
        theatre.addScreen(screen);
        return screen;
    }

    public Seat createSeatInScreen(final Integer rowNo,  Integer seatNo, Screen screen) {
        String seatId = UUID.randomUUID().toString();
        Seat seat = new Seat(seatId, rowNo, seatNo);
        seatMap.put(seatId, seat);
        screen.addSeat(seat);

        return seat;
    }

    private Screen createScreen(final String screenName, final Theatre theatre) {
        String screenId = UUID.randomUUID().toString();
        Screen screen = new Screen(screenId, screenName, theatre);
        screenMap.put(screenId, screen);
        return screen;
    }

    public Screen getScreen(String screenId){
        if(screenMap.get(screenId) == null){
            //throw not found exception
        }
        return screenMap.get(screenId);
    }

    public  Theatre getTheatre(String theatreId){
        if(theatreMap.get(theatreId) == null){
            //throw not found exception
        }

        return theatreMap.get(theatreId);
    }



}
