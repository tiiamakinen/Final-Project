### Created following files:

- **ArtistDao.java** - *Interface of ArtistDao that defines what operations the DAO class must perform*

- **AlbumDao.java** - *Interface of AlbumDao that defines what operations the DAO class must perform*

- **JDBCArtistDao.java** - *Defining methods that will connect with the database and return artist data*

- **JDBCAlbumDao.java** - *Defining methods that will connect with the database and return album data*

- **ArtistListServlet.java** - *Grabs data from the artistList.jsp file and calls the dao methods to display or insert artist data*

- **AlbumListServlet.java** - *Grabs data from the albumList.jsp file and calls the dao methods to display album data*

- **SearchServlet.java** - *Works as a bridge to get the information from the database using the dao methods to search artist data*

- **artistList.jsp** - *Page that shows the list of artists and holds the forms to insert and search data*

- **albumList.jsp** - *Page that shows the list of albums*

- **searchResults.jsp** - *Page that shows a list of artist(s) based the search terms and holds the forms to insert and search data*
