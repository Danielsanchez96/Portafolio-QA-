package co.com.client.project.steps;

import co.com.client.project.models.UsuarioDTO;
import net.serenitybdd.annotations.Step;

public class ReporteSteps {

    @Step("🐱‍👤 El primer Pokémon obtenido fue: {0}")
    public void mostrarNombrePokemon(String nombre) {
        // Este paso aparecerá en el reporte de Serenity
    }
    @Step("📋 Comparación de datos esperados vs obtenidos:\nEsperado: {0}\nObtenido: {1}")
    public void mostrarComparacionDatos(UsuarioDTO esperado, UsuarioDTO obtenido) {
        // Solo para mostrar en el reporte, no necesita lógica interna
    }
}
