import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest {

    @Step("<int> saniye kadar bekle")
    public void waitForSecond(int second) throws InterruptedException {
        Thread.sleep(1000 * second);
    }
    /*
    @Step("Xpath <xpath> li elementi bul ve tıkla") //Uygulamayı açma metodu
    public void clickByXpath(String s) {
        appiumDriver.findElement(By.xpath(s)).click();
        Assert.assertTrue(s, true);
    }

     */
    @Step("Xpath <xpath> li butonu bul ve tıkla")
    public void clickToShoppingButton(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        Assert.assertTrue(xpath, true);
    }

    @Step("<id> li alışveriş sayfasına girildiğini doğrula")
    public void validateToShoppingPage(String xpath){
        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).isDisplayed());
    }

    @Step("Xpath <xpath> li kategoriler sayfasını aç")
    public void clickToOpenCategory(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        Assert.assertTrue(xpath, true);
    }

    @Step("Xpath <xpath> li kategoriler sayfasının açıldığını doğrula")
    public void validateToOpenCategories(String xpath){
        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).isDisplayed());
    }

    @Step("Xpath <xpath> li kadın seçeneğine tıkla")
    public void clickToOptionWomen(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
    }

    @Step("Xpath <xpath> li pantolon kategorisini aç")
    public void clickToOptionPant(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
    }

    @Step("Sayfayı aşağı doğru kaydır")
    public void swipeUp() {
        int startx=717, starty=2569, endx=723, endy=490;
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.longPress(PointOption.point(startx,starty)).moveTo(PointOption.point(endx,endy)).release().perform();
        TLogger.logger.info("Sayfa aşağı kaydırılır");
    }

    @Step("Rastgele ürün seçimi yapılır")
    public void selectRandom() {
        List<MobileElement> elements = appiumDriver.findElements(By.xpath("//*[@resource-id=\"com.ozdilek.ozdilekteyim:id/imageView\"]\n"));
        Random random = new Random();
        int randomInt = random.nextInt(elements.size());
        elements.get(randomInt).click();
    }

    @Step("<id> li detay sayfası kontrolü")
    public void assertDetails(String xpath){
        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).isDisplayed());
        TLogger.logger.info("Ürün detay sayfası açılmıştır");
    }

    @Step("<xpath> favorilere tıkla")
    public void clickByFavoriteButton(String xpath){
        appiumDriver.findElement(By.xpath(xpath)).click();
    }
}


