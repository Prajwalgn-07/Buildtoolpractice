package Pages;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.FileReader;
import java.io.IOException;

public class ContactUsPage extends PageInitialisation {
    public ContactUsPage(WebDriver driver) throws IOException, ParseException {
        super(driver);
    }
    JSONParser parser=new JSONParser();
    Object obj=parser.parse(new FileReader("/Users/prajwal/Desktop/testvagrant /assignment projects/Buildtoolpractice/src/main/java/Properties/details.json"));
    JSONObject jsonObject=(JSONObject) obj;
    @FindBy(id="id_contact")
    WebElement subjectHeading;
    @FindBy(id="email")
    WebElement email;
    @FindBy(id="message")
    WebElement messageBox;
    @FindBy(id="submitMessage")
    WebElement submitButton;
    public void addMessage(String message){
        messageBox.sendKeys(message);
    }
    public void selectSubjectHeading(){
        Select heading=new Select(subjectHeading);
        heading.selectByValue("2");
    }
    public void addEmail(){
        email.sendKeys((String)jsonObject.get("email"));
    }
    public void sendMessage(){
        submitButton.click();
    }

}
