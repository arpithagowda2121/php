package AUTOMATION.php;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class homepage extends launch {
	static By MyAccount=By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a");
	static By SignUp=By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[2]/a");
	static By Login=By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[1]/a");
public static void SignUp() {
	driver.findElement(MyAccount).click();
	driver.findElement(SignUp).click();
}
public static void Login() {
	driver.findElement(MyAccount).click();
	driver.findElement(Login).click();
}
public static void main(String[] args)throws IOException {
	Launchbrowser();
	SignUp();
	Login();
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\arpi\\home"));
}
}
