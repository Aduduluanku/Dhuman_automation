package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DateTimeUtils;
import java.time.Duration;
import java.util.List;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    private final Actions actions;
    static Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void accessCreateProductPage() {
        driver.findElement(By.xpath("//li[@url='/products/products-management/product-list']")).click();
        driver.findElement(By.xpath("//span[text()='+ 상품 등록']")).click();
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

    public void checkDisplayProductForWeb(String checkDisplayOnWeb) {
        String chosingYnWeb = "//div[@id='displayStatus.isPcDisplay']//label[.//span[normalize-space(text())='%s']]//input[@type='radio']";
        driver.findElement(By.xpath(String.format(chosingYnWeb, checkDisplayOnWeb))).click();
    }

    public void checkDisplayProductForMobile(String checkDisplayOnMobile) {
        String chosingYnMobile = "//div[@id='displayStatus.isMobileDisplay']//label[.//span[normalize-space(text())='%s']]//input[@type='radio']";
        driver.findElement(By.xpath(String.format(chosingYnMobile, checkDisplayOnMobile))).click();
    }


    public void setDisplayPeriod(String optionType, String... optionValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        switch (optionType.toLowerCase()) {
            case "indefinite":
                wait.until(ExpectedConditions.elementToBeClickable(
                                By.xpath("//div[@id='displayStatus.isPeriodEnable']//label[.//span[normalize-space(text())='Indefinite']]//input[@type='radio']")))
                        .click();
                logger.info("Choosing not set time for display");

                break;

            case "input date manual":
                String startDay = DateTimeUtils.getCurrentDateTime();
                String endDay = DateTimeUtils.getDateTimePlusDays(30);

                driver.findElement(By.xpath("//input[@name='displayStatus.isPeriodEnable' and @value='2']")).click();
                logger.info("Choosing set time for display");

                WebElement fromInput = driver.findElement(By.xpath("//input[@id='displayStatus.periodFrom']"));
                fromInput.clear();
                fromInput.sendKeys(startDay);

                WebElement toInput = driver.findElement(By.xpath("//input[@id='displayStatus.periodTo']"));
                toInput.clear();
                toInput.sendKeys(endDay);
                logger.info("Input 1 month in display field by manual completed");
                break;

            case "picking date option":
                driver.findElement(By.xpath("//div[@id='displayStatus.isPeriodEnable']//label[.//span[normalize-space(text())='Set a period']]//input[@type='radio']")).click();

                if (optionValue.length > 0) {
                    String dateOptionXpath = String.format(
                            "//div[@id='dateRange_displayStatus.periodFrom_displayStatus.periodTo']//label[.//span[normalize-space(text())='%s']]",
                            optionValue[0]);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateOptionXpath))).click();
                }
                logger.info("Choosing option for display date completed");
                break;

            default:
                throw new IllegalArgumentException("Invalid sale period option: " + optionType);
        }
    }

    public void approveForMemberLevelDisplay(String type, String level) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement memberCheckbox = driver.findElement(
                By.xpath("(//label[.//span[contains(.,'" + type + "')]]//input)[1]")
        );
        if (type.equalsIgnoreCase("Non-members") || type.equalsIgnoreCase("First time members")) {
            if (memberCheckbox.isSelected()) {
                memberCheckbox.click();
            }

            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("displayStatus.memberTier")
            ));
            dropdown.click();
            logger.info("Dropdown have been clicked");

            WebElement targetCheckbox = driver.findElement(
                    By.xpath("(//label[.//span[contains(.,'" + type + "')]]//input)[1]")
            );
            if (!targetCheckbox.isSelected()) {
                targetCheckbox.click();
            }

        } else if (type.equalsIgnoreCase("Members")) {

            if (level == null || level.isEmpty()) {
                throw new IllegalArgumentException("Level must be provided for 'Members'.");
            }

            driver.findElement(By.id("displayStatus.memberTier")).click();
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'ant-select-dropdown')]//div[@title='" + level + "']")
            ));
            option.click();
        }
    }

    public void checkSaleProductForWeb(String checkSaleOnWeb) {
        String chosingYnWeb = "//div[@id='saleStatus.isPcDisplay']//label[.//span[normalize-space(text())='%s']]//input[@type='radio']";
        driver.findElement(By.xpath(String.format(chosingYnWeb, checkSaleOnWeb))).click();
    }

    public void checkSaleProductForMobile(String checkSaleOnMobile) {
        String chosingYnMobile = "//div[@id='saleStatus.isMobileDisplay']//label[.//span[normalize-space(text())='%s']]//input[@type='radio']";
        driver.findElement(By.xpath(String.format(chosingYnMobile, checkSaleOnMobile))).click();
    }


    public void setSalePeriod(String optionType, String... optionValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        switch (optionType.toLowerCase()) {
            case "indefinite":
                wait.until(ExpectedConditions.elementToBeClickable(
                                By.xpath("//div[@id='saleStatus.isPeriodEnable']//label[.//span[normalize-space(text())='Indefinite']]//input[@type='radio']")))
                        .click();
                logger.info("Choosing not set time");

                break;

            case "input date manual":  //
                String startDay = DateTimeUtils.getCurrentDateTime();
                String endDay = DateTimeUtils.getDateTimePlusDays(30);
                driver.findElement(By.xpath("//input[@name='saleStatus.isPeriodEnable' and @value='2']")).click();
                logger.info("Choosing set time");

                WebElement fromInput = driver.findElement(By.xpath("//input[@id='saleStatus.periodFrom']"));
                fromInput.clear();
                fromInput.sendKeys(startDay);

                WebElement toInput = driver.findElement(By.xpath("//input[@id='saleStatus.periodTo']"));
                toInput.clear();
                toInput.sendKeys(endDay);
                logger.info("Input 1 month by manual completed");
                break;

            case "picking date option":
                driver.findElement(By.xpath("//div[@id='saleStatus.isPeriodEnable']//label[.//span[normalize-space(text())='Set a period']]//input[@type='radio']")).click();

                if (optionValue.length > 0) {
                    String dateOptionXpath = String.format(
                            "//div[@id='dateRange_saleStatus.periodFrom_saleStatus.periodTo']//label[.//span[normalize-space(text())='%s']]",
                            optionValue[0]);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateOptionXpath))).click();
                }
                logger.info("Choosing option date completed");
                break;

            default:
                throw new IllegalArgumentException("Invalid sale period option: " + optionType);
        }
    }


    public void approveForMemberLevelSale(String type, String level) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 🔹 Checkbox locator theo type trong group saleStatus.memberList
        WebElement memberCheckbox = driver.findElement(
                By.xpath("//div[@id='saleStatus.memberList']//label[.//span[contains(.,'" + type + "')]]//input"));

        // 🔹 Nếu là Non-members hoặc First time members
        if (type.equalsIgnoreCase("Non-members") || type.equalsIgnoreCase("First time members")) {

            // Nếu checkbox đang bật thì bỏ chọn để đảm bảo clean state
            if (memberCheckbox.isSelected()) {
                memberCheckbox.click();
            }

            // 🔹 Click dropdown saleStatus.memberTier
            WebElement dropdown = driver.findElement(By.id("saleStatus.memberTier"));
            dropdown.click();
            logger.info("Dropdown for SALE has been clicked.");

            // 🔹 Sau khi dropdown mở, chọn lại checkbox tương ứng (có thể dùng khi tag được reset)
            WebElement targetCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@id='saleStatus.memberList']//label[.//span[contains(.,'" + type + "')]]//input")
            ));
            if (!targetCheckbox.isSelected()) {
                targetCheckbox.click();
                logger.info(" checkbox has been re-selected.");
            }

        }
        else if (type.equalsIgnoreCase("Members")) {

            if (level == null || level.isEmpty()) {
                throw new IllegalArgumentException("Level must be provided for 'Members'.");
            }

            WebElement dropdown = driver.findElement(By.id("saleStatus.memberTier"));
            dropdown.click();
            logger.info("Dropdown for SALE clicked.");

            WebElement option = driver.findElement(
                    By.xpath("(//div[contains(@class,'ant-select-dropdown')]//div[@title='" + level + "'])[2]"));
            option.click();
            logger.info("Selected sale member level");
        }
    }

    public void inputProductName(String prodName) {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(prodName);
    }

    public void inputKeyWordForSearchProductName(String keyWord) {
        driver.findElement(By.xpath("//input[@id='tag']")).sendKeys(keyWord);
    }

    public void uploadThumbnailImage(String filePath) {
        WebElement uploadInput = driver.findElement(By.xpath("//input[@id='thumbnailImage']"));
        uploadInput.sendKeys(filePath);
    }

    public void uploadTimeSaleImage(String filePath) {
        WebElement uploadInput = driver.findElement(By.xpath("//input[@id='timeSaleImage']"));
        uploadInput.sendKeys(filePath);
    }

    public void uploadDetailImage(String filePath) {
        WebElement uploadInput = driver.findElement(By.xpath("//input[@id='productDetailImages']"));
        uploadInput.sendKeys(filePath);
    }

    public void selectTagSettingDisplay(String iconName, String displayType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String startDate = DateTimeUtils.getCurrentDateTime();
        String endDate = DateTimeUtils.getDateTimePlusDays(30);

        WebElement clickDropdown = driver.findElement(By.id("icon"));
        clickDropdown.click();

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[contains(@class,'ant-select-item ant-select-item-option w-full')]//div[text()='%s']", iconName))
        ));
        option.click();

        String iconRowXpath = String.format("//tr[.//div[text()='%s']]", iconName);
        WebElement iconRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iconRowXpath)));

        WebElement radioButton = iconRow.findElement(By.xpath(
                String.format(".//span[@class='ant-radio-label' and normalize-space(text())='%s']", displayType)
        ));
        radioButton.click();

        if (displayType.equals("기간 설정")) {
            // ⚡ Lấy tất cả input theo placeholder 'Select date' trong đúng hàng icon
            List<WebElement> dateInputs = iconRow.findElements(By.xpath(".//input[contains(@placeholder,'Select date')]"));
            if (dateInputs.size() >= 2) {
                WebElement startInput = dateInputs.get(0);
                WebElement endInput = dateInputs.get(1);

                startInput.click();
                startInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), startDate);
                startInput.sendKeys(Keys.ENTER);
                logger.info("Input start date for tag");

                endInput.click();
                endInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), endDate);
                endInput.sendKeys(Keys.ENTER);
                logger.info("Input end date for tag");

            }

        }
    }


}