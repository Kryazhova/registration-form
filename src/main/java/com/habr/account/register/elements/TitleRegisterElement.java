package com.habr.account.register.elements;

import com.habr.account.register.BasePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TitleRegisterElement extends BasePageObject {

    @FindBy(css = "[class=\"shadow-box__title\"]")
    private WebElement title;

    @FindBy(css = "[for=\"email_field\"]")
    private WebElement titleForEmail;

    @FindBy(css = "[for=\"nickname_field\"]")
    private WebElement titleForName;

    @FindBy(css = "[for=\"password_field\"]")
    private WebElement titleForPassword;

    @FindBy(css = "[for=\"password_repeat\"]")
    private WebElement titleForPasswordRepeat;

    @FindBy(css = "[class=\"checkbox__label-text\"]")
    private WebElement titleForCheckBox;


    public TitleRegisterElement(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("проверка, что присутствуют нужные заголовки")
    public TitleRegisterElement checkTitle () {
        ExpectedConditions.visibilityOfAllElements(
                title,
                titleForEmail,
                titleForName,
                titleForPassword,
                titleForPasswordRepeat,
                titleForCheckBox
        );
        return this;
    }

    @Step("проверка, что заголовок страницы: {realTitle}")
    public TitleRegisterElement headerTitle (String realTitle) {
        assertThat(title.getText(), equalToIgnoringCase(realTitle));
        return this;
    }

}
