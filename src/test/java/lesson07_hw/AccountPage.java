package lesson07_hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static lesson07_hw.BaseTest.driver;

public class AccountPage extends BasePage {

    By signOutBtn = By.xpath("//a[text()='Sign out']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage signOut(){
            $(signOutBtn).click();
            return new LoginPage(driver);
    }

    public boolean checkSignOutBtn(){
        if($(signOutBtn).isDisplayed()){
            return true;
        }
        return false;
    }

}
