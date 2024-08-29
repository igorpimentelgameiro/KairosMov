package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;
import dao.KairosDAO;
import model.Userkairosmov;


public class TesteBancoJdbc
{
	@Test
	public void initBanco()
	{
		KairosDAO kairosDAO = new KairosDAO();
		Userkairosmov userkairosmov = new Userkairosmov();
		
		userkairosmov.setId(6L);
		userkairosmov.setNome("Douglas Costa");
		userkairosmov.setEmail("teste4@gmail.com");
		userkairosmov.setIdade(29);
		userkairosmov.setMinisterio("Música");
		
		kairosDAO.salvar(userkairosmov);
	}

}
