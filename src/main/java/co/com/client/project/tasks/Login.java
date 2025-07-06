package co.com.client.project.tasks;


import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.client.project.userinterfaces.Page.*;
import static java.lang.System.getenv;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;



public class Login implements Task {




    private static final String EMAIL_USUARIO = System.getenv("EMAIL_USUARIO");
    private static final String PASSWORD_USUARIO = System.getenv("PASSWORD_USUARIO");

    @Override
    @Step("{0} intenta iniciar sesión con el correo y contraseña proporcionados")
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                WaitUntil.the(TEXTBOX_CORREO_ELECTRONICO, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(TEXTBOX_CORREO_ELECTRONICO).isDisplayed(),
                Click.on(TEXTBOX_CORREO_ELECTRONICO),
                Clear.field(TEXTBOX_CORREO_ELECTRONICO),
                SendKeys.of(EMAIL_USUARIO).into(TEXTBOX_CORREO_ELECTRONICO),
                Click.on(TEXTBOX_PASSWORD),
                Clear.field(TEXTBOX_PASSWORD),
                SendKeys.of(PASSWORD_USUARIO).into(TEXTBOX_PASSWORD),
                Click.on(BOTON_INICIAR_SESION),
                WaitUntil.the(LOGO_ORANGE, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(LOGO_ORANGE).isDisplayed()

        );
    }


    public static Login login() {
        return new Login();
    }
}
