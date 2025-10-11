package scripts;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MemberPage;
import pages.ProductPage;

public class ProductTest extends BaseTest {
    @Test
    public void registerMemberComplete() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        String timestamp = String.valueOf(System.currentTimeMillis());
        String uid = timestamp.substring(timestamp.length() - 6);


        loginPage.login("admin","123456");
        productPage.accessCreateProductPage();

        productPage.addCategory("Dog Food");
        productPage.addCategory("Chicken");
        productPage.addCategory("Smoked Chicken");
        productPage.clickAddingCategory();

        productPage.checkOptionCategory("Dog Food", "Chicken");

        productPage.checkApplyCategories();

        productPage.checkAvailableProductForWeb("노출함");
        productPage.checkAvailableProductForMobile("노출함");
    }
}
