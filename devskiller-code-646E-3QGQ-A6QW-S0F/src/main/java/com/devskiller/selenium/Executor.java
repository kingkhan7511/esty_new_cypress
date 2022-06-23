package com.devskiller.selenium;

public interface Executor {

    void SetLoginAndClickNext(String login) throws InterruptedException;

    void SetPassword(String pass) throws InterruptedException;


    void SelectGiftIdeas();

    void ShopItem() throws InterruptedException;

    void AddBasket() throws InterruptedException;


    void SelectJewllery() throws InterruptedException;


    void UpdateAndVerifyBucket();

    void logOut();
}
