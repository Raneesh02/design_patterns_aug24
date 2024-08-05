package tests;

import Base.BaseTest;
import Base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FilterSideBar;
import pages.Homepage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterTests extends BaseTest {

    @Test
    public void testSortNames(){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        FilterSideBar filterBar = homepage.getFilterBar();
        filterBar.sortBy("Name (A - Z)");
        List<String> productNameList = homepage.getProductNameList();
        ArrayList<String> SortedList = new ArrayList<>(productNameList);
        Collections.sort(SortedList);
        Assert.assertEquals(productNameList, SortedList);
    }

    @Test
    public void testSortPrices(){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        FilterSideBar filterBar = homepage.getFilterBar();
        filterBar.sortBy("Price (Low - High)");
        List<String> productPriceList = homepage.getProductPriceList();
        ArrayList<String> SortedList = new ArrayList<>(productPriceList);
        Collections.sort(SortedList);
        Assert.assertEquals(productPriceList, SortedList);
    }

    @Test
    public void testFilterCategoryResults(){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        FilterSideBar filterBar = homepage.getFilterBar();
        filterBar.selectFilterCategory("Hammer");
        List<String> productNameList = homepage.getProductNameList();
        Assert.assertEquals(productNameList.stream().filter( product -> product.toLowerCase().contains("hammer")).count(),productNameList.size());
    }

    @Test
    public void testNoFilterResults(){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        FilterSideBar filterBar = homepage.getFilterBar();
        filterBar.selectFilterCategory("Grinder");
        Assert.assertTrue(homepage.noResultsPresent(),"Expected No Results for Grinder Filter");
    }

}
