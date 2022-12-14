package application;

import Entities.Client;
import application.Controller;
import java.awt.Color;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class addCustomerController  {
    
        public static int getIntFromTextField(TextField textField) {
            String text = textField.getText();
            return Integer.parseInt(text);
        }
        
        @FXML
	public void close(ActionEvent e) {
		Platform.exit();
	}
        @FXML
        private AnchorPane customerdets;
	private Stage stage;
	private Scene scene;
	private Parent root;
	double x,y;
	public void opencustomer(ActionEvent e) throws IOException {
            root = FXMLLoader.load(getClass().getResource("customer.fxml"));
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
        private void client(ActionEvent e) throws IOException{
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
        
    @FXML
    private TextField ssn;
    @FXML
    private TextField fName;
    @FXML
    private TextField LName;
    @FXML
    private TextField Phone;
    @FXML
    private TextField Address;
    @FXML
    private TextField cBalance;
    @FXML
    private TextField state;
    @FXML
    private TextField cardNum;
    @FXML
    private TextField CVC;
    @FXML
    private TextField Age;
    @FXML
    public void insert(){
            DBContext.DBopen();
            int currentBalance = getIntFromTextField(cBalance);
            int clientAge = getIntFromTextField(Age);
            DBContext.Insertion("INSERT INTO client(SSN, first_name, last_name, phone, address, current_balance, status, card_number, CCV, age) "
                    + "Values('"+ ssn.getText() +"', '"+ fName.getText()+"', '"+LName.getText() +"', '"+Phone.getText() +"', '"+Address.getText() +"', '"+ currentBalance+"', '"+ state.getText().toUpperCase()+"', '"+ cardNum.getText()+"', '"+ CVC.getText()+"', '"+ clientAge+"')");
            DBContext.DBclose();
    }
        
        @FXML
        private void close(MouseEvent event) {
        }
}

