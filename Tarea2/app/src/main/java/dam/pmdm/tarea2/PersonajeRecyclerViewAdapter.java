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

    private final ArrayList<DataPersonajeItem> personajes;
    private Context context;
    private View v;

    public PersonajeRecyclerViewAdapter (ArrayList<DataPersonajeItem> personaje) {
        this.personajes = personaje;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PersonajeCardviewBinding binding = PersonajeCardviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PersonajeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(PersonajeViewHolder holder, int position){
        DataPersonajeItem currentPersonaje = this.personajes.get(position);
        holder.bind(currentPersonaje);
        holder.itemView.setOnClickListener(view -> itemClicked(currentPersonaje));
    }

    @Override
    public int getItemCount(){
        return personajes.size();
    }

    private void itemClicked(PersonajeData currentPersonaje) {
        context = Context.;
        ((MainActivity)context).personajeClicked(currentPersonaje);
    }

}
