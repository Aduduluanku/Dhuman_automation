package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class IconPage {
    WebDriver driver;
    WebDriverWait wait;
    static Logger logger = LogManager.getLogger(IconPage.class);


    public IconPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.info("Set up page driver");

    }

    public void navigateToCreeteIconScreen() {
        driver.findElement(By.xpath("//span[text()='상품']")).click();
        driver.findElement(By.xpath("(//span[text()='관리'])[1]")).click();
        driver.findElement(By.xpath("//a[@href='/products/products-management/product-icon-registration']")).click();
    }

    public void createProductIcon(String iconName, String color) {
        driver.findElement(By.id("label")).sendKeys(iconName);
        logger.info("Input tag name");

        driver.findElement(By.id("colorCode")).click();
        driver.findElement(By.xpath("(//div[contains(@class,'ant-color-picker-input')]//input[contains(@class,'ant-input')])[1]")).click();
        driver.findElement(By.xpath("(//div[contains(@class,'ant-color-picker-input')]//input[contains(@class,'ant-input')])[1]")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.xpath("(//div[contains(@class,'ant-color-picker-input')]//input[contains(@class,'ant-input')])[1]")).sendKeys(Keys.chord(Keys.DELETE));
        driver.findElement(By.xpath("(//div[contains(@class,'ant-color-picker-input')]//input[contains(@class,'ant-input')])[1]")).sendKeys(color);
        driver.findElement(By.xpath("//body")).click();
        logger.info("Input tag color");
    }

    public void choosingDisplay(String useOrNot) {
        String chosingUseOrNot = "//label[.//span[normalize-space(text())='%s']]//input[@type='radio']";
        driver.findElement(By.xpath(String.format(chosingUseOrNot, useOrNot))).click();
    }


}


