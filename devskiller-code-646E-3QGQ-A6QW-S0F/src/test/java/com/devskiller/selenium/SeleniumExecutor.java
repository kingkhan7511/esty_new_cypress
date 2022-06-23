package com.devskiller.selenium;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;


import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static utils.Utility.reader;

public class SeleniumExecutor implements Executor {

    private final WebDriver driver;
    public String text;

    public SeleniumExecutor(WebDriver driver) {
        this.driver = driver;
    }

    By senderNameField = By.xpath("//button[@class=\"wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin\"]");

    By inputLogin = By.xpath("//input[@id=\"join_neu_email_field\"]");
    By continueLogin = By.xpath(" //button[@class=\"wt-btn wt-btn--primary wt-width-full\"]");

    By inputPassword = By.xpath("//input[@id=\"join_neu_password_field\"]");

    By signIn = By.xpath("//button[@class=\"wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin\"]");

    By jewllery = By.xpath("(//a[@class=\"wt-text-link-no-underline\"])[1]");
    By Item = By.xpath("//p[text()=\"Embroidery\"]");
    By addBasket = By.xpath("(//button[@class=\"wt-btn wt-btn--filled wt-width-full\"])[1]");
    By selectOption = By.xpath("(//select[@id=\"variation-selector-0\"])[1]\n");
    By optionSelected = By.xpath(" (//option[@value=\"2529600589\"])\n");
    By mainScreenMessage = By.xpath("//h1[@id=\"join-neu-overlay-title\"]");

    By accessoriesPageTitle = By.xpath("//h1[@class=\"wt-text-heading-01 wt-display-inline wt-mb-xs-2 wt-overflow-hidden\"]");
    By itemSelected = By.xpath("(//div[@class=\"height-placeholder\"])[2]\n");
    By selectColor = By.xpath(" //select[@id=\"variation-selector-0\"]");
    By colorSelected = By.xpath(" //option[@value=\"2699713867\"]");
    By addToBasket = By.xpath("//button[@class=\"wt-btn wt-btn--filled wt-width-full\"]");
    By titleActualAfterAddedToBasket = By.xpath("//a[@class=\"wt-text-link-no-underline wt-text-body-01 wt-line-height-tight wt-break-word\"]");
    By deliveryValueBeforeUpdation = By.xpath(" (//span[@class=\"currency-value\"])[6]");
    By personalizationText = By.xpath(" //p[@id=\"personalization-instructions\"]");
    By signoutImage = By.xpath(" //span[@class=\"wt-menu__trigger__label\"]");
    By signoutClick = By.xpath(" //p[text()=\"Sign out\"]");


    /// Page 1
    @Override
    public void SetLoginAndClickNext(String login) throws InterruptedException {
        String senderName = reader().getCellData1("Sheet1", login, 1);


        driver.findElement(signIn).click();
        Thread.sleep(3000);

        driver.findElement(inputLogin).sendKeys(senderName);


    }

    @Override

    public void SetPassword(String login) throws InterruptedException {

        String name = reader().getCellData1("Sheet1", login, 2);


        Thread.sleep(3000);
        boolean pass = driver.findElements(By.xpath("//button[@class=\"wt-btn wt-btn--primary wt-width-full\"]")).size() != 0;
        if (pass) {
            driver.findElement(By.xpath("//button[@class=\"wt-btn wt-btn--primary wt-width-full\"]")).click();
        } else {
            driver.findElement(inputPassword).sendKeys(name);
            driver.findElement(By.xpath("//button[@class=\"wt-btn wt-btn--primary wt-width-full\"]")).click();

        }
        Thread.sleep(3000);
        driver.findElement(inputPassword).sendKeys(name);

        driver.findElement(By.xpath("//button[@class=\"wt-btn wt-btn--primary wt-width-full\"]")).click();


    }

    @Override
    public void SelectGiftIdeas() {

    }


    public void SelectJewllery() throws InterruptedException {
        String expectedTitle = "Baseball & Trucker Caps";


//

        WebElement jewl = driver.findElement(By.xpath("(//a[@class=\"wt-text-link-no-underline\"])[1]"));

        Actions action = new Actions(driver);

//Performing the mouse hover action on the target element.
        action.moveToElement(jewl).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//li[@data-node-id=\"10856\"])[1]")).click();

        driver.findElement(By.xpath("//a[@id=\"catnav-l4-12291\"]")).click();
        String actualTitle = driver.findElement(accessoriesPageTitle).getText();
        Assert.assertEquals(actualTitle, expectedTitle);

    }


    @Override

    public void ShopItem() throws InterruptedException {
        driver.findElement(Item).click();
        Thread.sleep(2000);
        driver.findElement(itemSelected).click();

    }


    public void AddBasket() throws InterruptedException {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                String titleExpectedBeforeAddedToBasket = driver.findElement(By.xpath("//h1[@class=\"wt-text-body-03 wt-line-height-tight wt-break-word\"]")).getText();

                driver.findElement(selectColor).click();
                WebElement element = driver.findElement(By.id("variation-selector-0"));
                Select select = new Select(element);
                select.selectByIndex(1);
                boolean selected = driver.findElements(By.xpath("//select[@id=\"variation-selector-1\"]")).size() != 0;
                if (selected) {
                    driver.findElement(By.xpath("//select[@id=\"variation-selector-1\"]")).click();
                    Thread.sleep(2000);
                    WebElement elementselected = driver.findElement(By.id("variation-selector-1"));
                    Select selct = new Select(elementselected);
                    selct.selectByIndex(1);
                } else {
                    System.out.println("hello");
                }
                Thread.sleep(3000);
                boolean selection = driver.findElements(By.xpath("//option[@value=\"2464038694\"]")).size() != 0;
                if (selection) {
                    driver.findElement(By.xpath("//option[@value=\"2464038694\"]")).click();
                } else {

                    System.out.println("Nothing");
                }

                Thread.sleep(3000);
                boolean selectinput = driver.findElements(By.xpath("//textarea[@class=\"wt-textarea wt-textarea\"]")).size() != 0;
                if (selectinput) {
                    driver.findElement(By.xpath("//textarea[@class=\"wt-textarea wt-textarea\"]")).sendKeys("ans.jamil1@gmail.com");

                } else {

                    System.out.println("Nothing");
                }

                driver.findElement(addToBasket).click();


                String actualTitle = driver.findElement(titleActualAfterAddedToBasket).getText();
                Assert.assertEquals(titleExpectedBeforeAddedToBasket, actualTitle);
                String value = driver.findElement(deliveryValueBeforeUpdation).getText();
                UpdateAndVerifyBucket(value);


            }


        }
    }


    private void UpdateAndVerifyBucket(String value) throws InterruptedException {
        System.out.println(value);

        driver.findElement(By.xpath("(//select[@name=\"listing-quantity\"])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//option[@value=\"3\"])[2]")).click();

        String valueAfterUpdation = driver.findElement(By.xpath("(//span[@class=\"currency-value\"])[6]")).getText();
        System.out.println(valueAfterUpdation);

    }


    public void UpdateAndVerifyBucket() {


    }

    public void logOut() {
        driver.findElement(signoutImage).click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        driver.findElement(signoutClick).click();


    }

}
