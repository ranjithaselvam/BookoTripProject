package com.atmecs.bookotrip.testscript;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.bookotrip.constant.Path;
import com.atmecs.bookotrip.testbase.Browsers;
import com.atmecs.bookotrip.utils.UtilsTest;

/**
 * flight booking scenario for round trip.
   read input details from excel.
 * @author ranjitha.selvam
 *
 */
public class RoundTripTicketBooking extends Browsers {
	@DataProvider
	public Object[][] cityDetails(){
	Object data[][]=UtilsTest.ReadWriteExcel(Path.path1,"Sheet1");
	return data;
	}
	

   @Test(dataProvider = "cityDetails")
	
	public void searchingFlightAvailabilityRoundTrip (String from, String to) throws InterruptedException  {
	   Logger log=Logger.getLogger(RoundTripTicketBooking.class);
	   log.info("launching");
	   log.info("end");
	driver.manage().window().maximize();
		driver.findElement(By.id("li-flights")).click();
		driver.findElement(By.xpath("//*[@id=\"dv_rd_label\"]/label[1]/span/span")).click();
		
		  
		  driver.findElement(By.id("txtFlyFrom")).sendKeys(from);
		  driver.findElement(By.id("txtFlyTo")).sendKeys(to);
		 
		  driver.findElement(By.id("txtDepartingDate")).click();
		  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[4]/td[4]/a")).click();
		  
		  driver.findElement(By.id("txtReturnDate")).click();
		  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[3]/td[6]/a")).click();
		  driver.findElement(By.id("btn_search")).click();
   
  
		
		  
	   WebDriverWait wait2 = new WebDriverWait(driver,30);
		  driver.findElement(By.xpath("//*[@id=\"divRefNo_OB1\"]/div/ul/li[1]/div")).click();
		 
		  driver.findElement(By.xpath("//*[@id=\"divRefNo_RT_93-QQ0IP1R\"]/div/ul/li[1]/div")).click();
		  //booking flight
		  driver.findElement(By.id("btn_book")).click();
		  WebElement gender = driver.findElement(By.id("ddl_adt_gender_0"));
			// to select the drop drown list by index value
			Select s1 = new Select(gender);
			s1.selectByIndex(2);
			
			//user details
		  driver.findElement(By.id("txt_adt_fname_0")).sendKeys("ranjitha");
			driver.findElement(By.id("txt_adt_mname_0")).sendKeys("selvam");
			driver.findElement(By.id("txt_adt_lname_0")).sendKeys("roja");
			WebElement month = driver.findElement(By.id("ddl_adt_dob_mm_0"));
			Select s2 = new Select(month);
			s2.selectByIndex(4);
			WebElement day = driver.findElement(By.id("ddl_adt_dob_dd_0"));
			Select s3 = new Select(day);
			s3.selectByIndex(4);
			WebElement year = driver.findElement(By.id("ddl_adt_dob_yy_0"));
			Select s4 = new Select(year);
			s4.selectByIndex(4);
			driver.findElement(By.id("txtMobileNo")).sendKeys("9876543210");
			driver.findElement(By.id("txtEmail")).sendKeys("ranjitha666@gmail.com");
			driver.findElement(By.id("btn_continue")).click();
			 
		
		
	}
	
	

}
