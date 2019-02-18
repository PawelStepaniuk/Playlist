package Creator;

import Model.Movie;

public class MovieCreator extends Movie {
    public MovieCreator(String name, double duration) {
        setTitle(name);
        setDuration(duration);
    }
}
