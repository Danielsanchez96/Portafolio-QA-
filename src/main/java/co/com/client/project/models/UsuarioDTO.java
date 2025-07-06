package co.com.client.project.models;

public class UsuarioDTO {

    private String telefono;
    private String email;
    private String ciudad;

    // Constructor vacío (necesario para frameworks como Jackson o Gson)
    public UsuarioDTO() {
    }

    // Constructor con todos los campos
    public UsuarioDTO(String telefono, String email, String ciudad) {
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
    }

    // Getters y Setters
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
