package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
