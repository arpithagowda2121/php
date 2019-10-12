package AUTOMATION.php;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class registration extends homepage{
static By firstname=By.xpath("//input[@name='firstname']");
static By lastname=By.xpath("//input[@name='lastname']");
static By mobilenumber=By.xpath("//input[@name='phone']");
static By email=By.xpath("//input[@name='email']");
static By password=By.xpath("//input[@name='password']");
static By confirmpassword=By.xpath("//input[@name='confirmpassword']");
static By cookies=By.xpath("//button[@id='cookyGotItBtn']");
static By signup=By.xpath("//button[@type='submit']");
public static void registerpage() {
	driver.findElement(firstname).sendKeys(prop.getProperty("firstname"));
	driver.findElement(lastname).sendKeys(prop.getProperty("lastname"));
	driver.findElement(mobilenumber).sendKeys(prop.getProperty("mobilenumber"));
	driver.findElement(email).sendKeys(prop.getProperty("email"));
	driver.findElement(password).sendKeys(prop.getProperty("password"));
	driver.findElement(confirmpassword).sendKeys(prop.getProperty("confirmpassword"));
	driver.findElement(cookies).click();
	driver.findElement(signup).click();
}
public static void main(String[] args)throws IOException {
	Launchbrowser();
	SignUp();
	registerpage();
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\arpi\\register"));
}
	
}
