package geegees.service;

import geegees.model.Race;
import org.jsoup.nodes.Document;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class RacingPostRaceService {

    RacingPostDocumentService racingPostDocumentService;

    public RacingPostRaceService() {
        this.racingPostDocumentService = new RacingPostDocumentService();
    }

    public Collection<Race> getRaces() {
        List<Race> races = newArrayList();
        Collection<String> raceUrls = racingPostDocumentService.getRaceUrls();
        for (String url : raceUrls) {
            Document racePage = racingPostDocumentService.getRacePage(url);
            Race race = racingPostDocumentService.getRace(racePage);
            race.setHorses(racingPostDocumentService.getTipsDecorator(racePage,
                    racingPostDocumentService.getBettingForecast(racePage).getHorses()).getHorses());
            races.add(race);
        }
        Collections.sort(races);
        return races;
    }

}
