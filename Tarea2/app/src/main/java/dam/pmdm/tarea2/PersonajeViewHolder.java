package dam.pmdm.tarea2;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dam.pmdm.tarea2.databinding.PersonajeCardviewBinding;

public class PersonajeViewHolder extends RecyclerView.ViewHolder {

    private final PersonajeCardviewBinding binding;

    public PersonajeViewHolder(@NonNull PersonajeCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (@NonNull PersonajeViewHolder personaje) {
        binding.pctextview.setText(personaje.toString());
        binding.executePendingBindings();
    }

}