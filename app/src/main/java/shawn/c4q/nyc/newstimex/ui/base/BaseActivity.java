package shawn.c4q.nyc.newstimex.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import shawn.c4q.nyc.newstimex.daggersetup.component.BaseComponent;

/**
 * Created by shawnspeaks on 5/16/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @LayoutRes protected int layoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setLayoutId();
        setContentView(layoutId);
        bindView();

        setupInjector();
        setupPresenter();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        killPresenter();
    }

    public abstract BaseComponent component();

    protected abstract void killPresenter();

    protected abstract void setupPresenter();

    protected abstract void setupInjector();

    private void bindView(){
        ButterKnife.bind(this);
    }

    protected abstract void setLayoutId();


}
