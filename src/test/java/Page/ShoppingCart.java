package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart extends BasePage{
    public ShoppingCart(WebDriver driver1) {
        super(driver1);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@data-reactid='.0.0.1.0.0.0']")
    private WebElement CheckoutLogo;
    @FindBy(xpath = "//td[@data-reactid='.0.0.1.0.1.0.1.0:$1.0']")
    private WebElement Midtrans;
    @FindBy(xpath = "//td[@data-reactid='.0.0.1.0.1.0.1.1.2']")
    private WebElement PillowPrice;
    @FindBy(xpath = "//input[@data-reactid='.0.0.1.0.3.0.0.0.1.0']")
    private WebElement NameInput;
    @FindBy(xpath = "//input[@data-reactid='.0.0.1.0.3.0.0.1.1.0']")
    private WebElement EmailInput;
    @FindBy(xpath = "//input[@data-reactid='.0.0.1.0.3.0.0.2.1.0']")
    private WebElement PhoneInput;
    @FindBy(xpath = "//input[@data-reactid='.0.0.1.0.3.0.0.3.1.0']")
    private WebElement CityInput;
    @FindBy(xpath = "//textarea[@data-reactid='.0.0.1.0.3.0.0.4.1.0']")
    private WebElement AddressInput;
    @FindBy(xpath = "//input[@data-reactid='.0.0.1.0.3.0.0.5.1.0']")
    private WebElement PostalCodeInput;
    @FindBy(xpath = "//div[@data-reactid='.0.0.1.1.0']")
    private WebElement CheckOutButton;
    private String ShoppingCartAttribute = "//td[@class='input-label']";

    public boolean checkoutlogovisible()
    {
       boolean Flag = wait(CheckoutLogo).isDisplayed() ;
       return Flag;
    }
    public boolean verifymidtransPresent()
    {
       boolean Flag = wait(Midtrans).isDisplayed();
       return Flag;
    }
    public boolean verifyPillowPrice()
    {
        boolean Flag = (wait(PillowPrice).getText()).equalsIgnoreCase(properties.getProperty("Cost"));
        return Flag;
    }
    public boolean verifyNameAttribute()
    {
        boolean Flag = (listHolder(0 , ShoppingCartAttribute)).getText().equals((properties.getProperty("CartCustomerDetails")).substring(0,4));
        return Flag;
    }
    public boolean verifyEmailAttributeName()
    {
        boolean Flag = ((listHolder(1 , ShoppingCartAttribute)).getText()).equals((properties.getProperty("CartCustomerDetails")).substring(4,9));
        return Flag;
    }
    public boolean verifyPhoneAttributeName()
    {
        boolean Flag = (listHolder(2 , ShoppingCartAttribute)).getText().equals((properties.getProperty("CartCustomerDetails")).substring(9,17));
        return Flag;
    }
    public boolean verifyCityAttributeName()
    {
        boolean Flag = (listHolder(3 , ShoppingCartAttribute)).getText().equals((properties.getProperty("CartCustomerDetails")).substring(17,21));
        return Flag;
    }
    public boolean verifyAddressAttributeName()
    {
        boolean Flag = (listHolder(4 , ShoppingCartAttribute)).getText().equals((properties.getProperty("CartCustomerDetails")).substring(21,28));
        return Flag;
    }
    public boolean verifyPostalAttributeName()
    {
        boolean Flag = (listHolder(5 , ShoppingCartAttribute)).getText().equals((properties.getProperty("CartCustomerDetails")).substring(28,39));
        return Flag;
    }

    public void editName()
    {
        wait(NameInput).clear();
        wait(NameInput).sendKeys(properties.getProperty("Name"));
    }
    public void editEmail()
    {
        wait(EmailInput).clear();
        wait(EmailInput).sendKeys(properties.getProperty("Email"));
    }
    public void editPhoneNo()
    {
        wait(PhoneInput).clear();
        wait(PhoneInput).sendKeys(properties.getProperty("Phone"));
    }
    public void editCity()
    {
        wait(CityInput).clear();
        wait(CityInput).sendKeys(properties.getProperty("City"));
    }
    public void editAddress()
    {
        wait(AddressInput).clear();
        wait(AddressInput).sendKeys(properties.getProperty("Address"));
    }
    public void editPostal()
    {
        wait(PostalCodeInput).clear();
        wait(PostalCodeInput).sendKeys(properties.getProperty("Postal"));
    }
    public void clickOnCheckOutButton()
    {
        click(CheckOutButton);
        frameSwitchTo(0);
    }
}
