package geegees;

import geegees.model.Race;
import geegees.service.ExcelService;
import jxl.write.WriteException;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;
import static geegees.builders.HorseBuilder.horseBuilder;
import static geegees.builders.RaceBuilder.raceBuilder;

public class ExcelCreatingTest {

    @Test
    public void writeRaceDetails() throws IOException, WriteException {
        ExcelService excelService = new ExcelService();
        Collection<Race> races = newArrayList(
                raceBuilder()
                        .time("time 1")
                        .venue("venue 1")
                        .numberOfRunners(1)
                        .horses(newArrayList(horseBuilder().name("1").odds("1/1").tips(1).build()))
                        .build(),
                raceBuilder()
                        .time("time 2")
                        .venue("venue 2")
                        .numberOfRunners(2)
                        .horses(newArrayList(
                                horseBuilder().name("2").odds("2/2").tips(2).build(),
                                horseBuilder().name("3").odds("3/3").tips(3).build()
                        ))
                        .build()
        );
        excelService.createSpreadsheet(races);
    }
}
