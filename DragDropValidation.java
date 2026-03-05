
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;

public class DragDropValidation {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        WebElement frame = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(frame);

       
        List<WebElement> images = driver.findElements(By.cssSelector("#gallery li"));

        
        WebElement trash = driver.findElement(By.id("trash"));

        Actions actions = new Actions(driver);

        for (WebElement image : images) {

            String imageName = image.findElement(By.tagName("h5")).getText();

            
            actions.dragAndDrop(image, trash).perform();

            
            List<WebElement> trashItems =
                    driver.findElements(By.xpath("//ul[@id='trash']//h5[text()='" + imageName + "']"));

            if (trashItems.size() > 0) {
                System.out.println(imageName + " successfully moved to Trash");
            } else {
                System.out.println("Failed to move " + imageName + " to Trash");
            }
        }

        driver.quit();
    }
}