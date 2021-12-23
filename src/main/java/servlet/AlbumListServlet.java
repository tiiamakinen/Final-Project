package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCAlbumDao;
import model.Album;

@WebServlet("/albumList")
public class AlbumListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private JDBCAlbumDao dao = new JDBCAlbumDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("ArtistId");

		long idLong = Long.parseLong(id);

		List<Album> albums = this.dao.getAllAlbums(idLong);

		request.setAttribute("albums", albums);
		request.getRequestDispatcher("/WEB-INF/albumList.jsp").forward(request, response);

		// Retrieving all albums, forwarding them to the jsp page
		response.getWriter().println(albums);

	}

}