package Album;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;

public class SubAlbum extends Album{

    // instance variables
    private Album parentAlbum; // is not final because maybe we want to add feature to change parent album?

    public SubAlbum(final String albumName, Album parent) {
        // constructor for the SubAlbum class, calls super, and assigns rootAlbum as parent if no parent is assigned
        super(albumName);
        if (parent == null){
            System.out.println("Sub-album '" + this + "' has no parent assigned, assigning root album as parent...");
            this.parentAlbum = RootAlbum.get();
        } else {
            this.parentAlbum = parent;
        }
        assert invariant();
    }

    public boolean changeParentAlbum(Album album) throws ExecutionControl.NotImplementedException {
        // TODO: method to change parent album?
        if (album != null) {
            this.parentAlbum = album;
        }
        assert invariant();
        throw new ExecutionControl.NotImplementedException("change parent method implemented," +
                " but maybe is not supposed to be used?");
    }

    @Override
    public Album getParentAlbum(){
        // returns the parent album
        return this.parentAlbum;
    }

    @Override
    public boolean invariant() {
        // checks that the instance variables are viable
        return (this.albumName != null && this.parentAlbum != null);
    }

    @Override
    public boolean isRootAlbum() {
        // returns false because this is not the root album
        return false;
    }
}
