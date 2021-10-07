import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Control3 {

    @FXML
    private Text usernameOut;

    @FXML
    private TextField usernameLogout;

    @FXML
    private Button loginButoonLogout;

    @FXML
    private Text passwordOut;

    @FXML
    private TextField passwordLogout;

    @FXML
    private ImageView fingetImage;
    String name;
	String pass;
    ClientFXUI UI;
    static Control2 control2 = new Control2();

     public void setClientFXUI(ClientFXUI u){
			UI = u;
	}

    @FXML
    void loginbtnLogout() {
      // UI.stage.setScene(UI.scene3);
    }
}
