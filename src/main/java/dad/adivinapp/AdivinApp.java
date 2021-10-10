package dad.adivinapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application{

	private Label etiqueta;
	private Button comButton;
	private TextField numEsc;
	private VBox root;
	private int numCorrec;
	private int intentos;
	
	public void start(Stage primaryStage) throws Exception {
		
		etiqueta = new Label();
		etiqueta.setText("Introduce un número del 1 al 100");
		
		numEsc = new TextField();
		numEsc.setPromptText("0");
		numEsc.setMaxWidth(100);
		
		comButton = new Button();
		comButton.setText("Comprobar");
		comButton.setOnAction(e -> compNum(e));
		comButton.setDefaultButton(true);
		
		root = new VBox();
		root.setSpacing(15);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(etiqueta, numEsc, comButton);
		
		Scene scene = new Scene(root, 320,200);
		
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		numCorrec = numeroRan();
		
	}
	
	private void compNum(ActionEvent e) {
		try {
			int num = Integer.parseInt(numEsc.getText());
			if(num==numCorrec) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has ganado!");
				alert.setContentText("Sólo has necesitado " + intentos + " intenos " + "\n" + "Vuelve a jugar y hazlo mejor" );
				intentos=1;
				alert.showAndWait();
			} else if(num < numCorrec) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("!Has fallado¡");
				alert.setContentText("El número a adivinar es mayor que " + num + "\n" + "Vuelve a intentarlo");
				intentos++;
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("!Has fallado¡");
				alert.setContentText("El número a adivinar es menor que " + num + "\n" + "Vuelve a intentarlo");
				intentos++;
				alert.showAndWait();
				
			}
			
		} catch(NumberFormatException ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("El número introducido no es válido");
			alert.showAndWait();
			
		}
	
	}
	
	private int numeroRan() {
		return (int)Math.round(Math.random()*100+1);
	}

	public static void main(String[] args) {
		launch(args);

	}
}
