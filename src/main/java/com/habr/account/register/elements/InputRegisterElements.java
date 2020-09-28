package com.habr.account.register.elements;

import com.habr.account.register.BasePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputRegisterElements extends BasePageObject {


    public InputRegisterElements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[id=\"email_field\"]")
    private WebElement email;

    @FindBy(css = "[id=\"nickname_field\"]")
    private WebElement nickname;

    @FindBy(css = "[id=\"password_field\"]")
    private WebElement password;

    @FindBy(css = "[id=\"password_repeat\"]")
    private WebElement repeatPassword;

    @FindBy(css = "[class=\"checkbox__label checkbox__label_top\"]")
    private WebElement userAgreement;


    @Step("проверка, что присутствуют все поля для ввода данных и чекбоксы")
    public InputRegisterElements checkInputAndCheckbox(){
        wait1second.until(ExpectedConditions.visibilityOfAllElements(
           email,
           nickname,
           password,
           repeatPassword,
           userAgreement
        ));
        return this;
    }

    @Step("Тестирование ввода информации в инпуты")
    public InputRegisterElements dataInput(String emailText, String nicknameText, String passwordText, String repeatPasswordText){
        email.sendKeys(emailText);
        nickname.sendKeys(nicknameText);
        password.sendKeys(passwordText);
        repeatPassword.sendKeys(repeatPasswordText);
        return this;
    }

    @Step("Тестирование чекбоксов")
    public InputRegisterElements clickCheckbox(){
        userAgreement.click();
        userAgreement.click();
        return this;
    }
}
