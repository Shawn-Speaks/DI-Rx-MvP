package shawn.c4q.nyc.newstimex.daggersetup.component;

import javax.inject.Singleton;

import dagger.Component;
import shawn.c4q.nyc.newstimex.daggersetup.modules.AppModule;
import shawn.c4q.nyc.newstimex.daggersetup.modules.NetworkModule;

/**
 * Created by shawnspeaks on 5/23/17.
 */
@Singleton
@Component(modules = {
                AppModule.class,
                NetworkModule.class
        })
public interface ApplicationComponent {

    /**
     * @param activity
     */
//    void inject(MainActivity activity);

//    final class Initializer{
//
//        private Initializer(){
//
//        }
//        public static ApplicationComponent init(Activity activity){
//            return DaggerAppComponent.builder()
//                    .appModule(new AppModule(this))
//                    .networkModule(new NetworkModule())
//                    .build();
//        }
//    }

}
