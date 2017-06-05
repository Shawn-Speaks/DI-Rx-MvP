package shawn.c4q.nyc.newstimex.daggersetup.modules;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import shawn.c4q.nyc.newstimex.data.NewsApi;


@Module
public class NetworkModule {

    File cacheFile;

    public NetworkModule(File cacheFile) {
        this.cacheFile = cacheFile;
    }

    @Provides
    @Singleton
    Retrofit provideCall(){
        Cache cache = null;
        try{
            cache = new Cache(cacheFile, 10 * 1024 * 1024);
        }catch (Exception error){
            error.printStackTrace();
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request newRequest = originalRequest.newBuilder()
                                                    .addHeader("myKey", "myValue")
                                                    .build();

                Response response = chain.proceed(newRequest);
                response.cacheResponse();

                return response;
            }
        })
                .cache(cache)
                .build();

        return new Retrofit.Builder()
                            .baseUrl(NewsApi.BASE_URL)
                            .client(okHttpClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
    }

}
