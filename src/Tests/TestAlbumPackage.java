package Tests;

import Album.RootAlbum;
import Album.Song;
import Album.SoundClip;
import Album.SubAlbum;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TestAlbumPackage {

    // Tests all the classes under the package "Album"

    @Test
    public void testAlbum(){

        // check root album
        RootAlbum root = RootAlbum.get();
        assertEquals("All Sound Clips", root.toString());

        // add new subAlbums to root
        // checking addAlbum method
        SubAlbum rockAlbum = new SubAlbum("Rock", root);
        assertTrue(root.contains(rockAlbum)); // rockAlbum gets added as subAlbum to root in rockAlbum's constructor
        SubAlbum classicalAlbum = new SubAlbum("Classical", null);
        assertTrue(root.contains(classicalAlbum));

        // check getAlbum methods and values
        assertEquals(2, root.getSubAlbums().size());
        assertEquals("Rock", root.getSubAlbum(0).toString());
        assertEquals(0, rockAlbum.getSongs().size());

        // checking contains method
        assertTrue(root.contains(rockAlbum));
        assertEquals("Classical", root.getSubAlbum(1).toString());

        // checking getParent method
        assertEquals(root, classicalAlbum.getParentAlbum());

        // checking remove method
        assertTrue(root.remove(classicalAlbum));
        assertEquals(1, root.getSubAlbums().size());

        // adding sub-albums to sub-albums
        SubAlbum metalAlbum = new SubAlbum("Metal", rockAlbum);
        assertFalse(rockAlbum.add(metalAlbum));
        assertTrue(rockAlbum.contains(metalAlbum));
        assertEquals(metalAlbum, root.getSubAlbum(0).getSubAlbum(0));
        assertEquals(root, metalAlbum.getParentAlbum().getParentAlbum());
        assertNull(root.getParentAlbum());

        // checking isRootAlbum method
        assertFalse(rockAlbum.isRootAlbum());
        assertTrue(root.isRootAlbum());
    }

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
