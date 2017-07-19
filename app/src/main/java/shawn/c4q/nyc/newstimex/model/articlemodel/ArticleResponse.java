package shawn.c4q.nyc.newstimex.model.articlemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by shawnspeaks on 6/26/17.
 */

public class ArticleResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("articles")
    @Expose
    private ArrayList<Articles> articlesList;

    public String getStatus() {
        return status;
    }

    public ArrayList<Articles> getArticlesList() {
        return articlesList;
    }
}
