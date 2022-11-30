package homepage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        String mainMenu = menu.toLowerCase();
        String expression = "//a[@href ='/" + mainMenu + "']";
        driver.findElement(By.xpath(expression)).click();
    }
}
