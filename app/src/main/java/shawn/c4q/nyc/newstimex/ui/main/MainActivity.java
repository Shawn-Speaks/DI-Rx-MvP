package shawn.c4q.nyc.newstimex.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import shawn.c4q.nyc.newstimex.R;
import shawn.c4q.nyc.newstimex.daggersetup.component.ActivityComponent;
import shawn.c4q.nyc.newstimex.daggersetup.component.BaseComponent;
import shawn.c4q.nyc.newstimex.daggersetup.component.DaggerActivityComponent;
import shawn.c4q.nyc.newstimex.daggersetup.modules.NetworkModule;
import shawn.c4q.nyc.newstimex.model.SourcesResponse;
import shawn.c4q.nyc.newstimex.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.myTextView) TextView mTextView;
    @BindView(R.id.myButton) Button mButton;
    @BindView(R.id.progress_bar) ProgressBar progressBar;

    @Inject MainPresenter presenter;

    private ActivityComponent component;


    @Override
    protected void setLayoutId() {
        layoutId = R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        presenter.initialize();
    }

    @Override
    public BaseComponent component() {
        return component;
    }

    @Override
    protected void killPresenter() {
        presenter.unbindView();
        presenter.destroy();
    }

    @Override
    protected void setupPresenter() {
        presenter.bindView(this);
        presenter.initialize();
    }

    @Override
    protected void setupInjector() {
        File cacheFile = new File(getCacheDir(), "responses");
        component = DaggerActivityComponent.builder()
                .networkModule(new NetworkModule(cacheFile))
                .build();

        component.inject(this);

    }

    @OnClick(R.id.myButton)void clicked(){
        int number = Integer.parseInt(mTextView.getText().toString());
        if(number == 5){hideLoading();}
        if(number > 6){showLoading();}
        mTextView.setText(String.valueOf(number+1));
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, " I'm a toast! ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void revealNews(SourcesResponse sourcesResponse) {
        hideLoading();
    }

    @Override
    public void revealError(String errorMessage) {

    }
}
