import de.redsix.pdfcompare.PdfComparator;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import utils.FileDownloader;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;

public class ComparePdf extends BaseTest {

    @Test
    public void verifyDownloadMyOrderIsSuccessful() throws Exception {
        // Given
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.logIn("trandafilov.vladimir@gmail.com", "password");
        $("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span").click();
        waitFor(ExpectedConditions.titleContains("Order history"));
        // When
        FileDownloader fileDownloader = new FileDownloader(driver);
        fileDownloader.setURI($("//*[@id=\"order-list\"]/tbody/tr/td[6]/a").getAttribute("href"));
        File actualFile = fileDownloader.downloadFile();
        int requestStatus = fileDownloader.getLastDownloadHTTPStatus();
        // Then
        assertAll(() -> Assert.assertThat("Check status.", requestStatus, is(200)),
                () -> Assert.assertThat(new PdfComparator(new File("IN090063.pdf"), actualFile)
                        .compare().writeTo("diffOutputOrder"), is(true)));
    }

    @Test
    public void verifyDownloadMyOrderAreDifferentWithPrevious() throws Exception {
        // Given
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.logIn("trandafilov.vladimir@gmail.com", "password");
        $("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span").click();
        waitFor(ExpectedConditions.titleContains("Order history"));
        // When
        FileDownloader fileDownloader = new FileDownloader(driver);
        fileDownloader.setURI($("//*[@id=\"order-list\"]/tbody/tr/td[6]/a").getAttribute("href"));
        File actualFile = fileDownloader.downloadFile();
        int requestStatus = fileDownloader.getLastDownloadHTTPStatus();
        // Then
        assertAll(() -> Assert.assertThat("Check status.", requestStatus, is(200)),
                () -> Assert.assertThat(new PdfComparator(new File("IN090057.pdf"), actualFile)
                        .compare().writeTo("diffOutputPass"), is(false)));
    }
}