package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao
{
	
	private static String url = "jdbc:postgresql://localhost:5432/kairosmov";
	private static String password = "123456";
	private static String user = "postgres";
	private static Connection connection = null;
	
	static
	{
		Conectar();
	}
	
	public Conexao()
	{
		Conectar();
	}
	
	private static void Conectar()
	{
		try
		{
			if (connection == null)
			{
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conexão Estabelecida");
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		return connection;
	}

}
