package co.com.client.project.questions;

import co.com.client.project.models.UsuarioDTO;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.client.project.userinterfaces.Page.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class DatosMostradosCoincidenConDTO implements Question<UsuarioDTO> {

    private final UsuarioDTO usuario;

    public DatosMostradosCoincidenConDTO(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public static DatosMostradosCoincidenConDTO con(UsuarioDTO usuario) {
        return new DatosMostradosCoincidenConDTO(usuario);
    }

    @Override
    public UsuarioDTO answeredBy(Actor actor) {
        WaitUntil.the(TEXTBOX_CIUDAD, isClickable()).forNoMoreThan(10).seconds();
        String ciudadFront = TEXTBOX_CIUDAD.resolveFor(actor).getValue();
        String telefonoFront = TEXTBOX_TELEFONO.resolveFor(actor).getValue();
        String emailFront = TEXTBOX_EMAIL.resolveFor(actor).getValue();

        return new UsuarioDTO(telefonoFront, emailFront, ciudadFront);
    }
}