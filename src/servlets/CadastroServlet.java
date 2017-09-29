package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.DaoUsuario;
import entidades.Pessoa;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DaoUsuario cadastro = new DaoUsuario();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String sexo = request.getParameter("sexo");
		LocalDate nascimento = LocalDate.parse(request.getParameter("nascimento"), formatter);
		String cidade = request.getParameter("cidade");
		String profissao = request.getParameter("profissao");
		String foto = request.getParameter("foto");
		String senha = request.getParameter("senha");
		Pessoa pessoa = new Pessoa(email, nome, cidade, profissao, nascimento, sexo, foto, senha);
		try {
			if(cadastro.create(pessoa)) {
				request.setAttribute("mensagem","<script>alert('Cadastrado com sucesso')</script>");
			}else {
				request.setAttribute("mensagem","<script>alert('Já existe um usuário com este email')</script>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("mensagem",e.getMessage());
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		}
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
	}

}
