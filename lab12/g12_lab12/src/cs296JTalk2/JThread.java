package cs296JTalk2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
public class JThread extends JChatServer implements Runnable{
	public JThread(Socket sock) {
		super(sock);
	}
	public void run() {
		while(true) {
			if(!receiveMessage())
				break;
		}
		endChat();
	}
}
