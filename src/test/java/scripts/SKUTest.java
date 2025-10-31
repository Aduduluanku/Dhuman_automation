package scripts;

import org.testng.annotations.Test;
import pages.IconPage;
import pages.LoginPage;
import pages.SKUPage;

public class SKUTest extends BaseTest{
    @Test
    public void createSkuComplete(){
        LoginPage loginPage = new LoginPage(driver);
        SKUPage skuPage = new SKUPage(driver);

        loginPage.login("admin","123456");
        logger.info("Login completely");

        skuPage.navigateToSkuPage();
        logger.info("Navigate to create SKU page");

        skuPage.createNewSku("keke", "muahahaha");

    }
}
