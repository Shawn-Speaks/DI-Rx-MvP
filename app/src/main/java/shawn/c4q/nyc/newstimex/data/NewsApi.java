package shawn.c4q.nyc.newstimex.data;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import shawn.c4q.nyc.newstimex.model.SourcesResponse;

/**
 * Created by shawnspeaks on 5/11/17.
 */

public interface NewsApi {
    String BASE_URL = "https://newsapi.org/v1/";

//    @GET("sources")
//    Observable<SourcesResponse> fetchNewsSources();

    @GET("sources")
    Single<List<SourcesResponse>> fetchNewsSources();


    @GET("sources?")
    Single<List<SourcesResponse>> getNewsSourcesWithLanguage(@Query("language") String language);
}
