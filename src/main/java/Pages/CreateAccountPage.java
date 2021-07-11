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

public class CreateAccountPage extends PageInitialisation {
    public CreateAccountPage(WebDriver driver) throws IOException, ParseException {
        super(driver);
    }
    @FindBy(id="id_gender1")
    WebElement male;
    @FindBy(id="id_gender2")
    WebElement female;
    @FindBy(id="customer_firstname")
    WebElement firstname;
    @FindBy(id="customer_lastname")
    WebElement lastname;
    @FindBy(id="passwd")
    WebElement password;
    @FindBy(id="days")
    WebElement dateInDOB;
    @FindBy(id="months")
    WebElement monthInDOB;
    @FindBy(id="years")
    WebElement yearInDOB;
    @FindBy(id="address1")
    WebElement address;
    @FindBy(id="city")
    WebElement cityName;
    @FindBy(id="id_state")
    WebElement stateId;
    @FindBy(id="postcode")
    WebElement postcode;
    @FindBy(id="id_country")
    WebElement countryId;
    @FindBy(id="phone_mobile")
    WebElement mobileNumber;
    @FindBy(id="alias")
    WebElement aliasAddress;
    @FindBy(id="submitAccount")
    WebElement submitDetails;
    JSONParser parser=new JSONParser();
    Object obj=parser.parse(new FileReader("/Users/prajwal/Desktop/testvagrant /assignment projects/Buildtoolpractice/src/test/java/Properties/details.json"));
    JSONObject jsonObject=(JSONObject) obj;
    public void FillDetails(){
        if(jsonObject.get("gender").equals("male")){
            male.click();
        }
        else{
            female.click();
        }
        firstname.sendKeys((String)jsonObject.get("firstName"));
        lastname.sendKeys((String)jsonObject.get("lastName"));
        password.sendKeys((String)jsonObject.get("password"));
        Select date=new Select(dateInDOB);
        date.selectByValue((String)jsonObject.get("date"));
        Select month=new Select(monthInDOB);
        month.selectByValue((String)jsonObject.get("month"));
        Select year=new Select(yearInDOB);
        year.selectByValue(((String)jsonObject.get("year")));
        address.sendKeys((String)jsonObject.get("address"));
        cityName.sendKeys((String)jsonObject.get("city"));
        Select country=new Select(countryId);
        country.selectByValue("21");
        Select state=new Select(stateId);
        state.selectByValue("47");
        postcode.sendKeys((String)jsonObject.get("postCode"));
        mobileNumber.sendKeys((String)jsonObject.get("mobileNumber"));
        aliasAddress.clear();
        aliasAddress.sendKeys((String)jsonObject.get("aliasAddress"));
    }
    public void submitDetails(){
        submitDetails.click();
    }
}
