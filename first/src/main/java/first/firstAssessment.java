package first;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class firstAssessment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome/driver","C:\\Users\\pawan_sharma\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe" );
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https:\\google.com");
		 
		 //Find the search box and and enter the query 
		 WebElement searchBox = driver.findElement(By.name("q"));
	        searchBox.sendKeys("Selenium");
	        
	        
	        searchBox.submit();
	        
	        String parentHandle = driver.getWindowHandle();
	        
	        WebElement searchResults = driver.findElement(By.id("search"));

	        // Find the Wikipedia page link and open it in a new tab
	       
	        
	        WebElement wikipediaLink = searchResults.findElement(By.partialLinkText("Wikipedia"));
	        // find out the URL of that wikipdeia
	        
	        String wikipediaUrl = wikipediaLink.getAttribute("href");
	        
	        
	        // Open new Tab
	        
	        ((JavascriptExecutor) driver).executeScript("window.open('" + wikipediaUrl +"')");
	        	        
	       

	        // Print the title of the Wikipedia page
	        if(driver.getWindowHandles().size() > 1)
	        {
	        	for (String handle : driver.getWindowHandles()) {
	                if (!handle.equals(parentHandle)) {
	                    driver.switchTo().window(handle);
	                    break;
	                }
	                
	            }
	        	
	        	
	        	 String wikipediaTitle = driver.getTitle();
	        	    System.out.println("Wikipedia page title: " + wikipediaTitle);

	        	    // Close the browser
//	        	    driver.quit();
	        }
	        else {
	        	 System.out.println("Wikipedia page was not opened in a new tab, cannot close the driver");
	        }
	        


	}

}
