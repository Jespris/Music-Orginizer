package Tests;

import Album.RootAlbum;
import Album.SubAlbum;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAlbumPackage {
    @Test
    public void TestAlbum(){
        RootAlbum.get().addAlbum(new SubAlbum("Rock", RootAlbum.get()));
        assertEquals(RootAlbum.get().getAlbum(0).toString(), "Rock");

    }
}
