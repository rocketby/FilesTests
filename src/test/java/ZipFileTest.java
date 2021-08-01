import jdk.jfr.Description;
import net.lingala.zip4j.core.ZipFile;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipFileTest {

    String zipFilePath = "./src/test/resources/4_zip_with_password.zip";
    String unzipFolderPath = "./src/test/resources/unzipped/";
    String zipPassword = "123";
    String unzippedFileName = "readme.txt";
    String unzippedFileContent = "this is a readme.txt file!";

    @Description("Reading of doc content from Zip-archive with password using zip4j library")
    @Test
    void zipFileTest() throws Exception {
        ZipFile zipFile = new ZipFile(zipFilePath);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(zipPassword);
        }
        zipFile.extractAll(unzipFolderPath);

        String unzippedFileData = FileUtils.readFileToString(FileUtils
                .getFile(unzipFolderPath + unzippedFileName), "UTF-8");

        assertThat(unzippedFileData).contains(unzippedFileContent);
    }
}