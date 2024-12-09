package dam.pmdm.tarea2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dam.pmdm.tarea2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<PersonajeData> items = new ArrayList<>();

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

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.amRvpersonajes.setLayoutManager(new LinearLayoutManager(this));

        items.add(
                0,
                new PersonajeData(
                        R.drawable.mario,
                        "MARIO",
                        "ESTE ES MARIO"));
        items.add(1,
                new PersonajeData(
                        R.drawable.luigi,
                        "LUIGI",
                        "ESTE ES LUIGI"));
        items.add(2,
                new PersonajeData(
                        R.drawable.peache,
                        "PEACHE",
                        "ESTE ES PEACHE"));
        items.add(3,
                new PersonajeData(
                        R.drawable.toach,
                        "TOACH",
                        "ESTE ES TOACH"));

        binding.amRvpersonajes.setAdapter(new PersonajeRecyclerViewAdapter(items));

    }

    public void personajeClicked(PersonajeData currentPersonaje) {

    }
}