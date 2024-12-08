package dam.pmdm.videoclase1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import dam.pmdm.videoclase1.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.acceptButton.setOnClickListener(this::acceptPressed);

    }

    private void acceptPressed(View view) {
        String email= binding.emailEdit.getText().toString();
        String pass= binding.passEdit.getText().toString();
        System.out.println("El email es "+ email + " y el pass es "+pass);
        Toast.makeText(this,"El email es "+ email + " y el pass es "+pass,Toast.LENGTH_SHORT).show();

    }
}