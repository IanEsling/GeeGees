package geegees.model;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Collection;

public class Race implements Comparable<Race> {
    private String venue;
    private String time;
    private Integer numberOfRunners;
    private Collection<Horse> horses;

    public Race() {}

    public Race(Document document) {
        venue = document.select("h1 > span").get(0).text();
        time = document.select("h1 > strong").get(0).text();
        for (Element shortInfo : document.select("p.raceShortInfo > span")) {
            if ("Runners:".equals(shortInfo.textNodes().get(0).text().trim())) {
                numberOfRunners = Integer.valueOf(shortInfo.select("strong").get(0).text());
            }
        }
    }

    public String getVenue() {
        return venue;
    }

    public String getTime() {
        return time;
    }

    public Integer getNumberOfRunners() {
        return numberOfRunners;
    }

    public Collection<Horse> getHorses() {
        return horses;
    }

    public void setHorses(Collection<Horse> horses) {
        this.horses = horses;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setNumberOfRunners(Integer numberOfRunners) {
        this.numberOfRunners = numberOfRunners;
    }

    @Override
    public int compareTo(Race race) {
        if (race.getVenue().equals(getVenue())) {
            return getTime().compareTo(race.getTime());
        } else {
            return getVenue().compareTo(race.getVenue());
        }
    }
}
