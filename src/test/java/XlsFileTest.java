import com.codeborne.xlstest.XLS;
import jdk.jfr.Description;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class XlsFileTest {
    String fileName = "3_my_excel.xlsx";
    String cellOneContent = "Tatiana";
    String cellTwoContent = "Reading";

    @Description("Reading of PDF doc content using codeborne.xlstest.XLS library")
    @Test
    void xlsFileTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream(fileName);
        XLS xlsFile = new XLS(stream);

        Assertions.assertEquals(cellOneContent,
                xlsFile.excel.getSheetAt(0).getRow(1).getCell(0).getStringCellValue());

        Assertions.assertEquals(cellTwoContent,
                xlsFile.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue());
    }

    @Description("Reading of PDF doc content using XSSFWorkbook library")
    @Test
    void xlsFileXSSFTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream(fileName);
        XSSFWorkbook xlsFile = new XSSFWorkbook(stream);
        Assertions.assertEquals(cellOneContent,
                xlsFile.getSheetAt(0).getRow(1).getCell(0).getStringCellValue());
        Assertions.assertEquals(cellTwoContent,
                xlsFile.getSheetAt(0).getRow(1).getCell(1).getStringCellValue());

    }

}