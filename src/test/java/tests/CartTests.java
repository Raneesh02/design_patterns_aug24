package tests;

import Base.BaseTest;
import Base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.FilterSideBar;
import pages.Homepage;
import pages.ProductDetailPage;
import facades.AddToCartFacade;

public class CartTests extends BaseTest {


    @Test
    public void validateCartPage(){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        FilterSideBar filterBar = homepage.getFilterBar();
        filterBar.selectFilterCategory("Hammer");
        ProductDetailPage productDetailPage = homepage.selectProduct(1);
        productDetailPage.increaseProductQty(2);
        productDetailPage.addToCart();
        CartPage cartPage = productDetailPage.goToCart();
        Assert.assertTrue(cartPage.isProceedPresent());
        Assert.assertEquals(cartPage.getProductQty(), 2);
    }

    @Test
    public void validateCartPagePliers(){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        FilterSideBar filterBar = homepage.getFilterBar();
        filterBar.selectFilterCategory("Pliers");
        ProductDetailPage productDetailPage = homepage.selectProduct(1);
        productDetailPage.increaseProductQty(2);
        productDetailPage.addToCart();
        CartPage cartPage = productDetailPage.goToCart();
        Assert.assertTrue(cartPage.isProceedPresent());
        Assert.assertEquals(cartPage.getProductQty(), 2);
    }

    @Test
    public void validateCartPageFacade(){
        AddToCartFacade addToCartFacade = new AddToCartFacade(DriverManager.getDriver());
        CartPage cartPage = addToCartFacade.addToCart("Hammer",3);
        Assert.assertTrue(cartPage.isProceedPresent());
        Assert.assertEquals(cartPage.getProductQty(), 3);
    }

    @Test
    public void validateCartPageFacadePliers(){
        AddToCartFacade addToCartFacade = new AddToCartFacade(DriverManager.getDriver());
        CartPage cartPage = addToCartFacade.addToCart("Pliers",3);
        Assert.assertTrue(cartPage.isProceedPresent());
        Assert.assertEquals(cartPage.getProductQty(), 3);
    }

}
