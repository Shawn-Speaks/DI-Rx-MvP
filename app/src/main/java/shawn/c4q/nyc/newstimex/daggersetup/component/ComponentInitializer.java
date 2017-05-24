package shawn.c4q.nyc.newstimex.daggersetup.component;

import android.app.Application;

import shawn.c4q.nyc.newstimex.daggersetup.modules.AppModule;
import shawn.c4q.nyc.newstimex.daggersetup.modules.NetworkModule;

/**
 * Created by shawnspeaks on 5/23/17.
 */

public class ComponentInitializer extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate(){
        super.onCreate();
        component = createComponent();
    }

    private ApplicationComponent createComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
