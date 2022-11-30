package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//a[text()='Electronics ']"));
        // Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));


        // Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[text()='Cell phones']"));
        Assert.assertEquals("Text : Cell phones", expectedText, actualText);
    }


    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//a[text()='Electronics ']"));

        //2.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //2.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[text()='Cell phones']"));
        Assert.assertEquals("Text : Cell phones", expectedText, actualText);

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(5000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/a[1]/img[1]"));

        //2.6 Verify the text “Nokia Lumia 1020”

        String expectedText1 = "Nokia Lumia 1020";
        String actualText1 = getTextFromElement(By.xpath("//h1[text()='Nokia Lumia 1020']"));
        Assert.assertEquals("Text : Nokia Lumia 1020", expectedText1, actualText1);

        //2.7 Verify the price “$349.00”
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.id("price-value-20"));
        Assert.assertEquals("Price : $349.00", expectedPrice, actualPrice);

        //2.8 Change quantity to 2
        driver.findElement(By.name("addtocart_20.EnteredQuantity")).clear();
        sendTextToElements(By.name("addtocart_20.EnteredQuantity"), "2");
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("The product has been added to your shopping cart", expectedMessage, actualMessage);
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[text()='Shopping cart']"));
        clickOnElement(By.xpath("//button[text()='Go to cart']"));

        //2.12 Verify the message "Shopping cart"
        String expectedMessage1 = "Shopping cart";
        String actualMessage1 = getTextFromElement(By.xpath("//h1[text()='Shopping cart']"));
        Assert.assertEquals("Text : Shopping cart", expectedMessage1, actualMessage1);

        //2.13 Verify the quantity is 2
//        String expectedQuantity = "2";
//        String actualQuantity = getTextFromElement(By.xpath("//input[@value='2']]"));
//        Assert.assertEquals("Quantity : 2", expectedQuantity, actualQuantity);

        //2.14 Verify the Total $698.00
        String expectedTotal = "$698.00";
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        Assert.assertEquals("Total : $698.00", expectedTotal, actualTotal);

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedText2 = "Welcome, Please Sign In!";
        String actualText2 = getTextFromElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        Assert.assertEquals("Welcome, Please Sign In!", expectedText2, actualText2);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[text()='Register']"));

        //2.19 Verify the text “Register”
        String expectedText3 = "Register";
        String actualText3 = getTextFromElement(By.xpath("//h1[text()='Register']"));
        Assert.assertEquals("Text : Register", expectedText3, actualText3);

        //2.20 Fill the mandatory fields
        clickOnElement(By.id("gender-male"));
        sendTextToElements(By.id("FirstName"), "Smith");
        sendTextToElements(By.id("LastName"), "John");
        clickOnElement(By.name("DateOfBirthDay"));
        selectByVisibleTextFromDropDown(By.name("DateOfBirthDay"), "1");
        clickOnElement(By.name("DateOfBirthMonth"));
        selectByVisibleTextFromDropDown(By.name("DateOfBirthMonth"), "May");
        clickOnElement(By.name("DateOfBirthYear"));
        selectByVisibleTextFromDropDown(By.name("DateOfBirthYear"), "1999");
        sendTextToElements(By.id("Email"), "smith112@gmail.com");
        sendTextToElements(By.id("Password"), "smith123");
        sendTextToElements(By.id("ConfirmPassword"), "smith123");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));

        //2.22 Verify the message “Your registration completed”
        String expectedText4 = "Your registration completed";
        String actualText4 = getTextFromElement(By.xpath("//div[text()='Your registration completed']"));
        Assert.assertEquals("Text : Ypur registration completed", expectedText4, actualText4);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[text()='Continue']"));

        //2.24 Verify the text “Shopping card”
        String expectedText5 = "Shopping cart";
        String actualText5 = getTextFromElement(By.xpath("//h1[text()='Shopping cart']"));
        Assert.assertEquals("Text : Shopping text", expectedText5, actualText5);

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.27 Fill the Mandatory fields
        clickOnElement(By.id("BillingNewAddress_CountryId"));
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElements(By.id("BillingNewAddress_City"), "London");
        sendTextToElements(By.id("BillingNewAddress_Address1"), "100, high street");
        sendTextToElements(By.id("BillingNewAddress_ZipPostalCode"), "A1 2AB");
        sendTextToElements(By.id("BillingNewAddress_PhoneNumber"), "07171002233");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        //2.32 Select “Visa” From Select credit card dropdown
        clickOnElement(By.id("CreditCardType"));
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");
        //2.33 Fill all the details
        sendTextToElements(By.id("CardholderName"), "Smith john");
        sendTextToElements(By.id("CardNumber"), "4222222222222");
        clickOnElement(By.id("ExpireMonth"));
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "04");
        clickOnElement(By.id("ExpireYear"));
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2025");
        sendTextToElements(By.id("CardCode"), "643");

        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.35 Verify “Payment Method” is “Credit Card”
        String expectedMethodText = "Credit Card";
        String actualMethodText = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Payment method", actualMethodText, expectedMethodText);

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedMethodText1 = "2nd Day Air";
        String actualMethodText1 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Assert.assertEquals("Payment method", actualMethodText1, expectedMethodText1);

        //2.37 Verify Total is “$698.00”
        String expectedTotal1 = "$698.00";
        String actualTotal1 = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        Assert.assertEquals("Verify Total", expectedMessage1, actualMessage1);
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.39 Verify the Text “Thank You”
        String expectedText6 = "Thank you";
        String actualText6 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Text : Thank You", expectedText6, actualText6);

        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedText7 = "Your order has been successfully processed!";
        String actualText7 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Verify Message", expectedText7, actualText7);

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        String expectedText8 = "Welcome to our store";
        String actualText8 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Verify welcome message", expectedText8, actualText8);

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/
    }

    @After
    public void testDown() {
        closeBrowser();
    }
}
