package TestScripts;

import org.openqa.selenium.WebDriver;
import Pages.CartPage;
import Pages.Homepage;
import Pages.LongPrintedDressPage;
import Pages.ShortPrintedDressPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddingToCartTest {
    @Test
    public void test() throws IOException {
        WebDriver driver= DriverSelection.select("chrome");
        driver.get("https://www.google.com");
        driver.get("http://automationpractice.com/index.php");
        Homepage homepage=new Homepage(driver);
        CartPage cart=new CartPage(driver);
        ShortPrintedDressPage shortPrintedDress=new ShortPrintedDressPage(driver);
        LongPrintedDressPage longPrintedDress=new LongPrintedDressPage(driver);
        try {
            homepage.ViewShortPrintedDress();
            shortPrintedDress.AddShortPrintedDressToCart(driver);
            driver.navigate().back();
            homepage.ViewLongPrintedDress();
            longPrintedDress.AddLongPrintedDressToCart(driver);
            driver.navigate().back();
            homepage.ViewCart();
            cart.GetTotalAmountInCart();
       }
        finally {
            driver.quit();
        }
    }
}
