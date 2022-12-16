/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;


import static application.SharedVariables.incrementReadCount;
import static application.SharedVariables.returnWriteCount;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author a
 */

public class LoadingController implements Initializable {
    
        @FXML
        private TabPane ContentOfPane;
    
    @FXML
    private ImageView loadingIcon;
        @FXML
	public void close(ActionEvent e) throws IOException {
            Timeline timeline = new Timeline();
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            KeyFrame key = new KeyFrame(Duration.millis(250),
                           new KeyValue (stage.getScene().getRoot().opacityProperty(), 0)); 
            timeline.getKeyFrames().add(key);   
            timeline.setOnFinished((ae) -> Platform.exit()); 
            timeline.play();
	}
                @FXML
        	public  void Loading(ActionEvent e) throws IOException {

		 root = FXMLLoader.load(getClass().getResource("Loading.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
        @FXML
        private AnchorPane customerdets;
	private Stage stage;
	private Scene scene;
	private Parent root;
	double x,y;
        @FXML 
        private void client(ActionEvent e) throws IOException{
                        if(returnWriteCount() != 0){
                    Loading(e);
            }

            else{
            incrementReadCount();
		 root = FXMLLoader.load(getClass().getResource("viewClients.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
                //move around
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
            
        }}
                        @FXML
        public void openNewClient(ActionEvent e) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("newClient.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
                 //move around
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
        public void openHome(ActionEvent e) throws IOException{
                root = FXMLLoader.load(getClass().getResource("home.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
                //move around
			root.setOnMousePressed(evt->{
				x = evt.getSceneX();
				y = evt.getSceneY();
			});
			root.setOnMouseDragged(evt->{
				stage.setX(evt.getScreenX() - x);
				stage.setY(evt.getScreenY() - y);
				
			});
                stage.setScene(scene);
                stage.show();}
                    @Override
    public void initialize(URL url, ResourceBundle rb) {
            FadeTransition fade = new FadeTransition();
            fade.setNode(ContentOfPane);
            fade.setDuration(Duration.millis(250));
            fade.setInterpolator(Interpolator.LINEAR);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
            
            // rotate
                RotateTransition rotate = new RotateTransition();
                rotate.setNode(loadingIcon);
                rotate.setDuration(Duration.millis(2500));
                rotate.setCycleCount(TranslateTransition.INDEFINITE);
                rotate.setInterpolator(Interpolator.LINEAR);
                rotate.setByAngle(360);
                rotate.play();
    
		
        }
    
}
