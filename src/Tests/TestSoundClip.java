package Tests;

import Album.RootAlbum;
import Album.Song;
import Album.SoundClip;
import Album.SubAlbum;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class TestSoundClip {
    @Test
    public void testSong(){
        // tests the song class
        Song song = new Song(new SoundClip(new File("src/SongFiles/shrek.wav")), "TestSong", "TestArtist");
        RootAlbum root = RootAlbum.get();
        SubAlbum shrekAlbum = new SubAlbum("ShrekAlbum", null);
        assertTrue(shrekAlbum.add(song));  // add song to shrekAlbum, which should get passed up to root
        assertTrue(root.contains(song));
        assertEquals("TestSong", root.getSong(0).getSongName());
        assertEquals("TestArtist", root.getSong(0).getArtist());
        // test removing the song from root, song should get removed from all subAlbums
        assertTrue(root.remove(song));
        assertFalse(root.remove(song)); // cannot remove twice
        assertFalse(shrekAlbum.contains(song));

        System.out.println(song.getSoundClip().getFile().getPath());
    }
}
