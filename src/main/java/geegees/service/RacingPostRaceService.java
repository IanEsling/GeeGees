package geegees.service;

import geegees.model.Race;
import geegees.model.TipsDecorator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class RacingPostRaceService {

    RacingPostDocumentService racingPostDocumentService;

    public RacingPostRaceService() {
        this.racingPostDocumentService = new RacingPostDocumentService();
    }

    public Collection<Race> getRaces() {
        Collection<Race> races = newArrayList();
        Collection<String> raceUrls = racingPostDocumentService.getRaceUrls();
        for (String url : raceUrls) {
            Document racePage = racingPostDocumentService.getRacePage(url);
            Race race = racingPostDocumentService.getRace(racePage);
            race.setHorses(racingPostDocumentService.getTipsDecorator(racePage,
                    racingPostDocumentService.getBettingForecast(racePage).getHorses()).getHorses());
            races.add(race);
        }
        return races;
    }

}
