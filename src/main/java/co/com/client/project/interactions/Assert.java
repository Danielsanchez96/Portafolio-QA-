package co.com.client.project.interactions;

import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Assert {

    private Assert(){}

    public static Interaction fail(String mensaje){
        return instrumented(AssertFail.class, mensaje);
    }
}
