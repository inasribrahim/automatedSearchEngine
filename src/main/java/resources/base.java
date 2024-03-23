package resources;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class base extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
 static public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		String file = "data.properties";
		InputStream fins = getClass().getClassLoader().getResourceAsStream(file);
		try {
			if (fins != null)
				prop.load(fins);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			 WebDriverManager.chromiumdriver().browserInDocker().setup();
			  ChromeOptions options = new ChromeOptions();
		          options.addArguments("--headless"); // Set headless mode
		          options.addArguments("--disable-gpu"); // Disable GPU acceleration
		          options.addArguments("--no-sandbox"); // Disable sandbox for Alpine
		            options.addArguments("--disable-dev-shm-usage"); // Disable /dev/shm usage
            
			driver  = new ChromeDriver(options);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;

	}
	public  List<String> getDataFromFile() {
		List<String> listData = new ArrayList<String>();
		
		listData.add(prop.getProperty("key"));
		listData.add(prop.getProperty("cx"));
		listData.add(prop.getProperty("q"));
		listData.add(prop.getProperty("num"));
		listData.add(prop.getProperty("HOST"));
		listData.add(prop.getProperty("cookie"));
        
       return listData ; 
	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//" + result + "screenshot.png"));

	}

}
