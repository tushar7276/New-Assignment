package NewPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SkyscannerPage {
	private WebDriver driver;
    private WebDriverWait wait;

    public SkyscannerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    /**
     * @param origin
     * @param destination
     * @param date
     * @throws InterruptedException 
     */
    public void searchForFlights(String origin, String destination) throws InterruptedException {
    	
		/*
		 * WebElement searchFlight =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.id("Origin")));
		 * searchFlight.click();
		 * 
		 * WebElement searchOneWay =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.id("Destination")));
		 * searchOneWay.click();
		 */
    	
        WebElement originInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Origin")));
        originInput.sendKeys(origin);
        
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//*[@id=\"prefetch\"]/div[1]/span[2]/div/div/div[1]/p/strong[contains(text(),'Johannesburg')]")).click();
      
        Thread.sleep(3000);
        WebElement destinationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Destination")));
        destinationInput.sendKeys(destination);
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//*[@id=\"prefetch\"]/div[2]/span[2]/div/div/div[1]/p/strong[contains(text(),'London')]")).click();
        
      
		/*
		 * WebElement dateInput =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "Departing_date"))); dateInput.click();
		 * 
		 * driver.findElement(By.xpath(
		 * "/html/body/div[2]/div[2]/div/div[2]/div/span[34]"));
		 */
        



        // Enter number of passengers
        //WebElement passengersInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passengers-input")));
       // passengersInput.sendKeys(String.valueOf(passengers));

        // Click on search button
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[3]/div/div[3]/div/button")));
        searchButton.click();
        
        Thread.sleep(3000);
        WebElement element=driver.findElement(By.xpath("//button[contains(text(),'Select')][1]"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollintoview", element);
        element.click();
      
    }

    public void selectFlight() {
        // Implement the logic to select a flight from the search results
    }

}
