import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;

public class XlsFileTest {
    @Test
    void docxFileTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("3_my_excel.xlsx");
        XLS xlsFile = new XLS(stream);

        Assertions.assertEquals("Tatiana",
                xlsFile.excel.getSheetAt(0).getRow(1).getCell(0).getStringCellValue());

        Assertions.assertEquals("Dancing",
                xlsFile.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue());

    }




}
