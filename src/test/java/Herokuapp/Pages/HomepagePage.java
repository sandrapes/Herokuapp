package Herokuapp.Pages;

import Herokuapp.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepagePage extends BaseTest {

    public HomepagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "a")
    List<WebElement> pages;


    public void clickOnFormAuthentication() {
        for (int i = 0; i < pages.size(); i++) {
            if (pages.get(i).getText().equals("Form Authentication")) {
                pages.get(i).click();
                break;
            }
        }
    }



}
