package application;
import Entities.Client;
import java.util.ArrayList;
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
import javafx.fxml.Initializable;

public class Controller implements Initializable {
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

    @FXML
    private void close(MouseEvent event) {
    }
       

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                accid.setCellValueFactory(new PropertyValueFactory<>("ID"));
		cnumber.setCellValueFactory(new PropertyValueFactory<>("cardNum"));
		current_balance.setCellValueFactory(new PropertyValueFactory<>("currentBalance"));
		ssn.setCellValueFactory(new PropertyValueFactory<>("SSN"));
		ccv.setCellValueFactory(new PropertyValueFactory<>("CCV"));
		fname.setCellValueFactory(new PropertyValueFactory<>("FName"));
		lname.setCellValueFactory(new PropertyValueFactory<>("LName"));
		phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		address.setCellValueFactory(new PropertyValueFactory<>("address"));
		tableview.setItems(dataList);
                ReadBalance r = new ReadBalance();
                dataList.addAll(r.Read());
    }
	}

