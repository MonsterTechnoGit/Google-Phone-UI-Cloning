package com.monstertechno.googlephoneuiclone;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private SaveTheamSatate theamSatate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        theamSatate = new SaveTheamSatate(this);
        if(theamSatate.looadNightModeState()){
            setTheme(R.style.NightMode);
        }else {
            setTheme(R.style.DayMode);
        }
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        Drawable drawable = null;
        if(theamSatate.looadNightModeState()){
            drawable = ContextCompat.getDrawable(this,R.drawable.ic_search_black_24dp);
        }else {
            drawable = ContextCompat.getDrawable(this,R.drawable.ic_search_white_24dp);
        }


        toolbar.setNavigationIcon(drawable);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        Drawable drawable = menu.findItem(R.id.search_voice_btn).getIcon();
        drawable = DrawableCompat.wrap(drawable);
        if(theamSatate.looadNightModeState()){
            DrawableCompat.setTint(drawable,ContextCompat.getColor(this,R.color.iconTintDark));
        }else {
            DrawableCompat.setTint(drawable,ContextCompat.getColor(this,R.color.iconTintLight));
        }
        menu.findItem(R.id.search_voice_btn).setIcon(drawable);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.settings:
                startActivity(new Intent(MainActivity.this,Settings.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
