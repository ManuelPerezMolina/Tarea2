package dam.pmdm.tarea2;

public class PersonajeData {

    private final int imagen;
    private final String personaje;
    private final String descripcion;


    public PersonajeData(int imagen, String personaje, String descripcion) {
        this.imagen = imagen;
        this.personaje = personaje;
        this.descripcion = descripcion;
    }

    public int getImagen(int i) {
        return imagen;
    }

    public String getPersonaje(int i) {
        return personaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
