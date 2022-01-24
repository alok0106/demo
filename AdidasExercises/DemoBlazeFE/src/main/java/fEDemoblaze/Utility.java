package fEDemoblaze;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	public static boolean isClicked(WebElement element, WebDriver driver)
	{ 
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 5);
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        element.click();
	        return true;
	    } catch(Exception e){
	        return false;
	    }
	}
	
	public static String captureScrrenShot(WebDriver driver) throws IOException {
		
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		String storagePath = "X:\\eclipse\\abc\\screenshot\\" + System.currentTimeMillis() + ".png";
		File target = new File(storagePath);
		FileHandler.copy(src, target);
		return storagePath;
	}
	
	
}
