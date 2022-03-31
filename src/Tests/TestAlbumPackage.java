package Tests;

import Album.RootAlbum;
import Album.Song;
import Album.SoundClip;
import Album.SubAlbum;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TestAlbumPackage {
    @Test
    public void testAlbum(){
        // check root album
        RootAlbum root = RootAlbum.get();
        assertEquals("All Sound Clips", root.toString());

        // add new subAlbums to root
        // checking addAlbum method
        SubAlbum rockAlbum = new SubAlbum("Rock", root);
        assertTrue(root.addAlbum(rockAlbum));
        SubAlbum classicalAlbum = new SubAlbum("Classical", null);
        assertTrue(root.addAlbum(classicalAlbum));

        // check getAlbum methods and values
        assertEquals(2, root.getSubAlbums().size());
        assertEquals("Rock", root.getSubAlbum(0).toString());
        assertEquals(0, rockAlbum.getSongs().size());

        // checking contains method
        assertTrue(root.containsAlbum(rockAlbum));
        assertEquals("Classical", root.getSubAlbum(1).toString());

        // checking getParent method
        assertEquals(root, classicalAlbum.getParentAlbum());

        // checking remove method
        assertTrue(root.removeAlbum(classicalAlbum));
        assertEquals(1, root.getSubAlbums().size());

        // adding sub-albums to sub-albums
        SubAlbum metalAlbum = new SubAlbum("Metal", rockAlbum);
        assertTrue(rockAlbum.addAlbum(metalAlbum));
        assertEquals(metalAlbum, root.getSubAlbum(0).getSubAlbum(0));
        assertEquals(root, metalAlbum.getParentAlbum().getParentAlbum());
        assertNull(root.getParentAlbum());

        // checking isRootAlbum method
        assertFalse(rockAlbum.isRootAlbum());
        assertTrue(root.isRootAlbum());
    }

    @Test
    public void testSong(){
        Song song = new Song(new SoundClip(new File("src/SongFiles/shrek.wav")), "TestSong", "TestArtist");
        RootAlbum root = RootAlbum.get();
        assertTrue(root.addSong(song));
        System.out.println(song.getSoundClip().getFile().getPath());
    }
}
