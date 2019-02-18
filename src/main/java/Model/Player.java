package Model;

import Interface.IPlayer;
import Interface.IPlaylist;
import Interface.ITrack;

import java.util.*;

public abstract class Player implements IPlayer {
    private String name;
    private List<Playlist> playlists;
    private List<ITrack> trackList = new LinkedList<>();
    private playMethod method;

    public playMethod getMethod() {
        return method;
    }

    public void setMethod(playMethod method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void addPlaylist(Playlist playlist) {
        try {
            playlists.add(playlist);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage() + " AddPlayList");
        }
    }

    public void printPlaylists() {
        if (!playlists.isEmpty()) {
            for (Playlist playlist : playlists) {
                System.out.println("Nazwa: " + playlist.getName() + " Tryb odtwarzania " + playlist.getMethod().toString());
                for (int j = 0; j < playlist.getTrackList().size(); j++) {
                    System.out.println("Tytuł: " + playlist.getTrackList().get(j).getTitle() + " Długość: " + playlist.getTrackList().get(j).getDuration());
                }
            }
        }
    }

    public void createTrackList() {
        for (Playlist playlist : playlists) {
            if (playlist.getMethod().equals(IPlaylist.playMethod.random)) {
                trackList.addAll(Objects.requireNonNull(shuffle(playlist)));
            }
            if (playlist.getMethod().equals(IPlaylist.playMethod.sequential)) {
                trackList.addAll(playlist.getTrackList());
            }
        }
    }

    public void printTrackList() {
        System.out.println("Tracklista");
        for (int i = 0; i < trackList.size(); i++) {
            System.out.println("Tytuł: " + trackList.get(i).getTitle() + " Długość: " + trackList.get(i).getDuration());
        }
    }

    public List<ITrack> shuffle(Playlist playlist) {
        if (!playlist.getTrackList().isEmpty()) {
            List<ITrack> shuffledList = playlist.getTrackList();
            Collections.shuffle(shuffledList);
            return shuffledList;
        }
        return null;
    }

    public void menu() {
        ListIterator<ITrack> listIterator = trackList.listIterator();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Bye!");
                    quit = true;
                    break;
                case 1:
                    listIterator = nextSong(listIterator);
                    break;
                case 2:
                    listIterator = previousSong(listIterator);
                    break;
                case 3:
                    forward = replay(listIterator, forward);
                    break;
                case 4:
                    printTrackList();
                    break;
                case 5:
                    printMenu();
                    break;
            }
        }
    }

    public void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n");
    }

    private ListIterator<ITrack> nextSong(ListIterator<ITrack> listIterator) {
        if (listIterator.hasNext() && (getMethod().equals(playMethod.sequential) || getMethod().equals(playMethod.loop))) {
            ITrack track = (trackList.get(listIterator.nextIndex()));
            System.out.println("Now playing " + track.toString());
            listIterator.next();

        } else if (!listIterator.hasNext() && getMethod().equals(playMethod.loop)) {
            System.out.println("loop");
            listIterator = trackList.listIterator();

        } else if (getMethod().equals(playMethod.random)) {
            Random random = new Random();
            ITrack track = trackList.get(random.nextInt(trackList.size()));
            System.out.println("Now playing " + track.toString());
        } else {
            System.out.println("We have reached the end of the playlist");
        }
        return listIterator;
    }

    private ListIterator<ITrack> previousSong(ListIterator<ITrack> listIterator) {
        if (listIterator.hasPrevious()) {
            System.out.println("Now playing " + listIterator.previous().toString());
        } else {
            System.out.println("We are at the start of the playlist");
        }
        return listIterator;
    }

    private boolean replay(ListIterator<ITrack> listIterator, boolean forward) {

        if (listIterator.hasPrevious() && (!forward)) {
            System.out.println("Now replaying " + listIterator.previous().toString());
            return true;
        } else if (listIterator.hasNext() && (forward)) {
            System.out.println("Now replaying " + listIterator.next().toString());
            return false;
        }
        return forward;
    }
}


