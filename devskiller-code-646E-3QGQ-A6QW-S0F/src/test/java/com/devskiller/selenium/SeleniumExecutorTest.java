package com.devskiller.selenium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SeleniumExecutorTest extends BaseSeleniumTest {

    private static final String LOGIN = "lpassion598@gmail.com";
    private static final String PASSWORD = "singleuser!";

    @Test
    public void MultifactorAuthenticationLogin() throws InterruptedException {
        webDriver.get("https://www.etsy.com/");
        Executor executor = new SeleniumExecutor(webDriver);


        executor.SelectJewllery();
        executor.ShopItem();
        executor.AddBasket();
        executor.UpdateAndVerifyBucket();
        executor.SetLoginAndClickNext(LOGIN);
        executor.SetPassword(LOGIN);


    }
}
