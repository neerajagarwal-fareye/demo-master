package Utilities;

import SetupPack.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GenericMethod extends Setup {
        // Method for Hard wait
        public static void holdExecutionForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }

        //Method for wait till visibility of element
        public WebElement wait(WebElement element)
        {
            return wait.until(ExpectedConditions.visibilityOf(element));
        }

        //Method to click element
        public void click(WebElement element)
        {
            try {
                wait(element).click();
            }catch (StaleElementReferenceException e)
            {
                holdExecutionForSeconds(1);
                element.click();
            }
        }

        //method to enter text
        public void enterText(WebElement element,String Text)
        {
            try {
                wait(element).clear();
                wait(element).sendKeys(Text);
            }catch (StaleElementReferenceException e)
            {
                holdExecutionForSeconds(1);
                element.clear();
                element.sendKeys(Text);
            }
        }

        //Method to Switch frame
        public void frameSwitchTo(int index)
        {
           holdExecutionForSeconds(5);
           try {
               driver.switchTo().frame(index);
           }catch (NoSuchWindowException e)
           {
               driver.switchTo().window(driver.getWindowHandle());
               driver.switchTo().frame(index);
           }
        }

        //Method to brinf focus to defaultContent
        public void switchDefaultContent()
        {
            driver.switchTo().defaultContent();
        }

        //Method to find WebElement from list
        public WebElement listHolder(int index , String xpath) {
        try {
            List<WebElement> Options = driver.findElements(By.xpath(xpath));
            return Options.get(index);
        }catch (IndexOutOfBoundsException e)
        {
            holdExecutionForSeconds(10);
            List<WebElement> Options = driver.findElements(By.xpath(xpath));
            return Options.get(index);
        }

        }
        //Method to find current Time
        public String currentTime()
        {
            if(System.getProperty("webdriver.chrome.driver") == "chromedriver.exe")
            {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy h:");
                LocalDateTime now = LocalDateTime.now();
                return dtf.format(now);

            }else if(System.getProperty("webdriver.gecko.driver") == "geckodriver.exe") {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy h:");
                LocalDateTime now = LocalDateTime.now();
                return dtf.format(now);

            }else
            {
                System.out.println("else condition");
            }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy h:");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
        }
}
