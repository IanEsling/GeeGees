package geegees.model;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class BettingForecast {
    Logger logger = LoggerFactory.getLogger(BettingForecast.class);

    Collection<Horse> horses = newArrayList();

    public BettingForecast(Element element) {
        logger.info("loading betting forecast...");
        Element favourite = element.getElementsByTag("b").get(0);
        final String favouriteName = favourite.getElementsByTag("a").get(0).text();
        horses.add(new Horse(favouriteName, favourite.textNodes().get(0).text().trim()));

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
                        return !name.text().equals(favouriteName);
                    }
                }));

        for (int i = 0; i <= names.size() - 1; i++) {
            horses.add(new Horse(names.get(i).text(), odds.get(i).text().substring(2).trim()));
        }
    }

    public Collection<Horse> getHorses() {
        return horses;
    }

}
