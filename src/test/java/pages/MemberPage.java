package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MemberPage {
    WebDriver driver;

    public MemberPage(WebDriver driver) {
        this.driver = driver;
    }

    public void accessCreateMemberPage() {
        driver.findElement(By.xpath("//li[@url=\"/members/member-management/member-list\"]")).click();
        driver.findElement(By.xpath("(//span[text()='회원 등록'])[last()]")).click();
    }

    public void chosingTier(String tier) {
        //driver.findElement(By.xpath("//input[@id='tier']")).click();
        String listTier = "//span[@class='ant-select-selection-item' and text()='%s']";
        driver.findElement(By.xpath(String.format(listTier, tier))).click();
    }

    public void chosingApprove(String yn) {
        String chosingYN = "//span[@class='ant-radio-label' and text() ='%s']";
        driver.findElement(By.xpath(String.format(chosingYN, yn))).click();
    }

    public void inputID(String id, String name) {
        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(id);
        driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys(name);
    }

    public void inputPwd(String pwd) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(pwd);

    }

    public void checkSeePwd() {
        driver.findElement(By.xpath("(//span[@class='anticon anticon-eye-invisible ant-input-password-icon'])[1]")).click();
        driver.findElement(By.xpath("(//span[@class='anticon anticon-eye-invisible ant-input-password-icon'])[last()]")).click();

    }


    public void inputEmail(String infront, String below) {
        driver.findElement(By.xpath("//input[@id=\"emailPrefix\"]")).sendKeys(infront);
        driver.findElement(By.xpath("//input[@id=\"emailDomain\"]")).sendKeys(below);

//        driver.findElement(By.xpath("//div[@class=\"ant-form-item mb-0 min-w-[100px] w-[200px] css-qyo09v ant-form-item-has-success ant-form-item-horizontal\"]")).click();
//        //String locatorMail = "(//span[@class=\"ant-select-selection-item\"])[last()]and text()='%s']";
//        driver.findElement(By.xpath(String.format(locator, "hotmail.com"))).click();
    }


    public void tickAnnounceMail() {
        driver.findElement(By.xpath("//label[normalize-space()='정보/이벤트 MAIL 수신에 동의합니다']//input[@type='checkbox']")).click();


    }

    public void inputPhoneNumber(String phoneNumber) {
        driver.findElement(By.xpath("//input[@id='phoneNo']")).sendKeys(phoneNumber);
    }

    public void tickAnnounceSms() {
        driver.findElement(By.xpath("//label[normalize-space()='정보/이벤트 MAIL 수신에 동의합니다']//input[@type='checkbox']")).click();
    }

    public void findZipCode() throws InterruptedException {
// Click nút mở popup
        driver.findElement(By.xpath("//button[normalize-space()='우편번호찾기']")).click();

    }
}