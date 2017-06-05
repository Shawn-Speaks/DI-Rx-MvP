package shawn.c4q.nyc.newstimex.daggersetup.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import shawn.c4q.nyc.newstimex.data.NewsApi;

/**
 * Created by shawnspeaks on 6/5/17.
 */
@Module
public class HandlerModule {
    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public NewsApi provideNetworkService(Retrofit retrofit){
        return retrofit.create(NewsApi.class);
    }
}
