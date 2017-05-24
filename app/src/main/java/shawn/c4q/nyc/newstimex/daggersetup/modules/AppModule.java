package shawn.c4q.nyc.newstimex.daggersetup.modules;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    public Application provideApplication() {
        return mApplication;
    }

    @Provides
    public Context provideApplicationContext() { return mApplication.getApplicationContext(); }
}
