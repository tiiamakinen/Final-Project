package model;


public class Album {
	
	private long albumId;
	private long artistId;
	private String name;
	
	
	public Album(long albumId, String name, long artistId) {
		
		this.albumId = albumId;
		this.artistId = artistId;
		this.name = name;
	
	}

	public String getName() {
		return this.name;
		
	}
	
	public long getAlbumId() {
		return this.albumId;
		
	}

	public void setAlbumId(long id) {
		this.albumId = id;
				
	}

	public long getArtistId() {
		return artistId;
	}

	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}
	
}
