package application;


import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Controller {

	public void close(ActionEvent e) {
		Platform.exit();
	}
	private Stage stage;
	private Scene scene;
	private Parent root;
	double x,y;
	public void openAllClients(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("viewClients.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		root.setOnMousePressed(evt->{
			x = evt.getSceneX();
			y = evt.getSceneY();
		});
		root.setOnMouseDragged(evt->{
			stage.setX(evt.getScreenX() - x);
			stage.setY(evt.getScreenY() - y);
			
		});
		stage.setScene(scene);
		stage.show();
		}
	}
