package Album;

public class Song {
    private final SoundClip soundClip;
    private final String artist;
    private final String songName;

    public Song(SoundClip soundClip, String songName, String artist) {
        this.soundClip = soundClip;
        this.songName = songName;
        this.artist = artist;
    }

    @Override
    public boolean equals(final Object other){
        return false;
    }
}
