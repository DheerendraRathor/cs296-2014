package cs296JTalk2;
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.*;
public class JChatServer {

	public Socket sock;
	public int port = 5123;
	public String ip;
	public Tab tab;
	public JButton b;
	
	public JChatServer(Socket sock) {
		this.sock = sock;
		ip = sock.getRemoteSocketAddress().toString();
	}

	public boolean sendMessage() {
	try{
		final String msg = tab.tf.getText();
		JPacket jPacket = new JPacket(msg);
		PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
		out.println(jPacket.message.trim());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		Date date = new Date();
		String a1 = sdf.format(date);
		File file  = new File("./chatHistory/chat_log_"+a1+".txt");
		if (!file.exists()){
			//System.out.println("hii");
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getName(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		//PrintWriter pw = new PrintWriter(bw);
		bw.write("You: "+msg);
		//bw.close();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				tab.ta.append("You: "+msg+"\n");
				tab.tf.setText("");
			}
		});
		if(msg.equals("End Chat")) {
			endChat();
			return false;
		}
		else
			return true;
	}
	catch(Exception e) {
		System.out.println(e);
		return false;
	}
	}
	public boolean receiveMessage() {
	try{
		BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		final JPacket jPacket = new JPacket(in.readLine().trim());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		Date date = new Date();
		String a1 = sdf.format(date);
		File file  = new File("./chatHistory/chat_log_"+a1+".txt");
		if (!file.exists()){
			//System.out.println("hii");
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getName(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		//PrintWriter pw = new PrintWriter(bw);
		bw.write(ip+": "+jPacket.message);
		//bw.close();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				tab.ta.append("Client: "+jPacket.message+"\n");
			}
		});
		if(jPacket.message.equals("End Chat")) {
			endChat();
			return false;
		}
		return true;
	}
	catch(Exception e) {
		System.out.println(e);
		return false;
	}
	}

	public void endChat() {
	try{
		//System.out.println("[INFO]Chat Ended");
		JTab.pane.remove(tab);
		JTab.cons.remove(b);
		JTab.cons.revalidate();
		JTab.cons.repaint();
		sock.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	}

}
