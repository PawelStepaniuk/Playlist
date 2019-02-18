package Data;

import Creator.SongCreator;
import Interface.IData;
import Interface.ITrack;

import java.util.ArrayList;
import java.util.List;

public class SongData implements IData {
public static List<ITrack> getList(){
    List<ITrack> songList = new ArrayList<>();
    songList.add(new SongCreator("Piosenka1",12.3));
    songList.add(new SongCreator("Piosenka2",12.3));
    songList.add(new SongCreator("Piosenka3",12.3));
    songList.add(new SongCreator("Piosenka4",12.3));
    songList.add(new SongCreator("Piosenka5",12.3));
    songList.add(new SongCreator("Piosenka6",12.3));
    songList.add(new SongCreator("Piosenka7",12.3));
    songList.add(new SongCreator("Piosenka8",12.3));
return songList;
}
}
