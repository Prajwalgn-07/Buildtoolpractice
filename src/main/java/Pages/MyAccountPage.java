package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageInitialisation{
    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    @FindBy(className ="btn btn-default button button-small")
    WebElement HomeButton;
    public void pressHomeButton(){
        HomeButton.click();
    }
}
