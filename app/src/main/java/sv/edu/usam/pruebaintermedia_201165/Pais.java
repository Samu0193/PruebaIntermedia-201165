package sv.edu.usam.pruebaintermedia_201165;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Pais extends AppCompatActivity {

    TypedArray fotos;
    int[] banderas;
    String[] paises, capitales;

    ImageView imgBandera;
    TextView tvPais, tvCapital;
    Bundle posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);

        imgBandera = findViewById(R.id.imgvBandera);
        tvPais = findViewById(R.id.tvPais);
        tvCapital = findViewById(R.id.tvCapital);

        posicion = getIntent().getExtras();

        obtenerDatos(); // Obteniendo datos
        imgBandera.setImageResource(banderas[posicion.getInt("posicion")]);
        tvPais.setText(paises[posicion.getInt("posicion")]);
        tvCapital.setText(capitales[posicion.getInt("posicion")]);
    }

    private void obtenerDatos() {
        // Fotos
        Resources res = this.getResources();
        fotos = res.obtainTypedArray(R.array.banderas);
        banderas = new int[fotos.length()];
        for (int i = 0; i < banderas.length; i++) {
            banderas[i] = fotos.getResourceId(i, 0);
        }

        // Paises
        paises = new String[fotos.length()];
        paises = res.getStringArray(R.array.paises);

        // Capitales
        capitales = new String[fotos.length()];
        capitales = res.getStringArray(R.array.capitales_paises);
    }

}