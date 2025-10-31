package scripts;

import drivers.DriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class BaseTest {

    static WebDriver driver;

    static Logger logger = LogManager.getLogger(BaseTest.class); // Use class reference

    @BeforeMethod
    @Parameters({"browser"})

    public void setupTest(@Optional("chrome") String browser) {


        logger.info("Setting up WebDriver...");


        DriverFactory driverFactory = new DriverFactory();
        driverFactory.setDriver("chrome");
        driver = driverFactory.getDriver();
        driver.get("https://dhuman-vercel-cn2g.vercel.app/signin");
        logger.info("Navigated to test site: https://dhuman-vercel-cn2g.vercel.app/signin");
    }

    public WebDriver getDriver() {
        return driver;
    }

//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        if (driver != null) {
//            logger.info("Closing browser and quitting WebDriver...");
//            Thread.sleep(3000);
//            driver.quit();
//        }
//
//    }
}


