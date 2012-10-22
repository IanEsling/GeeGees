package geegees.service;

import com.google.common.base.Function;
import geegees.model.Horse;
import geegees.model.Race;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;
import static geegees.builders.BettingForecastBuilder.bettingForecastBuilder;
import static geegees.builders.HorseBuilder.horseBuilder;
import static geegees.builders.RaceBuilder.raceBuilder;
import static geegees.builders.TipsDecoratorBuilder.tipsDecoratorBuilder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class RacingPostRaceServiceTest {

    @Mock
    RacingPostDocumentService racingPostDocumentService;

    @InjectMocks
    RacingPostRaceService racingPostRaceService = new RacingPostRaceService();

    @Test
    public void getRaces() {
        Document doc1 = new Document("url1");
        Document doc2 = new Document("url2");
        List<Horse> horses1 = newArrayList(horseBuilder().name("1").odds("1/1").build(), horseBuilder().name("4").odds("4/4").build(), horseBuilder().name("5").odds("5/5").build());
        List<Horse> horses2 = newArrayList(horseBuilder().name("2").odds("2/2").build(), horseBuilder().name("3").odds("3/3").build());
        Collection<Horse> tips1 = addTips(horses1);
        Collection<Horse> tips2 = addTips(horses2);
        given(racingPostDocumentService.getRaceUrls()).willReturn(newArrayList("url1", "url2"));
        given(racingPostDocumentService.getRacePage("url1")).willReturn(doc1);
        given(racingPostDocumentService.getRacePage("url2")).willReturn(doc2);
        given(racingPostDocumentService.getRace(doc1)).willReturn(
                raceBuilder().venue("Venue 1").time("time 1").numberOfRunners(3).build());
        given(racingPostDocumentService.getRace(doc2)).willReturn(
                raceBuilder().venue("Venue 2").time("time 2").numberOfRunners(2).build());
        given(racingPostDocumentService.getBettingForecast(doc1)).willReturn(
                bettingForecastBuilder().horses(horses1).build());
        given(racingPostDocumentService.getBettingForecast(doc2)).willReturn(
                bettingForecastBuilder().horses(horses2).build());
        given(racingPostDocumentService.getTipsDecorator(doc1, horses1)).willReturn(
                tipsDecoratorBuilder().horses(tips1).build());
        given(racingPostDocumentService.getTipsDecorator(doc2, horses2)).willReturn(
                tipsDecoratorBuilder().horses(tips2).build());

        assertEquals("no races", 2, racingPostRaceService.getRaces().size());
        Race race1 = getRaceByVenue(racingPostRaceService.getRaces(), "Venue 1");
        Race race2 = getRaceByVenue(racingPostRaceService.getRaces(), "Venue 2");
        assertEquals("wrong time for race1", "time 1", race1.getTime());
        assertEquals("wrong number of runners for race 1", 3, race1.getNumberOfRunners().intValue());
        assertEquals("wrong number of horses for race 1", 3, race1.getHorses().size());

        assertEquals("wrong time for race2", "time 2", race2.getTime());
        assertEquals("wrong number of runners for race 2", 2, race2.getNumberOfRunners().intValue());
        assertEquals("wrong number of horses for race 2", 2, race2.getHorses().size());
    }

    private Race getRaceByVenue(Collection<Race> races, String venue) {
        for (Race race : races) {
            if (race.getVenue().equals(venue)) {
                return race;
            }
        }
        fail("couldn't find race for venue " + venue + " in races " + races);
        return null;
    }

    private Collection<Horse> addTips(List<Horse> horses) {
        return transform(horses, new Function<Horse, Horse>() {
            @Override
            public Horse apply(Horse horse) {
                horse.setTips(Integer.valueOf(horse.getName()));
                return horse;
            }
        });
    }
}