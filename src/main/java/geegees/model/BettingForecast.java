package geegees.model;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class BettingForecast {
    Logger logger = LoggerFactory.getLogger(BettingForecast.class);

    Collection<Horse> horses = newArrayList();

    public BettingForecast() {}

    public BettingForecast(Element element) {
        logger.info("loading betting forecast...");
        final Collection<String> favouriteNames = newArrayList();
        Elements favourites = element.getElementsByTag("b");
        for (Element favourite : favourites) {
            String favouriteName = favourite.getElementsByTag("a").get(0).text();
            favouriteNames.add(favouriteName);
            horses.add(new Horse(favouriteName, favourite.textNodes().get(0).text().trim()));
        }

        logger.info("getting names and odds from element : " + element.getElementsByTag("p").get(0));
        List<TextNode> odds = newArrayList(Collections2.filter(element.getElementsByTag("p").get(0).textNodes(),
                new Predicate<TextNode>() {
                    @Override
                    public boolean apply(TextNode node) {
                        return node.text().length() > 2;
                    }
                }));
        List<Element> names = newArrayList(Collections2.filter(element.getElementsByTag("p").get(0).getElementsByTag("a"),
                new Predicate<Element>() {
                    @Override
                    public boolean apply(Element name) {
                        return !favouriteNames.contains(name.text());
                    }
                }));

        logger.info("getting odds : " + odds);
        logger.info("for horses : " + names);
        for (int i = 0; i <= names.size() - 1; i++) {
            horses.add(new Horse(names.get(i).text(), odds.get(i).text().substring(2).trim()));
        }
    }

    public Collection<Horse> getHorses() {
        return horses;
    }

    public void setHorses(Collection<Horse> horses) {
        this.horses = horses;
    }
}
