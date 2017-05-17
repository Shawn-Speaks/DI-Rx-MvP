package shawn.c4q.nyc.newstimex.ui.base;

/**
 * Created by shawnspeaks on 5/16/17.
 */

public abstract class BasePresenter<V extends BaseView> {

    protected V view;

    public abstract void initialize();

    public abstract void destroy();

    public <T extends V> void bindBiew(T view){
        this.view = view;
    }

    public void unbindView(){
        this.view = null;
    }

}
