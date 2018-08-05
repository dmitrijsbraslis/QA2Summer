package pageObjectTest;

import org.junit.Assert;
import org.junit.Test;
import pageObjectTest.pages.ArticlePage;
import pageObjectTest.pages.BaseFunc;
import pageObjectTest.pages.CommentPage;
import pageObjectTest.pages.HomePage;

public class pageObjectTest {
    //В самом тесте больше никаких локаторов, только те переменные, что нужны самой логике теста
    //Сам Driver тепеь находится в BaseFunc и может использоваться отовсюду
    //Как только мы создаём копию объкта BaseFunc - принудительно срабатывает конструетор, где происходит открытие браузера
    BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "rus.delfi.lv";

    @Test
    public void checkArticleTitle() {
        baseFunc.openPage(HOME_PAGE);

        //Указываем тесту, что находимся на конкретной странице - это позволяет нам использовать инструменты этой страницы
        HomePage homePage = new HomePage(baseFunc);
        String title = homePage.getTitleById(1);
        ArticlePage articlePage = homePage.openArticlePage(1);

        String pageTitle = articlePage.getTitle();
        //Все проверки именно характерные логике теста находятся в тесте
        Assert.assertEquals("Article title does not match", title, pageTitle);

        CommentPage commentPage = articlePage.openCommentPage();

        String commentPageTitle = commentPage.getTitle();
        Assert.assertTrue("Article title does not match", commentPageTitle.contains(title));
    }
}
