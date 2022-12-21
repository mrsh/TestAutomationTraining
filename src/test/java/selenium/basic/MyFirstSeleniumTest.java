package selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MyFirstSeleniumTest {

    private WebDriver driver;

    @BeforeClass
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

    @Test
    public void automationExerciseLaunchTest() {
        List<WebElement> headerList = driver.findElements(By.id("header1"));
        Assert.assertNotEquals(headerList.size(),0, "Header section was not displayed");
    }

    @AfterClass
    public void tearDown() {
        //Zamknięcie okna przeglądarki i połączenia między naszym kodem a Chromedriver
        driver.quit();
    }

}
