package NewPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import NewPackage.SkyscannerPage;

public class FlightSearch {
	private ChromeDriver driver;
    private SkyscannerPage skyscannerPage;

    @BeforeClass
    public void setUp() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\agarw\\Desktop\\NewAssignment\\src\\test\\resources\\driver\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Instantiate the SkyscannerPage
        skyscannerPage = new SkyscannerPage(driver);
    }

    @Test
    public void searchAndSelectFlight() throws InterruptedException {
        // Open Skyscanner website
    	driver.get("https://www.travelwings.com/za/en/offers/book-cheap-flights.html?utm_source=google&utm_medium=cpc&utm_campaign=South-Africa-TW-Branding-13Sep21&utm_adgroup=127492202775&utm_term=travelwings&creative=545340142315&device=c&matchtype=b&targetid=kwd-317592781135&gclid=Cj0KCQjw1_SkBhDwARIsANbGpFvU1BAiPTu0lWyyZxxZRO5ZLy5VujPVwIQESiHBAKe7BGCdBXW60oIaAmrUEALw_wcB");
    	
   
        // Perform a search for flights
        skyscannerPage.searchForFlights("Johannesburg (JNB)", "London (LHR)");

        // Select a flight from the search results
        skyscannerPage.selectFlight();

        // Implement assertions or further actions as needed
    }

//    @AfterClass
//    public void tearDown() {
//        // Close the browser
//    	driver.quit();
//    }

}
