package com.sia.chapid.mailboxuptc;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sia.chapid.mailboxuptc.Login.Login;


public class MainHome extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
    }

    public void onClick(View v){
        Toast.makeText(this, "Login MailBoxUptc", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}
