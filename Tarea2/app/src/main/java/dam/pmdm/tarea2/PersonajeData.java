package dam.pmdm.tarea2;

public class PersonajeData {

    private final int imagen;
    private final String personaje;
    private final String descripcion;
    private final String habilidades;


    public PersonajeData(int imagen, String personaje, String descripcion, String habilidades) {
        this.imagen = imagen;
        this.personaje = personaje;
        this.descripcion = descripcion;
        this.habilidades = habilidades;
    }

    public String getHabilidades() {
        return habilidades;
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
