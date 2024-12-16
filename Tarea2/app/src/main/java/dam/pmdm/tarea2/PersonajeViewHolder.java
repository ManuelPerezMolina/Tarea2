package dam.pmdm.tarea2;

import androidx.recyclerview.widget.RecyclerView;
import dam.pmdm.tarea2.databinding.PersonajeCardviewBinding;

public class PersonajeViewHolder extends RecyclerView.ViewHolder {

    private final PersonajeCardviewBinding binding;

    /**
     * Constructor de la clase PersonajeViewHolder
     * @param binding
     */
    public PersonajeViewHolder(PersonajeCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Coloca los datos en las cardView
     */
    public void bind (PersonajeData datapersonaje) {
        binding.pctextview.setText(datapersonaje.getPersonaje());
        binding.pcimagenview.setImageResource(datapersonaje.getImagen());
        binding.executePendingBindings();
    }

}