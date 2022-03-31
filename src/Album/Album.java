package Album;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Album implements AlbumInterface{

    String albumName;
    List<SubAlbum> subAlbums;
    List<Song> songs;

    public Album(final String albumName){
        this.albumName = albumName;
        this.subAlbums = new ArrayList<SubAlbum>();
        this.songs = new ArrayList<Song>();
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
            for (SubAlbum album: this.subAlbums){
                album.removeSong(song);
            }
            assert invariant();
            return true;
        }
        return false;
    }

    public boolean addAlbum(SubAlbum album){
        if (!containsAlbum(album)){
            this.subAlbums.add(album);
            assert invariant();
            return true;
        }
        return false;
    }

    public boolean removeAlbum(final SubAlbum album){
        if (containsAlbum(album)){
            this.subAlbums.remove(album);
            assert invariant();
            return true;
        }
        return false;
    }

    public boolean containsAlbum(final SubAlbum album){
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

    public SubAlbum getSubAlbum(final int i){
        return this.subAlbums.get(i);
    }

    public List<SubAlbum> getSubAlbums(){
        return Collections.unmodifiableList(this.subAlbums);
    }

    public List<Song> getSongs(){
        return Collections.unmodifiableList(this.songs);
    }

    abstract boolean invariant();

    public abstract boolean isRootAlbum();

    public abstract Album getParentAlbum();

    @Override
    public boolean equals(final Object other){
        // TODO: equals method for album
        if (this.getClass() != other.getClass()){
            return false;
        }
        return this.hashCode() == other.hashCode();
    }

    @Override
    public int hashCode(){
        int prime = 31;
        return this.albumName.hashCode() * prime;
    }

    @Override
    public String toString(){
        return this.albumName;
    }
}
