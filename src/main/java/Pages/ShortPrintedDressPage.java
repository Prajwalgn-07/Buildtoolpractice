package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShortPrintedDressPage extends PageInitialisation {
    public ShortPrintedDressPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    WebElement addToCartButton;
    public void AddShortPrintedDressToCart(WebDriver driver) {
        By imageInPopUpAfterPressingCartButton= By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/div[1]/img");
        WebDriverWait wait=new WebDriverWait(driver,10);
        addToCartButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(imageInPopUpAfterPressingCartButton));
    }
    }
