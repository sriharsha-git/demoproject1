package com.AutomationTalks.demoProject1;

import net.rcarz.jiraclient.JiraException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestClass1 {


    public static WebDriver driver;
    public static final String USERNAME = "sriharshaavanchi1";
    public static final String AUTOMATE_KEY = "JipsqDdp7kFGpSu27TgD";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeMethod
    public void launchApplication() throws MalformedURLException {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nirbhay\\Desktop\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.addArguments("start-maximized");
        //options.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        //options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN10);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("project", "Demo Automation Project");
        caps.setCapability("build", "Build #1");
        caps.setCapability("name", "Demo Suite");
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(new URL(URL), options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void Test1() {
        driver.navigate().to("https://automationtalks.com/");
        System.out.println("Test 1 title is " + driver.getTitle());
    }

    @Test
    public void Test2() {
        driver.navigate().to("https://automationtalks.com/");
        System.out.println("Test 2 title is " + driver.getTitle());
    }

    @Test
    public void Test3() {
        driver.navigate().to("https://automationtalks.com/");
        System.out.println("Test 3 title is " + driver.getTitle());
        Assert.assertEquals("AutomationTalks - Learn Automation Testing", driver.getTitle());
    }

    @AfterMethod
    public void quit(ITestResult result) throws JiraException {
        driver.quit();
        //if test case fails then log the defect in JIRA
		/*if(result.getStatus() == ITestResult.FAILURE) {
			
			BasicCredentials creds = new BasicCredentials("admin", "admin");
			JiraClient jira = new JiraClient("http://localhost:8081", creds);
			Issue issueName = jira.createIssue("AUT", "Bug").field(Field.SUMMARY, result.getMethod().getMethodName() +"is failed due to: "+ result.getThrowable().toString()).field(Field.DESCRIPTION, "get the description").execute();
			System.out.println("Issue is created in JIRA with issue key: "+issueName.getKey());
		}*/


    }
}
