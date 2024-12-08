package dam.pmdm.tarea2;

public class PersonajeData {

    private final String numero;
    private final int imagen;
    private final String personaje;
    private final String descripcion;


    public PersonajeData(String numero, int imagen, String personaje, String descripcion) {
        this.numero = numero;
        this.imagen = imagen;
        this.personaje = personaje;
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public String getPersonaje() {
        return personaje;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
