package co.com.client.project.interactions.controlador;

import co.com.client.project.interactions.servicios.GetWHStatusVerification;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumirServicioPokemon {
    public static GetWHStatusVerification obtenerPokemon(String resource){
        Map<String, String> headers;
        headers = new HashMap<>();
        headers.put("x-api-key","");

        return instrumented(GetWHStatusVerification.class,resource,headers);

    }
}
