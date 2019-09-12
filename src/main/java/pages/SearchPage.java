package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class SearchPage extends BasePage {

    By prodItem = By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a");
    By addToCart = By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span");
    By proceedToCheckout = By.xpath("//a[@title='Proceed to checkout']");
    //By proceedToCheckout = By.xpath("//button/span/i[@class='icon-chevron-right right'] or //a[@title='Proceed to checkout']");
    By proceedToCheckout2 = By.xpath("//span[text()='Proceed to checkout']");
    By proceedToCheckout3 = By.xpath("//button[@type='submit' and @name='processCarrier']/span");
    By checkBox = By.id("uniform-cgv");
    By confirmMyOrder = By.xpath("//span[text()='I confirm my order']");
    By payBankWire = By.xpath("//a[@title='Pay by bank wire']");
    //By refOrder = By.xpath("//span[@class='price']/following-sibling::br/following-sibling::br/following-sibling::br");
    By refOrder = By.xpath("//span[@class='price']");
    By myCustomerAaccount = By.xpath("//a[@title='View my customer account']");




    Actions builder = new Actions(getDriver());
    Actions builder2 = new Actions(driver);

    public void addProductToCart() {
        WebElement el = $(prodItem);
        Actions builder = new Actions(getDriver());
        builder.moveToElement( el ).perform();
        $(addToCart).click();

        String myWindowHandle = getDriver().getWindowHandle();
        getDriver().switchTo().window(myWindowHandle);
        $(proceedToCheckout).click();
        $(proceedToCheckout2).click();
        $(proceedToCheckout2).click();
        $(checkBox).click();
        $(proceedToCheckout3).click();
        $(payBankWire).click();
        $(confirmMyOrder).click();
    }

    public String getOrderReference()
    {
        List<WebElement> allElements = $$(refOrder);
        System.out.println($(refOrder).getText());
        for (WebElement element: allElements) {
            System.out.println(element.getText());
        }

        return null;
    }



    public void openPage() {
        open("http://automationpractice.com/index.php");
    }

    ///////// Constructor ///////////
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    ///////// Methods ///////////


    public void clickOnMyUser(){
        $(myCustomerAaccount).click();
    }

}