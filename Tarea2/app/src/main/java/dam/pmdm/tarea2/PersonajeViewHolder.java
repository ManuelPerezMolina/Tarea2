package dam.pmdm.tarea2;

import androidx.recyclerview.widget.RecyclerView;
import dam.pmdm.tarea2.databinding.PersonajeCardviewBinding;

public class PersonajeViewHolder extends RecyclerView.ViewHolder {

    private final PersonajeCardviewBinding binding;

    public PersonajeViewHolder(PersonajeCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (PersonajeData datapersonaje) {
        binding.pctextview.setText(datapersonaje.getPersonaje());
        binding.pcimagenview.setImageResource(datapersonaje.getImagen());
        binding.executePendingBindings();
    }

}