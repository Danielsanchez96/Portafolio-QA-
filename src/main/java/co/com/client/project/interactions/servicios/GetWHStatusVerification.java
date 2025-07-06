package co.com.client.project.interactions.servicios;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

public class GetWHStatusVerification extends RestInteraction {

    private final Map<String, Object> headers;
    private final String fullUrl; // ✅ ahora se llama fullUrl para dejar claro que es la URL completa

    public GetWHStatusVerification(String fullUrl, Map<String, Object> headers) {
        this.fullUrl = fullUrl;
        this.headers = headers;
    }

    @Step("{0} ejecuta un GET a la URL completa: #fullUrl")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest()
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .headers(headers)
                .when()
                .get(fullUrl) // ✅ usamos la URL completa directamente
                .then()
                .statusCode(200);
    }
}
