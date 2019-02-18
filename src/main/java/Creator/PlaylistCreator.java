package Creator;

import Interface.ITrack;
import Model.Playlist;

import java.util.LinkedList;

public class PlaylistCreator extends Playlist {

    public PlaylistCreator(String name, playMethod method) {
        setName(name);
        setMethod(method);
        setTrackList(new LinkedList<>());
    }

    public PlaylistCreator() {

    }


}
