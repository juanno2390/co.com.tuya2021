package co.com.proyectobase.screenplay.stepdefinitions;

import co.com.proyectobase.screenplay.questions.ValidateSearchResults;
import co.com.proyectobase.screenplay.tasks.*;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.core.webdriver.driverproviders.ChromeDriverCapabilities;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementLocated;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AppTestStepDefinitions {

    public static List<List<String>> data;

    @Managed(driver="chrome")
    private WebDriver hisBrowser;
    private Actor theActorInTheSpotlight = Actor.named("tuyaUser");

    @Before
    public void configuracionInicial() {
        theActorInTheSpotlight.can(BrowseTheWeb.with(hisBrowser));
    }


    @Dado("^el usuario se encuetra en la página de portal demoblize$")
    public void elUsuarioSeEncuetraEnLaPáginaDePortalDemoblize() {
        theActorInTheSpotlight.wasAbleTo(OpenPage.AppTestWebStore());
    }

    @Cuando("^el usuario seleccione la categoria (.*)$")
    public void elUsuarioSeleccioneLaCategoriaCategoria(String categoria) {
        theActorInTheSpotlight.attemptsTo(AbrirProductosPorCategoria.ClickButton());
        //hisBrowser.findElement(By.xpath("//a[contains(.,'"+categoria+"')]")).click();
    }

    @Entonces("^el usuario debera identificar en la posicion (.*) de la grilla de productos resultantes$")
    public void elUsuarioDeberaIdentificarEnLaPosicionDeLaGrillaDeProductosResultantes(String posicion, DataTable resultadoEsperados) {
        List<Map<String, String>> rows = resultadoEsperados.asMaps(String.class, String.class);
        String imagenEsperado = "", nombreEsperado = "", precioEsperado = "", descripcionEsperado = "";
        for (Map<String, String> columns : rows) {
            if (columns.containsKey("imagen_esperado")) {
                imagenEsperado = columns.get("imagen_esperado");
            }
            if (columns.containsKey("nombre_esperado")) {
                nombreEsperado = columns.get("nombre_esperado");
            }
            if (columns.containsKey("precio_esperado")) {
                precioEsperado = columns.get("precio_esperado");
            }
            if (columns.containsKey("descripcion_esperado")) {
                descripcionEsperado = columns.get("descripcion_esperado");
            }
        }

        theActorInTheSpotlight.attemptsTo(Ensure.that(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div["+posicion+"]/div[1]/div[1]/h4[1]")).isDisplayed());
        Assert.assertEquals(hisBrowser.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div["+posicion+"]/div[1]/div[1]/h4[1]")).getText(),nombreEsperado);
        Assert.assertEquals(hisBrowser.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div["+posicion+"]/div[1]/div[1]/h5[1]")).getText(),precioEsperado);
        assertThat("Verifico coincida parte de la descripcion producto: ", hisBrowser.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div["+posicion+"]/div[1]/div[1]/p[1]")).getText(), anyOf(
                containsString(descripcionEsperado)));

        hisBrowser.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div["+posicion+"]/div[1]/div[1]/h4[1]")).click();
        theActorInTheSpotlight.attemptsTo(Ensure.that(By.xpath("(//img[@src='"+imagenEsperado+"'])[1]")).isDisplayed());
    }

    @Then("^He should be able to see in the search results: (.*) with title: (.*)$")
    public void HeShouldBeAbleToSeeInTheResultWithTitle(String idPosition, String productTitle) throws InterruptedException {
        theActorInTheSpotlight.attemptsTo(OpenProductDetail.ClickToIndexResult(idPosition));
        theActorInTheSpotlight.should(seeThat(ValidateSearchResults.is(), equalTo(productTitle)));
    }

    @Then("^He should be able to see the verify message for sign-in is display$")
    public void heShouldBeAbleToSeeTheVerifyMessageForSignInIsDisplay() {
        theActorInTheSpotlight.attemptsTo(Ensure.that(ElementLocated.by("//div[@id='auth-email-missing-alert']")).isDisplayed());
    }

}
