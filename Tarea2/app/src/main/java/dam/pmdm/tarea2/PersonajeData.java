package dam.pmdm.tarea2;

public class PersonajeData {

    private final String number;
    private final int imagen;
    private final String personaje;
    private final String descripcion;


    public PersonajeData(String number, int imagen,String personaje,String descripcion) {
        this.number = number;
        this.imagen = imagen;
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
