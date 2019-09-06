package lesson07_hw;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;


public class Test_Log_In_Out extends BaseTest {

    public interface Category1 {}
    public interface Category2 {}
    public interface Category3 {}

    @Test
    @Category({Category1.class})
    public void Log_In_To_Site_With_LogInMethod() {
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        String username = "qwerty123@ukr.net";
        String password = "qwe123ASD";

        loginPage.logIn(username, password);

        Assert.assertTrue("Log In was not successful",
                accountPage.checkSignOutBtn());
    }

    @Test
    @Category({Category2.class})
    public void Log_In_To_Site_With_Chain_Method() {
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        String username = "qwerty123@ukr.net";
        String password = "qwe123ASD";

        loginPage.clickSignInBtn();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSubmitBtn();

        Assert.assertTrue("Log In was not successful",
                accountPage.checkSignOutBtn());
    }

    @Test
    @Category({Category3.class})
    public void Log_Out() {
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        accountPage.signOut();

        Assert.assertTrue("Log Out was not successful",
                loginPage.checkSignInBtn());
    }
}