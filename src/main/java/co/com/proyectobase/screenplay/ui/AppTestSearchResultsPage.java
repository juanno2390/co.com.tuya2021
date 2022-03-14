package co.com.proyectobase.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AppTestSearchResultsPage extends PageObject {

    public void ValidateDescriptionOnThePositionIdResult(String idPosition) {
        getDriver().findElement(By.cssSelector("span[data-component-id="+idPosition+"]")).click();
    }

    public static final Target PRODUCT_INDEX_ID = Target.the("PRODUCT_INDEX_ID")
            .located(By.cssSelector("span[data-component-id='1']"));

    public static final Target PRODUCT_TITLE = Target.the("PRODUCT_TITLE")
            .located(By.cssSelector("span[id='productTitle']"));

    public static final Target LAPTOPS_CATEGORY_BUTTON = Target.the("LAPTOPS_CATEGORY")
            .located(By.xpath("//a[contains(.,'Laptops')]"));

}
