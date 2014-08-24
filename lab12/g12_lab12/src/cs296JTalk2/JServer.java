package cs296JTalk2;
import java.net.*;
import java.io.*;

public class JServer{
	private ServerSocket ssock;
	private int port = 5123;
	public Socket sock;
	
	public JServer(){
		try{
		ssock = new ServerSocket(port);
		}
		catch(Exception e) {
		System.out.println(e);
		}
	}
	public boolean acceptConnection() {
		try{
		sock = ssock.accept();
		String client = sock.getRemoteSocketAddress().toString();
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			if(in.readLine().trim().equals("Free for a chat?")) {
					PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
					out.println("Sure. Let us begin.");
					JThread jst = new JThread(sock);
					Thread t = new Thread(jst);
					t.start();
					JTab.cons.addClient(client, jst);
					return true;
			}
			else {
				sock.close();
				return false;
			}
		}
		catch(Exception e) {
			System.out.println(e);
			try{
			sock.close();
			}
			catch(Exception e1) {
			System.out.println(e1);
			}
			return false;
		}
	}
}
