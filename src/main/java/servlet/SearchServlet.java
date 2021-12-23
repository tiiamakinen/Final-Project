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

@WebServlet("/searchResults")
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private JDBCArtistDao dao = new JDBCArtistDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Lists searched artists

		System.out.println("hello");

		String searchTerm = request.getParameter("Name");

		List<Artist> artist = this.dao.getSearchedArtists(searchTerm);

		request.setAttribute("artists", artist);
		request.getRequestDispatcher("/WEB-INF/searchResults.jsp").forward(request, response);

		// Retrieving searched artists, forwarding them to the jsp page
		response.getWriter().println(artist);

	}
}