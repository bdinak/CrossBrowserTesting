import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Experitest {

  public static final String USERNAME = "ranganath.nagaraj@rbc.com";
  public static final String PASSWORD = "Password1";
  public static final String URL = "https://uscloud.experitest.com/wd/hub";

  public static void main(String[] args) throws Exception {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("username", USERNAME);
    caps.setCapability("password", PASSWORD);
    caps.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
    caps.setVersion("11.0.0");
    caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
    
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://www.google.com");
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("RBC Wealth Management");
    element.submit();
    driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]")).click();
    Thread.sleep(1000);
    System.out.println(driver.getTitle());
    driver.quit();

  }
}