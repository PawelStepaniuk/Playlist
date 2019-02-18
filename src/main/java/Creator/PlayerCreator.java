package Creator;

import Model.Player;
import Model.Playlist;

import java.util.LinkedList;

public class PlayerCreator extends Player {
    public PlayerCreator() {
    }
    public PlayerCreator(String name){
        setName(name);
        setPlaylists(new LinkedList<>());
        setMethod(playMethod.sequential);
    }

}
