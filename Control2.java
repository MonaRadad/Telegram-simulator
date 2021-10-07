import java.io.File;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.ArrayList;
import javafx.stage.FileChooser;
import javafx.scene.text.Text;
import javafx.stage.Stage;



 public class Control2 {

	    @FXML
	    private TextField Username;

	    @FXML
	    private Text usernameTxt;

	    @FXML
	    private Text bio;

	    @FXML
	    private TextField passwordTxt;

	    @FXML
	    private Button LoginButton;

	    @FXML
	    private TextField bioTxt;

	    @FXML
        private Text Password;
        @FXML
        private ListView<String> ListViewContact;
        String name;
        String pass;
        ClientFXUI UI;
        public void setClientFXUI(ClientFXUI u){
		   UI = u;
	    }
        static ArrayList<String> username = new ArrayList<String>();
        static ArrayList<String> password = new ArrayList<String>();
        //ArrayList<String> sendMessage = new ArrayList<String>();


         @FXML
		 void LoginButton() { UI.client.name = Username.getText();
                if( password.contains(passwordTxt.getText())){
					Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText("pelease enter another password!");
					alert.showAndWait();
					return;
				}

				if( username.contains(Username.getText())){
					Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("Error");
				    alert.setHeaderText(null);
					alert.setContentText("pelease enter another username!");
					alert.showAndWait();
					return;
				}
					name = Username.getText();
					username.add(name);
					pass = passwordTxt.getText();
					password.add(pass);
                    UI.client.pass = pass;
					ListViewContact.getItems().add(name);
					UI.client.name = name;
					UI.stage.setScene(UI.scene1);
				}


    }