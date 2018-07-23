package pageObjectTest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class BaseFunc {
    WebDriver driver;

    //конструктор - ничего не возвращает, называется так же как класс
    //всё, что внутри, выполняется принудительно как только создаём этот объект
    public BaseFunc() {
        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public List<WebElement> getElements(By locator) {
        Assert.assertFalse("No elements found", driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        //Так можем проверить есть ли вобще такой элемент на странице
        //всегда надо проверять элемент на присутствие прежде чем использовать его
        Assert.assertFalse("Element not found", getElements(locator).isEmpty());
        return driver.findElement(locator);
    }
}
