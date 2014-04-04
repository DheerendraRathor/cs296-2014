import cs296JTalk.*;

import java.net.*;
import java.io.*;
import java.util.*;

public class jtalkG12 extends Thread{
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Socket client;
		String type;
		JChatComm jc;
		if (args.length == 0){
			type="s";
			ServerSocket serverSocket;
			serverSocket = new ServerSocket(5123);
			JServer server = new JServer(serverSocket);
			server.acceptConnection();
			
			client = server.server;
			jc = new JChatComm("s","c",client);
			
			//JPacket temp = new JPacket("hii");
			//jc.sendMessage(temp);
			if (!client.isClosed()){
					try {
						JPacket jpr;
						jpr = jc.receiveMessage();
						//System.out.println(jpr.msg);
						if (jpr.msg.equals("End Chat")){
							
							client.close();
						}
						jc.logMessage(jpr);
					}
					catch(SocketException e){
						//client.close();
					}
					catch (EOFException e){
						//client.close();
					}
			}
		}
		else
		{
			type="c";
			client = new Socket(args[0],5123);
			JClient jclient = new JClient(client);
			
			jc = new JChatComm("c","s",client);
			
		}
		
		while(!client.isClosed()){
			try{
				System.out.print("You: ");
				BufferedReader msg = new BufferedReader(new InputStreamReader(System.in));
				String msgr = msg.readLine();
				//System.out.println(msgr);
				if (msgr.equals("End Chat")){
					jc.endChat();
				}
					JPacket jp = new JPacket(msgr);
					jc.sendMessage(jp);
					jc.logMessage(jp);
				
				JPacket jpr;
				jpr = jc.receiveMessage();
				jc.logMessage(jpr);
			}
			catch (SocketException e){
				break;
			}
			catch (EOFException e){
				break;
			}
		}
		
		
		
	}
}
				
