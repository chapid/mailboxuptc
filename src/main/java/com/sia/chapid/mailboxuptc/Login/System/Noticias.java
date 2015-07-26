package com.sia.chapid.mailboxuptc.Login.System;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sia.chapid.mailboxuptc.Login.System.Pk_Noticias.NoticiaCinco;
import com.sia.chapid.mailboxuptc.Login.System.Pk_Noticias.NoticiaDos;
import com.sia.chapid.mailboxuptc.Login.System.Pk_Noticias.NoticiaSeis;
import com.sia.chapid.mailboxuptc.Login.System.Pk_Noticias.NoticiaSiete;
import com.sia.chapid.mailboxuptc.Login.System.Pk_Noticias.NoticiaTres;
import com.sia.chapid.mailboxuptc.Login.System.Pk_Noticias.NoticiaUno;
import com.sia.chapid.mailboxuptc.Login.System.Pk_Noticias.Noticia_Cuatro;
import com.sia.chapid.mailboxuptc.R;

public class Noticias extends ActionBarActivity {

    ListViewAdapterTwo listAdapterTwo;

    String[] menu = {
            "Jornada Inducción",
            "Simposio",
            "Beca Colciencias",
            "Festividad",
            "Convocatoria",
            "UPTC firma",
            "Inscripciones abiertas"
    };

    String []contenido=new String[]{
            "La UPTC, les da la bienvenida a los estudiantes nuevos " +
            "que entran a formar parte de la Familia..",
            "Los grupos de investigación Historia y Prospectiva de la" +
            " Universidad Latinoamericana – HISULA y...",
            "Convocatoria abierta del 2 de julio al 11 de agosto de 2015...",
            "El grupo de conductores de la UPTC y la Unidad de Política Social," +
            " invitan a participar en las diferentes...",
            "Los grupos de investigación Historia y Prospectiva de la Universidad " +
            "Latinoamericana –HISULA- e -ILAC...",
            "Con el propósito de visibilizar la actividad académica y establecer " +
            "vínculos internacionales, el rector encargado...",
            "Los Doctorados en Historia, y en Lenguaje y Cultura, amplían las fechas " +
            "de inscripción para el segundo semestre de 2015"
    };

    int[] iconos = {
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img9,
            R.drawable.img1,
            R.drawable.img8,
            R.drawable.img7
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView lista = (ListView) findViewById(R.id.listViewNoticias);
        listAdapterTwo = new ListViewAdapterTwo(this,iconos,menu,contenido);
        lista.setAdapter(listAdapterTwo);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int posicion, long l) {
                switch (posicion) {
                    case 0 :
                        Intent opUno = new Intent(getApplicationContext(), NoticiaUno.class);
                        startActivity(opUno);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 1 :
                        Intent opDos = new Intent(getApplicationContext(), NoticiaDos.class);
                        startActivity(opDos);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 2:
                        Intent opTres = new Intent(getApplicationContext(), NoticiaTres.class);
                        startActivity(opTres);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 3:
                        Intent opCuatro = new Intent(getApplicationContext(), Noticia_Cuatro.class);
                        startActivity(opCuatro);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 4:
                        Intent opCinco = new Intent(getApplicationContext(), NoticiaCinco.class);
                        startActivity(opCinco);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 5:
                        Intent opSeis = new Intent(getApplicationContext(), NoticiaSeis.class);
                        startActivity(opSeis);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 6:
                        Intent opSiete = new Intent(getApplicationContext(), NoticiaSiete.class);
                        startActivity(opSiete);
                        overridePendingTransition(R.anim.right_in, R.anim.right_out);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "ninguna opcion", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
/*******************************************************/
public class ListViewAdapterTwo extends BaseAdapter {
    // Declare Variables
    Context context;
    int[] imagenes;
    String[] titulos;
    String[] contenido;
    LayoutInflater inflater;

    public ListViewAdapterTwo(Context context, int[] imagenes, String[] titulos, String[] contenido ) {
        this.context = context;
        this.imagenes = imagenes;
        this.titulos = titulos;
        this.contenido = contenido;
    }

    @Override
    public int getCount() {
        return titulos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        ImageView imgImg;
        TextView txtTitle;
        TextView txtContenido;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_row_two, parent, false);

        // Locate the TextViews in listview_item.xml
        imgImg = (ImageView) itemView.findViewById(R.id.imagen_single_post_circuito);
        txtTitle = (TextView) itemView.findViewById(R.id.tv_titulo_single_post_circuito);
        txtContenido = (TextView) itemView.findViewById(R.id.tv_contenido_single_post_circuito);

        // Capture position and set to the TextViews
        imgImg.setImageResource(imagenes[position]);
        txtTitle.setText(titulos[position]);
        txtContenido.setText(contenido[position]);

        return itemView;
    }
}
}
