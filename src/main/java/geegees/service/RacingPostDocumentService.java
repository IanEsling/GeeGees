package geegees.service;

import geegees.model.Race;
import org.jsoup.nodes.Document;

public class RacingPostDocumentService {
    public Race getRace(Document document) {
        return new Race(document);
    }
}
