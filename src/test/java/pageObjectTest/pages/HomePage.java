package pageObjectTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By ARTICLE_TITLE = By.xpath(".//a[@class = 'top2012-title']");

    BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitleById(Integer id) {
        return getArticleByID(id).getText();
    }

    public void openArticlePage(Integer id) {
        getArticleByID(id).click();
    }

    private WebElement getArticleByID(Integer id) {
        List<WebElement> articles = baseFunc.getElements(ARTICLE_TITLE);
        return articles.get(id);
    }
}
