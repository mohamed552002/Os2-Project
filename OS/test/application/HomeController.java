/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package application;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import static application.SharedVariables.incrementReadCount;
import static application.SharedVariables.decrementReadCount;
import static application.SharedVariables.returnReadCount;
import static application.SharedVariables.returnWriteCount;
import static application.SharedVariables.signalReader;
import static application.SharedVariables.signalWriter;
import static application.SharedVariables.waitReader;
import static application.SharedVariables.waitWriter;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author NH
 */
public class HomeController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    double x,y;
    @FXML
    private GridPane ContentOfPane;
    @FXML
    private BarChart<String, Integer> barChart;
    public void close(ActionEvent e) {
            Timeline timeline = new Timeline();
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            KeyFrame key = new KeyFrame(Duration.millis(250),
                           new KeyValue (stage.getScene().getRoot().opacityProperty(), 0)); 
            timeline.getKeyFrames().add(key);   
            timeline.setOnFinished((ae) -> Platform.exit()); 
            timeline.play();
	}
            public void openNewClient(ActionEvent e) throws IOException, InterruptedException {
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
            @FXML
                    	public void Loading(MouseEvent e) throws IOException {

		 root = FXMLLoader.load(getClass().getResource("Loading.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
            @FXML 
        private void client(MouseEvent e) throws IOException, InterruptedException{
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
        }
        }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            FadeTransition fade = new FadeTransition();
            fade.setNode(ContentOfPane);
            fade.setDuration(Duration.millis(250));
            fade.setInterpolator(Interpolator.LINEAR);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
            XYChart.Series series1 = new XYChart.Series();
            series1.setName("Deopsits");
            series1.getData().add(new XYChart.Data("3 Days Ago",124));
            series1.getData().add(new XYChart.Data("Yesterday",154));
            series1.getData().add(new XYChart.Data("Today",167));
            
            XYChart.Series series2 = new XYChart.Series();
            series2.setName("Withdraws");
            series2.getData().add(new XYChart.Data("3 Days Ago",152));
            series2.getData().add(new XYChart.Data("Yesterday",198));
            series2.getData().add(new XYChart.Data("Today",259));
            barChart.getData().addAll(series1,series2);
               
     }
    
}
