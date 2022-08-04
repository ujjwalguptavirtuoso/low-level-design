package ticketbookingsystem.model;

import java.util.Date;

public class Show {

    private String id;
    private Screen screen;
    private Movie movie;
    private Date startTime;
    private Integer durationInMinutes;

    public Show(String id, Screen screen, Movie movie, Date startTime, Integer durationInMinutes) {
        this.id = id;
        this.screen = screen;
        this.movie = movie;
        this.startTime = startTime;
        this.durationInMinutes = durationInMinutes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
