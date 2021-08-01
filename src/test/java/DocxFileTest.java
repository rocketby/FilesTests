import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.IOException;
import java.io.InputStream;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class DocxFileTest {
    @Test
    void docxFileTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("1_my_word_doc.docx");
        XWPFDocument docx = new XWPFDocument(stream);
        String parsedDocx = docx.getDocument().toString();

        assertThat(parsedDocx).contains("This is my word doc!");

    }

}
