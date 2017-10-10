package controladores;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.DaoUsuario;
import entidades.Pessoa;
import interfaces.Comando;

public class PessoaController implements Comando{
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException, ServletException {
		// TODO Auto-generated method stub
		DaoUsuario dao = new DaoUsuario();
		String email = request.getParameter("email");
		Pessoa pessoa = dao.read(email);
		request.setAttribute("pessoa", pessoa);
		request.getRequestDispatcher("pessoa.jsp").forward(request, response);
		
	}
	
}
