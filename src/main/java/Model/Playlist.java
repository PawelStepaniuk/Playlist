package Model;

import Interface.IPlaylist;
import Interface.ITrack;

import java.util.List;

public abstract class Playlist implements IPlaylist {
    private String name;
    private List<ITrack> trackList;
    private playMethod method;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ITrack> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<ITrack> trackList) {
        this.trackList = trackList;
    }

    public playMethod getMethod() {
        return method;
    }

    public void setMethod(playMethod method) {
        this.method = method;
    }

    public void addTrack(ITrack track) {
        if (!trackList.contains(track)) {
            trackList.add(track);
        }
    }

    public void addTrackList(List<ITrack> tracks) {
        try {
            trackList.addAll(tracks);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printTracks() {
        for (int i = 0; i < trackList.size(); i++) {
            System.out.println("Title " + trackList.get(i).getTitle() + " Duration " + trackList.get(i).getDuration());
        }
    }
}
