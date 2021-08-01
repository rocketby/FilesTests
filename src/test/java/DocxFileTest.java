import jdk.jfr.Description;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class DocxFileTest {
    String fileName = "1_my_word_doc.docx";
    String fileContent = "This is my word doc!";

    @Description("Reading of docx content using XWPFDocument")
    @Test
    void docxFileTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream(fileName);
        XWPFDocument docx = new XWPFDocument(stream);
        String parsedDocx = docx.getDocument().toString();

        assertThat(parsedDocx).contains(fileContent);
    }
}
