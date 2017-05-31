package shawn.c4q.nyc.newstimex.ui.main;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import shawn.c4q.nyc.newstimex.data.NewsApi;
import shawn.c4q.nyc.newstimex.data.NewsService;
import shawn.c4q.nyc.newstimex.model.Sources;
import shawn.c4q.nyc.newstimex.ui.base.BasePresenter;

/**
 * Created by shawnspeaks on 5/16/17.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private static final String TAG = "Error tag";
    private NewsApi newsClient;
    private NewsService service;
    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public MainPresenter(NewsApi client) {
        this.newsClient = client;
    }

    @Override
    public void initialize() {
        view.showLoading();
        loadNews();
//        data subscription here

    }

    @Override
    public void destroy() {
        unbindView();
        disposable.clear();
    }

//    private void loadNewsSources(){
//        view.showLoading();
//        disposable.add(service.getNewsSources(new NewsService.GetNewsSourceCallBack() {
//            @Override
//            public void onSuccess(SourcesResponse sourcesResponse) {
//                view.hideLoading();
//                view.getsNewsSourceSuccess(sourcesResponse);
//            }
//
//            @Override
//            public void onError(Throwable error) {
//                view.hideLoading();
//                view.revealError(error.toString());
//                for(int i = 0 ; i < 10; i++){
//                    Log.e(TAG, "ERRORRERRARERE");
//                }
//            }
//        }));
//    }

    private void loadNews(){
        Observable<List<Sources>> obs = newsClient.fetchNewsSources();
        disposable.add(obs.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onWinning, this::onErroring));








    }

    private void onWinning(List<Sources> sources) {
        view.hideLoading();
        view.getsNewsSourceSuccess(sources);
    }

    private void onErroring(Throwable throwable) {
        for(int i = 0 ; i < 10; i++){
                    Log.e(TAG, "~~~~~~~~~~ ERROR ~~~~~~~~~");
                }
    }

//    private void onWinning(SourcesResponse sourcesResponse) {
//        view.hideLoading();
//        view.getsNewsSourceSuccess(sourcesResponse);
//    }

}
