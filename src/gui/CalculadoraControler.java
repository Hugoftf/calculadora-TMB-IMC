package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entities.Calculadora;
import entities.Frequencia;
import entities.Sexo;
import gui.util.Alerts;
import gui.util.Constrains;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraControler implements Initializable {

	@FXML
	private TextField txtAltura;
	
	@FXML
	private TextField txtPeso;
	
	@FXML
	private TextField txtIdade;
	
	@FXML
	private ComboBox<Frequencia> comboBoxFrequencia;
	
	@FXML
	private ComboBox<Sexo> comboBoxSexo;
	
	@FXML
	private Button btIniciar;
	
	public void btActionIniciar() {
		btIniciar.setOnAction(event -> calcular());
	}
		
	 private void calcular() {
	        try {
	        	
	            double altura = Double.parseDouble(txtAltura.getText());
	            double peso = Double.parseDouble(txtPeso.getText());
	            int idade = Integer.parseInt(txtIdade.getText());
	            
	            if (txtAltura.getText().isEmpty() || txtPeso.getText().isEmpty() || txtIdade.getText().isEmpty()) {
	                throw new NumberFormatException("Campos de texto vazios");
	            }
	            
	            Sexo sexo = comboBoxSexo.getValue();
	            Frequencia frequencia = comboBoxFrequencia.getValue();
	            System.out.println("Sexo: " + sexo);
	            System.out.println("Frequancia: " + frequencia);
	            
	            if (comboBoxSexo.getValue() == null || comboBoxFrequencia.getValue() == null) {
	                throw new NullPointerException("ComboBox vazios");
	            }

	            double imc = Calculadora.calcularIMC(peso, altura);
	            double tmb = Calculadora.calculadoraDeCalorias(altura, peso, idade, frequencia, sexo);
	            String tabelaIMC = Calculadora.tabelaIMC(imc);
	            
	            mostrarResultados(imc, tmb, tabelaIMC);
			} 
	        catch (NumberFormatException e) {	
				Alerts.showAlert(null, "Error", "Preencha os espaços vazios", AlertType.ERROR);
			} 
	        catch (NullPointerException e) {
				Alerts.showAlert(null, "Error", "Selecione os valores no campo frequencia ou Sexo", AlertType.ERROR);
	        	e.printStackTrace();
			} 
	        catch (Exception e) {
				Alerts.showAlert(null, "Error", "Ocorreu um erro: " + e.getMessage(), AlertType.ERROR);
			}
	    }
	
	private void mostrarResultados(double imc, double tmb, String tabelaIMC) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultadoView.fxml"));
			AnchorPane resultadosPane = loader.load();

			ResultadoControler resultadosController = loader.getController();
			resultadosController.setResultados(imc, tmb, tabelaIMC);
			

			Stage resultadosStage = new Stage();
			resultadosStage.setTitle("Resultados");
			resultadosStage.setScene(new Scene(resultadosPane, 500, 400));
			resultadosStage.show();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		comboBoxSexo.getItems().addAll(Sexo.values());
		comboBoxFrequencia.getItems().addAll(Frequencia.values());
		Constrains.setTextFieldDouble(txtAltura);
		Constrains.setTextFieldDouble(txtPeso);
		Constrains.setTextFieldInteger(txtIdade);
		
	}
}
