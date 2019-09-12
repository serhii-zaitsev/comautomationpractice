import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pages.AccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.SearchPage;

public class Search_and_Buy_Product extends BaseTest {

    public interface Category4 {}

    @Test
    @Category({Test_Log_In_Out.Category1.class})
    public void Log_In_To_Site_With_LogInMethod() {
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        loginPage.openPage();
        String username = "qwerty123@ukr.net";
        String password = "qwe123ASD";

        loginPage.logIn(username, password);

        Assert.assertTrue("Log In was not successful",
                accountPage.checkSignOutBtn());
    }

    @Test
    @Category({Category4.class})
    public void Search_Buy_Prod() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        String query1 = "Dress";

        landingPage.searchFor(query1);
        landingPage.clickSubmitSearch();
        searchPage.addProductToCart();
        searchPage.clickOnMyUser();
        loginPage.clickOrderHistory();


    }

}
