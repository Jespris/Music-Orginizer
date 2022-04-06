package Album;

import java.util.Objects;

public class Song {

    // instance variables
    private final SoundClip soundClip;
    private final String artist;
    private final String songName;

    public Song(final SoundClip soundClip, final String songName, final String artist) {
        // public constructor for this class
        this.soundClip = soundClip;
        this.songName = songName;
        this.artist = artist;
        assert invariant();
    }

    public String getSongName(){
        // returns this object's song name
        return this.songName;
    }

    public String getArtist(){
        // returns this object's artist
        return this.artist;
    }

    public SoundClip getSoundClip(){
        // returns this object's SoundClip
        return this.soundClip;
    }

    private boolean invariant(){
        // checks that each instance variable is viable
        return (this.soundClip != null && this.songName != null && this.artist != null);
    }

    @Override
    public int hashCode(){
        // unique hashCode for this object
        int prime = 31;
        return this.songName.hashCode() * prime + this.artist.hashCode() * prime + this.soundClip.hashCode() * prime;
    }

    @Override
    public boolean equals(final Object other){
        // checks if objects are equal to each other, useful for sorting
        if (this.getClass() != other.getClass()){
            return false;
        }
        return this.hashCode() == other.hashCode();
    }
}
