import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import javax.naming.directory.SearchResult;
import java.util.List;


public class WebDriverJoom_Test {
    @Test
    public void CheckEmptyBasket () {
        WebDriver DriverForJoom = new ChromeDriver();
        DriverForJoom.get("https://www.joom.com/ru/products/5f1a841fcd239a0106798bd2");
        WebElement CloseAdvertising = (new WebDriverWait(DriverForJoom, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("close___2Mspp")));
        CloseAdvertising.click();
        WebElement SearchButtonAdd = DriverForJoom.findElement(By.className("button___1WAua"));
        SearchButtonAdd.click();
        WebElement GoToBasket = DriverForJoom.findElement(By.xpath("//*[@href='/ru/cart']"));
        GoToBasket.click();
        WebElement DeleteItem = (new WebDriverWait(DriverForJoom, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='text___183EF']")));
        DeleteItem.click();
        WebElement Confirm = DriverForJoom.findElement(By.xpath("//*[@class='button___3hmfW button___TbaLj fill-brand___18fJk padding-normal___2ctfV rounded___1J8B1']"));
        Confirm.click();
        List<WebElement>  ItemsInBasket = DriverForJoom.findElements(By.xpath("//*[@class='inner___15C_']"));
        Assert.assertTrue(ItemsInBasket.size() == 0,"The item was delete from basket");
        DriverForJoom.quit();
    }
}
