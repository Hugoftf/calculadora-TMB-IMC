package entities;

import java.util.Locale;

public class Calculadora {

	
	
	public static Double calculadoraDeCalorias(Double altura, Double peso, Integer idade, 
			Frequencia frenquencia, Sexo sexo) {
		Locale.setDefault(Locale.US);
		
		altura = altura *100;
		
		double resultado = (sexo == Sexo.HOMEM) ? 10 * peso + 6.25 * altura - 5 * idade + 5 
				: 10 * peso + 6.25 * altura - 5 * idade - 161;
		
		new Pessoa(altura, peso, idade, frenquencia, sexo);
		
		if (frenquencia == frenquencia.SEDENTARIO) {
			return resultado * 1.2;
		}
		if (frenquencia == frenquencia.LEVEMENTE_ATIVO) {
			return resultado * 1.375;
		}
		if (frenquencia == frenquencia.MODERADAMENTE_ATIVO) {
			return resultado * 1.55;
		}
		if (frenquencia == frenquencia.MUITO_ATIVO) {
			return resultado * 1.725;
		}
		else {
			return resultado * 1.9;
		}
		
	}
	
	public static Double calcularIMC(Double peso, Double altura) {
		double imc = peso/(altura*altura);
		return imc;
	}
	
	public static String tabelaIMC(Double resultadoIMC) {
		String resultadoTabela;
		
		if (resultadoIMC <= 18.5) {
			return resultadoTabela = "Abaixo do Peso";
		}
		if (resultadoIMC > 18.5 && resultadoIMC <= 24.9) {
			return resultadoTabela = "Peso Normal";
		}
		if (resultadoIMC > 25.0 && resultadoIMC <= 29.9) {
			return resultadoTabela = "Sobrepeso";
		}
		if (resultadoIMC > 30.0 && resultadoIMC <= 34.9) {
			return resultadoTabela = "Obesidade grau 1";
		}
		if (resultadoIMC > 35.0 && resultadoIMC <= 39.9) {
			return resultadoTabela = "Obesidade grau 2";
		}
		else {
			return resultadoTabela = "Obesidade grau 3";
		}
		
	}
	
	 
}
