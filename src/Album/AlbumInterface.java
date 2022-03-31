package Album;

public interface AlbumInterface {
    // interface for making sure that the album class contains all the necessary methods
    boolean addSong(final Song song);
    boolean removeSong(final Song song);
    boolean addAlbum(final Album album);
    boolean removeAlbum(final Album album);
    boolean containsAlbum(final Album album);
    boolean containsSong(final Song song);
}
