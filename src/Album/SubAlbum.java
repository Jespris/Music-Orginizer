package Album;

import java.util.ArrayList;

public class SubAlbum extends Album{

    private Album parentAlbum;

    public SubAlbum(final String albumName, Album parent) {
        super(albumName);
        if (parent == null){
            System.out.println("Sub-album '" + this.toString() + "' has no parent assigned, assigning root album as parent...");
            this.parentAlbum = RootAlbum.get();
        } else {
            this.parentAlbum = parent;
        }
        assert invariant();
    }

    @Override
    public Album getParentAlbum(){
        return this.parentAlbum;
    }

    @Override
    public boolean invariant() {
        return (this.albumName != null && this.parentAlbum != null);
    }

    @Override
    public boolean isRootAlbum() {
        return false;
    }
}
