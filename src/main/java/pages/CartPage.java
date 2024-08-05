package pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By qty = By.cssSelector("[class*='quantity']");
    By productName=By.cssSelector("[class*='product-title']");
    By proceedBtnCss =By.cssSelector("[data-test*='proceed']");
    By removeProductBtnCss =By.cssSelector("[class*='btn-danger']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return getText(productName);
    }

    public String getProductQty(){
        return getValue(qty);
    }

    public boolean isProceedPresent(){
        return isDisplayed(proceedBtnCss);
    }

    public void removeProduct(){
        waitAndClick(removeProductBtnCss);
        waitForInVisible(removeProductBtnCss);
    }

}
