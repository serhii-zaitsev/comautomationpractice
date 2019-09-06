package lesson07.f_add_basetest.hw07_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static lesson07.f_add_basetest.hw07_1.BaseTest.driver;

public class AccountPage {

    @FindBy (xpath = "//a[text()='Sign out']")
    private WebElement signOutBtn;

    public AccountPage(WebDriver driver)
        {
            PageFactory.initElements(driver, this);
        }

    public LoginPage signOut()
        {
            signOutBtn.click();
            return new LoginPage(driver);
        }

    public boolean checkSignOutBtn()
    {
        if(signOutBtn.isDisplayed())
        {
            return true;
        }
        return false;
    }

}
