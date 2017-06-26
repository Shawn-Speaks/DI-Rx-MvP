package shawn.c4q.nyc.newstimex.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import shawn.c4q.nyc.newstimex.model.Sources;

/**
 * Created by shawnspeaks on 6/6/17.
 */

public class NewsLocalDatabase extends SQLiteOpenHelper {


    //ACCESS DATABASE WITH NewsLocalDatabase databaseHelper = new NewsLocalDatabase(getContext());

    public static final String DATABASE_NAME = "newsCache_db";
    public static final int DATABASE_VERSION = 1;

    public NewsLocalDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "
            + DataBaseReaderContract.DataBaseEntry.TABLE_NAME + " ("
            + DataBaseReaderContract.DataBaseEntry._ID + " INTEGER PRIMARY KEY,"
            + DataBaseReaderContract.DataBaseEntry.COLUMN_NAME_NEWS_OUTLET_NAME + " TEXT,"
            + DataBaseReaderContract.DataBaseEntry.COLUMN_NAME_IMG_URL +  " TEXT,"
            + DataBaseReaderContract.DataBaseEntry.COLUMN_NAME_FAVORITED + " TEXT)";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXIST " + DataBaseReaderContract.DataBaseEntry.TABLE_NAME;



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for(int i = 0; i < 10; i++){
            Log.d("DATABASE LOG", "DATABASE CREATED SONNNN");
        }
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    boolean addToDB(Sources source){
        SQLiteDatabase db = getWritableDatabase();
        long added = db.insert(DataBaseReaderContract.DataBaseEntry.TABLE_NAME, null, flatten(source, 1));
        db.close();
        return added > -1;
    }

    private ContentValues flatten(Sources source, int position){
        ContentValues value = new ContentValues();

        value.put(DataBaseReaderContract.DataBaseEntry._ID, position);
        value.put(DataBaseReaderContract.DataBaseEntry.COLUMN_NAME_NEWS_OUTLET_NAME, source.getName());
        value.put(DataBaseReaderContract.DataBaseEntry.COLUMN_NAME_IMG_URL, "null");
        value.put(DataBaseReaderContract.DataBaseEntry.COLUMN_NAME_FAVORITED, "false");

        return value;
    }

}
