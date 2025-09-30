package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MemberPage {
    WebDriver driver;

    public MemberPage(WebDriver driver) {
        this.driver = driver;
    }

    public void accessCreateMemberPage() {
        driver.findElement(By.xpath("//li[@url=\"/members/member-management/member-list\"]")).click();
        driver.findElement(By.xpath("(//span[text()='회원 등록'])[last()]")).click();
    }

    public void chosingTier (String tier) {
        driver.findElement(By.xpath("//input[@id='tier']")).click();
        String listTier = "//span[@class='ant-select-selection-item' and text()='%s']";
        driver.findElement(By.xpath(String.format(listTier, tier))).click();
    }

    public void chosingApprove (String yn){
        String chosingYN = "//span[@class='ant-radio-label' and text() ='%s']";
        driver.findElement(By.xpath(String.format(chosingYN, yn))).click();
    }

    public void inputID (String id, String name) {
        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(id);
        driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys(name);
    }

    public void inputEmail (String infront, String below) {
        driver.findElement(By.xpath("//input[@id=\"emailPrefix\"]")).sendKeys(infront);
        driver.findElement(By.xpath("//input[@id=\"emailDomain\"]")).sendKeys(below);

//        driver.findElement(By.xpath("//div[@class=\"ant-form-item mb-0 min-w-[100px] w-[200px] css-qyo09v ant-form-item-has-success ant-form-item-horizontal\"]")).click();
//        //String locatorMail = "(//span[@class=\"ant-select-selection-item\"])[last()]and text()='%s']";
//        driver.findElement(By.xpath(String.format(locator, "hotmail.com"))).click();
    }
}
