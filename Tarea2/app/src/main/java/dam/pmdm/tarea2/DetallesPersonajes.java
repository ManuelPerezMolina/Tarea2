package dam.pmdm.tarea2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import dam.pmdm.tarea2.databinding.ActivityDetallesPersonajesBinding;

public class DetallesPersonajes extends AppCompatActivity {

    private Context context;
    private ActivityDetallesPersonajesBinding binding;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalles_personajes);
        binding = ActivityDetallesPersonajesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    public void init(){
       Bundle extras = getIntent().getExtras();
       binding.adpnombrepersonaje.setText(extras.getString("nombre"));
       binding.adpdescripcion.setText(extras.getString("descripcion"));
       binding.adphabilidades.setText(extras.getString("habilidades"));
       binding.adpimageView.setImageResource(extras.getInt("imagen"));
    }
}