package tests;

import Base.BaseTest;
import Base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.FilterSideBar;
import pages.web.WebHomepage;
import pages.ProductDetailPage;
import facades.AddToCartFacade;
import testdata.Product;

public class CartTests extends BaseTest {


    @Test
    public void validateCartPage(){
        //excelUtility.getData("Ts101")
        WebHomepage homepage = new WebHomepage(DriverManager.getDriver());
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
        WebHomepage homepage = new WebHomepage(DriverManager.getDriver());
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

    @Test
    public void validateCartPageFacadePliersUsingBuilder(){
        Product product1 = new Product.ProductBuilder()
                .setCategory("Hammer")
                .setName("Thor Hammer")
                .setQty(3).build();

        AddToCartFacade addToCartFacade = new AddToCartFacade(DriverManager.getDriver());
        addToCartFacade.addToCart(product1);

    }

    @Test
    public void validateCartPageFacadePliersUsingBuilder2(){
        Product product1 = new Product.ProductBuilder()
                .setCategory("Pliers")
                .setName("Thor Hammer")
                .setQty(3).build();

        AddToCartFacade addToCartFacade = new AddToCartFacade(DriverManager.getDriver());
        addToCartFacade.addToCart(product1);


    }

}
