package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.ProfilePage;
import pages.UserHomePage;

public class FacebookLoginTest extends BaseClass {

	public HomePage oHomepage;
	public UserHomePage oUserHome;
	public ProfilePage oProfilePage;

	@BeforeMethod
	public void setup() throws IOException {

		initialize();
		oHomepage = new HomePage();
		oUserHome = oHomepage.LogintoApp(oProp.getProperty("username"), oProp.getProperty("password"));

	}

	@Test
	public void postMessageTest() throws InterruptedException {

		Assert.assertTrue(oUserHome.postStatus(oProp.getProperty("postMessage")));

	}

	@Test
	public void postedonProfileTest() {
		oProfilePage = oUserHome.goToProfilePage();
		Assert.assertTrue(oProfilePage.checkForProfilePage());

		Assert.assertEquals(oProfilePage.checkForPostedMessage(oProp.getProperty("postMessage")), true);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
