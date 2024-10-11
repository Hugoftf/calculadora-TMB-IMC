package entities;

public class Pessoa {

	private Double altura;
	private Double peso;
	private Integer idade;
	
	private Frequencia frequencia;
	private Sexo sexo;
	
	public Pessoa() {
	}

	public Pessoa(Double altura, Double peso, Integer idade, Frequencia frequencia, Sexo sexo) {
		this.altura = altura;
		this.peso = peso;
		this.idade = idade;
		this.frequencia = frequencia;
		this.sexo = sexo;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Frequencia getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	
	
	
	
}
