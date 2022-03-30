package Album;

import java.util.ArrayList;

public class RootAlbum extends Album {

    private static RootAlbum instance = new RootAlbum("All Sound Clips");

    public RootAlbum(final String albumName){
        this.albumName = albumName;
        this.subAlbums = new ArrayList<SubAlbum>();
        this.songs = new ArrayList<Song>();
    }

    public static RootAlbum get(){
        return instance;
    }

    @Override
    void addSong(Song song) {

    }

    @Override
    void removeSong(Song song) {

    }

    @Override
    void addAlbum(SubAlbum subAlbum) {

    }

    @Override
    void removeAlbum(SubAlbum subAlbum) {

    }

    @Override
    boolean containsAlbum(SubAlbum subAlbum) {
        return false;
    }

    @Override
    boolean containsSong(Song song) {
        return false;
    }

    @Override
    boolean invariant() {
        return false;
    }
}
