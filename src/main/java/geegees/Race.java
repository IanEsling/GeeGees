package geegees;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Race {
    private String venue;
    private String time;
    private Integer numberOfRunners;

    public Race(Document document) {
        venue = document.select("h1 > span").get(0).text();
        time = document.select("h1 > strong").get(0).text();
        for (Element shortInfo :  document.select("p.raceShortInfo > span")) {
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
}
