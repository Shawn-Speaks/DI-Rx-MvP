package shawn.c4q.nyc.newstimex.daggersetup.modules;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shawnspeaks on 6/11/17.
 */

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application){
                this.application = application;
    }

    @Provides
    public Application provideApplication(){
        return application;
    }

    @Provides
    public Context provideApplicationContext(){
        return application.getApplicationContext();
    }
}
