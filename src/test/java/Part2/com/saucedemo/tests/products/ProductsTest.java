package Part2.com.saucedemo.tests.products;

import Part2.com.saucedemo.base.BaseTest;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void testProductsHeaderIsDisplayed() {
        ProductsPage productsPage = loginPage.logIntoApplication("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isProductsHeaderDisplayer(), "\n Products header is not displayed \n");
    }
}
