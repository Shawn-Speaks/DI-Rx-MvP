package shawn.c4q.nyc.newstimex.helper;

import android.app.Application;

import com.facebook.stetho.Stetho;

import java.io.File;

import shawn.c4q.nyc.newstimex.daggersetup.component.ActivityComponent;
import shawn.c4q.nyc.newstimex.daggersetup.component.DaggerActivityComponent;
import shawn.c4q.nyc.newstimex.daggersetup.modules.AppModule;
import shawn.c4q.nyc.newstimex.daggersetup.modules.HandlerModule;
import shawn.c4q.nyc.newstimex.daggersetup.modules.NetworkModule;

/**
 * Created by shawnspeaks on 5/14/17.
 */

public class DatabaseExtensionApplication extends Application {

    private ActivityComponent component;

    @Override
    public void onCreate(){
        super.onCreate();
        File cacheFile = new File(getCacheDir(), "responses");
        component = DaggerActivityComponent.builder()
                .networkModule(new NetworkModule(cacheFile))
                .handlerModule(new HandlerModule())
                .appModule(new AppModule(this))
                .build();


        Stetho.initializeWithDefaults(this);
    }

    public ActivityComponent getComponent() {
        return component;
    }
}
