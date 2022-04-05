package Album;

import java.util.*;

public abstract class Album implements AlbumInterface{

    // instance variables for this class
    String albumName;
    List<SubAlbum> subAlbums;
    List<Song> songs;

    public Album(final String albumName){
        // constructor
        this.albumName = albumName;
        this.subAlbums = new ArrayList<SubAlbum>() {};
        this.songs = new ArrayList<Song>();
    }

    //  methods that all albums should have below:

    public boolean addSong(final Song song){
        // adds a song to this album
        this.songs.add(song);
        assert invariant();
        // returns true for testing purposes
        return true;
    }

    public boolean removeSong(final Song song){
        // removes a song from this album and all sub-albums, returns boolean for testing purposes
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
        // adds an album to the list of sub-albums, returns boolean for testing purposes
        if (!containsAlbum(album)){
            this.subAlbums.add(album);
            assert invariant();
            return true;
        }
        return false;
    }

    public boolean removeAlbum(final SubAlbum album){
        // removes an album for list of sub-albums, returns boolean for testing purposes
        if (containsAlbum(album)){
            this.subAlbums.remove(album);
            assert invariant();
            return true;
        }
        return false;
    }

    public boolean containsAlbum(final SubAlbum album){
        // checks if this objects contains an album
        return this.subAlbums.contains(album);
    }

    public boolean containsSong(final Song song){
        // checks if this objects contains a song
        return this.songs.contains(song);
    }

    public void setAlbumName(final String albumName){
        // sets a new album name
        if (albumName != null) {
            this.albumName = albumName;
        }
        assert invariant();
    }

    public Song getSong(final int i){
        // returns song at index i
        return this.songs.get(i);
    }

    public SubAlbum getSubAlbum(final int i){
        // returns album at index i
        return this.subAlbums.get(i);
    }

    public List<SubAlbum> getSubAlbums(){
        // returns an unmodifiable list of this object's sub-albums
        return Collections.unmodifiableList(this.subAlbums);
    }

    public List<Song> getSongs(){
        // returns an unmodifiable list of this object's songs
        return Collections.unmodifiableList(this.songs);
    }

    abstract boolean invariant(); // to make sure each subclass has an invariant method

    public abstract boolean isRootAlbum();  // method for checking if subclass is a root album

    public abstract Album getParentAlbum(); // method for getting albums parent album

    @Override
    public boolean equals(final Object other){
        // overriding object's equals method, which can be useful in some cases like sorting
        if (this.getClass() != other.getClass()){
            return false;
        }
        return this.hashCode() == other.hashCode();
    }

    @Override
    public int hashCode(){
        // returns unique hashCode based on instance variables
        // TODO: maybe update hashCode for Album
        int prime = 31;
        return this.albumName.hashCode() * prime;
    }

    @Override
    public String toString(){
        // overrides the toString method which can be useful for debugging purposes,
        // and also displaying the album name without needing to call "getAlbumName" method.
        return this.albumName;
    }
}
