package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCArtistDao;
import model.Artist;


@WebServlet("/")
public class ArtistListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private JDBCArtistDao dao = new JDBCArtistDao();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Lists all artists
		List<Artist> artists = this.dao.getAllArtists();

		request.setAttribute("artists", artists);
		request.getRequestDispatcher("/WEB-INF/artistList.jsp").forward(request, response);

		// Retrieving all artists, forwarding them to the jsp page
		response.getWriter().println(artists);

	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String artistName = request.getParameter("name");

		Artist newArtist = new Artist(artistName);

		request.setAttribute("new artist", newArtist);

		dao.addArtist(newArtist);

		List<Artist> allArtists = this.dao.getAllArtists();

		response.getWriter().println(allArtists);

		response.sendRedirect("/");

	}
	
	
//	protected void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		//Lists searched artists
//		
//		System.out.println("hello");
//		
//		String searchTerm = request.getParameter("Name");
//		
//		List<Artist> searchedArtists = this.dao.getSearchedArtists(searchTerm);
//		
//		for (int i = 0; i < searchedArtists.size(); i ++) {
//			System.out.println(searchedArtists.get(i).getName());
//		}
//		
//		request.setAttribute("artists", searchedArtists);
//		request.getRequestDispatcher("/WEB-INF/searchResults.jsp").forward(request, response);
//		
//		// Retrieving searched artists, forwarding them to the jsp page
//		response.getWriter().println(searchedArtists);
//		
//	}

}
