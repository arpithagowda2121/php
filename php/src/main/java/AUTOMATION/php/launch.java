package AUTOMATION.php;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class launch {
		public static WebDriver driver;
		public static Properties prop=new Properties();
		public static void Launchbrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Online Test\\Desktop\\chrome\\chromedriver.exe");
		driver=new ChromeDriver();
		FileInputStream fis = new FileInputStream("C:\\New folder\\php\\src\\main\\java\\file\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("HOST"));
	    driver.manage().window().maximize();
		}
		public static void main(String[] args)throws IOException {
			Launchbrowser();
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\arpi\\launch"));
		}
}
