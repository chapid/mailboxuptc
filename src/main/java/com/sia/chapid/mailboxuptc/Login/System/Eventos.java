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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sia.chapid.mailboxuptc.Login.System.Pk_Eventos.EventoCinco;
import com.sia.chapid.mailboxuptc.Login.System.Pk_Eventos.EventoCuatro;
import com.sia.chapid.mailboxuptc.Login.System.Pk_Eventos.EventoDos;
import com.sia.chapid.mailboxuptc.Login.System.Pk_Eventos.EventoTres;
import com.sia.chapid.mailboxuptc.Login.System.Pk_Eventos.EventoUno;
import com.sia.chapid.mailboxuptc.Login.System.Pk_Noticias.NoticiaUno;
import com.sia.chapid.mailboxuptc.R;

public class Eventos extends ActionBarActivity {

    ListViewAdapterThree listAdapterThree;

    String[] menu = {
            "III EIMEM",
            "X Encuentro",
            "X Coloquio",
            "XII Congreso",
            "Congreso Investigación"
    };

    String []contenido=new String[]{
            "III EIMEM. Encuentro Internacional de Matemáticas, Estadística y Educación Matemática ",
            "X Encuentro Facultad de Ciencias-UPTC II Encuentro Nacional",
            "X Coloquio de Historia Social y de las Ciencias - Carta de Jamaica. Replanteamiento",
            "XII Congreso de Informática Educativa",
            "Congreso de Investigación y ..."
    };

    int[] iconos = {
            R.drawable.eve1,
            R.drawable.eve2,
            R.drawable.eve3,
            R.drawable.eve4,
            R.drawable.eve5
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView lista = (ListView) findViewById(R.id.listViewEventos);
        listAdapterThree = new ListViewAdapterThree(this,iconos,menu,contenido);
        lista.setAdapter(listAdapterThree);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int posicion, long l) {
                switch (posicion) {
                    case 0 :
                        Intent opUno = new Intent(getApplicationContext(), EventoUno.class);
                        startActivity(opUno);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 1 :
                        Intent opDos = new Intent(getApplicationContext(), EventoDos.class);
                        startActivity(opDos);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 2:
                        Intent opTres = new Intent(getApplicationContext(), EventoTres.class);
                        startActivity(opTres);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 3:
                        Intent opCuatro = new Intent(getApplicationContext(), EventoCuatro.class);
                        startActivity(opCuatro);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 4:
                        Intent opCinco = new Intent(getApplicationContext(), EventoCinco.class);
                        startActivity(opCinco);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "ninguna opcion", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    /*******************************************************/
    public class ListViewAdapterThree extends BaseAdapter {
        // Declare Variables
        Context context;
        int[] imagenes;
        String[] titulos;
        String[] contenido;
        LayoutInflater inflater;

        public ListViewAdapterThree(Context context, int[] imagenes, String[] titulos, String[] contenido ) {
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
