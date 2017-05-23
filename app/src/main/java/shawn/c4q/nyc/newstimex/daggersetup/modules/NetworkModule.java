package shawn.c4q.nyc.newstimex.daggersetup.modules;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import shawn.c4q.nyc.newstimex.data.NewsApi;


@Module
public class NetworkModule {




    @Provides
    @Singleton
    public NewsApi provideNewsClient(Gson gson, OkHttpClient client){
        return new Retrofit.Builder()
                    .baseUrl(NewsApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build()
                    .create(NewsApi.class);
    }


}
