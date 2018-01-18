package ru.andrey.savchenko.globalwarming.activities.di;

import dagger.Subcomponent;
import ru.andrey.savchenko.globalwarming.di.base.ComponentBuilder;
import ru.andrey.savchenko.globalwarming.di.base.BaseComponent;
import ru.andrey.savchenko.globalwarming.activities.GlobalActivity;

@Subcomponent(modules = GlobalModule.class)
@GlobalScope
public interface GlobalComponent extends BaseComponent<GlobalActivity> {
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<GlobalComponent, GlobalModule> {
    }
}
