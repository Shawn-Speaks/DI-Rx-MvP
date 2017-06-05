package shawn.c4q.nyc.newstimex.ui.main;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import shawn.c4q.nyc.newstimex.data.NewsApi;
import shawn.c4q.nyc.newstimex.model.SourcesResponse;
import shawn.c4q.nyc.newstimex.ui.base.BasePresenter;

/**
 * Created by shawnspeaks on 5/16/17.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private static final String TAG = "Error tag";
    private NewsApi newsClient;
    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public MainPresenter(NewsApi newsClient) {
        this.newsClient = newsClient;
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

    private void loadNews(){
        Observable<SourcesResponse> obs = newsClient.fetchNewsSources();
        disposable.add(obs.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onWinning, this::onErroring));
    }


    private void onErroring(Throwable throwable) {
        for(int i = 0 ; i < 10; i++){
                    Log.e(TAG, "~~~~~~~~~~ ERROR ~~~~~~~~~");
                }
        view.revealError("error");
    }

    private void onWinning(SourcesResponse sourcesResponse) {
        view.hideLoading();
        view.getsNewsSourceSuccess(sourcesResponse);
    }

}
