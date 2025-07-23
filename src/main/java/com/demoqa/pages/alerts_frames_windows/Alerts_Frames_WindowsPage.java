package com.demoqa.pages.alerts_frames_windows;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class Alerts_Frames_WindowsPage extends HomePage {
    private By modalDialogsMenu = By.xpath("//li[@id='item-4']/span[text()='Modal Dialogs']");
    private By alertsMenuItem = By.xpath("//li[@id='item-1']/span[text()='Alerts']");

    public ModalDialogsPage clickModalDialogs(){
        scrollToElementJS(modalDialogsMenu);
        click(modalDialogsMenu);
        return new ModalDialogsPage();
    }

    public AlertsPage clickAlertPage(){
        scrollToElementJS(alertsMenuItem);
        click(alertsMenuItem);
        return new AlertsPage();
    }
}
