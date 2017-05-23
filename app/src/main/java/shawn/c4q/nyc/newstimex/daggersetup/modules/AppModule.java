package shawn.c4q.nyc.newstimex.daggersetup.modules;

import android.app.Application;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }
}
