package dam.pmdm.tarea2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import dam.pmdm.tarea2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    List<PersonajeData> items;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }


    public void init() {
        this.context = context;
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.amRvpersonajes.setLayoutManager(new LinearLayoutManager(this));

        items = new ArrayList<>();
        items.add(
                0,
                new PersonajeData(
                        R.drawable.mario,
                        "MARIO",
                        "El héroe principal del Reino Champiñón.",
                        "poderosa habilidad para saltar"));
        items.add(1,
                new PersonajeData(
                        R.drawable.luigi,
                        "LUIGI",
                        "Hermano de Mario y héroe del Reino Champiñón",
                        "puede saltar más alto que Mario"));
        items.add(2,
                new PersonajeData(
                        R.drawable.peache,
                        "PEACHE",
                        "La querida princesa del Reino Champiñón",
                        "Es extremadamente amable y siempre está trabajando para crear un mundo en el que todos puedan convivir juntos y felices"));
        items.add(3,
                new PersonajeData(
                        R.drawable.toach,
                        "TOACH",
                        "Residente del Reino Champiñón, trabaja al servicio de la Princesa Peach",
                        "es muy alegre y leal"));

        binding.amRvpersonajes.setAdapter(new PersonajeRecyclerViewAdapter((ArrayList<DataPersonajeItem>) items));

    }

    public void personajeClicked(PersonajeData currentPersonaje){
        Intent intent = new Intent(this, DetallesPersonajes.class);
        startActivity(intent);
    }
}