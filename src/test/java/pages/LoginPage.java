package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String pwd) {
        driver.findElement(By.xpath("//input[@id=\"basic_user_id\"]")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id=\"basic_password\"]")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

    }
}
