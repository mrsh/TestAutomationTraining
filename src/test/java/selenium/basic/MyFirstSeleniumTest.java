package selenium.basic;

import com.altkom.framework.TestBase;
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

public class MyFirstSeleniumTest extends TestBase {

    @Test
    public void automationExerciseLaunchTest() {
        List<WebElement> headerList = driver.findElements(By.id("header1"));
        Assert.assertNotEquals(headerList.size(),0, "Header section was not displayed");
    }
}
