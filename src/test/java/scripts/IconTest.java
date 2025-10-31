package scripts;

import org.testng.annotations.Test;
import pages.IconPage;
import pages.LoginPage;


public class IconTest extends BaseTest{
    @Test
    public void createIconComplete(){
        LoginPage loginPage = new LoginPage(driver);
        IconPage iconPage = new IconPage(driver);

        loginPage.login("admin","123456");
        logger.info("Login completely");

        iconPage.navigateToCreeteIconScreen();
        logger.info("Navigate to create tag page");

        iconPage.createProductIcon("test nhe", "54134f");
        logger.info("Input name and tag completely");

        iconPage.choosingDisplay("not use");
        logger.info("Chosen display option completely");


    }
}
