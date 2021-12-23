package database;

import java.util.List;

import model.Artist;

/**
 * ShoppingListItemDao on rajapinta, joka määrittelee, mitä operaatioita
 * DAO-luokan on toteutattava.
 */
public interface ArtistDao {

    public List<Artist> getAllArtists();

//    public Artist getItem(long id);

    public boolean addArtist(Artist newArtist);

 //   public boolean removeItem(Artist item);
}

