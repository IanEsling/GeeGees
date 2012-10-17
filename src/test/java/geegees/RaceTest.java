package geegees;

import org.jsoup.Jsoup;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RaceTest {

    Race race;

    @Test
    public void shouldGetRaceDetails() {
        race = new Race(Jsoup.parse(getRaceHtml()));
        assertEquals("wrong venue for race", "Kempton (AW)", race.getVenue());
        assertEquals("wrong time for race", "6:10", race.getTime());
        assertEquals("wrong number of runners for race", 12, race.getNumberOfRunners().intValue());
    }

    private String getRaceHtml() {
        return "<div class=\"leftCol\">\n" +
                " <h1 class=\"cardHeadline\">\n" +
                " <strong>6:10</strong>\n" +
                " <span>\n" +
                " Kempton (AW) </span>\n" +
                " <em>\n" +
                " HORSE RACING\n" +
                " TODAY </em>\n" +
                " </h1>\n" +
                "\n" +
                " <!-- start race info -->\n" +
                " <h2 class=\"raceTitle\">\n" +
                " <strong>Back Or Lay At betdaq.com Handicap</strong>\n" +
                "\n" +
                " (CLASS 6) (3yo+ 0-55) </h2>\n" +
                " <p class=\"raceShortInfo clearfix\">\n" +
                " <span>Winner: <strong>£1,617</strong></span>\n" +
                " <span>Runners: <strong>12</strong></span> <span>Distance: <strong>5f</strong></span> <span>Going: <strong>Standard </strong></span>\n" +
                " <span>Channel:\n" +
                " <em>RUK</em> </span> </p>\n" +
                " <!-- end race info -->\n" +
                " </div>";
    }
}
