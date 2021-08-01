import com.codeborne.pdftest.PDF;
import jdk.jfr.Description;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class PdfFileTest {
    String fileName = "2_my_pdf_doc.pdf";
    String fileContent = "This is my pdf doc!";
    String filePath = "./src/test/resources/2_my_pdf_doc.pdf";

    @Description("Reading of PDF doc content using codeborne.pdftest.PDF library")
    @Test
    void pdfFileTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream(fileName);
        PDF pdfFile = new PDF(stream);
        assertThat(pdfFile.text).contains(fileContent);
    }

    @Description("Reading of PDF doc content using pdfbox library")
    @Test
    void pdfFileBoxTest() throws IOException {
        PDDocument document = PDDocument.load(new File(filePath));
        PDFTextStripper pdfParsedDoc = new PDFTextStripper();
        String contentFromParsedPdf = pdfParsedDoc.getText(document);
        document.close();
        assertThat(contentFromParsedPdf.contains(fileContent));

    }
}
