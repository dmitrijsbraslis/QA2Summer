package pageObjectTest.pages;

import org.openqa.selenium.By;

public class SearchResultPage {
    BaseFunc baseFunc;
    private final By SEARCH_RESULT = By.xpath(".//div[@class = 'gsc-webResult gsc-result']");

    public SearchResultPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public Integer getResultCount() {
        return baseFunc.getElements(SEARCH_RESULT).size();
    }

}
