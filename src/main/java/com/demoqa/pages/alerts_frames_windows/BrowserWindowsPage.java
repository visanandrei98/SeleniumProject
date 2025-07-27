package com.demoqa.pages.alerts_frames_windows;

import org.openqa.selenium.By;

import java.util.Set;

import static utilities.SwitchToUtility.switchToWindow;

public class BrowserWindowsPage extends Alerts_Frames_WindowsPage{
    private By newWindowsButton = By.id("windowButton");

    public void clickNewWindowButton(){
        click(newWindowsButton);
    }

    public void switchToNewWindow(){
        //Step 1: Get the current " main" window handle
        String currentHandle = driver.getWindowHandle();
        System.out.println("Main Window ID: " + currentHandle + "\n");

        //Step 2 : Get all Window Handles
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("# of Open Windows: " + allHandles.size());

        for (String handle: allHandles){
            if(currentHandle.equals(handle)){
                System.out.println("1st Window ID: " + handle);
            } else {

                switchToWindow(handle);
                System.out.println("2nd Window ID:");
            }
        }

        //Step 3: Switch To the new window using the window handle
    }
}
