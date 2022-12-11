package application;

import Entities.Client;
import application.Controller;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class CustomerController  {

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
            stage.setScene(scene);
            stage.show();
	}
        @FXML 
        private void client(ActionEvent e) throws IOException{
            root = FXMLLoader.load(getClass().getResource("viewClients.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        }
        @FXML
        private TextField deposieID;
        @FXML
        private TextField withdrawID;
        @FXML
        private TextField deposit;
        @FXML
        private TextField withdraw;
        @FXML
        public void runDeposite(){
            UpdateBalance.Deposit(deposit, deposieID);
        }
        @FXML
        public void runWithdraw(){
            UpdateBalance.Withdraw(withdraw, withdrawID);
        }
             
                
        @FXML
        private void close(MouseEvent event) {
        }
}

