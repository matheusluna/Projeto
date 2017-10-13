package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco.ConFactory;
import entidades.Solicitacao;
import interfaces.DaoSolicitacaoInterface;

public class DaoSolicitacao implements DaoSolicitacaoInterface{
	
	public List<Solicitacao> listar(String emissor) throws ClassNotFoundException, SQLException{
		
		List<Solicitacao> lista = new ArrayList<>();
		
		Connection con = new ConFactory().getConnection();
		String sql="select * from solicitacao where emissor = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, emissor);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String emissorBanco = rs.getString("emissor");
			String receptor = rs.getString("receptor");
			Solicitacao solicitacao = new Solicitacao(emissorBanco, receptor);
			lista.add(solicitacao);
		}
		stmt.close();
		con.close();
		return lista;
	}
	
public List<Solicitacao> listar() throws ClassNotFoundException, SQLException{
		
		List<Solicitacao> lista = new ArrayList<>();
		
		Connection con = new ConFactory().getConnection();
		String sql="select * from solicitacao";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String emissor = rs.getString("emissor");
			String receptor = rs.getString("receptor");
			Solicitacao solicitacao = new Solicitacao(emissor, receptor);
			lista.add(solicitacao);
		}
		stmt.close();
		con.close();
		return lista;
	}
	
	@Override
	public boolean create(Solicitacao solicitacao) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Solicitacao> lista = listar();
		for(Solicitacao s : lista) {
			if((s.getEmissor().equals(solicitacao.getEmissor()) && s.getReceptor().equals(solicitacao.getReceptor())) || (s.getReceptor().equals(solicitacao.getEmissor()) && s.getEmissor().equals(solicitacao.getReceptor()))) {
				return false;
			}
		}
		
		Connection con = new ConFactory().getConnection();
		String sql = "insert into solicitacao value (?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, solicitacao.getEmissor());
		stmt.setString(2, solicitacao.getReceptor());
		boolean resultado = !stmt.execute();
		stmt.close();
		con.close();
		return false;
	}

	@Override
	public Solicitacao read(String emissor, String receptor) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Solicitacao solicitacao) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Solicitacao solicitacao) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
