package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;

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
