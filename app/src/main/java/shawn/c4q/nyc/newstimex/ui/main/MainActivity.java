package shawn.c4q.nyc.newstimex.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Retrofit;
import shawn.c4q.nyc.newstimex.R;
import shawn.c4q.nyc.newstimex.daggersetup.component.ApplicationComponent;
import shawn.c4q.nyc.newstimex.daggersetup.component.BaseComponent;
import shawn.c4q.nyc.newstimex.model.Sources;
import shawn.c4q.nyc.newstimex.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.myTextView) TextView mTextView;
    @BindView(R.id.myButton) Button mButton;

    @Inject MainPresenter presenter;
    @Inject Retrofit retrofit;

    private ApplicationComponent component;


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
        presenter.initialize();
        presenter.bindView(this);
    }

    @Override
    protected void setupInjector() {
//        ((ComponentInitializer) getApplication()).getComponent().inject(this);
        component = ApplicationComponent.Initializer.init(this);
        component.inject(this);
    }

    @OnClick(R.id.myButton)void clicked(){
        int number = Integer.parseInt(mTextView.getText().toString());
        mTextView.setText(String.valueOf(number+1));
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void revealNews(List<Sources> sources) {

    }

    @Override
    public void revealError(String errorMessage) {

    }
}
