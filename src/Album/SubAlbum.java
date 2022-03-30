package Album;

import java.util.ArrayList;

public class SubAlbum extends RootAlbum{

    private final SubAlbum parentAlbum;

    public SubAlbum(final String albumName, final SubAlbum parent) {
        super(albumName);
        this.parentAlbum = parent;
    }

    @Override
    public boolean equals(final Object other){
        // overriding the equals method for albums, for enabling sorting sub-albums and such
        return false;
    }
}
