package geegees.builders;

import geegees.model.Race;

public class RaceBuilder {

    private String time;
    private String venue;
    private Integer numberOfRunners;

    private RaceBuilder(){}

    public static RaceBuilder raceBuilder(){
        return new RaceBuilder();
    }

    public Race build(){
        Race race = new Race();
        race.setTime(time);
        race.setVenue(venue);
        race.setNumberOfRunners(numberOfRunners);
        return race;
    }

    public RaceBuilder time(String time) {
        this.time = time;
        return this;
    }

    public RaceBuilder venue(String venue) {
        this.venue = venue;
        return this;
    }

    public RaceBuilder numberOfRunners(Integer numberOfRunners) {
        this.numberOfRunners = numberOfRunners;
        return this;
    }
}
