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

import com.sia.chapid.mailboxuptc.R;

public class Atencion extends ActionBarActivity {

    ListViewAdapterFour listAdapterFour;

    String[] menu = {
            "Forma Personal",
            "Linea Gratuita",
            "Correo Electrónico",
            "Fax",
            "Formulario",
            "Conmutador"
    };

    String []contenido=new String[]{
            "Edificio Administrativo 1 Piso Sogamoso - Boyacá",
            "018000 918782",
            "quejas.reclamos@uptc.edu.co",
            "Telefax: (7) 440585",
            "Sugerencia, queja,reclamo, consulta o denuncia",
            "(7)405626 Ext.:2580"
    };

    int[] iconos = {
            R.drawable.con1,
            R.drawable.con2,
            R.drawable.con3,
            R.drawable.con4,
            R.drawable.con5,
            R.drawable.con6
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atencion);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView lista = (ListView) findViewById(R.id.listViewAtencion);
        listAdapterFour = new ListViewAdapterFour(this,iconos,menu,contenido);
        lista.setAdapter(listAdapterFour);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int posicion, long l) {
                switch (posicion) {
                    case 0 :
                        Toast.makeText(getApplicationContext(),"En forma personal", Toast.LENGTH_SHORT).show();
                        break;
                    case 1 :
                        Toast.makeText(getApplicationContext(), "Linea Gratuita", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Intent opTres = new Intent(getApplicationContext(), Mensaje.class);
                        startActivity(opTres);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "Fax", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Intent opSeis = new Intent(getApplicationContext(), Sugerencias.class);
                        startActivity(opSeis);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(), "Conmutador", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "ninguna opcion", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    /*******************************************************/
    public class ListViewAdapterFour extends BaseAdapter {
        // Declare Variables
        Context context;
        int[] imagenes;
        String[] titulos;
        String[] contenido;
        LayoutInflater inflater;

        public ListViewAdapterFour(Context context, int[] imagenes, String[] titulos, String[] contenido ) {
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
