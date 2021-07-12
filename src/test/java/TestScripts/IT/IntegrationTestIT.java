package TestScripts.IT;

import Pages.*;
import Utilities.DriverSelection;
import Utilities.PropertyFileReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class IntegrationTestIT {
    WebDriver driver;
    @BeforeTest
    public void setUpDriver() throws FileNotFoundException {
        PropertyFileReader propertyFileReader=new PropertyFileReader();
        String browser=System.getProperty("browser");
        driver = DriverSelection.select(Objects.requireNonNullElse(browser, "chrome"));
        driver.get("https://www.google.com");
        System.out.println(propertyFileReader.getProperty("url"));
        driver.get(propertyFileReader.getProperty("url"));
    }
    @Test
    public void CreateAccountAddToCart() throws IOException, ParseException {
        Homepage homepage=new Homepage(driver);
        CreateAccountPage createAccountPage=new CreateAccountPage(driver);
        LoginPage loginPage=new LoginPage(driver);
        CartPage cart=new CartPage(driver);
        ShortPrintedDressPage shortPrintedDress=new ShortPrintedDressPage(driver);
        LongPrintedDressPage longPrintedDress=new LongPrintedDressPage(driver);
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        homepage.GoToSignInPage();
        loginPage.TypeEmail();
        loginPage.ClickCreateAccount();
        createAccountPage.FillDetails();
        createAccountPage.submitDetails();
        myAccountPage.pressHomeButton();
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
    public void quitDriver(){
        driver.quit();
    }
}
