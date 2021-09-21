package sv.edu.usam.pruebaintermedia_201165;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorPais extends ArrayAdapter<String> {

    Activity contexto;
    String[] paises, capitales;
    int[] imgPaises;
    ImageView imgvBanderas;
    TextView tvPaises, tvCapitales;

    public AdaptadorPais(Activity contexto, String[] paises, String[] capitales, int[] imgPaises) {
        super(contexto, R.layout.paises, paises);
        this.contexto = contexto;
        this.imgPaises = imgPaises;
        this.paises = paises;
        this.capitales = capitales;
    }

    public View getView(int posicion, View v, ViewGroup parent) {
        LayoutInflater inflater = contexto.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.paises, null, true);

        imgvBanderas = rowView.findViewById(R.id.imgvBanderas);
        tvPaises = rowView.findViewById(R.id.tvPaises);
        tvCapitales = rowView.findViewById(R.id.tvCapitales);

        imgvBanderas.setImageResource(imgPaises[posicion]);
        tvPaises.setText(paises[posicion]);
        tvCapitales.setText(capitales[posicion]);

        return rowView;
    }

}
