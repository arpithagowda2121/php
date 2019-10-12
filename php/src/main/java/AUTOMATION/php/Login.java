package AUTOMATION.php;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Login extends homepage {
static By email=By.xpath("/html/body/div[6]/div[1]/div[1]/form/div[1]/div[5]/div/div[1]/input");
static By password=By.xpath("/html/body/div[6]/div[1]/div[1]/form/div[1]/div[5]/div/div[2]/input");
static By login=By.xpath("//button[.='Login']");
public static void loginpage()
{
	driver.findElement(email).sendKeys(prop.getProperty("email"));
	driver.findElement(password).sendKeys(prop.getProperty("password"));
	driver.findElement(login).click();
}
public static void main(String[] args) throws IOException{
	
	Launchbrowser();
	Login();
	loginpage();
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\arpi\\login"));
}
}
