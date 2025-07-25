package co.com.client.project.interactions.servicios;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.serenitybdd.annotations.Step;

import java.util.Map;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostWithHeader extends RestInteraction {
    private String resource;
    private String body;
    private Map<String, Object> header;

    public PostWithHeader(String resource, String body, Map<String, Object> header) {
        this.resource = resource;
        this.body = body;
        this.header = header;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .headers(header)
                .body(body)
                .when()
                .post(as(actor).resolve(resource));
    }
}
