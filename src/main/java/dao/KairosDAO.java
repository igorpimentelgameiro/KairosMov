package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.Conexao;
import model.Userkairosmov;

public class KairosDAO 
{
	
	private Connection connection;
	
	public KairosDAO()
	{
		connection = Conexao.getConnection();
	}
	
	public void salvar (Userkairosmov userkairosmov)
	{
		try
		{
			String sql = "insert into membroskairos (id, nome, email, idade, ministerio) values (?,?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, userkairosmov.getId());
			insert.setString(2, userkairosmov.getNome());
			insert.setString(3, userkairosmov.getEmail());
			insert.setInt(4, userkairosmov.getIdade());
			insert.setString(5, userkairosmov.getMinisterio());
			insert.execute();
			connection.commit(); //Salva no Banco de Dados
		}catch (Exception e)
		 {
			try
			{
				connection.rollback(); //Reverte Operação
			} catch (SQLException e1)
			  {	
				e1.printStackTrace();
			  }
				e.printStackTrace();
		 }
	}
	
	public List<Userkairosmov> listar () throws Exception
	{
		List<Userkairosmov> list = new ArrayList<Userkairosmov>();
		
		String sql = "select * from membroskairos";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while (resultado.next()) 
		{
			Userkairosmov userkairosmov = new Userkairosmov();
			userkairosmov.setId(resultado.getLong("id"));
			userkairosmov.setNome(resultado.getString("nome"));
			userkairosmov.setEmail(resultado.getString("email"));
			userkairosmov.setIdade(resultado.getInt("idade"));
			userkairosmov.setMinisterio(resultado.getString("ministerio"));
			list.add(userkairosmov);
		}
		
		return list;
	}
}
