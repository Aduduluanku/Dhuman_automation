package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public void setDriver(String browser) {
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

                // ✅ Cho phép nội dung không an toàn (insecure content)
                chromeOptions.addArguments("--allow-running-insecure-content");
                chromeOptions.addArguments("--ignore-certificate-errors");

                // ✅ Tắt các cảnh báo liên quan đến mật khẩu, bảo mật
                chromeOptions.addArguments("--disable-save-password-bubble");
                chromeOptions.addArguments("--disable-features=AutofillServerCommunication,PasswordManagerOnboarding,SafetyTipUI,PasswordLeakDetection");

                // ✅ Tắt thông báo, popup, ẩn cảnh báo automation
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

                // ✅ Chế độ ẩn danh
                chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("This browser is not supported");
        }

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            threadLocalDriver.set(driver);
        }
    }


    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }

}