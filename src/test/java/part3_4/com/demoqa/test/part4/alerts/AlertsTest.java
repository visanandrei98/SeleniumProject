package part3_4.com.demoqa.test.part4.alerts;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.com.demoqa.base.BaseTest;

import static utilities.SwitchToUtility.*;

@Test
public class AlertsTest extends BaseTest {


    public void testInformationAlert(){
        String expectedAlertText = "You clicked a button";
        var alertsPage = homePage.goToAlertsFramesWindowsCard().clickAlertPage();
        alertsPage.clickInformationAlertButton();
        Assert.assertEquals(getAlertText(), expectedAlertText, "\n Actual & Expected Messages Do Not Match \n");
        acceptAlert();
    }


    public void testConfirmationAlert(){
        String expectedConfirmationResult = "You selected Cancel";
        var alertsPage = homePage.goToAlertsFramesWindowsCard().clickAlertPage();
        alertsPage.clickConfirmationAlertButton();
        dismissAlert();
        String actualConfirmationAlert = alertsPage.getConfirmationResult();
        Assert.assertEquals(expectedConfirmationResult,actualConfirmationAlert, "\n You did not selected cancel \n");
    }
}
