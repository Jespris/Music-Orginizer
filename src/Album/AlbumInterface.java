package Album;

public interface AlbumInterface {
    // interface for making sure that the album class contains all the necessary methods
    boolean add(final Song song);
    boolean remove(final Song song);
    boolean add(SubAlbum album);
    boolean remove(final SubAlbum album);
    boolean contains(final SubAlbum album);
    boolean contains(final Song song);
}
