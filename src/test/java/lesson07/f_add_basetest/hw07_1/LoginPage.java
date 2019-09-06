package lesson07.f_add_basetest.hw07_1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static lesson07.f_add_basetest.hw07_1.BaseTest.driver;

public class LoginPage {

    @FindBy(linkText = "Sign in")
    @CacheLookup
    private WebElement signInBtn;

    @FindBy(id = "email")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "passwd")
    @CacheLookup
    private WebElement passwd;

    @FindBy(id = "SubmitLogin")
    @CacheLookup
    private WebElement submitBtn;

///////// Constructor ///////////
    public LoginPage(WebDriver driver)
        {
            PageFactory.initElements(driver, this);
        }
///////// Methods ///////////
    public void enterUsername(String username)
        {
            email.clear();
            email.sendKeys(username);
        }

    public void enterPassword(String password)
        {
            passwd.clear();
            passwd.sendKeys(password);
        }

    public void clickSignInBtn()
        {
            signInBtn.click();
        }

    public void logIn(String username, String password)
        {
            clickSignInBtn();
            enterUsername(username);
            enterPassword(password);
            clickSubmitBtn();
        }

    public AccountPage clickSubmitBtn()
        {
            submitBtn.click();
            return new AccountPage(driver);
        }
    public boolean checkSignInBtn()
        {
            if(submitBtn.isDisplayed())
                {
                    return true;
                }
            return false;
        }


}
//qwerty123@ukr.net
//qwe123ASD
