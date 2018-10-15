package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class UserHomePage extends BaseClass {

	private WebDriverWait wait;

	@FindBy(xpath = "//a[contains(@title,'Profile')]")
	private WebElement profileButton;

	@FindBy(xpath = "//span[contains(text(),'Make Post')]")
	private WebElement makeStatus;

	@FindBy(xpath = "//button[@type='submit' and @data-testid='react-composer-post-button']")
	private WebElement shareButton;

	@FindBy(xpath = "//div[@id='pagelet_composer']/descendant::div[@role='presentation']/div[@class='_5yk2']")
	private WebElement statusInput;
	@FindBy(xpath = "//div[@class='clearfix fbNubFlyoutTitlebar']/div[@class='titlebarLabel clearfix']/div[@class='titlebarTextWrapper']")
	private WebElement Chatbox;

	public UserHomePage() {
		wait = new WebDriverWait(driver, 80);
		PageFactory.initElements(driver, this);
	}

	public void closeChatBox() {
		wait.until(ExpectedConditions.elementToBeClickable(Chatbox));
		Chatbox.click();

	}

	public boolean postStatus(String input) {

		makeStatus.click();
		wait.until(ExpectedConditions.elementToBeClickable(statusInput));
		statusInput.click();
		statusInput.sendKeys(input);
		shareButton.click();

		return driver.findElement(By.xpath("//p[contains(text(),'" + input + "')]")).isDisplayed();
	}

	public ProfilePage goToProfilePage() {
		wait.until(ExpectedConditions.elementToBeClickable(profileButton));
		profileButton.click();

		return new ProfilePage();
	}

}
