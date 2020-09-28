package com.habr.account.register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageObject {
    protected WebDriver driver;
    protected WebDriverWait wait1second;
    protected WebDriverWait wait30second;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.wait1second = new WebDriverWait(driver, 1);
        this.wait30second = new WebDriverWait(driver, 30);
    }

}
