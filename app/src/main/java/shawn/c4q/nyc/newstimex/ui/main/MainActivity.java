package shawn.c4q.nyc.newstimex.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import shawn.c4q.nyc.newstimex.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.myTextView) TextView mTextView;
    @BindView(R.id.myButton) Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.myButton)void clicked(){
        int number = Integer.parseInt(mTextView.getText().toString());
        mTextView.setText(String.valueOf(number+1));
    }
}
