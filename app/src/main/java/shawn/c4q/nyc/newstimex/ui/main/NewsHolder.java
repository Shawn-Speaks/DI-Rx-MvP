package shawn.c4q.nyc.newstimex.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import shawn.c4q.nyc.newstimex.R;
import shawn.c4q.nyc.newstimex.model.Sources;

/**
 * Created by shawnspeaks on 5/28/17.
 */

public class NewsHolder extends RecyclerView.ViewHolder{
    private Context context;
    private ImageView imageView;
    private TextView textView;


    public NewsHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        textView = (TextView) itemView.findViewById(R.id.news_source_name);
        imageView = (ImageView) itemView.findViewById(R.id.news_image);
    }

    public void bind(Sources source) {
        int insertFromDrawable = R.drawable.technology_img;
        switch(source.getCategory()){
            case "business":
                insertFromDrawable = R.drawable.business_img;
                break;
            case "entertainment":
                insertFromDrawable = R.drawable.entertainment_img;
                break;
            case "gaming":
                insertFromDrawable = R.drawable.gaming_img;
                break;
            case "general":
                insertFromDrawable = R.drawable.general_img;
                break;
            case "music":
                insertFromDrawable = R.drawable.music_img;
                break;
            case "politics":
                insertFromDrawable = R.drawable.politics_img;
                break;
            case "science-and-nature":
                insertFromDrawable = R.drawable.science_and_nature;
                break;
            case "sport":
                insertFromDrawable = R.drawable.sports_img;
                break;
            case "technology":
                insertFromDrawable = R.drawable.technology_img;
                break;
        }

        Glide.with(context).load(insertFromDrawable).into(imageView);
        textView.setText(source.getName());


    }
}
