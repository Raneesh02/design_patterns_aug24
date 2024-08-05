package tests;

import Base.BaseTest;
import Base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;

import java.util.Arrays;

public class HomePageTests extends BaseTest {

    @Test
    public void testCategories(){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        homepage.openCategories();
        Assert.assertEquals(homepage.getCategoriesList(), Arrays.asList("Hand Tools", "Power Tools", "Other", "Special Tools","","Rentals"));
    }

    @Test
    public void testHeader(){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        homepage.validateHeader();
    }

    @Test
    public void testFooter(){
        Homepage homepage = new Homepage(DriverManager.getDriver());
        Assert.assertEquals(homepage.getFooterText(),"This is a DEMO application (GitHub repo), used for software testing training purpose. | Support this project | Privacy Policy | Banner photo by Barn Images on Unsplash.");
    }
}
