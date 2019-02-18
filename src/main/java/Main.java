import Creator.PlayerCreator;
import Creator.PlaylistCreator;
import Data.MovieData;
import Data.SongData;
import Interface.IPlayer;
import Interface.IPlaylist;
import Model.Player;
import Model.Playlist;

public class Main {
    public static void main(String[] args) {

        Player player = new PlayerCreator("Odtwarzacz");
        Playlist playlistMovies = new PlaylistCreator("Playlista Filmów", IPlaylist.playMethod.sequential);
        Playlist playlistSongs = new PlaylistCreator("Playlista Piosenek", IPlaylist.playMethod.sequential) ;
        playlistMovies.addTrackList(MovieData.getList());
        playlistSongs.addTrackList(SongData.getList());
        player.addPlaylist(playlistMovies);
        player.addPlaylist(playlistSongs);
        player.createTrackList();
        player.setMethod(IPlayer.playMethod.loop);
        player.menu();
    }
}
