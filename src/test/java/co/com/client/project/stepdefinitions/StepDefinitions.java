package co.com.client.project.stepdefinitions;
import co.com.client.project.interactions.controlador.ConsumirServicioPokemon;
import co.com.client.project.models.UsuarioDTO;
import co.com.client.project.questions.DatosMostradosCoincidenConDTO;
import co.com.client.project.tasks.LlenarFormulario;
import co.com.client.project.tasks.OpenSite;
import co.com.client.project.utils.Constants;
import co.com.client.project.steps.ReporteSteps; // Clase auxiliar
import co.com.client.project.utils.DatabaseConnection;
import co.com.client.project.utils.DatosUsuario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import net.thucydides.model.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static co.com.client.project.questions.BotonOrangeQuestion.botonOrangeQuestion;
import static co.com.client.project.stepdefinitions.Hooks.actor;
import static co.com.client.project.stepdefinitions.Hooks.driver;
import static co.com.client.project.tasks.Login.login;
import static co.com.client.project.utils.PropertiesManager.getValue;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;


public class StepDefinitions {

    private static final Logger LOGGER = LoggerFactory.getLogger(StepDefinitions.class);
    private static EnvironmentVariables environmentVariables;
    private String endpoint;
    private UsuarioDTO usuario;

    @Steps
    ReporteSteps reporteSteps; // Para mostrar info en el reporte Serenity

    @Before
    public void beforeRun() {
        LOGGER.info(Constants.Messages.MSG_INICIA_PRUEBA);
    }


    @Dado("que el usuario inicia sesión")
    public void queElUsuarioIniciaSesion() {
        // PRIMER METODO para obtener la url
        //obtiene la url desde el serenity.conf ó con el getValue lo obtiene desde environment.properties
        //String url = environmentVariables.optionalProperty("applications.url").orElse(getValue("url"));
        // SEGUNDO METODO para obtener la url por medio de la base de datos
        String url = DatabaseConnection.obtenerEndpointPorId(1);
        actor.attemptsTo(OpenSite.abrir(url));
        actor.attemptsTo(login());
        actor.should(seeThat(botonOrangeQuestion(), is(true)));
    }


    @Cuando("actualiza sus datos")
    public void actualizaSusDatos() {
        usuario = DatosUsuario.generarDatos();
        actor.attemptsTo(LlenarFormulario.conDatos(usuario));

    }

    @Entonces("valido que los datos se actualizaron correctamente")
    public void validoQueLosDatosSeActualizaronCorrectamente() {
        UsuarioDTO datosEsperados = usuario;
        UsuarioDTO datosObtenidos = actor.asksFor(DatosMostradosCoincidenConDTO.con(datosEsperados));
        // Mostrar en el reporte la comparación
        reporteSteps.mostrarComparacionDatos(datosEsperados, datosObtenidos);
        // Validaciones con trazabilidad en caso de error
        assertEquals("La ciudad no coincide", datosEsperados.getCiudad(), datosObtenidos.getCiudad());
        assertEquals("El teléfono no coincide", datosEsperados.getTelefono(), datosObtenidos.getTelefono());
        assertEquals("El email no coincide", datosEsperados.getEmail(), datosObtenidos.getEmail());

    }

    @Dado("que obtengo el endpoint desde la base de datos")
    public void obtenerEndpointDesdeBaseDeDatosPonId() {
        // PRIMER METODO para obtener el endpoint
        //obtiene el endpoint desde el serenity.conf ó con el getValue lo obtiene desde environment.properties
        //endpoint = environmentVariables.optionalProperty("api.url").orElse(getValue("endpoint"));
        // SEGUNDO METODO para obtener la url por medio de la base de datos
        endpoint = DatabaseConnection.obtenerEndpointPorId(2);
        LOGGER.info("🔗 Endpoint obtenido desde la base de datos: {}", endpoint);

    }

    @Cuando("consulto el servicio de especies Pokémon")
    public void consultarServicioDeEspeciesPokemon() {
        String pokemon;
        actor.attemptsTo(ConsumirServicioPokemon.obtenerPokemon(endpoint));
        pokemon = lastResponse().jsonPath().getString("results[0].name");
        LOGGER.info("📦 Primer Pokémon recibido: {}", pokemon);
        reporteSteps.mostrarNombrePokemon(pokemon);

    }

    @Entonces("el primer Pokémon de la respuesta debe ser {string}")
    public void verificarPrimerPokemonDeLaRespuesta(String nombreEsperado) {
        // Obtener el nombre del primer Pokémon de la respuesta JSON
        String primerPokemon = lastResponse().jsonPath().getString("results[0].name");
        // Mostrar en consola
        LOGGER.info("📦 Primer Pokémon recibido: {}", primerPokemon);
        // Validar que el nombre obtenido sea igual al esperado
        assertEquals("Se esperaba que el primer Pokémon fuera: " + nombreEsperado + ", pero se recibió: " + primerPokemon,
                nombreEsperado, primerPokemon);

    }

    @After
    public void afterRun() {
        LOGGER.info(Constants.Messages.MSG_FIN_PRUEBA);
    }
}