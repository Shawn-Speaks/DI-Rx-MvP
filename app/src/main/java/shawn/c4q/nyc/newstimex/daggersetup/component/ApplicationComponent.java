package shawn.c4q.nyc.newstimex.daggersetup.component;

import javax.inject.Singleton;

import dagger.Component;
import shawn.c4q.nyc.newstimex.daggersetup.modules.AppModule;
import shawn.c4q.nyc.newstimex.daggersetup.modules.NetworkModule;
import shawn.c4q.nyc.newstimex.ui.main.MainActivity;

/**
 * Created by shawnspeaks on 5/23/17.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class
        })
public interface ApplicationComponent {

    void inject(MainActivity activity);

}
