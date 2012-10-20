package geegees.service;

import com.google.common.base.Function;
import geegees.model.Horse;
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
        List<Horse> horses1 = newArrayList(horseBuilder().name("1").odds("1/1").build());
        List<Horse> horses2 = newArrayList(horseBuilder().name("2").odds("2/2").build(), horseBuilder().name("3").odds("3/3").build());
        Collection<Horse> tips1 = addTips(horses1);
        Collection<Horse> tips2 = addTips(horses2);
        given(racingPostDocumentService.getRaceUrls()).willReturn(newArrayList("url1", "url2"));
        given(racingPostDocumentService.getRacePage("url1")).willReturn(doc1);
        given(racingPostDocumentService.getRacePage("url2")).willReturn(doc2);
        given(racingPostDocumentService.getRace(doc1)).willReturn(
                raceBuilder().venue("Venue 1").time("time 1").numberOfRunners(1).build());
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

//for (String url : raceUrls) {
//        Document racePage = racingPostDocumentService.getRacePage(url);
//Race race = racingPostDocumentService.getRace(racePage);
//race.setHorses(racingPostDocumentService.getTipsDecorator(racePage,
//        racingPostDocumentService.getBettingForecast(racePage).getHorses()).getHorses());
//races.add(race);
//}