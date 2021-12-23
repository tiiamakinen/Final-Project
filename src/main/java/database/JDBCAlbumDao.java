package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Album;
import model.Artist;

public class JDBCAlbumDao implements AlbumDao {
	
	private Database database = new Database();
	
	public List<Album> getAllAlbums(long id) {
		
		String selectAll = "SELECT AlbumId, Title, ArtistId FROM Album WHERE ArtistId = ?;";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Album> allAlbums = new ArrayList<>();
		
//		PreparedStatement statement = connection.prepareStatement("SELECT AlbumId, Title FROM Album WHERE ArtistId = ?;");
		
		try {
			
			connection = database.connect();
			
			statement = connection.prepareStatement(selectAll);
			
	//		statement.setLong(1, artistId);
	//		statement.setString(1, selectAll);
			
			statement.setLong(1, id);
			
			results = statement.executeQuery();
			
			while (results.next()) {
				
				long albumId = results.getLong("AlbumId");
				String name = results.getString("Title");
				long artistId = results.getLong("ArtistId");
				
				Album album = new Album(albumId, name, artistId);
				allAlbums.add(album);
				
				System.out.println(albumId);
				System.out.println(name);
				System.out.println(artistId);

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// suljetaan connection
			this.database.close(connection, statement, results);
		}
		return allAlbums;
	}
	
//    @Override
//    public Album getAlbum(long id) {
//
//        List<Album> allAlbums = this.getAllAlbums();
//        for (Album album : allAlbums) {
//            if (id == album.getId()) {
//                return album;
//            }
//        }
//        return null;
//    }


	}
