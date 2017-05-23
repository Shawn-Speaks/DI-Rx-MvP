package shawn.c4q.nyc.newstimex.ui.main;

import java.util.List;

import shawn.c4q.nyc.newstimex.model.Sources;
import shawn.c4q.nyc.newstimex.ui.base.BaseView;

/**
 * Created by shawnspeaks on 5/16/17.
 */

public interface MainView extends BaseView {

    void showLoading();
    void hideLoading();
    void revealNews(List<Sources> sources);
    void revealError(String errorMessage);
}
