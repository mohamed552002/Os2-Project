package application;
import Entities.Client;
import java.util.ArrayList;
import  application.SharedVariables;
import static application.SharedVariables.decrementReadCount;
import static application.SharedVariables.incrementReadCount;
import static application.SharedVariables.returnReadCount;
import static application.SharedVariables.signalReader;
import static application.SharedVariables.waitReader;
import static application.SharedVariables.signalWriter;
import static application.SharedVariables.waitWriter;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;


public class Controller implements Initializable {
    @FXML
    private HBox paneHeader;
    @FXML
    private BorderPane ContentOfPane;
    @FXML
    private TableView<Client> tableview;
    @FXML
    private TableColumn<Client, String> accid;
    @FXML
    private TableColumn<Client, String> cnumber;
    @FXML
    private TableColumn<Client, String> ccv;
    @FXML
    private TableColumn<Client, String> current_balance;
    @FXML
    private TableColumn<Client, String> ssn;
    @FXML
    private TableColumn<Client, String> fname;
    @FXML
    private TableColumn<Client, String> lname;
    @FXML
    private TableColumn<Client, String> phone;
    @FXML
    private TableColumn<Client, String> address;
   ObservableList<Client> dataList = FXCollections.observableArrayList();
    @FXML
	public void close(ActionEvent e) {
            Timeline timeline = new Timeline();
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            KeyFrame key = new KeyFrame(Duration.millis(250),
                           new KeyValue (stage.getScene().getRoot().opacityProperty(), 0)); 
            timeline.getKeyFrames().add(key);   
            timeline.setOnFinished((ae) -> Platform.exit()); 
            timeline.play();
	}
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
        

	public void openAllClients(ActionEvent e) throws IOException, InterruptedException {
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
        public void openHome(ActionEvent e) throws IOException{
            signalWriter();
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
                stage.show();
		
        }
     
    String cardNumFilter;
    @FXML
    private TextField cardNimReader;
     public void readText(){
        cardNumFilter = cardNimReader.getText();
        FilteredList<Client> filterdDataListByCardNumber = new FilteredList<>(dataList, i-> i.getCardNum().startsWith(cardNumFilter));
        tableview.setItems(filterdDataListByCardNumber);
        accid.setCellValueFactory(new PropertyValueFactory<>("ID"));
        cnumber.setCellValueFactory(new PropertyValueFactory<>("cardNum"));
        current_balance.setCellValueFactory(new PropertyValueFactory<>("currentBalance"));
        ssn.setCellValueFactory(new PropertyValueFactory<>("SSN"));
        ccv.setCellValueFactory(new PropertyValueFactory<>("CCV"));
        fname.setCellValueFactory(new PropertyValueFactory<>("FName"));
        lname.setCellValueFactory(new PropertyValueFactory<>("LName"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
     }
     @FXML
public void clickItem(MouseEvent event) throws IOException
{
    if (event.getClickCount() == 2) //Checking double click
    {
                                        waitReader();
            decrementReadCount();
            if(returnReadCount() == 0)
                signalWriter();
             signalReader();
            waitWriter();
            if(returnReadCount() >= 1){
                		 root = FXMLLoader.load(getClass().getResource("Loading.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
            }
            else{

                int clientId = tableview.getSelectionModel().getSelectedItem().getID();
                String fullname = tableview.getSelectionModel().getSelectedItem().getFName()+ " "+ tableview.getSelectionModel().getSelectedItem().getLName();
                String cardNum = tableview.getSelectionModel().getSelectedItem().getCardNum();
                String cvc = tableview.getSelectionModel().getSelectedItem().getCCV();
                double  CB = tableview.getSelectionModel().getSelectedItem().getCurrentBalance();
                String SSN = tableview.getSelectionModel().getSelectedItem().getSSN();
                String Pnum = tableview.getSelectionModel().getSelectedItem().getPhone();
                String Addr = tableview.getSelectionModel().getSelectedItem().getAddress();
                FXMLLoader Loader = new FXMLLoader(getClass().getResource("customer.fxml"));
                root = Loader.load();
                CustomerController customerController = Loader.getController();
                customerController.setClientInfo(clientId,fullname,cardNum,cvc,CB,SSN,Pnum,Addr);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
}
        

       @Override
    public void initialize(URL url, ResourceBundle rb) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                // fade
                FadeTransition fade = new FadeTransition();
                fade.setNode(ContentOfPane);
                fade.setDuration(Duration.millis(250));
                //fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(0);
                fade.setToValue(1);
                fade.play();
                
                accid.setCellValueFactory(new PropertyValueFactory<>("ID"));
		cnumber.setCellValueFactory(new PropertyValueFactory<>("cardNum"));
		current_balance.setCellValueFactory(new PropertyValueFactory<>("currentBalance"));
		ssn.setCellValueFactory(new PropertyValueFactory<>("SSN"));
		ccv.setCellValueFactory(new PropertyValueFactory<>("CCV"));
		fname.setCellValueFactory(new PropertyValueFactory<>("FName"));
		lname.setCellValueFactory(new PropertyValueFactory<>("LName"));
		phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		address.setCellValueFactory(new PropertyValueFactory<>("address"));
                ReadBalance r = new ReadBalance();
                ArrayList<Client> x = new ArrayList();
                x = r.Read();
                dataList.addAll(x);
                tableview.setItems(dataList);
                x.clear();
    }
    }