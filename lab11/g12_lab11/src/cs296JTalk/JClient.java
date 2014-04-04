package cs296JTalk;

//File Name GreetingClient.java

import java.net.*;
import java.io.*;

public class JClient{
	private Socket client;
	public JClient(Socket s) throws IOException{
		client = s;
		OutputStream outToServer = client.getOutputStream();
		DataOutputStream out = new DataOutputStream(outToServer);
		out.writeUTF("Free for a chat?");
		client.setSoTimeout(10000);
		try{
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			String input = in.readUTF();
			System.out.println(input);
			if(input.equals("Sure. Let us begin.")){
				client.setSoTimeout(1000000);
			}
			else {
				System.out.println("Server not Available");
				client.close();
			}
		}
		catch(SocketTimeoutException e){
			System.out.println("Server not Available");
			client.close();
		}
	}
	
}
