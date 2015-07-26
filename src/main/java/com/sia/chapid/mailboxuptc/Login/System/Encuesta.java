package com.sia.chapid.mailboxuptc.Login.System;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.sia.chapid.mailboxuptc.Login.Register;
import com.sia.chapid.mailboxuptc.R;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHAPID on 09/07/2015.
 */
public class Encuesta extends ActionBarActivity{

    private EditText campUno;
    private EditText campDos;
    private EditText campTres;
    private EditText campCuatro;
    private EditText campCinco;
    private Button butonSubmit;
    private ProgressDialog pDialog;
    private static String url = "http://softwareuno.siasoftware.com/control.php?y=insertarencuesta";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.encuesta);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    public void OnClik(View view) {
        Thread nt = new Thread() {
            @Override
            public void run() {
                campUno = (EditText) findViewById(R.id.campo1);
                campDos = (EditText) findViewById(R.id.campo2);
                campTres = (EditText) findViewById(R.id.campo3);
                campCuatro = (EditText) findViewById(R.id.campo4);
                campCinco = (EditText) findViewById(R.id.campo5);

                try {
                    final String res;
                        res = enviarPost(campUno.getText().toString(), campDos
                                .getText().toString(), campTres.getText().toString(),
                                campCuatro.getText().toString(), campCinco.getText().toString());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Encuesta.this, res,Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {

                }
            }
        };
        nt.start();
    }

    public String enviarPost(String campUno, String campDos, String campTres,String campCuatro,String campCinco) {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpPost httpPost = new HttpPost(url);
        HttpResponse response = null;
        try {
            List<NameValuePair> params = new ArrayList<NameValuePair>(5);
            params.add(new BasicNameValuePair("campUno", campUno));
            params.add(new BasicNameValuePair("campDos", campDos));
            params.add(new BasicNameValuePair("campTres", campTres));
            params.add(new BasicNameValuePair("campCuatro", campCuatro));
            params.add(new BasicNameValuePair("campCinco", campCinco));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            response = httpClient.execute(httpPost, localContext);
        } catch (Exception e) {

        }
        return response.toString();
    }
}
