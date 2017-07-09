package com.valmaraz.chat.view;

import android.app.Application;

import com.valmaraz.chat.Environment;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Environment.configure();
    }
}
