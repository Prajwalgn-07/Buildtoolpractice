package TestScripts;

import Pages.CartPage;
import Pages.Homepage;
import Pages.LongPrintedDressPage;
import Pages.ShortPrintedDressPage;
import Utilities.DriverSelection;
import Utilities.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Objects;

public class AddingToCartTest {
    WebDriver driver;
    @BeforeTest
    public void setupDriver() throws IOException {
        PropertyFileReader propertyFileReader=new PropertyFileReader();
        String browser=System.getProperty("browser");
        driver = DriverSelection.select(Objects.requireNonNullElse(browser, "chrome"));
        driver.get("https://www.google.com");
        driver.get(propertyFileReader.getProperty("url"));
    }
    @Test
    public void test(){
        Homepage homepage=new Homepage(driver);
        CartPage cart=new CartPage(driver);
        ShortPrintedDressPage shortPrintedDress=new ShortPrintedDressPage(driver);
        LongPrintedDressPage longPrintedDress=new LongPrintedDressPage(driver);
        homepage.ViewShortPrintedDress();
        shortPrintedDress.AddShortPrintedDressToCart(driver);
        driver.navigate().back();
        homepage.ViewLongPrintedDress();
        longPrintedDress.AddLongPrintedDressToCart(driver);
        driver.navigate().back();
        homepage.ViewCart();
        cart.GetTotalAmountInCart();
    }
    @AfterTest
    public void exitDriver(){
        driver.quit();
    }
}
