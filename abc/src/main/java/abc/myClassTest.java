package abc;


import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;

import com.google.common.base.Stopwatch;

public class myClassTest {
	
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
    String baseUrl = "https://www.demoblaze.com/index.html";
    
    // launch Fire fox and direct it to the Base URL
    driver.get(baseUrl);
    Thread.sleep(5000);
    driver.manage().window().maximize();
    Thread.sleep(2000);
   driver.findElement(By.linkText("Laptops")).click();
   Thread.sleep(5000);
   
    driver.findElement(By.linkText("Sony vaio i5")).click();
   // driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
    Thread.sleep(5000);
    driver.findElement(By.linkText("Add to cart")).click();
    Thread.sleep(5000);
    Alert alert = driver.switchTo().alert();
    alert.accept();	
    Thread.sleep(5000);
   driver.navigate().to("https://www.demoblaze.com/index.html");
   
   Thread.sleep(5000);
   
   driver.findElement(By.linkText("Laptops")).click();
   Thread.sleep(5000);
   driver.findElement(By.linkText("Dell i7 8gb")).click();
   // driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
    Thread.sleep(5000);
    driver.findElement(By.linkText("Add to cart")).click();
    Thread.sleep(5000);
    Alert alert1 = driver.switchTo().alert();
    alert1.accept();	
    Thread.sleep(5000);
    driver.findElement(By.linkText("Cart")).click();
    Thread.sleep(5000);
   // String xPath1 = “//td[text(Dell i7 8gb)='']”;
    WebElement element = driver.findElement(By.xpath("//td[text()=('Dell i7 8gb')]"));
   // WebElement itemToDelete = driver.findElement(By.linkText("Dell i7 8gb"));
    WebElement parent = element.findElement(By.xpath(".."));
    
    System.out.println(element.toString());
    System.out.println(parent.toString());
    
    parent.findElement(By.linkText("Delete")).click();
    
    Thread.sleep(5000);
    driver.findElement(By.xpath("//button[text()=('Place Order')]")).click();
    
    
    Thread.sleep(5000);
    
    
    Set<String> windows = driver.getWindowHandles();
    String parentWindow = driver.getWindowHandle();
    windows.remove(parent);
    Iterator<String> it = windows.iterator(); 
    String child = (String)it.next();
    driver.switchTo().window(child); 
    driver.findElement(By.id("name")).sendKeys("gaurav");  
    driver.findElement(By.id("country")).sendKeys("india");  
    driver.findElement(By.id("city")).sendKeys("delhi");  
    driver.findElement(By.id("card")).sendKeys("master");  
    driver.findElement(By.id("month")).sendKeys("may");  
    driver.findElement(By.id("year")).sendKeys("2020");  
  
    driver.findElement(By.xpath("//button[text()=('Purchase')]")).click();
    Thread.sleep(5000);
    
    
    //Alert alert2 = driver.switchTo().alert();
   // alert2.accept();	
    
   windows = driver.getWindowHandles();
    windows.remove(parent);
    windows.remove(child);
    it = windows.iterator(); 
    String thankyou = (String)it.next();
    driver.switchTo().window(thankyou); 
    
    
    
    List<WebElement> c = driver.findElements(By.xpath("./child::*"));
    // iterate child nodes
    for ( WebElement i : c ) {
    //getText() to get text for child nodes
    System.out.println(i.getText());}
    
   //WebElement msg =  driver.findElement(By.xpath("//h2[text()=('Thank you for your purchase!')]"));
   
  // WebElement followingSibling = msg.findElement(By.xpath("following-sibling::*[1]"));
  // String a = followingSibling.getText();
    //System.out.println(msg.toString());
    
    // get the actual value of the title
   // actualTitle = driver.getTitle();
   // System.out.println(actualTitle);
    /*
     * compare the actual title of the page with the expected one and print
     * the result as "Passed" or "Failed"
     */
    //if (actualTitle.contentEquals(expectedTitle)){
        System.out.println("Test Passed!");
  //  } else {
        System.out.println("Test Failed");
   //
    //close Fire fox
    //driver.close();
   
}
	

}
