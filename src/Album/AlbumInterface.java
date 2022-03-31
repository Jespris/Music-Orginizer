package Album;

public interface AlbumInterface {
    // interface for making sure that the album class contains all the necessary methods
    boolean addSong(final Song song);
    boolean removeSong(final Song song);
    boolean addAlbum(SubAlbum album);
    boolean removeAlbum(final SubAlbum album);
    boolean containsAlbum(final SubAlbum album);
    boolean containsSong(final Song song);
}
