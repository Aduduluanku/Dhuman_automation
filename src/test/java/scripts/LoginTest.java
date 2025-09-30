package scripts;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    @Test
    public void loginComplete(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("admin","123456");

    }
}
