package shawn.c4q.nyc.newstimex.ui.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.HashMap;

import shawn.c4q.nyc.newstimex.R;
import shawn.c4q.nyc.newstimex.model.Sources;


public class NewsHolder extends RecyclerView.ViewHolder{
    private Context context;
    private ImageView imageView;
    private TextView textView;
    private SharedPreferences sp;
    private HashMap<String, String> map;

    public NewsHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        textView = (TextView) itemView.findViewById(R.id.news_source_name);
        imageView = (ImageView) itemView.findViewById(R.id.news_image);
        sp = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        map = (HashMap<String, String>) sp.getAll();
    }

    public void bind(final Sources source) {

        if(map.containsKey(source.getId())){
            Glide.with(context).load(map.get(source.getId())).into(imageView);
        }else
            Glide.with(context).load(R.drawable.gaming_img).into(imageView);

        textView.setText(source.getName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, source.getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
