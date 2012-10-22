package geegees.builders;

import geegees.model.Horse;
import geegees.model.Race;

import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;

public class RaceBuilder {

    private String time;
    private String venue;
    private Integer numberOfRunners;
    private Collection<Horse> horses = newArrayList();

    private RaceBuilder(){}

    public static RaceBuilder raceBuilder(){
        return new RaceBuilder();
    }

    public Race build(){
        Race race = new Race();
        race.setTime(time);
        race.setVenue(venue);
        race.setNumberOfRunners(numberOfRunners);
        race.setHorses(horses);
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

    public RaceBuilder horses(Collection<Horse> horses) {
        this.horses = horses;
        return this;
    }

    public RaceBuilder horse(Horse horse) {
        this.horses.add(horse);
        return this;
    }
}
