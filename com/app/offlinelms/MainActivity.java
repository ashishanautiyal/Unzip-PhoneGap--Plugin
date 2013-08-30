package com.app.offlinelms;

import org.apache.cordova.DroidGap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

@SuppressWarnings("unused")
public class MainActivity extends DroidGap {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       super.loadUrl("file:///android_asset/www/index.html");
        //super.loadUrl("file:///android_asset/www/track/track.html");
    }

   
}