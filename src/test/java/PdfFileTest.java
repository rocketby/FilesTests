import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class PdfFileTest {
    @Test
    void docxFileTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("2_my_pdf_doc.pdf");
        PDF pdfFile = new PDF(stream);
        assertThat(pdfFile.text).contains("This is my pdf doc!");
    }
}
