package geegees.service;

import geegees.model.BettingForecast;
import geegees.model.Race;
import org.jsoup.nodes.Document;

public class RacingPostDocumentService {
    public Race getRace(Document document) {
        return new Race(document);
    }

    public BettingForecast getBettingForecast(Document document) {
        return new BettingForecast(document.select("div.info").get(0));
    }
}
