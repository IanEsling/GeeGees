package geegees.model;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Collection;

public class TipsDecorator {

    private final Collection<Horse> horses;

    public TipsDecorator(Document document, Collection<Horse> horses) {
        this.horses = horses;
        Elements runners = document.select("table#sc_sortBlock > tbody");
        for (Element runner : runners){
            String name = runner.select("td.h").get(0).getElementsByTag("b").get(0).text();
            Horse horse = getHorseByName(name);
            if (horse != null) {
                horse.setTips(Integer.valueOf(runner.select("div.tips").get(0).text()));
            }
        }
    }

    private Horse getHorseByName(String name) {
        for (Horse horse : horses) {
            if (horse.getName().equalsIgnoreCase(name)) {
                return horse;
            }
        }
        return null;
    }

    public Collection<Horse> getHorses() {
        return horses;
    }
}
