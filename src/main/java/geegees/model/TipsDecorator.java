package geegees.model;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;

public class TipsDecorator {
    Logger logger = LoggerFactory.getLogger(TipsDecorator.class);

    private Collection<Horse> horses = newArrayList();

    public TipsDecorator(Document document, Collection<Horse> horses) {
        logger.debug("decorating tips for document {}", document);
        this.horses = horses;
        Elements runners = document.select("table#sc_sortBlock > tbody");
        for (Element runner : runners){
            logger.debug("getting tips for runner {}", runner);
            String name = runner.select("td.h").get(0).getElementsByTag("b").get(0).text();
            Horse horse = getHorseByName(name);
            if (horse != null) {
                horse.setTips(Integer.valueOf(runner.select("div.tips").get(0).text()));
            }
        }
    }

    public TipsDecorator() {}

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

    public void setHorses(Collection<Horse> horses) {
        this.horses = horses;
    }
}
