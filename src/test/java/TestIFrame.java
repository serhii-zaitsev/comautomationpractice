import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import pages.LandingPage;


public class TestIFrame extends BaseTest {

    @Test
    @Category({Test_Log_In_Out.Category1.class})
    public void Get_Text_From_Iframe_Test_Succesfully() {
        LandingPage landingPage = new LandingPage(driver);

        landingPage.openPage();


        JavascriptExecutor jse = (JavascriptExecutor)driver;


             /*   (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("f2c21840f3f93bc"));*/

            driver.switchTo().frame("f2c21840f3f93bc");
        //WebElement element = driver.findElement(By.xpath("//span[@itemprop='telephone']"));
        //jse.executeScript("return arguments[0].text", element);
        jse.executeScript("window.scrollBy(0,500)");

        WebElement webl = driver.findElement(By.xpath("//iframe[@name='f2c21840f3f93bc']"));

        String text = (String) jse.executeScript("return arguments[0].text;", webl);
        System.out.println("title" + text);

    }


}