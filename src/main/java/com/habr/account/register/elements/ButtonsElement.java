package com.habr.account.register.elements;

import com.habr.account.register.BasePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonsElement extends BasePageObject {

    @FindBy(css = " [id=\"registration_button\"]")
    private WebElement registration;

    @FindBy(css = "[class=\"socials-buttons__button socials-buttons__button_facebook\"]")
    private WebElement iconFacebook;

    @FindBy(css = "[class=\"socials-buttons__button socials-buttons__button_vkontakte\"]")
    private WebElement iconVk;

    @FindBy(css = "[class=\"socials-buttons__button socials-buttons__button_twitter\"]")
    private WebElement iconTwitter;

    @FindBy(css = "[class=\"socials-buttons__button socials-buttons__button_github\"]")
    private WebElement iconGithub;

    @FindBy(css = "[class=\"socials-buttons__button socials-buttons__button_liveid\"]")
    private WebElement iconLiveID;

    @FindBy(css = "[class=\"socials-buttons__button socials-buttons__button_google google\"]")
    private WebElement iconGoogle;

    public ButtonsElement(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Проверка наличия кнопок")
    public ButtonsElement checkButton(){
        wait1second.until(ExpectedConditions.visibilityOfAllElements(
                iconFacebook,
                iconVk,
                iconGithub,
                iconTwitter,
                iconLiveID,
                iconGoogle,
                registration
        ));
        assertFalse(registration.isEnabled());
        return this;
    }
    String url;
    @Step("Проверка, что при нажатии кнопки соц сети открывается верная ссылка")
    public ButtonsElement clickButton(SocialButtonEnum nameButton){
        button(nameButton);
        if (nameButton==SocialButtonEnum.GOOGLE) {
            String MainWindow = driver.getWindowHandle();
            for (String activeHandle : driver.getWindowHandles()) {
                if (!activeHandle.equals(MainWindow)) {
                    driver.switchTo().window(activeHandle);
                }
            }
        }
        wait1second.until(ExpectedConditions.urlContains(url));
        return this;
    }

    @Step("Нажатие иконки соц сети {nameButton}")
    public WebElement button(SocialButtonEnum nameButton) {
        switch (nameButton) {
            case FACEBOOK:
                iconFacebook.click();
                url = "facebook.com";
                return iconFacebook;
            case VK:
                iconVk.click();
                url = "vk.com";
                return iconVk;
            case TWITTER:
                iconTwitter.click();
                url = "twitter";
                return iconTwitter;
            case GIT:
                iconGithub.click();
                url = "github";
                return iconGithub;
            case LIVE:
                iconLiveID.click();
                url = "live.com";
                return iconLiveID;
            case GOOGLE:
                iconGoogle.click();
                url = "google";
                return iconGoogle;
            default: {
                throw new IllegalStateException("Нет кнопки: " + nameButton);
            }
        }
    }

    @Step("Нажатие на кнопку Зарегистрироваться")
    public ButtonsElement clickRegistration(){
        assertTrue(registration.isEnabled());
        registration.click();
        return this;
    }

}
