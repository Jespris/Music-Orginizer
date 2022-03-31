package Album;

import java.util.ArrayList;

public class SubAlbum extends Album{

    private final Album parentAlbum;

    public SubAlbum(final String albumName, final Album parent) {
        super(albumName);
        this.parentAlbum = parent;
    }

    public Album getParentAlbum(){
        return this.parentAlbum;
    }

    @Override
    public boolean invariant() {
        return (this.albumName != null && this.parentAlbum != null);
    }

    @Override
    boolean isRootAlbum() {
        return false;
    }
}
