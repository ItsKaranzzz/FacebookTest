package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class ProfilePage extends BaseClass {
	public WebDriverWait wait;

	@FindBy(xpath = "//a[contains(text(),'Timeline')]")
	private WebElement timelinebutton;

	public ProfilePage() {
		wait = new WebDriverWait(driver, 80);

		PageFactory.initElements(driver, this);
	}

	public boolean checkForProfilePage() {
		wait.until(ExpectedConditions.elementToBeClickable(timelinebutton));

		if (timelinebutton.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean checkForPostedMessage(String message) {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'" + message + "')]")));
		if (driver.findElement(By.xpath("//p[contains(text(),'" + message + "')]")).isDisplayed())
			return true;
		else
			return false;
	}
}
