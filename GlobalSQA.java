

	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	
	public class GlobalSQA {
	    public static void main(String[] args) throws InterruptedException {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
            Thread.sleep(2000);
            
	        driver.get("https://www.globalsqa.com/");
            WebElement freeEbooks = driver.findElement(By.cssSelector("a[href*='ebooks']"));
            Actions actions = new Actions(driver);
	        actions.moveToElement(freeEbooks).perform();
            driver.findElement(By.cssSelector("a[href*='machine-learning']")).click();

            Thread.sleep(2000);
	        driver.quit();
	    }
	}
	
	

