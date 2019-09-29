package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;


public class LoginPage extends BasePage {

    @CacheLookup
    By signInBtn = By.linkText("Sign in");
    By email = By.id("email");
    By passwd = By.id("passwd");
    By submitBtn = By.id("SubmitLogin");
    By orderHistory = By.xpath("//span[text()='Order history and details']");
    //By orderHistory = By.xpath("//iframe[@title='fb:like_box Facebook Social Plugin']");

    public void openPage() {
        open("http://automationpractice.com/index.php");
        waitForDocumentCompleteState();
    }

///////// Constructor ///////////
public LoginPage(WebDriver driver) {
    super(driver);
}
///////// Methods ///////////
    public void enterUsername(String username){
        $(email).clear();
        $(email).sendKeys(username);
    }

    public void enterPassword(String password){
        $(passwd).clear();
        $(passwd).sendKeys(password);
    }

    public void clickSignInBtn(){
        $(signInBtn).click();
    }

    public void logIn(String username, String password){
        clickSignInBtn();
        enterUsername(username);
        enterPassword(password);
        clickSubmitBtn();
        waitForDocumentCompleteState();
    }

    public AccountPage clickSubmitBtn(){
        $(submitBtn).click();
        return new AccountPage(driver);
    }

    public void clickOrderHistory(){
        $(orderHistory).click();
    }

    public boolean checkSignInBtn(){
        if($(submitBtn).isDisplayed()){
            return true;
        }
            return false;
    }

    public String getErrorMessage() {
        return $("//*[@id=\"center_column\"]/div[1]/ol/li").getText();
    }
}
//qwerty123@ukr.net
//qwe123ASD
