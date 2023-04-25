package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    String baseurl = "https://demo.nopcommerce.com/";
    String menu;

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    //

    public void selectMenu(String menu) {
        List<WebElement> topMenuName = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li"));
        for (WebElement name : topMenuName) {
            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;


            }
        }
    }
    @Test
    public void verifyPageNavigation(){
        selectMenu("Electronics");
        verifyText("Electronics",By.xpath("//h1[contains(text(),'Electronics')]"),"Electronics");
    }
     @After
    public void tearDown(){
        closeBrowser();
     }
}
