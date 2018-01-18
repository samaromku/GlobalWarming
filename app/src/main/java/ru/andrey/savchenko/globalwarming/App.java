package ru.andrey.savchenko.globalwarming;

import android.app.Application;

import ru.andrey.savchenko.globalwarming.di.ComponentManager;


/**
 * Created by Andrey on 25.09.2017.
 */

public class App extends Application {
    private static ComponentManager componentManager;

    public static ComponentManager getComponentManager() {
        return componentManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        componentManager = new ComponentManager();
        componentManager.init();
    }
}
