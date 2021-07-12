package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends PageInitialisation {
    public Homepage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath="//*[@id=\"homefeatured\"]/li[3]/div/div[2]/h5/a")
    WebElement shortPrintedDress;
    @FindBy(xpath ="//*[@id=\"homefeatured\"]/li[4]/div/div[2]/h5/a")
    WebElement longPrintedDress;
    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    WebElement cart;
    @FindBy(linkText = "Sign in")
    WebElement signIn;
    @FindBy(id="contact-link")
    WebElement contactUs;
    public void ViewShortPrintedDress(){
        shortPrintedDress.click();
    }
    public void ViewLongPrintedDress(){
        longPrintedDress.click();
    }
    public void ViewCart(){
        cart.click();
    }
    public void GoToSignInPage(){
        signIn.click();
    }
    public void GoToContactUs(){
        contactUs.click();
    }

}
