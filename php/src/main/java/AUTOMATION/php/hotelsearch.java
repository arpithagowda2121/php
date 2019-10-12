package AUTOMATION.php;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class hotelsearch extends launch {

static By Hotel=By.xpath("//a[@title='Hotels']");

//static By cookies=By.xpath("//*[@id=\"cookyGotItBtn\"]");
//static By Searchhotelcity=By.xpath("//span[.='Search by Hotel or City Name']");
//static By Searchhotelcitybtn=By.xpath("/html/body/div[6]/section/div[2]/div/div/div[2]/div[1]/div[4]/form/div[1]/div/div[2]/a");
static By Checkin=By.xpath("//div[@id='dpd1']//input[@placeholder='Check in']");

//static By Search=By.xpath("");
public static void hotelpage()  {
	driver.findElement(Hotel).click();
	//driver.findElement(cookies).click();
	//driver.findElement(Searchhotelcity).click();
	//driver.findElement(Searchhotelcitybtn).sendKeys(prop.getProperty("Searchhotelcitybtn"));
	//driver.findElement(Search).click();
	driver.findElement(Checkin).click();
	
	
	//check in
	while(true)
	{
		String str = driver.findElement(By.xpath("/html[1]/body[1]/div[14]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
		if(str.equals(prop.getProperty("MONTH")))
		{
			break;
		}
		else {
			driver.findElement(By.xpath("/html[1]/body[1]/div[14]/div[1]/table[1]/thead[1]/tr[1]/th[3]")).click();
		}
	}
	driver.findElement(By.xpath("//div[14]//tr[4]//td[6][contains(text(),"+prop.getProperty("day")+")]")).click();	


//check out
while(true)
{
	String str1 = driver.findElement(By.xpath("/html[1]/body[1]/div[15]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
	if(str1.equals(prop.getProperty("MONTH1")))
	{
		break;
	}
	else {
		driver.findElement(By.xpath("/html[1]/body[1]/div[15]/div[1]/table[1]/thead[1]/tr[1]/th[3]")).click();
		str1=driver.findElement(By.xpath("")).getText();
	}
}
driver.findElement(By.xpath("//div[15]//tr[5]//td[5][contains(text(),"+prop.getProperty("day1")+")]")).click();

//guest

driver.findElement(By.xpath("//input[@id='htravellersInput']")).click();
driver.findElement(By.xpath("//input[@id='hadultInput']")).sendKeys(prop.getProperty("adultid"));
driver.findElement(By.xpath("//input[@id='hchildInput']")).sendKeys(prop.getProperty("childid"));
 
//search
driver.findElement(By.xpath("//button[contains(@class,'btn btn-lg btn-block btn-primary pfb0 loader')]")).click();

}

public static void main(String[] args) throws IOException {
	
	
		Launchbrowser();
		hotelpage();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\arpi\\hotelsearch"));
}
}
