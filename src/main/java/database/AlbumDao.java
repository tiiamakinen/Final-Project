package database;

import java.util.List;

import model.Album;

/**
 * AlbumDao is an interface that defines what operations the DAO class must perform.
 */
public interface AlbumDao {

    public List<Album> getAllAlbums(long id);
    
 //   public Album getAlbum(long id);

}