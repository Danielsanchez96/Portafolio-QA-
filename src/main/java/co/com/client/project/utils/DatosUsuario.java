package co.com.client.project.utils;
import co.com.client.project.models.UsuarioDTO;
import com.github.javafaker.Faker;

public class DatosUsuario {
    public static UsuarioDTO generarDatos() {
        Faker faker = new Faker();
        return new UsuarioDTO(
                faker.numerify("##########"),
                faker.internet().emailAddress(),
                faker.address().cityName()

        );
    }
}