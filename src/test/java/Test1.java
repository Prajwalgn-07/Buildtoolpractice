import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test1 {
    WebDriver driver;
    @BeforeMethod
    public void driversetup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        driver.get("https://www.google.com");
        driver.get("http://automationpractice.com/index.php");
        WebElement signIn=driver.findElement(By.linkText("Sign in"));
        signIn.click();
    }
    @AfterMethod
    public void closetest(){
        driver.quit();
    }
}
