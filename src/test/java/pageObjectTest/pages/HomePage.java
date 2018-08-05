package pageObjectTest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By ARTICLE_TITLE = By.xpath(".//a[@class = 'top2012-title']");
    private final By DELFI_LOGO = By.xpath(".//img[@alt = 'DELFI']");
    private final By COMMERCIAL = By.xpath(".//div[@class = 'top-banner']");
    private final By MENU = By.xpath(".//nav[@class = 'headerMainNavigation headerSeparatedNav']");

    BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

        Assert.assertTrue("There is no Logo", baseFunc.isElementPresent(DELFI_LOGO));
        Assert.assertTrue("There is no commercial banner", baseFunc.isElementPresent(COMMERCIAL));
        Assert.assertTrue("There is no Menu", baseFunc.isElementPresent(MENU));
    }

    public String getTitleById(Integer id) {
        return getArticleByID(id).getText();
    }

    public ArticlePage openArticlePage(Integer id) {
        getArticleByID(id).click();
        return new ArticlePage(baseFunc);
    }

    private WebElement getArticleByID(Integer id) {
        List<WebElement> articles = baseFunc.getElements(ARTICLE_TITLE);
        return articles.get(id);
    }
}
