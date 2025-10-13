package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;


public class MemberPage {
    WebDriver driver;
    Actions actions;

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

    public void inputAddress(String address) {
        driver.findElement(By.xpath("//input[@id='addressLine2']")).sendKeys(address);
     }

    public void choseGender(String gender) {
        String chosingGender = "//label[normalize-space()='%s']//input[@type='radio']";
        driver.findElement(By.xpath(String.format(chosingGender, gender))).click();
    }

    public void DOB() {
        Random random = new Random();

        int year = random.nextInt(2025 - 1900 + 1) + 1900;
        int month = random.nextInt(12) + 1;
        int maxDay;
        switch (month) {
            case 2: // Tháng 2
                maxDay = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
                break;
            case 4: case 6: case 9: case 11:
                maxDay = 30;
                break;
            default:
                maxDay = 31;
        }

        int day = random.nextInt(maxDay) + 1;
        String dob = String.format("%04d-%02d-%02d", year, month, day);
        driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(dob);

    }

    public void interesting(String foodType) {
        String chosingFoodType = "//label[normalize-space()='%s']//input[@type='checkbox']";
        driver.findElement(By.xpath(String.format(chosingFoodType, foodType))).click();
    }

    By bottomScreen = By.xpath("//div[text()='© 2025 BurningBros All Rights Reserved.']");
    public void scrollToBottom() {
        WebElement element = driver.findElement(bottomScreen);
        actions.moveToElement(element).perform();
    }

    public void addRegistrationPath() {
//        String listsocialNetwork = "//div[contains(@class,'ant-select-item-option-content') and text()='TV']";
//        driver.findElement(By.xpath(String.format(listsocialNetwork, socialNetwork))).click();
        String optionXpath = "//div[contains(@class,'ant-select-item-option-content') and normalize-space()='%s']";
        driver.findElement(By.xpath(String.format(optionXpath, "TV"))).click();
    }

    public void chosingDog(String dog) {
        String listDog = "//span[@class='ant-select-selection-placeholder' and text()='%s']";
        driver.findElement(By.xpath(String.format(listDog, dog))).click();
    }

    public void chosingCat(String cat) {
        String listCat = "//span[@class='ant-select-selection-placeholder' and text()='%s']";
        driver.findElement(By.xpath(String.format(listCat, cat))).click();
    }

    public void petDOB() {
        Random random = new Random();

        int year = random.nextInt(2025 - 1900 + 1) + 1900;
        int month = random.nextInt(12) + 1;
        int maxDay;
        switch (month) {
            case 2: // Tháng 2
                maxDay = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
                break;
            case 4: case 6: case 9: case 11:
                maxDay = 30;
                break;
            default:
                maxDay = 31;
        }

    }
}