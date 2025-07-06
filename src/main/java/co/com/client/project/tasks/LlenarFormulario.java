package co.com.client.project.tasks;


import co.com.client.project.models.UsuarioDTO;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


import static co.com.client.project.userinterfaces.Page.*;


public class LlenarFormulario implements Task {

    private final UsuarioDTO usuario;

    public LlenarFormulario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public static LlenarFormulario conDatos(UsuarioDTO usuario) {
        return Tasks.instrumented(LlenarFormulario.class, usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BOTON_MY_INFO, isClickable()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BOTON_MY_INFO),
                WaitUntil.the(BOTON_CONTACT_DETAILS, isClickable()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BOTON_CONTACT_DETAILS),

                WaitUntil.the(TEXTBOX_TELEFONO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(TEXTBOX_TELEFONO),
                Enter.keyValues(Keys.CONTROL, "a").into(TEXTBOX_TELEFONO),
                Enter.keyValues(Keys.DELETE).into(TEXTBOX_TELEFONO),
                Enter.theValue(usuario.getTelefono()).into(TEXTBOX_TELEFONO),
                Click.on(TEXTBOX_EMAIL),
                Enter.keyValues(Keys.CONTROL, "a").into(TEXTBOX_EMAIL),
                Enter.keyValues(Keys.DELETE).into(TEXTBOX_EMAIL),
                Enter.theValue(usuario.getEmail()).into(TEXTBOX_EMAIL),
                Click.on(TEXTBOX_CIUDAD),
                Enter.keyValues(Keys.CONTROL, "a").into(TEXTBOX_CIUDAD),
                Enter.keyValues(Keys.DELETE).into(TEXTBOX_CIUDAD),
                Enter.theValue(usuario.getCiudad()).into(TEXTBOX_CIUDAD),
                Click.on(BOTON_GUARDAR),
                WaitUntil.the(TOAST_ACTUALIZACION_EXITOSA, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}