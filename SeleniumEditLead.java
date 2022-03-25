package week5day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumEditLead {
	@DataProvider(name="login")
	public String[][] getData(){
		
		String[][] data=new String[2][3];
		data[0][0]="LeafLife";
		data[0][1]="Logesh";
	    data[0][2]="R";
		
		data[1][0]="LeafLife1";
		data[1][1]="Logesh1";
	    data[1][2]="R1";
		return data;
	}
 
	@Test(dataProvider="login")
	public void login (String cName,String fName,String sName) {
	    WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(sName);
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Raj");
		driver.findElement(By.name("departmentName")).sendKeys("Cse");
		driver.findElement(By.name("description")).sendKeys("Selenium Basics Course");
		driver.findElement(By.name("primaryEmail")).sendKeys("logesh.cse43@gmail.com");
		WebElement elementDropdown = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select dd=new Select(elementDropdown);
		dd.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.name("description")).clear();
		driver.findElement(By.name("importantNote")).sendKeys("Kindly Fill Required Fields");
		driver.findElement(By.name("submitButton")).click();
		System.out.println(driver.getTitle());
		driver.close();
		

	}

}
