package pages;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import utils.Conditions;
import java.util.List;


public class LandingPage extends BasePage {

    By searchBox = By.id("search_query_top");
    By tips = By.xpath("//*[@id=\"index\"]/div[2]/ul/li");
    public By firstTip = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");
    By submit_search = By.name("submit_search");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        open("http://automationpractice.com/index.php");
        waitForDocumentCompleteState();
    }

    public void searchFor(String searchQuery) {
        $(searchBox, Conditions.CLICKABLE).clear();
        $(searchBox).sendKeys(searchQuery);
        //$$(tips, 5);
    }

    public String getFirstTipText() {
        return $(firstTip).getText();
    }

    public String getFirstTipText(int expTipsNumber) {
        return $$(tips, expTipsNumber).get(0).getText();
    }

    public List<WebElement> getAllTips() {
        return $$(tips);
    }

    public void clickSubmitSearch() {
        $(submit_search).click();
    }


    public void getTextIframe() {

        getDriver().switchTo().frame("f2c21840f3f93bc");
    }








/*    public ExpectedCondition<Boolean> listNthElementHasText(List<WebElement> allTips, int elNo, String expText) {
        return new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                try {
                    allTips.get(elNo + 1).equals(expText);
                    return true;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid option = IndexOutOfBoundsException");
                    e.printStackTrace();
                    return false;
                }
                finally {
                    return false;
                }
            }
        };

    }

    public static ExpectedCondition<Boolean> stalenessOfElement(final By locator) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(final WebDriver driver) {
                try {
                    driver.findElement(locator);
                    return false;
                } catch (WebDriverException ignored) {
                    return true;
                }
            }

            @Override
            public String toString() {
                return String.format("absence of element located by %s", locator);
            }
        };
    }

    waitFor(new ExpectedCondition<Boolean>() {
        @NullableDecl
        @Override
        public Boolean apply(@NullableDecl WebDriver driver) {
            return driver.getCurrentUrl().equals("") && driver.getTitle().equals("");
        }
    });*/
}