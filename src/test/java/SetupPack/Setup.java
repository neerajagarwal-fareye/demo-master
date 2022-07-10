package SetupPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Setup {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions builder;

    public static WebDriver LaunchBrowser(String browserName, String executionMode){
        if (executionMode.equalsIgnoreCase("remote")){
            DesiredCapabilities cap = new DesiredCapabilities();
            if (browserName.equalsIgnoreCase("chrome")){
                cap.setCapability("browserName", "chrome");
            }else if  (browserName.equalsIgnoreCase("firefox")){
                cap.setCapability("browserName", "firefox");
            }
            try {
                driver= new RemoteWebDriver(new URL("http://54.201.189.19:port/wd/hub".replace("port", System.getProperty("port"))), cap);
            }catch (MalformedURLException e){
                e.printStackTrace();
            }
        }else{
            if (browserName.equalsIgnoreCase("chrome") && System.getProperty("os.name").indexOf("win") >= 0) {
                System.out.println("Launching Chrome On Windows");
                System.setProperty("webdriver.chrome.driver", "chromedriver_win.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox") && System.getProperty("os.name").indexOf("win") >= 0) {
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("chrome") && (System.getProperty("os.name").indexOf("nix") >= 0 || System.getProperty("os.name").indexOf("nux") >= 0 || System.getProperty("os.name").indexOf("aix") > 0)){
                System.out.println("Launching Chrome On Linux");
                System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                //chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
                driver = new ChromeDriver(chromeOptions);
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MICROSECONDS);
        wait = new WebDriverWait(driver,30);
        builder = new Actions(driver);
        return driver;
    }

}
