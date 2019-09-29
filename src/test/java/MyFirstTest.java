import de.redsix.pdfcompare.PdfComparator;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LandingPage;
import pages.LoginPage;

import utils.FileDownloader;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;


import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;


public class MyFirstTest extends BaseTest {

    @Test
    public void verify_First_Tip_Is_Correctly_Updated_After_Entering_New_Query() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openPage();
        String query1 = "Dress";
        String query2 = "T-shirt";

        landingPage.searchFor(query1);
        Assert.assertThat(landingPage.getFirstTipText(7),
                CoreMatchers.containsString(query1));

        landingPage.searchFor(query2);

        String firstTipText = landingPage.getFirstTipText(1);
        assertAll(() -> Assert.assertThat(firstTipText, CoreMatchers.containsString(query2 + "0")),
                () -> Assert.assertThat(firstTipText, CoreMatchers.containsString(query2)),
                () -> Assert.assertThat(firstTipText, CoreMatchers.containsString(query2 + "1"))
        );
    }

    @Test
    public void verifyFirst_TipIsCorrectlyUpdatedAfterEnteringNewQuery() {
        LandingPage landingPage = new LandingPage(driver);
        String query1 = "Dress";
        String query2 = "T-shirt";

        landingPage.searchFor(query1);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(landingPage.firstTip));
        Assert.assertThat(landingPage.getFirstTipText(),
                CoreMatchers.containsString("Dress"));

        landingPage.searchFor(query2);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElementLocated(landingPage.firstTip, "T-shirt"));

        Assert.assertThat(
                landingPage.getFirstTipText(),
                CoreMatchers.containsString("T-shirt"));
    }

/*    @Test
    public void verifyDownloadMyOrder() throws Exception {
        // Given
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.logIn("qwerty123@ukr.net", "qwe123ASD");
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
    public void verifyDownloadMyOrderNegative() throws Exception {
        // Given
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.logIn("qwerty123@ukr.net", "qwe123ASD");
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
    }*/


    @Test
    public void verifyUploadingImageOnGoogle() {
        // Given
        open("https://www.google.com.ua/imghp?hl=uk&tab=wi");
        assertThat(titleContains("Google"));
        // When
        $("//*[@id=\"sbtc\"]/div/div[3]/div[1]/span").click();
        $(By.linkText("Завантажте зображення")).click();
        String filePath = new File("").getAbsolutePath().concat("\\").concat("download.jpg");

        $(By.id("qbfile"))
                .sendKeys(filePath);
        // Then
        assertThat(textToBePresentInElementLocated(By.xpath("//*[@id=\"topstuff\"]/div/div[2]/a"),
                "milliner (la modiste - renée vert)"));
    }


}