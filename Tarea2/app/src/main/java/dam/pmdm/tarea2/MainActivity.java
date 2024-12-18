package dam.pmdm.tarea2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import dam.pmdm.tarea2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    List<PersonajeData> items;
    private Context context;
    private MainActivity mainactivity;

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
     * @param menu inflamos el menu que hemos generado en res/menu/personaje_menu.xml
     *
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.personaje_menu,menu);
        return true;
    }

    /**
     *
     * @param item corresponde a la opción del menu Acerca de... que nos dirige al metodo
     *             mostrarDialogo()
     *
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

    /**
     *
     * Creamos un Dialogo que nos da la información del nombre del desarrollador y
     * de la versión de la App
     *
     */
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

        /**
         * Creamos un ArrayList con los datos de cada cardview
         *      (imagen,nombre personaje,descripción y habilidades)
         */

        items = new ArrayList<>();
        items.add(
                0,
                new PersonajeData(
                        R.drawable.mario,
                        getString(R.string.n_mario),
                        getString(R.string.des_mario),
                        getString(R.string.hab_mario)));
        items.add(1,
                new PersonajeData(
                        R.drawable.luigi,
                        getString(R.string.n_luigi),
                        getString(R.string.des_luigi),
                        getString(R.string.hab_luigi)));
        items.add(2,
                new PersonajeData(
                        R.drawable.peache,
                        getString(R.string.n_peache),
                        getString(R.string.des_peache),
                        getString(R.string.hab_peache)));
        items.add(3,
                new PersonajeData(
                        R.drawable.toach,
                        getString(R.string.n_toad),
                        getString(R.string.des_toad),
                        getString(R.string.hab_toad)));

        simpleSnackbar(findViewById(android.R.id.content));
        binding.amRvpersonajes.setAdapter(new PersonajeRecyclerViewAdapter((ArrayList<PersonajeData>) items));

    }

    public void simpleSnackbar(View view){
        Snackbar mySnackbar = Snackbar.make(view, R.string.men_snackbar, Snackbar.LENGTH_SHORT);
        mySnackbar.show();


    }

    /**
     * Metodo para gestionar click en un cardview procedente del
     * metodo PersonajeRecyclerViewAdapter.java/itemClicked
     * @param personaje nos da la información del cardview clickado
     * @param view viene heredado del modulo PersonajeRecyclerViewAdapter.java/itemClicked
     */
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