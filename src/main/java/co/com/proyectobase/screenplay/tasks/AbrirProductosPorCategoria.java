package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.ui.AppTestSearchResultsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class AbrirProductosPorCategoria implements Task {

    public AbrirProductosPorCategoria() {
        super();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(AppTestSearchResultsPage.LAPTOPS_CATEGORY_BUTTON));
    }

    public static AbrirProductosPorCategoria ClickButton() {
        return Tasks.instrumented(AbrirProductosPorCategoria.class);
    }

}
