package co.com.client.project.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.junit.Assert;

public class AssertFail implements Interaction {

    private String mensaje;

    public AssertFail(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Assert.fail(mensaje);
    }
}
