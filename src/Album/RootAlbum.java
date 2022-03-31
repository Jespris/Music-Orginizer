package Album;

import java.util.ArrayList;

public class RootAlbum extends Album {

    private static final RootAlbum instance = new RootAlbum("All Sound Clips");

    private RootAlbum(final String albumName){
        super(albumName);
        assert invariant();
    }

    public static RootAlbum get(){
        return instance;
    }

    @Override
    boolean invariant() {
        return this.albumName != null;
    }

    @Override
    public boolean isRootAlbum() {
        return true;
    }

    @Override
    public Album getParentAlbum() {
        return null;
    }
}
