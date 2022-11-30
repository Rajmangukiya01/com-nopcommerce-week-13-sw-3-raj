package computer;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //Click on the computer menu
        clickOnElement(By.xpath("//div/ul[1]/li[1]/a[text()='Computers ']"));

        //Click on desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));

        //Select sort by position Name Z to A
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: Z to A");

        // Verify the Product will arrange in Descending order

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        //Click on the computer menu
        clickOnElement(By.xpath("//div/ul[1]/li[1]/a[text()='Computers ']"));

        //Click on desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));


        //Select sort by position Name A to Z
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: A to Z");
        Thread.sleep(5000);

        //Click on add to cart
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        // Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//h1[text()='Build your own computer']"));
        Assert.assertEquals("Text : Build your own computer", expectedText, actualText);

        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        clickOnElement(By.name("product_attribute_1"));
        selectByVisibleTextFromDropDown(By.name("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //Select "8GB [+$60.00]" using Select class.
        clickOnElement(By.name("product_attribute_2"));
        selectByVisibleTextFromDropDown(By.name("product_attribute_2"), "8GB [+$60.00]");

        // Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        // Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));

        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        //clickOnElement(By.id("product_attribute_5_10"));
        clickOnElement(By.id("product_attribute_5_12"));

        //Verify the price "$1,475.00"
        Thread.sleep(5000);
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.id("price-value-1"));
        Assert.assertEquals("Price", expectedPrice, actualPrice);

        //Click on "ADD TO CARD" Button
        clickOnElement(By.id("add-to-cart-button-1"));

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedText1 = "The product has been added to your shopping cart";
        String actualText1 = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals(expectedText1, actualText1);

        //After that close the bar clicking on the cross button
        clickOnElement(By.xpath("//span[@class='close']"));

        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        // Verify the message "Shopping cart"
        String expectedText2 = "Shopping cart";
        String actualText2 = getTextFromElement(By.xpath("//h1[text()='Shopping cart']"));
        Assert.assertEquals("Text : Shopping cart", expectedText2, actualText2);

        //Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        sendTextToElements(By.xpath("//input[@value='1']"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //Verify the Total"$2,950.00"


        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.name("termsofservice"));

        // Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        // Verify the Text “Welcome, Please Sign In!”
        String expectedText3 = "Welcome, Please Sign In!";
        String actualText3 = getTextFromElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        Assert.assertEquals("Text : Welcome, Please Sign In! ", expectedText3, actualText3);

        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));

        // Fill the all mandatory field
        sendTextToElements(By.id("BillingNewAddress_FirstName"), "Raj");
        sendTextToElements(By.id("BillingNewAddress_LastName"), "Mangukiya");
        sendTextToElements(By.id("BillingNewAddress_Email"), "raj123@gmail.com");
        clickOnElement(By.id("BillingNewAddress_CountryId"));
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElements(By.id("BillingNewAddress_City"), "London");
        sendTextToElements(By.id("BillingNewAddress_Address1"), "100, High road");
        sendTextToElements(By.id("BillingNewAddress_ZipPostalCode"), "A1 2AB");
        sendTextToElements(By.id("BillingNewAddress_PhoneNumber"), "07171002233");

        //Click on “CONTINUE”
        clickOnElement(By.name("save"));

        // Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));

        // Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));


        // Select “Master card” From Select credit card dropdown
        clickOnElement(By.id("CreditCardType"));
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");

        // Fill all the details
        sendTextToElements(By.id("CardholderName"), "Raj Mangukiya");
        sendTextToElements(By.id("CardNumber"), "5555555555554444");
        clickOnElement(By.id("ExpireMonth"));
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "06");
        clickOnElement(By.id("ExpireYear"));
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2026");
        sendTextToElements(By.id("CardCode"), "624");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //Verify “Payment Method” is “Credit Card”
        String expectedText4 = "Credit Card";
        String actualText4 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Text : Credit Card", expectedText4, actualText4);

        // Verify “Shipping Method” is “Next Day Air”
        String expectedText5 = "Next Day Air";
        String actualText5 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Assert.assertEquals("Text : Next Day Air", expectedText5, actualText5);

        // Verify Total is “$2,950.00”
        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        Assert.assertEquals("Total : $2,950.00", expectedTotal, actualTotal);

        // Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        // Verify the Text “Thank You”
        String expectedText6 = "Thank you";
        String actualText6 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Text : Thank You", expectedText6, actualText6);

        // Verify the message “Your order has been successfully processed!”
        String expectedText7 = "Your order has been successfully processed!";
        String actualText7 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Text : Your order has been successfully processed!", expectedText7, actualText7);

        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        // Verify the text “Welcome to our store"
        String expectedText8 = "Welcome to our store";
        String actualText8 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Text : Welcome to our store", expectedText8, actualText8);
    }

    @After
    public void testDown() {
        closeBrowser();
    }
}
