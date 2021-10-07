import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.ArrayList;
import javafx.stage.Stage;
import java.io.File;
import javafx.stage.FileChooser;



public class Control1 {

    @FXML
    private Button logout;

    @FXML
    private TextField Message;

    @FXML
    private TextField sreachUser;

    @FXML
    private Text online;

    @FXML
    private Button filebtn;

    @FXML
    private ListView<String> ListViewContact;

    @FXML
    private ListView<String> messageView;

    @FXML
    private Button userbtn;

    @FXML
    private Button messagebtn;

    @FXML
    private Button crateGroupe;

    String name;
	String ToContact;
	String pass;
	Boolean fileBoolean;
	//Boolean groupBoolean;
	String address;
	ClientFXUI UI;
	static Control2 control2 = new Control2();



    public void setClientFXUI(ClientFXUI u){
		UI = u;
	}


    @FXML
    void sendFilebtn() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Browse File");
        File file = fileChooser.showOpenDialog(UI.stage);
		 if(file !=null)
		  address = file.getAbsolutePath();
		  fileBoolean = true;

    }

    @FXML
    void sendMessagebtn() {
     //if(groupBoolean)

	 //UI.client.sendGroupCht(Message.getText());
	//if(fileBoolean)
	// UI.client.sendFile(tfSendFileTo.getText(),address);
	// else
	 //UI.client.SingleCht(ToContact.getText(),Message.getText());

    }

    @FXML
    void searchUserbtn() {

    }

    @FXML
    void CreateGroupbtn() {

    }

    @FXML
    void logoutbtn() {
		UI.stage.setScene(UI.scene3);

    }

    @FXML
    void contactClick() {
		 ToContact = ListViewContact.getSelectionModel().getSelectedItems().toString();
		 //serverHolder.clienManeger.contactList.get(serverHolder.username.indexOf(ToContact));
    }

}
