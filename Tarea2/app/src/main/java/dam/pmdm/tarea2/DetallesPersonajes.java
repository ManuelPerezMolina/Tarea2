package dam.pmdm.tarea2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import dam.pmdm.tarea2.databinding.ActivityDetallesPersonajesBinding;
import dam.pmdm.tarea2.databinding.ActivityMainBinding;

public class DetallesPersonajes extends AppCompatActivity {

    private Context context;
    private ActivityDetallesPersonajesBinding binding;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalles_personajes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding = ActivityDetallesPersonajesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    public void init(){
       Bundle extras = getIntent().getExtras();
       binding.adpnombrepersonaje.setText(extras.getString("nombre"));
       binding.adpdescripcion.setText(extras.getString("descripcion"));
       binding.adphabilidades.setText(extras.getString("habilidades"));
       binding.adpimageView.set("imagen");

    }
}