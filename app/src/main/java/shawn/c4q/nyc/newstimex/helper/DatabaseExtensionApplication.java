package shawn.c4q.nyc.newstimex.helper;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by shawnspeaks on 5/14/17.
 */

public class DatabaseExtensionApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);

        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );

        Stetho.Initializer initializer = initializerBuilder.build();

        Stetho.initialize(initializer);

    }


}
