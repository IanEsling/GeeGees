package geegees;

import geegees.model.Race;
import geegees.service.ExcelService;
import geegees.service.RacingPostRaceService;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        Collection<Race> races = new RacingPostRaceService().getRaces();
        new ExcelService().createSpreadsheet(races);
    }
}
