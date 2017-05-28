package shawn.c4q.nyc.newstimex.data;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
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
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends SourcesResponse>>() {
                    @Override
                    public ObservableSource<? extends SourcesResponse> apply(Throwable throwable) throws Exception {
                        return Observable.error(throwable);
                    }
                })
                .subscribe();
    }

    public interface GetNewsSourceCallBack{
        void onSuccess(SourcesResponse sourcesResponse);

        void onError(Throwable error);
    }

}
