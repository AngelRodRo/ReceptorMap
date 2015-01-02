package com.example.usuario.receptormap;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.PushService;


public class MainActivity extends ActionBarActivity {

    //API KEY
    String APPLICATION_ID = "Lackvxrwz7K5sQtxagm8LSoTPsqtWDWMoOYoAYzA";
    String CLIENT_KEY = "38iRP2FhSPcwHNmoLVaVRD6XLEtBX18dYibtygzJ";
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Toast.makeText(getApplicationContext(),"" + extras.getString("longitude").toString(),Toast.LENGTH_SHORT).show();
        }

        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);
        ParsePush.subscribeInBackground("Taxis");
        PushService.setDefaultPushCallback(this, MainActivity.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        map = (MapFragment) getFragmentManager().findFragmentById(R.id.)

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
