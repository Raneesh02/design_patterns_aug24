package tests;

import Base.BaseTest;
import Base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Factory.PageFactory;
import pages.interfaces.HomePage;
import pages.web.WebHomepage;

import java.util.Arrays;

public class HomePageTests extends BaseTest {


    @Test
    public void testCategories(){
        PageFactory pageFactory = new PageFactory();
        HomePage homePage = pageFactory.getHomePage(DriverManager.getDriver());
        homePage.openCategories();
        Assert.assertEquals(homePage.getCategoriesList(), Arrays.asList("Hand Tools", "Power Tools", "Other", "Special Tools","","Rentals"));
    }

    @Test
    public void testHeader(){
        WebHomepage homepage = new WebHomepage(DriverManager.getDriver());
        homepage.validateHeader();
    }

    @Test
    public void testFooter(){
        WebHomepage homepage = new WebHomepage(DriverManager.getDriver());
        Assert.assertEquals(homepage.getFooterText(),"This is a DEMO application (GitHub repo), used for software testing training purpose. | Support this project | Privacy Policy | Banner photo by Barn Images on Unsplash.");
    }
}
