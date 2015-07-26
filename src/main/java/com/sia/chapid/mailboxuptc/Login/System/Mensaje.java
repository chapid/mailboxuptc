package com.sia.chapid.mailboxuptc.Login.System;

import android.content.Intent;
import android.provider.Contacts;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sia.chapid.mailboxuptc.R;

public class Mensaje extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        Button btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etEmail = (EditText) findViewById(R.id.etEmail);
                EditText etSubject = (EditText) findViewById(R.id.etSubject);
                EditText etBody = (EditText) findViewById(R.id.etBody);

                Intent itSend = new Intent(android.content.Intent.ACTION_SEND);

                itSend.setType("plain/text");

                itSend.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ etEmail.getText().toString()});
                itSend.putExtra(android.content.Intent.EXTRA_SUBJECT, etSubject.getText().toString());
                itSend.putExtra(android.content.Intent.EXTRA_TEXT, etBody.getText());
                startActivity(itSend);

            }
        });
    }
}
