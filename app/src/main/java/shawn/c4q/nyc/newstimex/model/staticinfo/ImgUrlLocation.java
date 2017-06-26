package shawn.c4q.nyc.newstimex.model.staticinfo;

import java.util.HashMap;

/**
 * Created by shawnspeaks on 6/25/17.
 */

public class ImgUrlLocation {

    private static ImgUrlLocation instance;
    private HashMap<String, String> imgLocationMap = new HashMap<>();
    protected ImgUrlLocation(){
        // Forbid use of instantiation.
    }
    public static ImgUrlLocation getInstance(){
        if(instance == null){
            instance = new ImgUrlLocation();
        }
        return instance;
    }

    public HashMap<String, String> getImgLocationMap() {
        return imgLocationMap;
    }
}
