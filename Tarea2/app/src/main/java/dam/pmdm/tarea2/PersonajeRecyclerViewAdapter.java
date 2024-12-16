package dam.pmdm.tarea2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import dam.pmdm.tarea2.databinding.PersonajeCardviewBinding;

public class PersonajeRecyclerViewAdapter extends RecyclerView.Adapter <PersonajeViewHolder> {

    private final ArrayList<PersonajeData> personajes;

    /**
     * Constructor de la clase
     * @param personaje parametro recogido de MainActivity con los datos de los personajes
     */
    public PersonajeRecyclerViewAdapter (ArrayList<PersonajeData> personaje) {
        this.personajes = personaje;
    }

    /**
     * Metodo para inflar los datos de los personajes en las cardView
     * @param parent
     * @param viewType
     * @return PersonajeViewHolder.java y los datos de los personajes
     */

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PersonajeCardviewBinding binding = PersonajeCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new PersonajeViewHolder(binding);
    }

    /**
     *Colocamos los datos de los personajes en el recyclerview y llamamos al método itemClicked
     * @param holder cardview clickado
     * @param position posició de los datos del cardview pulsado
     */
    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position){
        PersonajeData currentPersonaje = this.personajes.get(position);
        holder.bind(currentPersonaje);
        holder.itemView.setOnClickListener(view -> itemClicked(currentPersonaje,view));
    }

    /**
     * Cuenta el numero de Cardview creados
     * @return devuelve el número de elementos de la lista
     */
    @Override
    public int getItemCount(){
        return personajes.size();
    }

    /**
     * Metodo que recoge el clikado de un cardview y envia los datos a
     * MainActivity.java/personajeClicked
     * @param currentPersonaje datos del personaje del cardview clickado
     * @param view
     */
    private void itemClicked(PersonajeData currentPersonaje, View view) {
        ((MainActivity) view.getContext()).personajeClicked(currentPersonaje,view);
    }

}
