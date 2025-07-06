package co.com.client.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TestQuestion implements Question<Boolean> {

    public static TestQuestion validarAccion() {
        return new TestQuestion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
       return true; //TODO Implementar validacion logica
    }

}
