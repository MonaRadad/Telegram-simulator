import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javax.xml.soap.Text;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ListView;

public class ClientFXUI extends Application {

Control control ;
Client client;
Stage stage;
Scene scene1,scene2,scene3;

    public void textFieldPrint(){
        System.out.println(control.Message.getText());
    }

	@Override
	public void start(Stage s) throws Exception {
	stage = s;

	 control = new Control();

			client = new Client(this);
			// add contact to listview
			client.start();
			//////
System.out.println("hi");
		Pane pane1 = FXMLLoader.load(getClass().getResource("doc2.fxml")) ;
		 scene1 = new Scene(pane1);
		stage.setScene(scene1);

		 //Pane pane2 = FXMLLoader.load(getClass().getResource("doc1.fxml")) ;
		 //scene2 = new Scene(pane2);
		 //stage.setScene(scene2);


	      //Pane pane3 = FXMLLoader.load(getClass().getResource("doc3.fxml")) ;
		 //scene3 = new Scene(pane3);
	// manage events
/*		btnSendSingleCht.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				client.sendSingleCht(tfSingleChtTo.getText(), tfSingleChtMessage.getText());
			}
		});
		btnSendGroupCht.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				client.sendGroupCht(tfGroupChtMessage.getText());
			}
		});
		btnBrowseFile.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Browse File");
				File file = fileChooser.showOpenDialog(stage);

				if (file != null)
					tfFilePath.setText(file.getAbsolutePath());
			}
		});
		btnSendFile.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				client.sendFile(tfSendFileTo.getText(), tfFilePath.getText());
			}
		});
*/
		stage.setResizable(false);
		stage.setScene(scene3);
		stage.setTitle("Telegraph");
		stage.show();

	}

	public void showMessage(final String message) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				control.Message.appendText(message + "\n");
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
