package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KinzCollector extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
		primaryStage.setTitle("KinzCollector");
		Scene scene = new Scene(root,520,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

//		primaryStage.setScene(new Scene(root,1280,800));
//		Parent root = FXMLLoader.load(getClass().getResource("/database/createAccount.fxml"));