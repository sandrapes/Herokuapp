package Herokuapp.Pages;

import Herokuapp.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseTest {

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".flash.success")
    public WebElement success;

    @FindBy(css = ".button.secondary.radius")
    public WebElement logOutButton;


}
