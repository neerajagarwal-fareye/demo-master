package TestCases;

import Page.*;
import SetupPack.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MTestCase {
    public WebDriver driver;
    HomePage homePage;
    ShoppingCart shoppingCart;
    OrderSummary orderSummary;
    SelectPayment selectPayment;
    CreditDebitCard creditDebitCard;

    @BeforeClass(groups = {"Req"})
    public void tearUp() {
        driver = Setup.LaunchBrowser("chrome");
        homePage = new HomePage(driver);
        shoppingCart = new ShoppingCart(driver);
        orderSummary  = new OrderSummary(driver);
        selectPayment = new SelectPayment(driver);
        creditDebitCard = new CreditDebitCard(driver);
    }

    @BeforeMethod(groups = {"Req"})
    public void launchWebsite(){
        driver.get(homePage.properties.getProperty("URL"));
        homePage.holdExecutionForSeconds(1);
        Assert.assertTrue(homePage.homepagelogodisplayed());
    }

    @Test(priority = 1 , groups = {"regression"})
    public void verifyMidTransPillowAddedToCartWith20000()
    {
        homePage.clickonBUyNow();
        Assert.assertTrue(shoppingCart.checkoutlogovisible());
        Assert.assertTrue(shoppingCart.verifymidtransPresent());
        Assert.assertTrue(shoppingCart.verifyPillowPrice());

    }

    @Test(priority = 2,groups = {"regression","smoke"})
    public void verifyClickOnBuyNowRedirectToCheckOutPage()
    {
        homePage.clickonBUyNow();
        Assert.assertTrue(shoppingCart.checkoutlogovisible());
    }

    @Test(priority = 3 , groups = {"regression"})
    public void verifyCheckOutDetails()
    {
        homePage.clickonBUyNow();
        Assert.assertTrue(shoppingCart.checkoutlogovisible());
        Assert.assertTrue(shoppingCart.verifyNameAttribute());
        Assert.assertTrue(shoppingCart.verifyEmailAttributeName());
        Assert.assertTrue(shoppingCart.verifyPhoneAttributeName());
        Assert.assertTrue(shoppingCart.verifyCityAttributeName());
        Assert.assertTrue(shoppingCart.verifyAddressAttributeName());
        Assert.assertTrue(shoppingCart.verifyPostalAttributeName());

    }
    @Test(priority = 4 , groups = {"regression"})
    public void verifyNameEmailPhoneCityAddressPostalCodeFieldsAreEditable()
    {
        homePage.clickonBUyNow();
        shoppingCart.checkoutlogovisible();
        shoppingCart.editName();
        shoppingCart.editEmail();
        shoppingCart.editPhoneNo();
        shoppingCart.editCity();
        shoppingCart.editAddress();
        shoppingCart.editPostal();
    }
    @Test(priority = 5,groups={"regression","smoke"})
    public void verifyClickingOnCheckoutButtonRedirectToOrderSummaryPopup()
    {
        verifyClickOnBuyNowRedirectToCheckOutPage();
        shoppingCart.clickOnCheckOutButton();
        Assert.assertTrue(orderSummary.verifyOrderSummaryLogoVisible());
    }

    @Test(priority = 6 , groups = {"regression"})
    public void verifyPriceProductNameDetailsOnOrderSummeryPopup()
    {
        verifyNameEmailPhoneCityAddressPostalCodeFieldsAreEditable();
        shoppingCart.clickOnCheckOutButton();
        Assert.assertTrue(orderSummary.verifyItemName());
        Assert.assertTrue(orderSummary.verifyAmountValueDetails());
        orderSummary.clickOnShippingDetails();
        Assert.assertTrue(orderSummary.verifyShippingDetailsName());
        Assert.assertTrue(orderSummary.verifyShippingDetailsPhoneNo());
        Assert.assertTrue(orderSummary.verifyShippingDetailsEmail());
        Assert.assertTrue(orderSummary.verifyShippingDetailsAddress());
    }
    @Test(priority = 7 , groups = {"regression", "smoke"})
    public void verifyClickingOnContinueButtonRedirectSelectPaymentPage()
    {
        verifyClickOnBuyNowRedirectToCheckOutPage();
        shoppingCart.clickOnCheckOutButton();
        orderSummary.clickOnContinueButton();
        Assert.assertTrue(selectPayment.selectPaymentLogoVisible());
    }
    @Test(priority = 8 , groups = {"regression"})
    public void verifyAllPaymentOptionsListOnPaymentPage()
    {
        verifyClickingOnContinueButtonRedirectSelectPaymentPage();
        Assert.assertTrue(selectPayment.verifyCreditDebitCard_1());
        Assert.assertTrue(selectPayment.verifyATMBankTransfer_2());
        Assert.assertTrue(selectPayment.verifyGoPayotherEWallets_3());
        Assert.assertTrue(selectPayment.verifyShopeePayotherEWallets_4());
        Assert.assertTrue(selectPayment.verifyKlikBCA_5());
        Assert.assertTrue(selectPayment.verifyBCAKlikPay_6());
        Assert.assertTrue(selectPayment.verifyOCTOClicks_7());
        Assert.assertTrue(selectPayment.verifyDanamonOnlineBanking_8());
        Assert.assertTrue(selectPayment.verifyPayBRI_9());
        Assert.assertTrue(selectPayment.verifyLINEPayEcashMandiriEcash_10());
        Assert.assertTrue(selectPayment.verifyTelkomselCash_11());
        Assert.assertTrue(selectPayment.verifyIndomaret_12());
        Assert.assertTrue(selectPayment.verifyAlfaGroup_13());
        Assert.assertTrue(selectPayment.verifyAkulaku_14());

    }
    @Test(priority = 9 , groups = {"regression" , "smoke"})
    public void verifyClickOnCreditDebitCardPaymentMethodRedirectedCardDetailsScreen()
    {
        verifyClickingOnContinueButtonRedirectSelectPaymentPage();
        selectPayment.clickOnCreditDebitCardPromo();
        Assert.assertTrue(creditDebitCard.verifyCreditDebitCardLogoVisible());
    }
    @Test(priority = 10 , groups = {"regression"})
    public void verifyOrderAmountAndApplyCouponCodeAndValidate()
    {
        verifyClickOnCreditDebitCardPaymentMethodRedirectedCardDetailsScreen();
        Assert.assertTrue(creditDebitCard.verifyOnPotongan10Rupiah());
        Assert.assertTrue(creditDebitCard.verifyON10PercentDiscount());
        Assert.assertTrue(creditDebitCard.verifyDemoMasterCard());
    }
    @Test(priority = 11 , groups = {"regression" , "smoke"})
    public void verifyAfterEnteringValidCardDetailsPayNowEnabled()
    {
        verifyClickOnCreditDebitCardPaymentMethodRedirectedCardDetailsScreen();
        creditDebitCard.enterCardNumber();
        creditDebitCard.enteExpiryDate();
        creditDebitCard.enterCVV();
        creditDebitCard.clickOnPayNow();
    }
    @Test(priority = 12 , groups = {"regression"})
    public void verifyClickingOnPayNowRedirectToBankPaymentScreenThanVerifyAllExitingDetails()
    {
        verifyAfterEnteringValidCardDetailsPayNowEnabled();
        Assert.assertTrue(creditDebitCard.verifyMerchantName());
        Assert.assertTrue(creditDebitCard.verifyAmount());
        Assert.assertTrue(creditDebitCard.verifyCardNumber());
        Assert.assertTrue(creditDebitCard.verifyTransactionTime());
    }
    @Test(priority = 13 , groups = {"regression" , "smoke"})
    public void verifyOnClickingOKButtonWithValidOTPRedirectToOrderSuccssfullScreen()
    {
        verifyAfterEnteringValidCardDetailsPayNowEnabled();
        creditDebitCard.enterOTP();
        creditDebitCard.clickOnOKButton();
        Assert.assertTrue(homePage.successMessageVisible());
    }
    @Test(priority = 14 , groups = {"regression"})
    public void verifyOnClickingOKButtonWithInvalidOTPRedirectToOrderFailedScreen()
    {
        verifyAfterEnteringValidCardDetailsPayNowEnabled();
        creditDebitCard.enterInValidOTP();
        creditDebitCard.clickOnOKButton() ;
        Assert.assertTrue(creditDebitCard.failedScreenDiplayed());
    }
    @Test(priority = 15 , groups = {"regression"})
    public void verifyOnClickingCancelButtonRedirectToOrderFailedScreen()
    {
        verifyAfterEnteringValidCardDetailsPayNowEnabled();
        creditDebitCard.clickOnCancelButton();
        Assert.assertTrue(creditDebitCard.failedScreenDiplayed());
    }
    @AfterClass(groups = {"Req"})
    public void teardown()
    {
        driver.quit();
    }

}




