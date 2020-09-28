package com.habr.account.register.elements;

import com.habr.account.register.BasePageObject;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;

public class FooterElements extends BasePageObject {

    @FindBy(css = "[class=\"footer-links__link\"]")
    private WebElement language;

    @FindBy(css = "[href=\"https://account.habr.com/info/about/?consumer=default\"]")
    private WebElement about;

    @FindBy(css = "[href=\"https://account.habr.com/feedback/?consumer=default\"]")
    private WebElement feedback;

    @FindBy(css = "[href=\"https://account.habr.com/info/agreement/?consumer=default\"]")
    private WebElement agreement;

    public FooterElements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("проверка, что присутствуют нужные элементы")
    public FooterElements checkIconFooter () {
        ExpectedConditions.visibilityOfAllElements(
                language,
                about,
                feedback,
                agreement
        );
        return this;
    }


    @Step("проверка, что открыется ссылка футера: {nameFooterButton}")
    public FooterElements clickAbout(FooterElementsEnum nameFooterButton){

        switch (nameFooterButton){
            case ABOUT:
                about.click();
                Assert.assertEquals(driver.getCurrentUrl(),"https://account.habr.com/info/about/?consumer=default");
                driver.navigate().back();
                break;
            case FEEDBACK:
                feedback.click();
                Assert.assertEquals(driver.getCurrentUrl(),"https://account.habr.com/feedback/?consumer=default");
                driver.navigate().back();
                break;
            case AGREEMENT:
                agreement.click();
                Assert.assertEquals(driver.getCurrentUrl(),"https://account.habr.com/info/agreement/?consumer=default");
                driver.navigate().back();
                break;
        }
        return this;
    }

    @Step("смена языка")
    public FooterElements changeLanguage(){
        language.click();
        return this;
    }


}
