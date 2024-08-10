package facades;

import Base.BasePage;
import Base.DriverManager;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.FilterSideBar;
import pages.Homepage;
import pages.ProductDetailPage;

public class AddToCartFacade extends BasePage {
    public AddToCartFacade(WebDriver driver) {
        super(driver);
    }

    public CartPage addToCart(String category, int qty){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        FilterSideBar filterBar = homepage.getFilterBar();
        filterBar.selectFilterCategory(category);
        ProductDetailPage productDetailPage = homepage.selectProduct(1);
        productDetailPage.increaseProductQty(qty);
        productDetailPage.addToCart();
        return productDetailPage.goToCart();
    }


}