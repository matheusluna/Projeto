package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.DaoUsuario;
import entidades.Pessoa;
import interfaces.Comando;

public class PesquisaUsuarioController implements Comando{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		// TODO Auto-generated method stub
		DaoUsuario dao = new DaoUsuario();
		List<Pessoa> lista = dao.pesquisa(request.getParameter("pesquisa"));
		request.setAttribute("pessoas", lista);
		request.getRequestDispatcher("Pesquisa.jsp").forward(request, response);
	}

}
