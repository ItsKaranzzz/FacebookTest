package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(id = "email")
	private WebElement username;
	@FindBy(id = "pass")
	private WebElement password;
	@FindBy(id = "loginbutton")
	private WebElement loginbutton;

	public HomePage() {

		PageFactory.initElements(driver, this);

	}

	public UserHomePage LogintoApp(String name, String pwd) {

		username.sendKeys(name);
		password.sendKeys(pwd);
		loginbutton.click();

		return new UserHomePage();
	}
}
