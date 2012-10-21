package geegees.service;

import geegees.model.BettingForecast;
import geegees.model.Horse;
import geegees.model.Race;
import geegees.model.TipsDecorator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class RacingPostDocumentService {
    Logger logger = LoggerFactory.getLogger(RacingPostDocumentService.class);
    private static final String RACING_POST_BASE_URL = "http://betting.racingpost.com";
    private static final int TIMEOUT = 60000;

    public Document getRacePage(String url) {
        try {
            logger.debug("loading race from URL {}", url);
            return Jsoup.connect(RACING_POST_BASE_URL + url).timeout(TIMEOUT).get();
        } catch (IOException e) {
            logger.error("error getting race URL: " + url, e);
        }
        return null;
    }

    public Race getRace(Document document) {
        Race race = new Race(document);
        logger.info("loading {} at {}", race.getTime(), race.getVenue());
        return race;
    }

    public BettingForecast getBettingForecast(Document document) {
        return new BettingForecast(document.select("div.info").get(0));
    }

    public TipsDecorator getTipsDecorator(Document document, Collection<Horse> horses) {
        return new TipsDecorator(document, horses);
    }

    public Collection<String> getRaceUrls() {
        Document racesPage = null;
        try {
            logger.info("looking for races...");
            racesPage = Jsoup.connect(RACING_POST_BASE_URL + "/horses/cards").timeout(TIMEOUT).get();
        } catch (IOException e) {
            logger.error("error trying to read from Racing Post website.", e);
        }
        Collection<String> raceUrls = newArrayList();
        getRaceUrlsForColumn(racesPage, "leftColumn", raceUrls);
        getRaceUrlsForColumn(racesPage, "rightColumn", raceUrls);
        logger.debug("loaded race URLs: {}", raceUrls);
        logger.info("found {} races...", raceUrls.size());
        return raceUrls;
    }

    private void getRaceUrlsForColumn(Document racePage, String column, Collection<String> raceUrls) {
        for (Element races : racePage.getElementsByClass(column)) {
            for (Element raceCourse : races.getElementsByTag("table")) {
                for (Element raceTime : raceCourse.getElementsByTag("strong")) {
                    List<Element> links = raceTime.getElementsByTag("a");
                    if (links.size() > 0) {
                        raceUrls.add(links.get(0).attr("href"));
                    }
                }
            }
        }
    }
}
