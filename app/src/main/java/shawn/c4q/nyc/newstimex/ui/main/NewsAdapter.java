package shawn.c4q.nyc.newstimex.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import shawn.c4q.nyc.newstimex.R;
import shawn.c4q.nyc.newstimex.model.Sources;

/**
 * Created by shawnspeaks on 5/28/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {
    private List<Sources> newsSourceList;
    private Context context;

    public NewsAdapter(List<Sources> newsSourceList, Context context) {
        this.newsSourceList = newsSourceList;
        this.context = context;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_recycler_item, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        final Sources source = newsSourceList.get(position);
        holder.bind(source);
    }

    @Override
    public int getItemCount() {
        return newsSourceList.size();
    }
}
