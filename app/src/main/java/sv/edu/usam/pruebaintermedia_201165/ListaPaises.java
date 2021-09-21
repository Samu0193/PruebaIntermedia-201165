package sv.edu.usam.pruebaintermedia_201165;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListaPaises extends AppCompatActivity {

    TypedArray fotos;
    int[] banderas;
    String[] paises, capitales;
    ListView lvstPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);

        obtenerDatos(); // Obteniendo datos
        AdaptadorPais adaptador = new AdaptadorPais(this, paises, capitales, banderas);
        lvstPais = findViewById(R.id.lstPaises);
        lvstPais.setAdapter(adaptador);

        lvstPais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {
                Intent pantallaPais = new Intent(getApplicationContext(), Pais.class);
                pantallaPais.putExtra("posicion", posicion);
                startActivity(pantallaPais);
            }
        });
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