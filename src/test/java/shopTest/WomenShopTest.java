package shopTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WomenShopTest {

    //Выносим WebDriver на уровень класса, что бы он был доступен во всех методах этого класса
    private WebDriver driver;

    private final String HOME_PAGE = "http://automationpractice.com";
    private final By MAIN_MENU_ITEMS = By.xpath(".//ul[@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a");
    private final By FILTER_CHECK_BOX = By.xpath(".//ul[@class = 'col-lg-12 layered_filter_ul']/li/label");
    private final By COLOR_FILTER = By.xpath(".//ul[@class = 'col-lg-12 layered_filter_ul color-group']/li/label");
    private final By LOADER = By.xpath(".//ul[@class = 'product_list grid row']/p");
    private final By LIST_VIEW_ICON = By.className("icon-th-list");

    private final Logger LOGGER = LogManager.getLogger(WomenShopTest.class);

    @Test
    public void dressesTest() {
        LOGGER.info("Setting Gecko global property");
        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");

        LOGGER.info("Open Browser");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening Home Page");
        driver.get(HOME_PAGE);

        //код, который потом может быть использован в других тестах, выносим в отдельный метод, который потом просто вызываем подавая параметры
        selectMenuItem("WOMEN");

        //здесь вызываем метрод, который заселектит нужный нам чек бокс в определённом фильтре
        selectFilter("Dresses", FILTER_CHECK_BOX);
        waitLoad();

        selectFilter("Orange", COLOR_FILTER);
        waitLoad();

        LOGGER.info("Click to view icon");
        driver.findElement(LIST_VIEW_ICON).click();
    }

    //Этот метод может использоваться для выбора любого пункта основного менюб надо его только передать как параметр
    private void selectMenuItem(String menuItem) {
        LOGGER.info("Selecting " + menuItem);
        List<WebElement> menuItems = driver.findElements(MAIN_MENU_ITEMS);

        //цикл: принимает 3 параметра: с какого элемента обходим, по какой элемент, с каким шагом
        //если не знаем количество элементов в списке - метод .size возвращает кол-во элементов
        for (int i = 0; i < menuItems.size(); i++) {
            //.equals - в случае работы со строками - проверяет на полное совпадение строк
            if (menuItems.get(i).getText().equals(menuItem)) {
                menuItems.get(i).click();
                break;
            }
        }
    }

    private void selectFilter(String filterName, By locator) {
        LOGGER.info("Selecting from filter " + filterName);
        List<WebElement> filterItems = driver.findElements(locator);

        //аналог цикла for - данная запись должна быть использована если обходим все элементы списка
        //1. Указываем с какими объектами работаем - WebElement (именно из них состоит список, который обходим)
        //2. Указываем название - через это название мы раблтаем с каждым элементом списка
        //3. После двоеточия указываем какой список обходим
        for (WebElement filterItem : filterItems) {
            //.contains - в случае работы со строками - проверяет на частичное совпадение строк
            if (filterItem.getText().contains(filterName)) {
                filterItem.click();
                break;
            }
        }
    }

    //Ожидание, указываем "окно браузера" в котором ждём, таимаут - сколько максимум времени ждём, далее указываем условие которое ожидаем
    //Селениум будет постоянно проверять, выполнилось ли условие, если да - не ждём до конца - идём дальше - так экономим время
    private void waitLoad() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(LOADER));
    }
}
