package hw05;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MyStream {

    public static boolean checkList(List<WebElement> list)
    {
        if (list.size() > 0)
        {
            for(WebElement we: list)
            {
                System.out.println("Items without Dress : " + we.getText());
            }
            return false;
        }
        else
        {
            System.out.println("All items contains Dress");
            return true;
        }
    }

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test(timeout = 10000l)
    public void verifyFirstTipIsCorrect() {
        driver.findElement(By.id("search_query_top"))
                .clear();
        driver.findElement(By.id("search_query_top"))
                .sendKeys("Dress");

        //Collection all li elements
//      List<WebElement> allItems = driver.findElements(By.xpath("//div[@class='ac_results']/ul/li"));

        List<WebElement> wrongItems= driver.findElements(By.xpath("//div[@class='ac_results']/ul/li")).stream().filter(e -> !e.getText().contains("Dress")).collect(Collectors.toList());


        Assert.assertTrue("Some items are not correct",
                checkList(wrongItems));
    }


}
