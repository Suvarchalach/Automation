package shoppingcart;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass 
{
	public static Properties prop ;
	public static WebDriver driver;
	public BaseClass(){
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\features\\config.properties");
			
			prop.load(fis);
		}catch(Exception  e) {
			e.getMessage();
		}
	}	
	
	public void initializer() {
		
		String brw = prop.getProperty("browser");
		if(brw.contentEquals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(brw.contentEquals("firfox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
}

