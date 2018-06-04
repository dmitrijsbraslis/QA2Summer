import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class WebTest {
    private final String HOME_PAGE = "http://javaguru.lv";
    private final By ELEMENT = By.id("12346");
    private final By NAME_ELEMENT = By.name("name");
    private final By CLASS_ELEMENT = By.className("logo");

    @Test
    public void someTest() {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        //Vozvrashaet odin element
        WebElement classElement = driver.findElement(CLASS_ELEMENT);

        //Vozvrashaet vse elementi spiskom
        List<WebElement> classElements = driver.findElements(CLASS_ELEMENT);
        WebElement el = classElements.get(1);
//        classElements.get(5);
//        classElements.get(7);



        WebElement webElement = driver.findElement(ELEMENT);
        webElement.click();
        webElement.sendKeys("Test");

        Assert.assertEquals("", "");

    }
}
