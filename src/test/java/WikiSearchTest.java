import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WikiSearchTest {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ganesh G\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qawikisearch.ccbp.tech/");
        WebElement inputEl = driver.findElement(By.xpath("//input[@id = 'searchInput']"));
        inputEl.sendKeys("HTML");
        WebElement searchEl = driver.findElement(By.xpath("//button[@class = 'search-button']"));
        searchEl.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'result-item']")));
        List<WebElement> results = driver.findElements(By.xpath("//div[@class = 'result-item']"));
        System.out.println(results.size() + " Results Found");
        driver.quit();
    }
}
