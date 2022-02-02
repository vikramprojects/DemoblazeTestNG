package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.timeout;

public class BaseDB {
public static WebDriver driver;
	
	public static Properties prop=new Properties();
	
	
	
	public BaseDB() {
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\vikram\\eclipse-workspace\\DemoBlazetest\\src\\test\\java\\environment\\config.properties");
			prop.load(file);
		}
	catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException a) {
			a.printStackTrace();
		}
	}
	public static void initiate() {
		
		String browsername= prop.getProperty("browser");
		if(driver==null) {
		if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.firefox.driver","geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browsername.equals("Chrome")) {
			System.getProperty("webdriver.chrome.driver", "Chromedriver.exe");
			driver=new ChromeDriver();
		}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout.timepage));
		driver.get(prop.getProperty("url"));
		
	}
	
	public String verification() {
		return driver.getTitle();
		
	}
	public void tsleep() throws InterruptedException {
		Thread.sleep(2000);
		
	}
		public static void screenshots(String Filename) {
			File file1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file1, new File("C:\\Users\\vikram\\eclipse-workspace\\DemoBlazetest\\src\\test\\java\\screenshot\\Demoblazescreenshots"+Filename+".jpg"));
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

