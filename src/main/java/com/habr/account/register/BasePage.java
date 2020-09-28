package com.habr.account.register;

import com.habr.account.register.elements.*;
import com.habr.account.register.utilites.OpenUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.habr.account.register.elements.FooterElementsEnum.*;

public abstract class BasePage extends BasePageObject implements OpenUrl {
    protected InputRegisterElements inputRegisterElements;
    protected ButtonsElement buttonsElement;
    protected TitleRegisterElement titleRegisterElement;
    protected FooterElements footerElements;

    @FindBy(css = "[class=\"notice error \"]")
    private WebElement errorMessage;

    public BasePage(WebDriver driver) {
        super(driver);
        this.inputRegisterElements = new InputRegisterElements(driver);
        this.buttonsElement = new ButtonsElement(driver);
        this.titleRegisterElement = new TitleRegisterElement(driver);
        this.footerElements = new FooterElements(driver);
        PageFactory.initElements(driver, this);
    }

    public BasePage testTitle(String nameTitle){
        this.getTitle().checkTitle();
        this.getTitle().headerTitle(nameTitle);
        return this;
    }

    public BasePage testFooter(){
        this.getFooter().checkIconFooter();
        this.getFooter().clickAbout(ABOUT);
        this.getFooter().clickAbout(FEEDBACK);
        this.getFooter().clickAbout(AGREEMENT);
        return this;
    }

    public BasePage testChangeLanguage(){
        this.getFooter().changeLanguage();
        return this;
    }

    public BasePage testButtonsAndInputs(){
        this.getButtonsElement().checkButton();
        this.getInputRegisterElements().checkInputAndCheckbox();
        return this;
    }


    public BasePage testClickOnSocialIcon(SocialButtonEnum nameButton){
        this.getButtonsElement().clickButton(nameButton);
        return this;
    }

    public BasePage testInputWork(String emailText, String nicknameText, String passwordText, String repeatPasswordText){
        getInputRegisterElements().clickCheckbox();
        getInputRegisterElements().dataInput(emailText,nicknameText,passwordText,repeatPasswordText);
        getButtonsElement().clickRegistration();
        wait1second.until(ExpectedConditions.visibilityOf(errorMessage));
        return this;
    }

    public TitleRegisterElement getTitle(){return titleRegisterElement;}
    public FooterElements getFooter(){return footerElements;}
    public ButtonsElement getButtonsElement(){return buttonsElement;}
    public InputRegisterElements getInputRegisterElements(){return inputRegisterElements;}
}
