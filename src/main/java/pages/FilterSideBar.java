package pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterSideBar extends BasePage {

    By sortDdnCss= By.cssSelector("[data-test='sort']");
    String categoryCheckXpath="//label[contains(text(),'%s')]/input[@type='checkbox']";
    By sortCompleteCss = By.cssSelector("[data-test='sorting_completed']");
    By filterCompleteCss = By.cssSelector("[data-test='filter_completed']");


    public FilterSideBar(WebDriver driver) {
        super(driver);
    }

    public void sortBy(String sorting){
        waitAndSelect(sortDdnCss,sorting);
        waitForVisible(sortCompleteCss);
    }

    public void selectFilterCategory(String categoryName){
        waitAndClick(By.xpath(String.format(categoryCheckXpath, categoryName)));
        waitForVisible(filterCompleteCss);
    }
}
