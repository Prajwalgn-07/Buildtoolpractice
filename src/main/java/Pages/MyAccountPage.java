package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageInitialisation{
    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/a")
    WebElement HomeButton;
    public void pressHomeButton(){
        HomeButton.click();
    }
}
