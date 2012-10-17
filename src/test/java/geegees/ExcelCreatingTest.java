package geegees;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.*;
import jxl.write.Number;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ExcelCreatingTest {

    @Test
    public void writeRaceDetails() throws IOException, WriteException {
        WritableWorkbook races = Workbook.createWorkbook(File.createTempFile("races" + String.valueOf(new Date().getTime()), ".xls", new File(System.getProperty("user.dir"))));
        races.createSheet("race", 0);
        races.getSheet(0).addCell(new Label(0, 0, "race name"));
        races.getSheet(0).addCell(new DateTime(1, 0, new Date()));
        races.getSheet(0).addCell(new Label(0, 1, "number of runners:"));
        races.getSheet(0).addCell(new Number(1, 1, 10));
        WritableCellFormat format = new WritableCellFormat();
        format.setBackground(Colour.LIGHT_BLUE);
        races.getSheet(0).getWritableCell(0, 0).setCellFormat(format);
        races.getSheet(0).getWritableCell(0, 1).setCellFormat(format);
        races.getSheet(0).getWritableCell(1, 0).setCellFormat(format);
        races.getSheet(0).getWritableCell(1, 1).setCellFormat(format);
        races.write();
        races.close();
    }
}
