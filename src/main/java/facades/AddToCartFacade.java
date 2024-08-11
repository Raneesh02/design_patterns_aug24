package facades;

import Base.BasePage;
import Base.DriverManager;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.FilterSideBar;
import pages.web.WebHomepage;
import pages.ProductDetailPage;
import testdata.Product;

public class AddToCartFacade extends BasePage {
    public AddToCartFacade(WebDriver driver) {
        super(driver);
    }

    public CartPage addToCart(String category, int qty){
        WebHomepage homepage = new WebHomepage(DriverManager.getDriver());
        FilterSideBar filterBar = homepage.getFilterBar();
        filterBar.selectFilterCategory(category);
        ProductDetailPage productDetailPage = homepage.selectProduct(1);
        productDetailPage.increaseProductQty(qty);
        productDetailPage.addToCart();
        return productDetailPage.goToCart();
    }

    public CartPage addToCart(Product product){
        WebHomepage homepage = new WebHomepage(DriverManager.getDriver());
        FilterSideBar filterBar = homepage.getFilterBar();
        filterBar.selectFilterCategory(product.getCategory());
        ProductDetailPage productDetailPage = homepage.selectProduct(product.getName());
        productDetailPage.increaseProductQty(product.getQty());
        productDetailPage.addToCart();
        return productDetailPage.goToCart();
    }

}
