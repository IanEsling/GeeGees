package geegees.model;

import geegees.model.BettingForecast;
import geegees.model.Horse;
import org.jsoup.Jsoup;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BettingForecastTest {

    BettingForecast bettingForecast;
    Map<String, String> horses;

    @Before
    public void setHorseNames(){
        horses = newHashMap();
        horses.put("Kingdom", "10/11");
        horses.put("Sophisticated Heir", "5/1");
        horses.put("Lucky Kitten", "12/1");
        horses.put("Pay Day Kitten", "16/1");
        horses.put("Rock N Rover", "20/1");
        horses.put("Tale Of Fame", "25/1");
    }

    @Test
    public void shouldParseBettingForecastHtml(){
        bettingForecast = new BettingForecast(Jsoup.parse(getBettingForecastHTML()));
        assertTrue("wrong number of horses", bettingForecast.getHorses().size() == 6);
        for (Horse horse : bettingForecast.getHorses()) {
            assertTrue("horse not found", horses.keySet().contains(horse.getName()));
            assertEquals("horse odds not correct", horses.get(horse.getName()), horse.getOdds());
        }
    }

    private String getBettingForecastHTML() {
        return "<html><head></head><body>" +
                "<p>" +
                "<strong>BETTING FORECAST:</strong>" +
                "<b>10/11 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=800437\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">Kingdom</a></b>" +
                ", 5/1 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=818910\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">Sophisticated Heir</a>" +
                ", 12/1 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=816284\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">Lucky Kitten</a>" +
                ", 16/1 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=821766\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">Pay Day Kitten</a>" +
                ", 20/1 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=820782\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">Rock N Rover</a>" +
                ", 25/1 <a href=\"http://www.racingpost.com/horses/horse_home.sd?horse_id=816846\" onclick=\"scorecards.send(&quot;horse_name&quot;);return Html.popup(this, {width:695, height:800})\" title=\"Full details about this HORSE\">Tale Of Fame</a>" +
                ".</p>" +
                "</body></html>";
    }
}
