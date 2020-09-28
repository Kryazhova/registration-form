package com.habr.account.register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage{

        public StartPage(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver,this);
        }

        @Override
        public StartPage openUrl() {
            driver.get("https://account.habr.com/register/");
            return this;
        }


}
