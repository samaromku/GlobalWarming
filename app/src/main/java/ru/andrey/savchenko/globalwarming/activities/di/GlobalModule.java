package ru.andrey.savchenko.globalwarming.activities.di;

import dagger.Module;
import dagger.Provides;
import ru.andrey.savchenko.globalwarming.di.base.BaseModule;
import ru.andrey.savchenko.globalwarming.activities.GlobalView;
import ru.andrey.savchenko.globalwarming.activities.GlobalPresenter;
import ru.andrey.savchenko.globalwarming.activities.GlobalInterActor;

@Module
public class GlobalModule implements BaseModule {
    private GlobalView view;

    public GlobalModule(GlobalView view) {
        this.view = view;
    }

    @GlobalScope
    @Provides
    public GlobalPresenter presenter(GlobalInterActor interActor) {
        return new GlobalPresenter(view, interActor);
    }

    @GlobalScope
    @Provides
    GlobalInterActor interActor() {
        return new GlobalInterActor();
    }
}

