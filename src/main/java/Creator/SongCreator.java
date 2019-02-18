package Creator;

import Model.Song;

public class SongCreator extends Song {
    public SongCreator(String name, double duration) {
        setTitle(name);
        setDuration(duration);
    }
}
