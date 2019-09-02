package hw05;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class AccountTest {
    static WebDriver driver;

    @Before
    public void signIn() {
        driver.findElement(By.linkText("Sign in")).click();

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("qwerty123@ukr.net");

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("qwe123ASD");

        driver.findElement(By.id("SubmitLogin")).click();
    }

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

    @Test(timeout = 6000l)
    public void verifyFirstTipIsCorrect() {
        driver.findElement(By.xpath("//span[text()='Order history and details']")).click();

        driver.navigate().back();
        driver.findElement(By.xpath("//span[text()='My credit slips']")).click();

        driver.navigate().back();
        driver.findElement(By.xpath("//span[text()='My addresses']")).click();

        driver.navigate().back();
        driver.findElement(By.xpath("//span[text()='My personal information']")).click();

        driver.navigate().back();
        driver.findElement(By.xpath("//span[text()='My wishlists']")).click();

        driver.navigate().back();
    }
}
