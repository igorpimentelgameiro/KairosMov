package model;

public class Userkairosmov
{
	private Long id;
	private String nome;
	private String email;
	private Integer idade;
	private String ministerio;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public Integer getIdade()
	{
		return idade;
	}
	
	public void setIdade(Integer idade)
	{
		this.idade = idade;
	}
	
	public String getMinisterio()
	{
		return ministerio;
	}
	
	public void setMinisterio(String ministerio)
	{
		this.ministerio = ministerio;
	}	
}