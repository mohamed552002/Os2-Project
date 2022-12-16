package application;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	double x,y;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
			Scene scene = new Scene(root);
                                                
			primaryStage.initStyle(StageStyle.UNDECORATED);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//move around
			root.setOnMousePressed(evt->{
				x = evt.getSceneX();
				y = evt.getSceneY();
			});
			root.setOnMouseDragged(evt->{
				primaryStage.setX(evt.getScreenX() - x);
				primaryStage.setY(evt.getScreenY() - y);
				
			});
			primaryStage.setScene(scene);
			primaryStage.show();}
                
                         catch(Exception e) {
			e.printStackTrace();
                         }
        }
	public static void main(String[] args) throws IOException {
		                            
                                            launch(args);
	}
}
