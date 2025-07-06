package co.com.client.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.client.project.userinterfaces.Page.LOGO_ORANGE;


public class BotonOrangeQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LOGO_ORANGE, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds()

        );
        return true;
    }

    public static BotonOrangeQuestion botonOrangeQuestion() {
        return new BotonOrangeQuestion();
    }
}

