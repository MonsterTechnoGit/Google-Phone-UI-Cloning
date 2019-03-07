package com.monstertechno.googlephoneuiclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;

public class Settings extends AppCompatActivity {

    private SwitchCompat changeSettings;
    private SaveTheamSatate saveTheamSatate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        saveTheamSatate = new SaveTheamSatate(this);
        if(saveTheamSatate.looadNightModeState()){
            setTheme(R.style.NightMode);
        }else {
            setTheme(R.style.DayMode);
        }
        setContentView(R.layout.activity_settings);

        changeSettings = findViewById(R.id.switchButton);

        if(saveTheamSatate.looadNightModeState()){
            changeSettings.setChecked(true);
        }

        changeSettings.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    saveTheamSatate.setNightModeState(true);
                    restartApp();
                }else {
                    saveTheamSatate.setNightModeState(false);
                    restartApp();
                }
            }
        });
    }

    private void restartApp() {
        Intent i = new Intent(Settings.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
