
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {
	ServerSocket mServer;
	int serverPort = 9090;
	ArrayList<Thread> threads = new ArrayList<Thread>();
	int limit = 100;
	HashMap<String,ClientManager> clientsMap=new HashMap<String, ClientManager>();
    Controller controller;
	public Server() {
	    controller = new Controller();

		try {
			// create server socket!
			mServer = new ServerSocket(serverPort);

			System.out.println("Server Created!");

			// always running
			// Go ahead and leave me, i am still alive
			while (true) {
				// wait for client
				// hold an object of Socket for each client
				Socket client = mServer.accept();

				// horaaaaa
				System.out.println("Connected to New Client!");

				// create new thread to manage each client separately and
				// simultaneously
				Thread t = new Thread(new ClientManager(this,client));

				// add Thread to "threads" list
				threads.add(t);

				if (threads.size() > limit) {
					// run your scheduling algorithm
				}
				// start thread
				t.start();

			}
		} catch (IOException e) {
		}

	}

	public void addClientManager(String clientName,ClientManager cm){
		clientsMap.put(clientName, cm);
	}

	public ClientManager findClientManager(String clientName){
		return clientsMap.get(clientName);
	}
	public ArrayList<ClientManager> findAllClientManagers(){
		ArrayList<ClientManager> result=new ArrayList<>();
		for(Map.Entry<String,ClientManager> entry:clientsMap.entrySet()){
			result.add(entry.getValue());
		}
		return result;
	}


	public static void main(String[] args) {
		new Server();
	}
}
