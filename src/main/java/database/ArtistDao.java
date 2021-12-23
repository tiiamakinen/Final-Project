package database;

import java.util.List;

import model.Artist;

/**
 * ArtistDao is an interface that defines what operations the DAO class must perform.
 */
public interface ArtistDao {

    public List<Artist> getAllArtists();

    public boolean addArtist(Artist newArtist);
    
  //  public Artist getId(long id);

}

