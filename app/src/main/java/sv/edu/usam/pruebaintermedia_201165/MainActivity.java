package sv.edu.usam.pruebaintermedia_201165;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imgLogIn;
    EditText etUser, etPassword;
    Button btnLogIn, btnClose;
    int intentos = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLogIn = findViewById(R.id.imgLogIn);
        imgLogIn.setClipToOutline(true);

        // Textos
        etUser = findViewById(R.id.edtUser);
        etPassword = findViewById(R.id.edtPass);

        // Botones
        btnLogIn = findViewById(R.id.btnLogIn);
        btnClose = findViewById(R.id.btnClose);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user, pass;
                user = etUser.getText().toString();
                pass = etPassword.getText().toString();
                Intent listaPaises = new Intent(getApplicationContext(), ListaPaises.class);
                if (!user.equals("") && !pass.equals("")) {
                    if (user.equals("Android") && pass.equals("123")) {
                        startActivity(listaPaises);
                        Toast.makeText(getApplicationContext(), "Bienvenido " + user + "!", Toast.LENGTH_SHORT).show();
                    } else {
                        intentos--;
                        if (intentos != 0) {
                            Toast.makeText(getApplicationContext(), "\t\t\t\t\t\tERROR!\n\nTe quedan " + intentos + " intentos", Toast.LENGTH_SHORT).show();
                        } else {
                            finish();
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Ingresa tus credenciales!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}