package TestCases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileTest {

//    public static void main(String...a){
//        openCalculator();
//    }

    //WebDriver driver;
    AppiumDriver appiumDriver;

    @Test(alwaysRun = true)
    public void openCalculator(){
        DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setCapability("deviceName","Samsung m31");
        cap.setCapability("deviceName","Pixel 2");
        cap.setCapability("udid","emulator-5554");
        //cap.setCapability("udid","RZ8NA1CQA9V");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","10");
        //cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        //cap.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
        cap.setCapability("appPackage", "com.android.chrome");
        cap.setCapability("appActivity","org.chromium.chrome.browser.document.ChromeLauncherActivity");
        URL url = null;
        try {
            //url = new URL("http://127.0.0.1:4723/wd/hub");
            url = new URL("http://172.18.0.5:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        appiumDriver = new AppiumDriver<MobileElement>(url,cap);

        System.out.println("application Started");
//        appiumDriver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07").click();
//        appiumDriver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add").click();
//        appiumDriver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_08").click();
//        appiumDriver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal").click();

        //System.out.println("Result --"+ appiumDriver.findElementById("com.sec.android.app.popupcalculator:id/calc_edt_formula").getText());

//        if(appiumDriver.findElementById("com.sec.android.app.popupcalculator:id/calc_edt_formula").getText().equals("15")){
//            System.out.println("test pass");
//        }else {
//            System.out.println("test fail");
//        }

    }
}
