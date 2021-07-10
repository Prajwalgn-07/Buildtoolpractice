package Pages;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileReader;
import java.io.IOException;

public class LoginPage extends PageInitialisation {
    public LoginPage(WebDriver driver) throws IOException, ParseException {
        super(driver);
    }
    @FindBy(id="email_create")
    WebElement CreateEmailAccount;
    @FindBy(id="SubmitCreate")
    WebElement CreateAnAccountButton;
    JSONParser parser=new JSONParser();
    Object obj=parser.parse(new FileReader("/Users/prajwal/Desktop/testvagrant /assignment projects/Buildtoolpractice/src/test/java/Properties/details.json"));
    JSONObject jsonObject=(JSONObject) obj;
    public void TypeEmail(){
        String email=(String)jsonObject.get("email");
        CreateEmailAccount.sendKeys(email);
    }
    public void ClickCreateAccount(){
        CreateAnAccountButton.click();
    }
}
