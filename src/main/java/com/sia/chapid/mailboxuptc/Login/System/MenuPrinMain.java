package com.sia.chapid.mailboxuptc.Login.System;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.sia.chapid.mailboxuptc.R;

import java.util.ArrayList;
import java.util.List;

public class MenuPrinMain extends ActionBarActivity {

    ListViewAdapter listAdapter;

    String[] menu = {
            "Noticias",
            "Eventos",
            "Atencion al Usuario",
            "Encuesta",
            "Sugerencias",
            "Mensajes"
    };

    int[] iconos = {
            R.drawable.icon1,
            R.drawable.icon2,
            R.drawable.icon3,
            R.drawable.icon5,
            R.drawable.icon6,
            R.drawable.icon7
    };

    int[] imagenes = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3
    };

    ManejadoraGaleria manejadorGaleria;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_prin_main);

        //lista
        final ListView lista = (ListView) findViewById(R.id.listView1);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, menu);
        lista.setAdapter(adapter);

        listAdapter = new ListViewAdapter(this, menu, iconos);
        lista.setAdapter(listAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int posicion, long l) {
                //Toast.makeText(getApplicationContext(), "presiono " + i, Toast.LENGTH_SHORT).show();
                switch (posicion) {
                    case 0 :
                        Intent opUno = new Intent(getApplicationContext(), Noticias.class);
                        startActivity(opUno);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 1 :
                        Intent opDos = new Intent(getApplicationContext(), Eventos.class);
                        startActivity(opDos);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 2:
                        Intent opCuatro = new Intent(getApplicationContext(), Atencion.class);
                        startActivity(opCuatro);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 3:
                        Intent opCinco = new Intent(getApplicationContext(), Encuesta.class);
                        startActivity(opCinco);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 4:
                        Intent opSeis = new Intent(getApplicationContext(), Sugerencias.class);
                        startActivity(opSeis);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    case 5:
                        Intent opSiete = new Intent(getApplicationContext(), Mensaje.class);
                        startActivity(opSiete);
                        overridePendingTransition(R.anim.left_in, R.anim.left_out);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "ninguna opcion", Toast.LENGTH_SHORT).show();
                }
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "presiono LARGO " + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //galeria de imagenes

        manejadorGaleria = new ManejadoraGaleria(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[0]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[1]));
        manejadorGaleria.agregarFragmentos(FragmentosImagenes.newInstance(imagenes[2]));

        mViewPager.setAdapter(manejadorGaleria);

    }



    public class ManejadoraGaleria extends FragmentPagerAdapter {

        List<Fragment> fragmentos;
        public ManejadoraGaleria(FragmentManager fm) {
            super(fm);
            fragmentos = new ArrayList();
        }

        public void agregarFragmentos(Fragment xfragmento){
            fragmentos.add(xfragmento);
        }


        @Override
        public Fragment getItem(int position) {
            return fragmentos.get(position);
        }

        @Override
        public int getCount() {
            return fragmentos.size();
        }
    }


    public static class FragmentosImagenes extends Fragment {

        private static final String ARG_IMAGE = "imagen";
        private int imagen;

        public static FragmentosImagenes newInstance(int imagen) {
            FragmentosImagenes fragment = new FragmentosImagenes();
            Bundle args = new Bundle();
            args.putInt(ARG_IMAGE, imagen);
            fragment.setArguments(args);
            fragment.setRetainInstance(true);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if(getArguments() != null) {
                imagen = getArguments().getInt(ARG_IMAGE);
            }
        }

        public FragmentosImagenes() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment, container, false);

            ImageView imagenView = (ImageView) rootView.findViewById(R.id.imageView1);
            imagenView.setImageResource(imagen);
            return rootView;
        }
    }
}
