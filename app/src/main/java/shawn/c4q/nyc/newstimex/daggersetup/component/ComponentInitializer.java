package shawn.c4q.nyc.newstimex.daggersetup.component;

import android.app.Application;

import shawn.c4q.nyc.newstimex.daggersetup.modules.AppModule;

/**
 * Created by shawnspeaks on 5/23/17.
 */

public class ComponentInitializer extends Application {

    private ApplicationComponent component;

    public ApplicationComponent getComponent(){
        if(component == null){
            component = DaggerApplicationComponent.builder()
                            .appModule(new AppModule(this))
                            .build();
        }
        return component;
    }
//
//    private ApplicationComponent createComponent() {
//        return DaggerApplicationComponent.builder()
//                .appModule(new AppModule(this))
//                .networkModule(new NetworkModule())
//                .build();
//    }

}
