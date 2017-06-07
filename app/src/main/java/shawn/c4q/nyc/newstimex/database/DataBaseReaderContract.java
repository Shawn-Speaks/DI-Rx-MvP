package shawn.c4q.nyc.newstimex.database;

import android.provider.BaseColumns;

/**
 * Created by shawnspeaks on 6/6/17.
 */

public final class DataBaseReaderContract {
    private DataBaseReaderContract(){

    }

    public static class DataBaseEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_IMG_URL = "imgUrl";
        public static final String COLUMN_NAME_FAVORITED = "favorited";
        public static final String COLUMN_NAME_DISLIKED = "disliked";

    }
}

