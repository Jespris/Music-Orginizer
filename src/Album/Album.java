package Album;

import java.util.ArrayList;
import java.util.List;

public abstract class Album implements AlbumInterface{

    String albumName;
    List<Album> subAlbums;
    List<Song> songs;

    public Album(final String albumName){
        this.albumName = albumName;
        this.subAlbums = new ArrayList<Album>();
        this.songs = new ArrayList<Song>();
        assert invariant();
    }

    // interface for making sure that the album class contains all the necessary methods
    public boolean addSong(final Song song){
        this.songs.add(song);
        assert invariant();
        return true;
    }
    public boolean removeSong(final Song song){
        if (containsSong(song)){
            this.songs.remove(song);
            assert invariant();
            return true;
        }
        return false;
    }

    public boolean addAlbum(final Album album){
        if (!containsAlbum(album)){
            this.subAlbums.add(album);
            assert invariant();
            return true;
        }
        return false;
    }

    public boolean removeAlbum(final Album album){
        if (containsAlbum(album)){
            this.subAlbums.remove(album);
            assert invariant();
            return true;
        }
        return false;
    }

    public boolean containsAlbum(final Album album){
        return this.subAlbums.contains(album);
    }

    public boolean containsSong(final Song song){
        return this.songs.contains(song);
    }

    public void setAlbumName(final String albumName){
        this.albumName = albumName;
        assert invariant();
    }

    public Song getSong(final int i){
        return this.songs.get(i);
    }

    public Album getAlbum(final int i){
        return this.subAlbums.get(i);
    }

    abstract boolean invariant();

    abstract boolean isRootAlbum();

    @Override
    public boolean equals(final Object other){
        // TODO: equals method for album
        return true;
    }

    @Override
    public String toString(){
        return this.albumName;
    }
}
