package geegees.service;

import geegees.model.Horse;
import geegees.model.Race;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class ExcelService {

    Logger logger = LoggerFactory.getLogger(ExcelService.class);
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy-HH:mm");

    public void createSpreadsheet(Collection<Race> races) {
        WritableWorkbook racesDoc = null;
        try {
            logger.info("creating spreadsheet...");
            racesDoc = Workbook.createWorkbook(new File(new File(System.getProperty("user.dir")), "races-" + format.format(new Date()) + ".xls"));
        } catch (IOException e) {
            logger.error("Error trying to write races to spreadsheet", e);
        }
        if (racesDoc != null) {
            WritableSheet sheet = racesDoc.createSheet("races", 0);

            WritableFont raceTitleFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD);
            WritableCellFormat raceTitleFormat = new WritableCellFormat(raceTitleFont);
            int row = 0;
            for (Race race : races) {
                logger.info("writing to spreadsheet for {}", race);
                try {
                    sheet.addCell(new Label(0, row, race.getVenue(), raceTitleFormat));
                    sheet.addCell(new Label(1, row, race.getTime(), raceTitleFormat));
                    sheet.addCell(new Label(2, row, race.getNumberOfRunners() + " runners", raceTitleFormat));
                    row++;
                    for (Horse horse : race.getHorses()) {
                        sheet.addCell(new Label(0, row, horse.getName()));
                        sheet.addCell(new Label(1, row, horse.getOdds()));
                        sheet.addCell(new Number(2, row, horse.getTips()));
                        row++;
                    }
                    row++;
                } catch (WriteException e) {
                    logger.error("error adding cell to spreadsheet", e);
                }
            }

            try {
                racesDoc.write();
                racesDoc.close();
            } catch (IOException e) {
                logger.error("error trying to write spreadsheet", e);
            } catch (WriteException e) {
                logger.error("error trying to write spreadsheet", e);
            }
        }
    }
}