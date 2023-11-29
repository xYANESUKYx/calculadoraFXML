package calculadoraFXML;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	//controllers
	private Controller controlador;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		controlador = new Controller();
		
		primaryStage.setScene(new Scene(controlador.getView()));
		primaryStage.setTitle("CALCULADORA");
		primaryStage.show();
	}

}
