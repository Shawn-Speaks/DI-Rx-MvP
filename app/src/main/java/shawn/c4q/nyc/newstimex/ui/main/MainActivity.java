package shawn.c4q.nyc.newstimex.ui.main;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import shawn.c4q.nyc.newstimex.R;
import shawn.c4q.nyc.newstimex.daggersetup.component.ActivityComponent;
import shawn.c4q.nyc.newstimex.daggersetup.component.BaseComponent;
import shawn.c4q.nyc.newstimex.daggersetup.component.DaggerActivityComponent;
import shawn.c4q.nyc.newstimex.daggersetup.modules.NetworkModule;
import shawn.c4q.nyc.newstimex.model.Sources;
import shawn.c4q.nyc.newstimex.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainView {

    private static final int NUMBER_OF_RECYCLER_COLUMNS = 3;
    @BindView(R.id.progress_bar) ProgressBar progressBar;
    @BindView(R.id.newsList) RecyclerView recyclerView;
    @BindView(R.id.network_error_textView) TextView errorTextView;

    @Inject MainPresenter presenter;

    private ActivityComponent component;


    @Override
    protected void setLayoutId() {
        layoutId = R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRV();
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

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }


    @Override
    public void revealError(String errorMessage) {
        errorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void getsNewsSourceSuccess(List<Sources> sources) {
        NewsAdapter adapter = new NewsAdapter(sources, getApplicationContext());
        Toast.makeText(this, String.valueOf(adapter.getItemCount()) , Toast.LENGTH_SHORT).show();
        recyclerView.setAdapter(adapter);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void initRV(){
        recyclerView.setLayoutManager(new GridLayoutManager(this, NUMBER_OF_RECYCLER_COLUMNS));
    }
}
