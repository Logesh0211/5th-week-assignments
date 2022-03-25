package week5day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumBasics extends ProjectSpecificMethods  {
	
	@Parameters({"username","password"})
	@Test
	
	public void tc01(String username,String password) {
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
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
		System.out.println(driver.getTitle());
		
		
		
		
		
		


	}

}
