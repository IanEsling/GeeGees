package geegees.service;

import geegees.model.Race;
import org.jsoup.nodes.Document;

import java.util.Collection;

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
