package TestCases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileTest {

    public static void main(String...a){
        openCalculator();
    }

    WebDriver driver;
    static AppiumDriver appiumDriver;

    public static void openCalculator(){
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","Samsung m31");
        cap.setCapability("udid","RZ8NA1CQA9V");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","11");
        cap.setCapability("appPackage", "com.myos.calculator2");
        cap.setCapability("appActivity","com.myos.calculator2.calculator");
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        appiumDriver = new AppiumDriver<MobileElement>(url,cap);

        System.out.println("application Started");

    }
}
