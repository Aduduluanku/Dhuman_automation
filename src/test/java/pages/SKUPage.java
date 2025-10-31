package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SKUPage {
    WebDriver driver;
    WebDriverWait wait;
    static Logger logger = LogManager.getLogger(IconPage.class);


    public SKUPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.info("Set up page driver");
    }

    public void navigateToSkuPage (){
        driver.findElement(By.xpath("//span[text()='상품']")).click();
        driver.findElement(By.xpath("(//span[text()='관리'])[1]")).click();
        driver.findElement(By.xpath("//a[@href='/products/products-management/product-sku-registration']")).click();
    }

    public void createNewSku (String optionName, String skuCode){
        driver.findElement(By.id("name")).sendKeys(optionName);
        driver.findElement(By.id("code")).sendKeys(skuCode);
    }
}
