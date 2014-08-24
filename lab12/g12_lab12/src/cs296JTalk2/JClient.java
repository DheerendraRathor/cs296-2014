package cs296JTalk2;
import java.net.*;
import java.io.*;
public class JClient{

	private String ip;
	private int port = 5123;
	public Socket sock;

	public JClient(String ip) {
		this.ip = ip;
	}

	public boolean callServer() {
		try {
		sock = new Socket();
		long time = System.currentTimeMillis();
		sock.connect(new InetSocketAddress(ip, port), 10000);
		PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
		out.println("Free for a chat?");
		while(System.currentTimeMillis() < time + 10000) {
			if(sock.getInputStream().available() != 0) {
				BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				if(in.readLine().trim().equals("Sure. Let us begin.")) {
					return true;
				}
				else
					return false;
			}			
		}
		return false;
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
