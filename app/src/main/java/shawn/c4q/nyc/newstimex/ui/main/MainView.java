package shawn.c4q.nyc.newstimex.ui.main;

import shawn.c4q.nyc.newstimex.model.SourcesResponse;
import shawn.c4q.nyc.newstimex.ui.base.BaseView;

/**
 * Created by shawnspeaks on 5/16/17.
 */

public interface MainView extends BaseView {

    void showLoading();
    void hideLoading();
    void revealError(String errorMessage);
    void getsNewsSourceSuccess(SourcesResponse sourcesResponse);
}
