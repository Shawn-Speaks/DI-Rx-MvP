package shawn.c4q.nyc.newstimex.ui.articleinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import shawn.c4q.nyc.newstimex.R;

public class ArticleActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        textView = (TextView) findViewById(R.id.articleTV);

    }
}
