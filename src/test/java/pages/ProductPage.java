package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DateTimeUtils;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void accessCreateProductPage() {
        driver.findElement(By.xpath("//li[@url='/products/products-management/product-list']")).click();
        driver.findElement(By.xpath("(//span[text()='+ Add Product'])[last()]")).click();
    }

    public void addCategory(String cate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//li[normalize-space()='%s']", cate))
        ));
        option.click();
    }

    public void clickAddingCategory() {
        driver.findElement(By.xpath("//span[text()='선택']")).click();
    }

    public void checkOptionCategory(String... options) {
        StringBuilder condition = new StringBuilder();
        for (String foodType : options) {
            if (condition.length() > 0) {
                condition.append(" and ");
            }
            condition.append(String.format(".//text()[contains(.,'%s')]", foodType));
        }

        String xpath = String.format("//tr[%s]//input[@type='radio']", condition);
        WebElement checkFoodCategories = driver.findElement(By.xpath(xpath));
        checkFoodCategories.click();
    }

    public void checkApplyCategories() {
        driver.findElement(By.xpath("//label[normalize-space()='상단 고정진열 적용 (체크 시 선택된 모든 카테고리의 쇼핑몰 상품 페이지 최상단에 진열됩니다.)']//input[@type='checkbox']")).click();
    }

    public void checkAvailableProductForWeb(String checkOnWeb) {
        String chosingYnWeb = "//div[@id='displayStatus.isPcDisplay']//label[.//span[normalize-space(text())='%s']]//input[@type='radio']";
        driver.findElement(By.xpath(String.format(chosingYnWeb, checkOnWeb))).click();
    }

    public void checkAvailableProductForMobile(String checkOnMobile) {
        String chosingYnMobile = "//div[@id='displayStatus.isMobileDisplay']//label[.//span[normalize-space(text())='%s']]//input[@type='radio']";
        driver.findElement(By.xpath(String.format(chosingYnMobile, checkOnMobile))).click();
    }

    public void notSetSaleTime(String checkNotSet) {
        String chosingNoSetSaleTime = "//div[@id='saleStatus.isPeriodEnable']//label[.//span[normalize-space(text())='Indefinite']]//input[@type='radio']";
        driver.findElement(By.xpath(String.format(chosingNoSetSaleTime, checkNotSet))).click();
    }

    public void setSaleTimeByInputTime(String checkSetDate) {
        String startDay = DateTimeUtils.getCurrentDateTime();
        String endDay = DateTimeUtils.getDateTimePlusDays(30);
        String chosingSetSaleTime = "//div[@id='saleStatus.isPeriodEnable']//label[.//span[normalize-space(text())='Set a period']]//input[@type='radio']";
        driver.findElement(By.xpath(String.format(chosingSetSaleTime, checkSetDate))).click();
        driver.findElement(By.xpath("//input[@id='displayStatus.periodFrom']/following-sibling::span[contains(@class,'ant-picker-suffix')]//span[@aria-label='calendar']")).click();
        driver.findElement(By.xpath("//input[@id='displayStatus.periodFrom']")).sendKeys(startDay);
        driver.findElement(By.xpath("//input[@id='displayStatus.periodTo']/following-sibling::span[contains(@class,'ant-picker-suffix')]//span[@aria-label='calendar']")).click();
        driver.findElement(By.xpath("//input[@id='displayStatus.periodTo']")).sendKeys(endDay);
    }

}


