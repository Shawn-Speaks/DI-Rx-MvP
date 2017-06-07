package shawn.c4q.nyc.newstimex.daggersetup.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import shawn.c4q.nyc.newstimex.data.NewsApi;
import shawn.c4q.nyc.newstimex.database.NewsLocalDatabase;

/**
 * Created by shawnspeaks on 6/5/17.
 */
@Module
public class HandlerModule {
    @Provides
    @Singleton
    public NewsApi provideNetworkService(Retrofit retrofit){
        return retrofit.create(NewsApi.class);
    }

    @Provides
    @Singleton
    public NewsLocalDatabase providesNewsLocalDatabase(Context context){
        return new NewsLocalDatabase(context);
    }
}
