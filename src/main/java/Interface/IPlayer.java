package Interface;

import Model.Playlist;

import java.util.List;

public interface IPlayer {

    enum playMethod {
        random,
        sequential,
        loop
    }
    void printMenu();
    void menu();
    void setPlaylists(List<Playlist> playlists);
    void addPlaylist(Playlist playlist);
    void createTrackList();
    void printTrackList();
    List<ITrack> shuffle(Playlist playlist);

}
