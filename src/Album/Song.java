package Album;

import java.util.Objects;

public class Song {

    private final SoundClip soundClip;
    private final String artist;
    private final String songName;

    public Song(final SoundClip soundClip, final String songName, final String artist) {
        this.soundClip = soundClip;
        this.songName = songName;
        this.artist = artist;
    }

    public String getSongName(){
        return this.songName;
    }

    public String getArtist(){
        return this.artist;
    }

    public SoundClip getSoundClip(){
        return this.soundClip;
    }

    private boolean invariant(){
        return (this.soundClip != null && this.songName != null && this.artist != null);
    }

    @Override
    public int hashCode(){
        int prime = 31;
        return this.songName.length() * prime * this.artist.length() * prime * this.soundClip.hashCode() * prime;
    }

    @Override
    public boolean equals(final Object other){
        if (this.getClass() != other.getClass()){
            return false;
        }
        return this.hashCode() == other.hashCode();
    }
}
