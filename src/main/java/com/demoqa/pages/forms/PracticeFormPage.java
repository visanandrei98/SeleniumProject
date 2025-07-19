package com.demoqa.pages.forms;

import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.*;

public class PracticeFormPage extends FormsPage{
    private By femaleRadioButton = By.xpath("//input[@id='gender-radio-2']");

    public void clickFemaleRadioButton(){
        scrollToElementJS(femaleRadioButton);
        clickJS(femaleRadioButton);
    }

    public boolean isFemaleSelected(){
        return find(femaleRadioButton).isSelected();
    }
}
