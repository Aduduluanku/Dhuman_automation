package scripts;

import org.testng.annotations.Test;
import pages.LoginPage;

import pages.ProductPage;

public class ProductTest extends BaseTest {
    @Test
    public void registerMemberComplete(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.login("admin", "123456");
        logger.info("Log in successfully");

        productPage.accessCreateProductPage();
        logger.info("Access to register product page");

        productPage.addCategory("Dog Food");
        productPage.addCategory("Chicken");
        productPage.addCategory("Smoked Chicken");
        productPage.clickAddingCategory();
        logger.info("Adding categories completed");

        productPage.checkOptionCategory("Dog Food", "Chicken");
        logger.info("Chosen these categories completed");

        productPage.checkApplyCategories();
        logger.info("Checked 상단 고정진열 적용 (체크 시 선택된 모든 카테고리의 쇼핑몰 상품 페이지 최상단에 진열됩니다.)");

        productPage.checkDisplayProductForWeb("노출함");
        logger.info("Tick checkbox for web in check display");

        productPage.checkDisplayProductForMobile("노출함");
        logger.info("Tick checkbox for mobile in check display");

        productPage.setDisplayPeriod("picking date option", "최근 30일");
        logger.info("Set display time completed");

        productPage.approveForMemberLevelDisplay("Members", "Silver Dumon");
        logger.info("Chosen approvemently for member level display");

        productPage.checkSaleProductForWeb("노출안함");
        logger.info("Tick checkbox for web in check sale");

        productPage.checkSaleProductForMobile("노출안함");
        logger.info("Tick checkbox for mobile in check sale");

        productPage.setSalePeriod("picking date option", "최근 30일");
        logger.info("Set sale time completed");

        productPage.approveForMemberLevelSale("Members", "Silver Dumon");
        logger.info("Chosen approvemently for member level sale");

        productPage.inputProductName("San pham nay dzui de");
        logger.info("Input product name completed");

        productPage.inputKeyWordForSearchProductName("vui ve ko quao");
        logger.info("Input keyword completed");

        productPage.uploadThumbnailImage("D:\\luan\\document\\polpish\\admin_data_images\\123.jpg");
        logger.info("Uploaded product thumbnail image completed");

        productPage.uploadTimeSaleImage("D:\\luan\\document\\polpish\\admin_data_images\\123.jpg");
        logger.info("Uploaded time sales image completed");

        productPage.uploadDetailImage("D:\\luan\\document\\polpish\\admin_data_images\\123.jpg");
        logger.info("Uploaded product detail image completed");

        productPage.selectTagSettingDisplay("Discount","기간 설정");
        logger.info("Choosing tag and set display completed");
    }
}
