package dam.pmdm.tarea2;

public class PersonajeData {

    private final String imagen;
    private final String personaje;
    private final String descripcion;


    public PersonajeData(String imagen, String personaje, String description) {
        this.imagen = imagen;
        this.personaje = personaje;
        this.descripcion = description;
    }

    public String getImagen() {
        return imagen;
    }

    public String getPersonaje() {
        return personaje;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
