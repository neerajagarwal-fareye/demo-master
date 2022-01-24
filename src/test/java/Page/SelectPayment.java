package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectPayment extends HomePage{
    public SelectPayment(WebDriver driver1)
    {
        super(driver1);
        PageFactory.initElements(driver , this);
    }
    @FindBy(xpath = "//p[@class='text-page-title-content']")
     private WebElement SelectPaymentLogo;
    @FindBy(xpath = "//span[text()='promo']")
    private WebElement ClickOnCreditDebitCardPromo;
    private String PayMentList = "//div[@class='list-title text-actionable-bold']";

    public boolean selectPaymentLogoVisible()
    {
        boolean Flag = wait(SelectPaymentLogo).isDisplayed();
        return Flag;
    }
    public boolean verifyCreditDebitCard_1()
    {
        boolean Flag = (listHolder(0 , PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_1"));
        return Flag;
    }
    public boolean verifyATMBankTransfer_2()
    {
        boolean Flag = (listHolder(1 , PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_2"));
        return Flag;
    }
    public boolean verifyGoPayotherEWallets_3()
    {
        boolean Flag = (listHolder(2 , PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_3"));
        return Flag;
    }
    public boolean verifyShopeePayotherEWallets_4()
    {
        boolean Flag = (listHolder(3 , PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_4"));
        return Flag;
    }

    public boolean verifyKlikBCA_5()
    {
        boolean Flag = (listHolder(4 , PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_5"));
        return Flag;
    }
    public boolean verifyBCAKlikPay_6()
    {
        boolean Flag = (listHolder(5 , PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_6"));
        return Flag;
    }
    public boolean verifyOCTOClicks_7()
    {
        boolean Flag = (listHolder(6 , PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_7"));
        return Flag;
    }
    public boolean verifyDanamonOnlineBanking_8()
    {
        boolean Flag = (listHolder(7 , PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_8"));
        return Flag;
    }
    public boolean verifyPayBRI_9()
    {
        boolean Flag = (listHolder(8 , PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_9"));
        return Flag;
    }
    public boolean verifyLINEPayEcashMandiriEcash_10()
    {
        boolean Flag = (listHolder(9, PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_10"));
        return Flag;
    }
    public boolean verifyTelkomselCash_11()
    {
        boolean Flag = (listHolder(10, PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_11"));
        return Flag;
    }
    public boolean verifyIndomaret_12()
    {
        boolean Flag = (listHolder(11, PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_12"));
        return Flag;
    }
    public boolean verifyAlfaGroup_13()
    {
        boolean Flag = (listHolder(12, PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_13"));
        return Flag;
    }
    public boolean verifyAkulaku_14()
    {
        boolean Flag = (listHolder(13, PayMentList)).getText().equalsIgnoreCase(properties.getProperty("PayMentList_14"));
        return Flag;
    }

    public void clickOnCreditDebitCardPromo()
    {
        click(ClickOnCreditDebitCardPromo);
    }
}
