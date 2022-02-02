package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseDB;

public class pomsignup extends BaseDB{

	@FindBy(id="signin2") WebElement signup;
	@FindBy(id="sign-username") WebElement username;
	@FindBy(id="sign-password") WebElement password;
	@FindBy(xpath="//button[@onclick='register()']") WebElement signupbtn;
	//Alert
	//Alert alert = driver.switchTo().alert();
	
	public pomsignup() {
		PageFactory.initElements(driver, this);
		
	}
	public void clicksignuptab() {
		signup.click();
	}
	public void typeusername(String name) {
		username.sendKeys(name);
	}
	public void typepassword(String pass) {
		password.sendKeys(pass);
	}
	public void clicksignupbtn() {
		signupbtn.click();
	}
	/*public void Alertsignup() {
		alert.accept();
	}*/
}
