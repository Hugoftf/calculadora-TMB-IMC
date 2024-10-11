package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultadoControler {

	   @FXML
	    private Label lbIMC;

	    @FXML
	    private Label lbTMB;
	    
	    @FXML
	    private Label lbTabelaIMC;

	    public void setResultados(double imc, double tmb, String tabelaIMC) {
	        lbIMC.setText(" " + String.format("%.2f", imc));
	        lbTMB.setText(" " + String.format("%.2f", tmb));
	        lbTabelaIMC.setText("  " + tabelaIMC);
	        
	    }
	
}
