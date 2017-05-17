package shawn.c4q.nyc.newstimex.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import shawn.c4q.nyc.newstimex.R;
import shawn.c4q.nyc.newstimex.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.myTextView) TextView mTextView;
    @BindView(R.id.myButton) Button mButton;




    @Override
    protected void setLayoutId() {
        layoutId = R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void killPresenter() {

    }

    @Override
    protected void setupPresenter() {

    }

    @Override
    protected void setupInjector() {

    }

    @OnClick(R.id.myButton)void clicked(){
        int number = Integer.parseInt(mTextView.getText().toString());
        mTextView.setText(String.valueOf(number+1));
    }
}
