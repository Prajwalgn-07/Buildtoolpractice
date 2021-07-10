package TestScripts;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import Pages.CreateAccountPage;
import Pages.Homepage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateAccountTest {
    @Test
    public void test() throws IOException, ParseException {
        WebDriver driver= DriverSelection.select("chrome");
        driver.get("https://www.google.com");
        driver.get("http://automationpractice.com/index.php");
        Homepage homepage=new Homepage(driver);
        CreateAccountPage createAccountPage=new CreateAccountPage(driver);
        LoginPage loginPage=new LoginPage(driver);
        try {
            homepage.GoToSignInPage();
            loginPage.TypeEmail();
            loginPage.ClickCreateAccount();
            createAccountPage.FillDetails();
            System.out.println(driver.getTitle());
//            createAccountPage.submitDetails();
        }
        finally {
            driver.quit();
        }
    }
}
