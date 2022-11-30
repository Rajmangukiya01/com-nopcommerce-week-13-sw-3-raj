package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    //This method will click on method

    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void sendTextToElements(By by, String text) {
        //Find the email field element
        WebElement emailField = driver.findElement(by);
        emailField.sendKeys(text);
    }

    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    //This method will switch to alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //This method will accept alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //This method will dismiss alert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //This method will get text from alert
    public void getTextFromAlert() {
        String text = driver.switchTo().alert().getText();
        System.out.println(text);
    }

    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    //Homework

    //selectByValue
    public void selectByValue(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    //selectByIndex (int index)
    public void selectByIndex(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    //selectOptionByContainsText

    //mouseHoverToElement(By by)
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);

        WebElement computer = driver.findElement(by);
        WebElement software = driver.findElement(by);

        //Mouse hover to computers
        actions.moveToElement(computer).build().perform();
    }

    //mouseHoverToElementAndClick(By by)
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(by);
        WebElement software = driver.findElement(by);

        //Click on software in computer
        actions.moveToElement(software).click().build().perform();

    }
}
