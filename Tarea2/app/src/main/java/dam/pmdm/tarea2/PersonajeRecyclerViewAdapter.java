package dam.pmdm.tarea2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dam.pmdm.tarea2.databinding.PersonajeCardviewBinding;

public class PersonajeRecyclerViewAdapter extends RecyclerView.Adapter <PersonajeViewHolder> {

    private final ArrayList<PersonajeItem> personajes;
    private final Context context;

    public PersonajeRecyclerViewAdapter (ArrayList<PersonajeItem> personajes, Context context){
        this.personajes = personajes;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PersonajeCardviewBinding binding = PersonajeCardviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PersonajeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position){
        PersonajeItem currentPersonaje = this.personajes.get(position);
        holder.bind(currentPersonaje);
        holder.itemView.setOnContextClickListener(view -> itemClicked(currentPersonaje));
    }

    @Override
    public int getItemCount(){
        return personajes.size();
    }

    private void itemClicked(PersonajeItem currentPersonaje) {
        ((MainActivity)context.finalize(currentPersonaje));
    }

}
