package shawn.c4q.nyc.newstimex.daggersetup.component;

import javax.inject.Singleton;

import dagger.Component;
import shawn.c4q.nyc.newstimex.daggersetup.modules.AppModule;
import shawn.c4q.nyc.newstimex.daggersetup.modules.HandlerModule;
import shawn.c4q.nyc.newstimex.daggersetup.modules.NetworkModule;
import shawn.c4q.nyc.newstimex.ui.main.MainActivity;

/**
 * Created by shawnspeaks on 5/28/17.
 */

@Singleton
@Component(modules = {
        NetworkModule.class,
        HandlerModule.class,
        AppModule.class
        })
public interface ActivityComponent extends BaseComponent {
    void inject(MainActivity activity);
}
