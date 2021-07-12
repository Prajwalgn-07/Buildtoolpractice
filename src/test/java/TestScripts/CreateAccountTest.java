package TestScripts;

import Pages.CreateAccountPage;
import Pages.Homepage;
import Pages.LoginPage;
import Utilities.DriverSelection;
import Utilities.PropertyFileReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Objects;

public class CreateAccountTest {
    WebDriver driver;

    public CreateAccountTest() throws IOException {
    }

    @BeforeTest
    public void setupDriver() throws IOException {
        PropertyFileReader propertyFileReader=new PropertyFileReader();
        String browser=System.getProperty("browser");
        driver = DriverSelection.select(Objects.requireNonNullElse(browser, "chrome"));
        driver.get("https://www.google.com");
        System.out.println(propertyFileReader.getProperty("url"));
        driver.get(propertyFileReader.getProperty("url"));
    }
    @Test
    public void test() throws IOException, ParseException {
        Homepage homepage=new Homepage(driver);
        CreateAccountPage createAccountPage=new CreateAccountPage(driver);
        LoginPage loginPage=new LoginPage(driver);
            homepage.GoToSignInPage();
            loginPage.TypeEmail();
            loginPage.ClickCreateAccount();
            createAccountPage.FillDetails();
            System.out.println(driver.getTitle());
//            createAccountPage.submitDetails();
    }
    @AfterTest
    public void exitDriver(){
        driver.quit();
    }
}
