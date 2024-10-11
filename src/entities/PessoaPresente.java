package entities;

public class PessoaPresente {

	public Pessoa intanciaDePessoa(Double altura, Double peso, Integer idade, Frequencia frequencia, Sexo sexo) {
		Pessoa pessoa = new Pessoa(altura, peso, idade, frequencia, sexo);
		return pessoa;
	}
	
}
