package com.devskiller.selenium;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class BaseSeleniumTest {

    protected WebDriver webDriver;

    // @Rule
//  public WireMockRule wireMockRule = new WireMockRule(8089);

    @BeforeClass
    public static void prepareWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        createWebDriver();
    }


    private void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
//    options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1200");
        webDriver = new ChromeDriver(options);


    }
}
