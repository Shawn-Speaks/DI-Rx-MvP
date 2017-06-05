package shawn.c4q.nyc.newstimex.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by shawnspeaks on 5/15/17.
 */

public class SourcesResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sources")
    @Expose
    private ArrayList<Sources> sourcesList;


    public ArrayList<Sources> getSourcesList() {
        return sourcesList;
    }

    public String getStatus() {
        return status;
    }
}
