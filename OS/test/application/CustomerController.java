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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    
    @FXML
    private TextField Address;
    @FXML
    private TextField CVC;
    @FXML
    private TextField SSN;
    @FXML
    private TextField accID;
    @FXML
    private TextField cBalance;
    @FXML
    private TextField cardNum;
    @FXML
    private TextField fName;
    @FXML
    private TextField pNum;
    @FXML
    private TextField currentBalanceInDeposit;
    @FXML
    private TextField currentBalanceInWithdraw;
    @FXML
    private TextField deposit;
    @FXML
    private Label DepositMsg;
    @FXML
    private TextField withdraw;
    @FXML
    private Label withdrawMsg;
    @FXML
    private TextField currentStatus;
    @FXML
    private Button changeStatusBtn;
    
    int ClientID;
    
        public void setClientInfo(int id, String name,String cn, String cvc,double cb,String ssn,String Pn, String Addr){
         accID.setText(""+id);
         cardNum.setText(cn);
         CVC.setText(cvc);
         cBalance.setText(""+cb);
         fName.setText(name);
         SSN.setText(ssn);
         pNum.setText(Pn);
         Address.setText(Addr);
         ClientID = id;
         currentBalanceInDeposit.setText(""+cb);
         currentBalanceInWithdraw.setText(""+cb);
         DBContext.DBopen();
         currentStatus.setText(""+DBContext.returnStatus(ClientID));
         DBContext.DBclose();
         if("ACTIVE".equals(currentStatus.getText())){
                changeStatusBtn.setText("");
                changeStatusBtn.setText("Deactivate Account");
                   
            }else if ("DEACTIVE".equals(currentStatus.getText())){
                changeStatusBtn.setText("");
                changeStatusBtn.setText("Activate Account");
            }
         
        }
        @FXML
        public void runDeposite(){
          if("ACTIVE".equals(currentStatus.getText())){
            UpdateBalance.Deposit(deposit, ClientID);
            DBContext.DBopen();
            String UpdatedBalance = DBContext.returnBalance("client", ClientID);
            currentBalanceInDeposit.setText(UpdatedBalance);
            currentBalanceInWithdraw.setText(UpdatedBalance);
            cBalance.setText(DBContext.returnBalance("client", ClientID));
            DBContext.DBclose();
            DepositMsg.setText("Operation done successfully !");
            DepositMsg.setStyle("-fx-text-fill: green");
            deposit.setText("");
          }else{
                DepositMsg.setText("This Account is Deactivated !");
                DepositMsg.setStyle("-fx-text-fill: red");
                deposit.setText("");
          }
        }
        @FXML
        public void runWithdraw(){
          if("ACTIVE".equals(currentStatus.getText())){
            if(UpdateBalance.Withdraw(withdraw, ClientID)){
                DBContext.DBopen();
                String UpdatedBalance = DBContext.returnBalance("client", ClientID);
                currentBalanceInDeposit.setText(UpdatedBalance);
                currentBalanceInWithdraw.setText(UpdatedBalance);
                cBalance.setText(DBContext.returnBalance("client", ClientID));
                DBContext.DBclose();
                withdrawMsg.setText("Operation done successfully !");
                withdrawMsg.setStyle("-fx-text-fill: green");
                withdraw.setText("");      
            }
            else{
                withdrawMsg.setText("There is no enough money !");
                withdrawMsg.setStyle("-fx-text-fill: red");
                withdraw.setText("");
            } 
          }
          else{
                withdrawMsg.setText("This Account is Deactivated !");
                withdrawMsg.setStyle("-fx-text-fill: red");
                withdraw.setText("");
          }
        }
        
        public void deleteAccount(ActionEvent e) throws IOException{
                DBContext.DBopen();
                DBContext.delete("DELETE FROM client WHERE account_id ="+ClientID);
                DBContext.DBclose();
                client(e);
} 
        public void ChangeAccountState(ActionEvent event) {
           if("ACTIVE".equals(currentStatus.getText())){
                DBContext.updateStatus(ClientID, "DEACTIVE");
                DBContext.DBopen();
                currentStatus.setText(DBContext.returnStatus(ClientID));
                DBContext.DBclose();
                changeStatusBtn.setText("");
                changeStatusBtn.setText("Activate Account");
                   
            }
           else if ("DEACTIVE".equals(currentStatus.getText())){
                DBContext.updateStatus(ClientID, "ACTIVE");
                DBContext.DBopen();
                currentStatus.setText(DBContext.returnStatus(ClientID));
                DBContext.DBclose();
                changeStatusBtn.setText("");
                changeStatusBtn.setText("Deactivate Account");
            }
            }
}

