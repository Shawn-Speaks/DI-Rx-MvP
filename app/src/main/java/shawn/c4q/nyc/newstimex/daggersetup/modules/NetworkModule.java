package shawn.c4q.nyc.newstimex.daggersetup.modules;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Cache;

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
    public Gson provideGson(){
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application){
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHTttpClient(okhttp3.Cache cache) {
        return new OkHttpClient.Builder().cache(cache).build();
    }

    @Provides
    @Singleton
    public NewsApi provideNewsClient(Gson gson, OkHttpClient client){
        return new Retrofit.Builder()
                    .baseUrl(NewsApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build()
                    .create(NewsApi.class);
    }


}
