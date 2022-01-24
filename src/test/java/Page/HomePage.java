package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver1)
    {
        super(driver1);
        PageFactory.initElements(driver , this);
    }

    @FindBy(xpath = "//a[@data-reactid='.0.0.0.0.0.0.0']")
    private WebElement HomeLogo;
    @FindBy(xpath = "//a[@data-reactid='.0.0.0.2.0.0.5']")
    private WebElement BuyNowbutton;
    @FindBy(xpath = "//span[text()='Thank you for your purchase.']")
    private WebElement SuccessMessage;


    public boolean homepagelogodisplayed() {
        boolean Flag = wait(HomeLogo).isDisplayed();
        return Flag;
    }

    public void clickonBUyNow()
    {
        click(BuyNowbutton);
    }
    public boolean successMessageVisible()
    {
        switchDefaultContent();
        boolean Flag =  wait(SuccessMessage).isDisplayed();
        return Flag;
    }
}
