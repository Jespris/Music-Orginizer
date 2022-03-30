package Album;

public interface AlbumInterface {
    // interface for making sure that the album class contains all the necessary methods
    void addSong(final Song song);
    void removeSong(final Song song);
    void addAlbum(SubAlbum subAlbum);
    void removeAlbum(SubAlbum subAlbum);
    boolean containsAlbum(SubAlbum subAlbum);
    boolean containsSong(Song song);
}
