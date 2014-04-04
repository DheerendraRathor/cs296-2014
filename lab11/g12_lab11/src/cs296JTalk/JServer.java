package cs296JTalk;


import java.net.*;
import java.io.*;

public class JServer{
	private ServerSocket serverSocket;
	public Socket server;
	public JServer(ServerSocket s) throws IOException{
      serverSocket = s;
      System.out.println("listening on port "+serverSocket.getLocalPort());
   }

   public void acceptConnection() throws IOException{
	   server = serverSocket.accept();
	   DataInputStream in = new DataInputStream(server.getInputStream());
	   System.out.println(in.readUTF());
	   //System.out.println("hellowsdfksd");
	   DataOutputStream out =new DataOutputStream(server.getOutputStream());
	   System.out.print("Enter y to start chat with "+server.getRemoteSocketAddress()+" : ");
	   BufferedReader affr = new BufferedReader(new InputStreamReader(System.in));
	   if(affr.readLine().equals("y")){
		   out.writeUTF("Sure. Let us begin.");
		   out.flush();
	   }
	   else {
		   out.writeUTF("Not Today");
		   server.close();
	   }
	  
   }
}

