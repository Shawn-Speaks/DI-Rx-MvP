package shawn.c4q.nyc.newstimex.ui.main;

import javax.inject.Inject;

import shawn.c4q.nyc.newstimex.data.NewsApi;
import shawn.c4q.nyc.newstimex.ui.base.BasePresenter;

/**
 * Created by shawnspeaks on 5/16/17.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private NewsApi newsClient;

    @Inject
    public MainPresenter(NewsApi newsClient) {
        this.newsClient = newsClient;
    }

    @Override
    public void initialize() {
        view.showLoading();
//        data subscription here

    }

    @Override
    public void destroy() {
        unbindView();
    }

}
