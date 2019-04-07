package com.Stepdef;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	public WebDriver driver;
	
	@Given("^Open \"(.*?)\" in chrome$")			
    public void launchApp(String url) throws Throwable							
    {	System.setProperty("webdriver.chrome.driver","G:\\file_new\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
        System.out.println("This Step open the Firefox and launch the application.");					
    }		

	@When("^User enters \"(.*?)\" in search box and selects option no\\. (\\d+)$")    
	public void enterText(String para, int i) throws Throwable 							
    {	
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys(para);
    }		

    @Then("^user should see result page$")					
    public void clickSearch() throws Throwable 							
    {    		
        //your code goes here				
    }		

}

