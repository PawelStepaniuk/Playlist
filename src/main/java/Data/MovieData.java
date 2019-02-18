package Data;

import Creator.MovieCreator;
import Interface.IData;
import Interface.ITrack;

import java.util.ArrayList;
import java.util.List;

public class MovieData implements IData {
    public static List<ITrack> getList(){
        List<ITrack> movieList = new ArrayList<>();
        movieList.add(new MovieCreator("Film1",12.54));
        movieList.add(new MovieCreator("Film2",12.54));
        movieList.add(new MovieCreator("Film3",12.54));
        movieList.add(new MovieCreator("Film4",12.54));
        movieList.add(new MovieCreator("Film5",12.54));
        movieList.add(new MovieCreator("Film6",12.54));
        movieList.add(new MovieCreator("Film7",12.54));
        movieList.add(new MovieCreator("Film8",12.54));
        movieList.add(new MovieCreator("Film9",12.54));
        return movieList;
    }
}
