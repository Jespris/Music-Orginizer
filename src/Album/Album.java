package Album;

import java.util.ArrayList;
import java.util.List;

public abstract class Album {

    String albumName;
    List<SubAlbum> subAlbums;
    List<Song> songs;

    // interface for making sure that the album class contains all the necessary methods
    abstract void addSong(final Song song);
    abstract void removeSong(final Song song);
    abstract void addAlbum(SubAlbum subAlbum);
    abstract void removeAlbum(SubAlbum subAlbum);
    abstract boolean containsAlbum(SubAlbum subAlbum);
    abstract boolean containsSong(Song song);
    abstract boolean invariant();
}
