package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UniversalMethods {
	
	public void switchScene(ActionEvent event, String fxml) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/views/" + fxml));
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
}