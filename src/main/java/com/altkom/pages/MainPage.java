package com.altkom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class MainPage {

    private WebDriver driver;

    public MainPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Wyciągnięcie listy elementów menu - pobrane zostaną wszystkie elementry ze znacznikiem <li>
    @FindBy(css = "div.col-sm-8 > div > ul > li")
    private List<WebElement> menu;

    //wyszukanie po skróconym xpath
//    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[@class='col-sm-8']/div/ul/li[4]/a")
    //wyszukanie po pełnym xpath
//    @FindBy(xpath = "/html/body/header/div/div/div/div[2]/div/ul/li[4]/a")
    @FindBy(css = "div.col-sm-8 > div > ul > li:nth-child(4) > a")
    private WebElement signupLoginButton;

    public boolean isSignupLoginButtonVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(signupLoginButton));
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public void clickSignupLoginButton() {
        signupLoginButton.click();
    }
}
