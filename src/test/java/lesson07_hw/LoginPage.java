package lesson07_hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;


public class LoginPage extends BasePage {

    @CacheLookup
    By signInBtn = By.linkText("Sign in");
    By email = By.id("email");
    By passwd = By.id("passwd");
    By submitBtn = By.id("SubmitLogin");

    void openPage() {
        open("http://automationpractice.com/index.php");
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
    }

    public AccountPage clickSubmitBtn(){
        $(submitBtn).click();
        return new AccountPage(driver);
    }

    public boolean checkSignInBtn(){
        if($(submitBtn).isDisplayed()){
            return true;
        }
            return false;
    }
}
//qwerty123@ukr.net
//qwe123ASD
