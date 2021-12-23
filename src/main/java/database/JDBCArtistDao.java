package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Artist;

public class JDBCArtistDao implements ArtistDao {
	
	// Acts as an interface to the database
	
	private Database database = new Database();
	
	@Override
	public List<Artist> getAllArtists() {
		
		String selectAll = "SELECT ArtistId, Name FROM Artist ORDER BY Name ASC;";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Artist> allArtists = new ArrayList<>();
		
		try {
			
			connection = database.connect();
			statement = connection.prepareStatement(selectAll);
			results = statement.executeQuery();
			
			while (results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");
				
				Artist artist = new Artist(id, name);
				allArtists.add(artist);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// suljetaan connection
			this.database.close(connection, statement, results);
		}
		
		return allArtists;
	}
	
	@Override
	public boolean addArtist(Artist newArtist) {
        String sql = "INSERT INTO Artist (Name) VALUES (?);";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet ids = null;

        try {
            connection = this.database.connect();
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, newArtist.getName());
            
            int rows = statement.executeUpdate();
            
            if (rows == 1) {
                ids = statement.getGeneratedKeys();
                ids.next();
                long generatedId = ids.getLong(1);
                newArtist.setId(generatedId);
                return true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.database.close(connection, statement, ids);
        }
        
        return false;
    }	

}
