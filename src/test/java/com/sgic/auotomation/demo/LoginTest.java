package com.sgic.auotomation.demo;

import static org.testng.Assert.assertEquals;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sgic.auotomation.demo.util.Log;

public class LoginTest extends BaseTest {


  private static Logger logger = LogManager.getLogger(LoginTest.class);

  boolean flag = false;

  @Test
  public void testUntitledTestCase() throws Exception {
    
    for (int i=0;i<DataStore.testData.get(Username).size();i++) {
      
    extentTest = extentReports.startTest("Admin Login");
    driver.get(prop.getProperty("baseUrl"));
    Log.startTestCase();
    driver.findElement(By.id("txtUsername")).clear();
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    extentTest.log(LogStatus.PASS,"enteredUserName");
    logger.log(Level.INFO, "######  entered username ######");
    driver.findElement(By.id("divPassword")).click();
    driver.findElement(By.id("frmLogin")).click();
    driver.findElement(By.id("txtPassword")).click();
    extentTest.log(LogStatus.PASS,"enteredPassword");
    logger.log(Level.INFO, "######  entered password ######");
    driver.findElement(By.id("txtPassword")).clear();
    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    driver.findElement(By.id("btnLogin")).click();
    extentTest.log(LogStatus.PASS,"LoginButtton clicked");
    logger.log(Level.INFO, "######  login button clicked ######");

     if (driver.findElement(By.id("welcome")).getText().equalsIgnoreCase("Welcoe Admin")) {
     flag = true;
     } else {
       extentTest.log(LogStatus.FAIL,"Failed to find the message");
     logger.log(Level.ERROR, "Failed To find the message.\n"
         + "Screenshot file: "+file);
     }

    try {
      assertEquals(driver.findElement(By.id("welcome")).getText(), "Welcome Admin");
    } catch (Error e) {
      logger.log(Level.ERROR, "Failed to find mesasge");
    }

    // Thread.sleep(2000);
    driver.findElement(By.id("welcome")).click();
    driver.findElement(By.linkText("Logout")).click();
    Log.endTestCase();
    extentReports.log(LogStatus.PASS,"enteredUserName");
  }
}
