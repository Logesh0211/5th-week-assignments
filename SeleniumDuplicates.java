package week5day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDuplicates {
	@DataProvider(name="excel")
	public String[][] getData() throws IOException{
		String[][] excelData=ExcelIntegration.getExcelData();
		return excelData;
				
	}
	@Test(dataProvider="excel")
	public void getExcelData(String data[][]) {
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
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("LeafLife");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Logesh");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Raj");
		driver.findElement(By.name("departmentName")).sendKeys("Cse");
		driver.findElement(By.name("description")).sendKeys("Selenium Basics Course");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("logesh.cse43@gmail.com");
		WebElement elementDropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd=new Select(elementDropdown);
		dd.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("LeafTree");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vimal");
		driver.findElement(By.name("submitButton")).click();
		System.out.println(driver.getTitle());
		driver.close();
		
		

	}

}
