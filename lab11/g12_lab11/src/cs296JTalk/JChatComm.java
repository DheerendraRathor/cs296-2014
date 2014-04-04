package cs296JTalk;

import java.util.*;
import java.io.*;
import java.net.*;

public class JChatComm extends JChatSession{
	private String type;
	private String typ2;
	private Socket client;
	
	public JChatComm(String s, String t, Socket c){
		type=s;
		client = c;
		typ2= t;
	}

	public void sendMessage(JPacket j1) throws IOException{
		OutputStream outToServer = client.getOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(outToServer);
		out.writeObject(j1);
		out.flush();
	}
	
	public JPacket receiveMessage() throws IOException, ClassNotFoundException{
		
		InputStream inFromServer = client.getInputStream();
		ObjectInputStream in = new ObjectInputStream(inFromServer);
		//System.out.println("hellow owrol");
		JPacket jp;
		jp = (JPacket) in.readObject();
		
		System.out.println("other: "+jp.msg+ "     Sent on:" + jp.a1);
		//System.out.println("msg got");
		return jp;
	}
	
	public void logMessage(JPacket j1){
		withwho w = new withwho(j1.msg,type,typ2);
		myList.add(w);
	}
	
	public void endChat() throws IOException {
		try{
			client.close();
		}
		catch(SocketException e){
		}
	}
	
}
		

