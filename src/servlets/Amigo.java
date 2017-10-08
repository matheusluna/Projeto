package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.DaoAmigo;
import controle.DaoUsuario;
import entidades.Pessoa;

/**
 * Servlet implementation class Amigo
 */
@WebServlet("/Amigo")
public class Amigo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Amigo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DaoAmigo amigos = new DaoAmigo();
		DaoUsuario dao = new DaoUsuario();
		HttpSession session = request.getSession();
		List<String> listaAmigo = new ArrayList<>();
		try {
			List<entidades.Amigo> lista = amigos.list((String) session.getAttribute("usuario"));
			for(entidades.Amigo a : lista) {
				Pessoa p = dao.read(a.getPessoa2());
				listaAmigo.add(p.getNome());
			}
			request.setAttribute("amigos", listaAmigo);
			request.getRequestDispatcher("Amigo.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
