package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseDB;

public class pomproduct extends BaseDB {
	@FindBy(linkText="Laptops") WebElement laptops;
	@FindBy(xpath="//img[@src='imgs/macbook_air.jpg']") WebElement order1;
	@FindBy(xpath="//a[@class='btn btn-success btn-lg']") WebElement addtocart;
	//Alert
	@FindBy(id="cartur") WebElement cart;
	@FindBy(xpath="//tr[@class='success']") WebElement added;
	
	public pomproduct() {
		PageFactory.initElements(driver, this);
		
	}
		
	public void clicklaptoptab() {
		laptops.click();
	}
	public void clickorder() {
		order1.click();
	}
	public void clickaddtocart() {
		addtocart.click();
	}
	/*public void addtocartalert() {
		alert.accept();
	}*/
	public void Clickcarttab() {
		cart.click();
	}
	public void verify() {
		boolean result=added.isSelected();
	}
}
