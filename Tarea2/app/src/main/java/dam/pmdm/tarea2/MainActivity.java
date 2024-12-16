package dam.pmdm.tarea2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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
    private MainActivity mainactivity;

    /**
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
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

    /**
     *
     * @param menu The options menu in which you place your items.
     *
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.personaje_menu,menu);
        return true;
    }

    /**
     *
     * @param item The menu item that was selected.
     *
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.acerca_de) {
            mostrarDialogo();
        }
        return super.onOptionsItemSelected(item);
    }

    private void mostrarDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        TextView myMsg = new TextView(this);
        myMsg.setText(R.string.mensaje);
        myMsg.setTextSize(40);
        myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
        builder.setView(myMsg).show();
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

        binding.amRvpersonajes.setAdapter(new PersonajeRecyclerViewAdapter((ArrayList<PersonajeData>) items));

    }

    public void personajeClicked(PersonajeData personaje,View view){

       Context context = view.getContext();
       Intent intent = new Intent(context, DetallesPersonajes.class);
       intent.putExtra("nombre",personaje.getPersonaje());
       intent.putExtra("imagen",personaje.getImagen());
       intent.putExtra("descripcion",personaje.getDescripcion());
       intent.putExtra("habilidades",personaje.getHabilidades());
       context.startActivity(intent);
    }
}