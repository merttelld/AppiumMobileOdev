import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class Random extends BaseTest{
    @Step("Ürünler <xpath> arasından rastgele bir tane seç")
    public void clickByRandomElement(String xpath) {
        Random random = new Random();
        List<MobileElement> products = BaseTest.appiumDriver.findElements(By.xpath(xpath));
        int index = random.nextInt(products.size());
        products.get(index).click();
    }
}
