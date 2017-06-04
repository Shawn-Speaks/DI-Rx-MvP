package shawn.c4q.nyc.newstimex.data;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import shawn.c4q.nyc.newstimex.model.SourcesResponse;

/**
 * Created by shawnspeaks on 5/28/17.
 */

public class NewsService {
    private final NewsApi newsApi;

    public NewsService(NewsApi newsApi) {
        this.newsApi = newsApi;
    }


    public Disposable getNewsSources(final GetNewsSourceCallBack callback){
        return newsApi.fetchNewsSources()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public interface GetNewsSourceCallBack{
        void onSuccess(SourcesResponse sourcesResponse);

        void onError(Throwable error);
    }

}
