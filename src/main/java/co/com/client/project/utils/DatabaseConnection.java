package co.com.client.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // Clase que almacena el resultado de la consulta
import java.sql.SQLException;

public class DatabaseConnection {

    /**
     * Método para obtener un endpoint desde la base de datos MySQL usando un ID específico.
     *
     * @param id El ID del endpoint que se desea consultar
     * @return La URL del endpoint almacenado en la base de datos
     */
    public static String obtenerEndpointPorId(int id) {
        // Leer variables de entorno del sistema (asegúrate de haberlas configurado correctamente)
        String url = System.getenv("DB_URL");
        String usuario = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        // Consulta SQL con un parámetro (el signo de pregunta ? será reemplazado más adelante)
        String query = "SELECT endpoint_url FROM endpoints WHERE id = ?";

        try (
                // Establece la conexión con la base de datos
                Connection conexion = DriverManager.getConnection(url, usuario, password);

                // Prepara la sentencia SQL. Esta es una forma segura de ejecutar consultas con parámetros
                PreparedStatement statement = conexion.prepareStatement(query);
        ) {
            // Reemplaza el signo de pregunta (?) con el valor real del ID proporcionado
            // El número 1 indica que se está reemplazando el primer ?
            statement.setInt(1, id);

            // Ejecuta la consulta y almacena el resultado en un ResultSet
            ResultSet resultSet = statement.executeQuery();

            // Si hay resultados, obtener el valor de la columna "endpoint_url"
            if (resultSet.next()) {
                return resultSet.getString("endpoint_url");
            }

        } catch (SQLException e) {
            // Imprime el error en consola si ocurre algo
            e.printStackTrace();
        }

        // Si no se encuentra el endpoint o ocurre un error, devuelve null
        return null;
    }
}