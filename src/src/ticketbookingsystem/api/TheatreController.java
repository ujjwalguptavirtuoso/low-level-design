package ticketbookingsystem.api;

import ticketbookingsystem.model.Screen;
import ticketbookingsystem.model.Theatre;
import ticketbookingsystem.services.TheatreService;


public class TheatreController {

    private TheatreService theatreService;

    public String createTheatre( String theatreName) {
        return theatreService.createTheatre(theatreName).getId();
    }

    public String createScreenInTheatre( String screenName,  String theatreId) {
        final Theatre theatre = theatreService.getTheatre(theatreId);
        return theatreService.createScreenInTheatre(screenName, theatre).getId();
    }

    public String createSeatInScreen(Integer rowNo, Integer seatNo, String screenId) {
        final Screen screen = theatreService.getScreen(screenId);
        return theatreService.createSeatInScreen(rowNo, seatNo, screen).getId();
    }


}
