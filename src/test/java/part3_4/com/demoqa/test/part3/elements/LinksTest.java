package part3_4.com.demoqa.test.part3.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.BaseTest;

public class LinksTest extends BaseTest {

    @Test
    public void testLinks(){
        var linksPage = homePage.goToElements().clickLink();
        linksPage.clickBadRequestLink();
        String actualResponse = linksPage.getResponse();
        Assert.assertTrue(
                actualResponse.contains("400")
                &&
                actualResponse.contains("Bad Request"),
                "\n Actual Response(" + actualResponse + ") Does Not Contain '400' and 'Bad Request'\n");
    }
}
