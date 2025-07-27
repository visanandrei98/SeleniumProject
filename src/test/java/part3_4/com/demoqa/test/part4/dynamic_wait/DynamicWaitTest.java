package part3_4.com.demoqa.test.part4.dynamic_wait;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.BaseTest;

public class DynamicWaitTest extends BaseTest {
    @Test
    public void testVisibleAfterButtonText(){
        var dynamicPage = homePage.goToElements().clickDynamicProperties();
        String actualText = dynamicPage.getVisibleAfterButtonText();
        String expectedText = "Visible After 5 Seconds";
        Assert.assertEquals(actualText,expectedText, "\n Actual And Expected Text do not match \n");
    }
}
