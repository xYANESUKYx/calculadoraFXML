package calculadoraFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Controller implements Initializable {

	//view
    @FXML
    private BorderPane view;
	@FXML
	private Button c;
	@FXML
	private Button calcular;
	@FXML
	private Button ce;
	@FXML
	private Button cero;
	@FXML
	private Button cinco;
	@FXML
	private Button cuatro;
	@FXML
	private Button dividir;
	@FXML
	private Button dos;
	@FXML
	private Button multiplicar;
	@FXML
	private Button nueve;
    @FXML
    private Button ocho;
    @FXML
    private Button punto;
    @FXML
    private Button restar;
    @FXML
    private TextField resultado;
    @FXML
    private Button seis;
    @FXML
    private Button siete;
    @FXML
    private Button sumar;
    @FXML
    private Button tres;
    @FXML
    private Button uno;
    
	private Calculadora calc = new Calculadora();

	
	public Controller() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
			loader.setController(this);
			loader.load();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//bindings
		
		resultado.setPromptText("0.0");
	}
	
	public BorderPane getView() {
		return view;
	}
	


    
    //Logica de negocio
    
    @FXML
    void onCAction(ActionEvent event) {
    	resultado.setText(resultado.getText().substring(0, resultado.getText().length() - 1));
    	calc.borrar();
    }

    @FXML
    void onCEAction(ActionEvent event) {
    	resultado.setText("");
    	calc.borrarTodo();
    }

    @FXML
    void onCalcularAction(ActionEvent event) {
    	calc.operar(Calculadora.IGUAL);
    	resultado.setText(calc.getPantalla());
    }

    @FXML
    void onCeroAction(ActionEvent event) {
    	resultado.setText((resultado.getText() + "0"));
    	calc.insertar('0');
    }

    @FXML
    void onCincoAction(ActionEvent event) {
    	resultado.setText((resultado.getText() + "5"));
    	calc.insertar('5');
    }

    @FXML
    void onCuatroAction(ActionEvent event) {
    	resultado.setText((resultado.getText() + "4"));
    	calc.insertar('4');
    }

    @FXML
    void onDividirAction(ActionEvent event) {
    	if (resultado.getText().endsWith(" x ") || resultado.getText().endsWith(" + ") || resultado.getText().endsWith(" - ") || resultado.getText().endsWith(" ÷ ")) {
    		resultado.setText(resultado.getText().substring(0, resultado.getText().length() - 3));
    	}else if (resultado.getText().endsWith(".")){
        	resultado.setText((resultado.getText() + "0"));
    	}
    	resultado.setText((resultado.getText() + " ÷ "));
    	calc.operar(Calculadora.DIVIDIR);
    }

    @FXML
    void onDosAction(ActionEvent event) {
    	resultado.setText((resultado.getText() + "2"));
    	calc.insertar('2');
    }

    @FXML
    void onMultiplicarAction(ActionEvent event) {
    	if (resultado.getText().endsWith(" x ") || resultado.getText().endsWith(" + ") || resultado.getText().endsWith(" - ") || resultado.getText().endsWith(" ÷ ")) {
    		resultado.setText(resultado.getText().substring(0, resultado.getText().length() - 3));
    	}else if (resultado.getText().endsWith(".")){
        	resultado.setText((resultado.getText() + "0"));
    	}
    	resultado.setText((resultado.getText() + " x "));
    	calc.operar(Calculadora.MULTIPLICAR);
    }

    @FXML
    void onNueveAction(ActionEvent event) {
    	resultado.setText((resultado.getText() + "9"));
    	calc.insertar('9');
    }

    @FXML
    void onOchoAction(ActionEvent event) {
    	resultado.setText((resultado.getText() + "8"));
    	calc.insertar('8');
    }

    @FXML
    void onPuntoAction(ActionEvent event) {
        String ultimoCaracter = resultado.getText().substring(resultado.getText().length() - 1);
    	if (!Character.isDigit(ultimoCaracter.charAt(0))) {
    		resultado.setText((resultado.getText() + "0"));
    	}
    	resultado.setText((resultado.getText() + "."));
    	calc.insertar('.');
    }

    @FXML
    void onRestarAction(ActionEvent event) {
    	if (resultado.getText().endsWith(" x ") || resultado.getText().endsWith(" + ") || resultado.getText().endsWith(" - ") || resultado.getText().endsWith(" ÷ ")) {
    		resultado.setText(resultado.getText().substring(0, resultado.getText().length() - 3));
    	}else if (resultado.getText().endsWith(".")){
        	resultado.setText((resultado.getText() + "0"));
    	}
    	resultado.setText((resultado.getText() + " - "));
    	calc.operar(Calculadora.RESTAR);
    }

    @FXML
    void onSeisAction(ActionEvent event) {
    	resultado.setText((resultado.getText() + "6"));
    	calc.insertar('6');
    }

    @FXML
    void onSieteAction(ActionEvent event) {
    	resultado.setText((resultado.getText() + "7"));
    	calc.insertar('7');
    }

    @FXML
    void onSumarAction(ActionEvent event) {
    	if (resultado.getText().endsWith(" x ") || resultado.getText().endsWith(" + ") || resultado.getText().endsWith(" - ") || resultado.getText().endsWith(" ÷ ")) {
    		resultado.setText(resultado.getText().substring(0, resultado.getText().length() - 3));
    	}else if (resultado.getText().endsWith(".")){
        	resultado.setText((resultado.getText() + "0"));
    	}
    	resultado.setText((resultado.getText() + " + "));
    	calc.operar(Calculadora.SUMAR);
    }

    @FXML
    void onTresAction(ActionEvent event) {
    	resultado.setText((resultado.getText() + "3"));
    	calc.insertar('3');
    }

    @FXML
    void onUnoAction(ActionEvent event) {
    	resultado.setText((resultado.getText() + "1"));
    	calc.insertar('1');
    }
}

