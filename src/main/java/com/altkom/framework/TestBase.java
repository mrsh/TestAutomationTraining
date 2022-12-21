package com.altkom.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;

    @BeforeSuite
    public void setUpBrowser(ITestContext context) {
        //Ustalenie ścieżki do chromedriver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //Umożliwienie wstrzykiwania własnej zawartości do raportu html
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        //Uruchomienie przeglądarki
        driver = new ChromeDriver();
        //Zapis drivera do kontekstu
        context.getSuite().setAttribute("driver", driver);
        //Ustawienie domyślnego timeoutu dla Selenium - program będzie czekał tyle czasu
        //na KAŻDY element na stronie
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Maksymalizacja okna
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @AfterSuite
    public void tearDown() {
        //Zamknięcie okna przeglądarki i połączenia między naszym kodem a Chromedriver
        driver.quit();
    }
}
