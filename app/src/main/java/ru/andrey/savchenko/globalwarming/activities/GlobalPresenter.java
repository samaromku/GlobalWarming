package ru.andrey.savchenko.globalwarming.activities;

public class GlobalPresenter {
    private static final String TAG = GlobalPresenter.class.getSimpleName();
    private GlobalView view;
    private GlobalInterActor interActor;

    public GlobalPresenter(GlobalView view, GlobalInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
    }

}
