package Page;

import Utilities.GenericMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.FileInputStream;
import java.util.Properties;

public class BasePage extends GenericMethod {
    public WebDriver driver;
    public FileInputStream fis;
    public Properties properties;

    public BasePage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
        properties = new Properties();
        try {
            fis = new FileInputStream("resources/Config.Properties");
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
