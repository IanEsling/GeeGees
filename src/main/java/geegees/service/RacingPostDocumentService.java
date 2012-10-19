package geegees.service;

import geegees.model.BettingForecast;
import geegees.model.Horse;
import geegees.model.Race;
import geegees.model.TipsDecorator;
import org.jsoup.nodes.Document;

import java.util.List;

public class RacingPostDocumentService {
    public Race getRace(Document document) {
        return new Race(document);
    }

    public BettingForecast getBettingForecast(Document document) {
        return new BettingForecast(document.select("div.info").get(0));
    }

    public TipsDecorator getTipsDecorator(Document document, List<Horse> horses) {
        return new TipsDecorator(document, horses);
    }
}
