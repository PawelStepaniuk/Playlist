package Interface;

import java.util.List;

public interface IPlaylist {
     enum playMethod {
        random,
        sequential,
    }
    List<ITrack> getTrackList();
    playMethod getMethod();
    String getName();
}
