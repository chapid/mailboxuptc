package com.sia.chapid.mailboxuptc.Login.System;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sia.chapid.mailboxuptc.R;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.util.ArrayList;
import java.util.List;

public class Sugerencias extends ActionBarActivity {

    private EditText txtNombre;
    private EditText txtEmail;
    private EditText txtTelefono;
    private EditText txtSugerencia;
    private Resources resources;
    private Button butonSubmit;
    private static String url = "http://softwareuno.siasoftware.com/control.php?y=insertarsugerencia";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias);
    }

    public void OnClickS(View view) {
       // if (validateFields()) {
            Thread nt = new Thread() {
                @Override
                public void run() {

                    //if (validateFields()) {
                    txtNombre = (EditText) findViewById(R.id.txtNombre);
                    txtEmail = (EditText) findViewById(R.id.txtEmail);
                    txtTelefono = (EditText) findViewById(R.id.txtTelefono);
                    txtSugerencia = (EditText) findViewById(R.id.txtSugerencia);
                    try {
                        final String res;
                        res = enviarPost(txtNombre.getText().toString(), txtEmail
                                        .getText().toString(), txtTelefono.getText().toString(),
                                txtSugerencia.getText().toString());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(Sugerencias.this, res, Toast.LENGTH_LONG).show();
                            }
                        });
                    } catch (Exception e) {

                    }
                    //    }

                }
            };
            nt.start();
        }

    public String enviarPost(String nombre, String email, String telefono,String suger) {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpPost httpPost = new HttpPost(url);
        HttpResponse response = null;
        try {
            List<NameValuePair> params = new ArrayList<NameValuePair>(4);
            params.add(new BasicNameValuePair("txtNombre", nombre));
            params.add(new BasicNameValuePair("txtEmail", email));
            params.add(new BasicNameValuePair("txtTelefono", telefono));
            params.add(new BasicNameValuePair("txtSuger", suger));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            response = httpClient.execute(httpPost, localContext);
        } catch (Exception e) {

        }
        return response.toString();
    }
}
