package com.dio.soccernews;

import android.app.Application;

public class app extends Application {
    private static app instance;
    public static app getInstance() { return instance; }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
