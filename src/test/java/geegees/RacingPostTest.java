package geegees;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class RacingPostTest {

    @Mock
    RacingPostService racingPostService;

    List<String> raceUrls;
    private String baseURL;

    @Before
    public void loadRacePage() throws IOException {
        baseURL = "http://betting.racingpost.com";
        Document racePage = Jsoup.connect(baseURL + "/horses/cards").get();
        raceUrls = newArrayList();
        getRaceUrlsForColumn(racePage, "leftColumn");
        getRaceUrlsForColumn(racePage, "rightColumn");
    }

    @Test
    public void getBettingForecastForEachRace() throws IOException {
//        given(racingPostService.getForecast(anyString())).willReturn()
        List<Element> forecast = newArrayList();
        for (String url : raceUrls) {
            Document race = Jsoup.connect(baseURL + url).timeout(10000).get();
            forecast = race.getElementsByClass("cardFooter").get(0).getElementsByTag("p");
            System.out.println(forecast.get(0).textNodes());
            System.out.println(forecast.get(0).children());
            assertEquals(forecast.get(0).children().first().tagName(), "strong");
        }
    }

    private void getRaceUrlsForColumn(Document racePage, String column) {
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
