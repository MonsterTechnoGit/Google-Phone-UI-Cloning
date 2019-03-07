package com.monstertechno.googlephoneuiclone;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveTheamSatate {

    SharedPreferences mySharedPref;

    public  SaveTheamSatate(Context context){
        mySharedPref = context.getSharedPreferences("filename",Context.MODE_PRIVATE);
    }

    public void setNightModeState(Boolean state){
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("Nightmode",state);
        editor.apply();
    }

    public Boolean looadNightModeState(){
        Boolean state = mySharedPref.getBoolean("Nightmode",false);
        return state;
    }
}
