package testlayer;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseDB;
import pompackage.pomlogin;
import pompackage.pomproduct;
import pompackage.pomsignup;
import testdataDemo.DemoExcelsheet;


public class TestDB extends BaseDB {
 	
			//refreance variable ffor my pom
	
	pomsignup signup;
	pomlogin login;
	pomproduct product;
	
	public TestDB() {	//calling my constructor of my parent class
		super();
	
	}
	@BeforeMethod
	public void initsetup() {
		initiate();
	signup= new pomsignup();
	login=new pomlogin();
	product=new pomproduct();
	
	}
 
	@Test(priority=1)
	public void Title() {
		String actual= verification();
		System.out.println(actual);
		Assert.assertEquals(actual, "STORE"); //product store not sure how to change to what i want
		screenshots("verify");
	}
	
	@DataProvider
	public Object[][] Demoexecelsheet(){
		Object result[][]=DemoExcelsheet.readdata("Sheet1");
		return result;
		
	}
	@Test(priority=2, dataProvider="Demoexecelsheet")
	public void signup(String username, String password) throws InterruptedException {
		signup.clicksignuptab();
		screenshots("signup");
		tsleep();
		signup.typeusername(username);
		screenshots("username");
		signup.typepassword(password);
		screenshots("password");
		tsleep();
		signup.clicksignupbtn();
		tsleep();
		screenshots("signinbtn");
		Alert al=driver.switchTo().alert();	//one command we are using
		tsleep();							//hard wait: no matter what it will wait for 5000 millisec
		al.accept();
		 
				
	}
	@Test(priority=3, dataProvider="Demoexecelsheet")
	public void login(String username, String password) throws InterruptedException {
		login.clicklogintab();
		login.loginusername(username);
		screenshots("loginu");
		login.loginpassword(password);
		screenshots("loginp");
		tsleep();
		login.clicksigninbtn();
	}
	@Test(priority=4, dataProvider="Demoexecelsheet")
	public void product(String username, String password) throws InterruptedException {
		login.clicklogintab();
		login.loginusername(username);
		login.loginpassword(password);
		tsleep();
		login.clicksigninbtn();
		tsleep();
		product.clicklaptoptab();
		screenshots("laptopT");
		tsleep();
		product.clickorder();
		screenshots("orderl");
		tsleep();
		product.clickaddtocart();
		screenshots("addtocarts");
		tsleep();
		Alert gg= driver.switchTo().alert();
		tsleep();
		gg.accept();
		screenshots("Alert2");
		tsleep();
		product.Clickcarttab();
		screenshots("cartelement");
		tsleep();
		product.verify();
		screenshots("diplayed");
		
	}

	/*
	 * @Test(priority=5, dependsOnMethods="login") //ignore this dont know how this
	 * work but i am trying to figure it out public void test() throws
	 * InterruptedException { product.clicklaptoptab(); tsleep();
	 * product.clickorder(); tsleep(); product.clickaddtocart(); tsleep(); Alert gg=
	 * driver.switchTo().alert(); tsleep(); gg.accept(); tsleep();
	 * product.Clickcarttab(); tsleep(); product.verify();
	 */
	
	@AfterMethod
	public void close() {
		driver.quit();
	
	}
}
