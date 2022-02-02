package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseDB;

public class pomlogin extends BaseDB {
	@FindBy(id="login2") WebElement login;
	@FindBy(id="loginusername") WebElement logusername;
	@FindBy(id="loginpassword") WebElement logpassword;
	@FindBy(xpath="//button[@onclick='logIn()']") WebElement signinbtn;
	
	
	public pomlogin() {
		PageFactory.initElements(driver, this);
	}
	
	public void clicklogintab() {
		login.click();
	}
	public void loginusername(String name) {
		logusername.sendKeys(name);
	}
	public void loginpassword(String pass) {
		logpassword.sendKeys(pass);
	}
	public void clicksigninbtn() {
		signinbtn.click();
	}
}
