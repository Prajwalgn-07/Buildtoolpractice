package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSelection {
    public static WebDriver select(String webdriver){
        if(webdriver=="chrome"){
            WebDriverManager.chromedriver().setup();
                //headless
                    ChromeOptions options=new ChromeOptions();
                    /*chrome options default size is mobile window, if we don't mention window size it will
                      open in mobile size window and it may generate element not found exception*/
                    options.addArguments("window-size=1400,800");
                    options.addArguments("headless");
            WebDriver cdriver=new ChromeDriver();//if we want headless pass new ChromeDriver(options)
            EventFiringWebDriver driver=new EventFiringWebDriver(cdriver);
            ActivityCapture activityCapture=new ActivityCapture();
            driver.register(activityCapture);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return driver;
        }
        else {
            WebDriverManager.firefoxdriver().setup();
                //headless
                    FirefoxBinary firefoxBinary=new FirefoxBinary();
                    firefoxBinary.addCommandLineOptions("--headless");
                    FirefoxOptions firefoxOptions=new FirefoxOptions();
                    firefoxOptions.setBinary(firefoxBinary);
            WebDriver fdriver=new FirefoxDriver();//if we want headless pass new FirefoxDriver(firefoxOptions)
            EventFiringWebDriver driver=new EventFiringWebDriver(fdriver);
            ActivityCapture activityCapture=new ActivityCapture();
            driver.register(activityCapture);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return driver;
        }
    }
//    public static WebDriver RemoteWebDriver() throws MalformedURLException{
//        DesiredCapabilities capabilities=new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");//change to firefox, if firefox is needed
//        String nodeUrl;//initialize the node url to this variable
//        capabilities.setPlatform(Platform.MAC);//we can change it to which ever the node system is
//        WebDriver driver;
//        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
//        return driver;
//    }
}
