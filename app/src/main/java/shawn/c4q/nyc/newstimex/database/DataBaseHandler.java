package shawn.c4q.nyc.newstimex.database;

import shawn.c4q.nyc.newstimex.data.DataBaseManager;
import shawn.c4q.nyc.newstimex.model.Sources;

/**
 * Created by shawnspeaks on 6/7/17.
 */

public class DataBaseHandler implements DataBaseManager<Sources> {
    private NewsLocalDatabase localDatabase;

    public DataBaseHandler(NewsLocalDatabase localDatabase) {
        this.localDatabase = localDatabase;
    }

    @Override
    public boolean addToDB(Sources toAdd) {
        return localDatabase.addToDB(toAdd);
    }
}
