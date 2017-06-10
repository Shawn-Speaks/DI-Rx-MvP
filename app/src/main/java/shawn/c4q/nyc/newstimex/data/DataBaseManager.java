package shawn.c4q.nyc.newstimex.data;

/**
 * Created by shawnspeaks on 6/7/17.
 */

public interface DataBaseManager<T> {
    boolean addToDB(T toAdd);
}
