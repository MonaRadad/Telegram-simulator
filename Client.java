
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
	Socket mSocket;
	int port = 9090;
	String serverAddress = "127.0.0.1";

	InputStream fromServerStream;
	OutputStream toServerStream;
    String name;
    String pass;
    ServerMessagesManager serverMessagesManager;
	DataInputStream reader;
	PrintWriter writer;
	ClientFXUI clientUIHolder=null;
	public Client(ClientFXUI clientUI){
		clientUIHolder=clientUI;
	}

	public Client() {
	}
	public void start(){
		try {

			mSocket = new Socket(serverAddress, port);

			System.out.println("connect to server ....");

			// input stream (stream from server)
			fromServerStream = mSocket.getInputStream();

			// output stream (stream to server)
			toServerStream = mSocket.getOutputStream();

			reader = new DataInputStream(fromServerStream);
			writer = new PrintWriter(toServerStream, true);

			// first : read server message
			String msg = reader.readLine();
			System.out.println("Server :" + msg);

			// Manage other server message by a Thread
			serverMessagesManager = new ServerMessagesManager(reader,clientUIHolder);
			Thread t = new Thread(serverMessagesManager);
			t.start();


		//	menu();


		} catch (UnknownHostException e) {
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}


	}
	public void menu() {

		Scanner sc = new Scanner(System.in);

	//	name = clientUIHolder.controller.name;
		pass = clientUIHolder.control.pass;
		sendName(name);

		if(clientUIHolder!=null){
			//we have GUI , no need to console
			return;
		}
		while (true) {
			System.out.println("-----------");
			System.out.println("Enter Command number(ex:3):\n"
					//+ "1)add two number\n"
					//+ "2)evaluate an expression\n"
					//+ "3)echo\n"
					+ "4)single cht!\n"
					+ "5)group cht!\n"
					+ "6)send file\n"
					+ "7)exit");

			int commandNumber = Integer.parseInt(sc.nextLine());

			switch (commandNumber) {
		/*	case 4:
				//System.out.println("Enter receiver name");
				//String to = sc.nextLine();

				System.out.println("Enter your message");
				String text = sc.nextLine();

				sendMessage(text);
				break;
			case 5:
				System.out.println("Enter your message");
				text = sc.nextLine();

				sendGroupCht(text);
				break;
			case 6:
				System.out.println("Enter receiver name");
				to = sc.nextLine();

				System.out.println("Enter file name(Full Path)");
				String fileName = sc.nextLine();

				sendFile(to, fileName);
				break;
			case 7:

				bye();

				return;
*/
			}
		}
	}//

	private void sendName(String name) {
		writer.println(name);
	}



	public void sendMessage(String text) {
		writer.println("SCHT");
		//writer.println(to);
		writer.println(text);
	}

	public void sendGroupCht(String text) {
		writer.println("GCHT");
		writer.println(text);
	}

	public void sendFile(String fileName) {
		File file = new File(fileName);
		long fileLength = file.length();

		writer.println("SFILE");
		writer.println(file.getName());
		//writer.println(to);
		writer.println("" + fileLength);

		try {

			// convert file to byte array
			DataInputStream dis = new DataInputStream(new FileInputStream(file));
			byte[] fileData = new byte[(int) fileLength];
			dis.readFully(fileData);

			// send byte array to server
			toServerStream.write(fileData);

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void bye() {
		writer.println("BYE");
	}

	public static void main(String[] args) {
	   new Client().start();
	}
}


